import javafx.application.Platform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Class that controls the back-end of the program. Tells the MainGUI what to display.
 */
public class RegexChecker implements RegexBackend {

    // The GUI/Frontend that we have to communicate with.
    private RegexFrontend frontend;

    // The current regex pattern. If the current pattern is invalid, this will equal null.
    private Pattern pattern;

    // The current String the user entered to test the regex on.
    private String inputString;

    @Override
    public void regexUpdated(String regex) {
        try {
            this.pattern = Pattern.compile(regex);
            // Compile successful; no warnings needed.
            this.frontend.updateWarnings(Constants.DEFAULT_WARNINGS_DISPLAY);
        } catch (PatternSyntaxException e) {
            // Error in the regex. Display warning to notify user.
            String message = Constants.START_WARNINGS_ERROR;
            message += e.getDescription();
            this.frontend.updateWarnings(message);
            // Pattern is invalid.
            this.pattern = null;
        }
        // Update the display accordingly.
        this.updateDisplay(this.inputString);
    }

    /**
     * Creates and returns a MatchedString, which contains both matched and unmatched SubSequences.
     * @param matcher The Matcher to create the MatchedString with.
     * @return The MatchedString.
     */
    private MatchedString createMatchedString(Matcher matcher) {
        MatchedString string = new MatchedString();
        // The starting and ending indices in which to copy unmatched characters.
        int start = 0;
        int end = this.inputString.length();
        // Loop through each match, get all the sub sequences that match and the ones that do not.
        while (matcher.find()) {
            end = matcher.start();

            // Get the unmatched String before the match, if any.
            String unmatched = this.inputString.substring(start, end);
            // Ignore empty Strings, we only want matches that are a part of the String the user entered.
            if (!unmatched.equals("")) {
                SubSequence subSequence = new SubSequence(unmatched, false);
                string.addSubSequence(subSequence);
            }
            // Indices of next unmatched String. Assume end index is the last index.
            start = matcher.end();
            end = this.inputString.length();

            // Get the matched String.
            String matched = matcher.group();
            if (!matched.equals("")) {
                SubSequence subSequence = new SubSequence(matched, true);
                string.addSubSequence(subSequence);
            }
        }
        // Get the unmatched String, if any, after the last match.
        String unmatched = this.inputString.substring(start, end);
        if (!unmatched.equals("")) {
            SubSequence subSequence = new SubSequence(unmatched, false);
            string.addSubSequence(subSequence);
        }
        return string;
    }

    @Override
    public void inputUpdated(String input) {
        this.updateDisplay(input);
    }

    @Override
    public void clearButtonPressed() {
        // Clear all of the text fields.
        this.inputUpdated("");
        this.regexUpdated("");
        this.frontend.updateRegex("");
        this.frontend.updateInput("");
    }

    @Override
    public void closeButtonPressed() {
        // Close the program.
        Platform.exit();
    }

    /**
     * Updates the display using the given input and regex.
     * @param input The input.
     */
    private void updateDisplay(String input) {
        this.inputString = input;
        // The current pattern is valid, and so is the input.
        if (this.pattern != null && this.inputString != null) {
            Matcher matcher = this.pattern.matcher(this.inputString);
            MatchedString matchedString = this.createMatchedString(matcher);
            this.frontend.updateDisplay(matchedString);
        } else {
            // The pattern or the input is not valid.
            // Create SubSequence that includes the entire input, unmatched.
            SubSequence subSequence = new SubSequence(input, false);
            MatchedString matchedString = new MatchedString();
            matchedString.addSubSequence(subSequence);
            this.frontend.updateDisplay(matchedString);
        }
    }

    @Override
    public void setFrontend(RegexFrontend frontend) {
        this.frontend = frontend;
    }
}