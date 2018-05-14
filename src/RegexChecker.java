import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexChecker implements RegexBackend {

    // The GUI/Frontend that we have to communicate with.
    private RegexFrontend frontend;

    // The current regex pattern. If the current pattern is invalid, this will equal null.
    private Pattern pattern;

    // The current String the user entered to test the regex on.
    private String inputString;

    /**
     * Create a new RegexChecker.
     */
    public RegexChecker() {
    }

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
            String unmatched = this.inputString.substring(start, end);
            // Ignore empty Strings, we only want matches that are a part of the String the user entered.
            if (!unmatched.equals("")) {
                SubSequence subSequence = new SubSequence(unmatched, false);
                string.addSubSequence(subSequence);
            }
            String matched = matcher.group();
            if (!matched.equals("")) {
                SubSequence subSequence = new SubSequence(matched, true);
                string.addSubSequence(subSequence);
            }
            start = matcher.end();
        }
        String unmatched = this.inputString.substring(start, end);
        if (!unmatched.equals("")) {
            SubSequence subSequence = new SubSequence(unmatched, false);
            string.addSubSequence(subSequence);
        }
        return string;
    }

    @Override
    public void inputUpdated(String input) {
        this.inputString = input;
        // The current pattern is valid.
        if (this.pattern != null) {
            Matcher matcher = this.pattern.matcher(this.inputString);
            MatchedString matchedString = this.createMatchedString(matcher);
            this.frontend.updateDisplay(matchedString);
        } else {
            // The pattern is not valid, so create a MatchedString that is empty.
            MatchedString matchedString = new MatchedString();
            this.frontend.updateDisplay(matchedString);
        }
    }

    @Override
    public void setFrontend(RegexFrontend frontend) {
        this.frontend = frontend;
    }
}