import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexChecker implements RegexBackend {

    // The GUI/Frontend that we have to communicate with.
    private RegexFrontend frontend;

    // The current regex pattern.
    private Pattern pattern;

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
        }
    }

    @Override
    public void inputUpdated(String input) {

    }

    @Override
    public void setFrontend(RegexFrontend frontend) {
        this.frontend = frontend;
    }
}