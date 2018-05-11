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



    @Override
    public void inputUpdated(String input) {
        this.inputString = input;
        // The current pattern is valid.
        if (this.pattern != null) {
            Matcher matcher = this.pattern.matcher(this.inputString);
            matcher.group();

        }
    }

    @Override
    public void setFrontend(RegexFrontend frontend) {
        this.frontend = frontend;
    }
}