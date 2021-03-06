import javafx.scene.Scene;

/**
 * Interface that represents the frontend of the program. Allows the backend to tell the frontend what to display.
 */
public interface RegexFrontend extends Frontend {

    /**
     * Update the regex text area.
     * @param newRegex The new text.
     */
    void updateRegex(String newRegex);

    /**
     * Update the input text area.
     * @param newInput The new text.
     */
    void updateInput(String newInput);

    /**
     * Update the display using the given MatchedString to show which SubSequences are matched by the regex.
     * @param matchedString The MatchedString.
     */
    void updateDisplay(MatchedString matchedString);

    /**
     * Update the warnings to display.
     * @param newWarnings The new warnings to display.
     */
    void updateWarnings(String newWarnings);

    /**
     * Returns the Scene that this Front-End represents.
     * @return The Scene object.
     */
    Scene getScene();

}
