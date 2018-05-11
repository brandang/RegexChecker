public class RegexChecker implements RegexBackend {

    // The GUI/Frontend that we have to communicate with.
    private RegexFrontend frontend;

    /**
     * Create a new RegexChecker.
     */
    public RegexChecker() {
    }

    @Override
    public void regexUpdated(String regex) {

    }

    @Override
    public void inputUpdated(String input) {

    }

    @Override
    public void setFrontend(RegexFrontend frontend) {
        this.frontend = frontend;
    }
}