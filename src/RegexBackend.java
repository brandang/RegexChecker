/**
 * Interface that represent the backend code for the RegexChecker. Used to allow the GUI to communicate
 * with the backend.
 */
public interface RegexBackend extends Backend {

    /**
     * User has updated the Regex text area, respond accordingly.
     * @param regex The current value of the text area.
     */
    void regexUpdated(String regex);

    /**
     * User has updated the input text area, respond accordingly.
     * @param input The current value of the text area.
     */
    void inputUpdated(String input);

    /**
     * User has clicked on the clear button.
     */
    void clearButtonPressed();

    /**
     * User has clicked on the close button.
     */
    void closeButtonPressed();

}
