import javafx.scene.Scene;

/**
 * Interface that represents the frontend of the program. Allows the backend to tell the frontend what to display.
 */
public interface RegexFrontend {

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
     * Returns the Scene that this Front-End represents.
     * @return The Scene object.
     */
    Scene getScene();
}
