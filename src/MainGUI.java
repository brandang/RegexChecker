import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Class that controls the main GUI.
 */
public class MainGUI implements RegexFrontend {

    // The Backend that this GUI has to communicate with.
    private RegexBackend backend;

    // The scene.
    private Scene mainScene;

    // The background of the mainScene.
    private VBox background;

    // The text box for entering regex.
    private TextField regexBox;

    // Label that displays any error when user types in a regex.
    private Label warnings;

    /**
     * Create a new GUI that represents the program.
     * @param backend The Backend that this GUI has to communicate with.
     */
    public MainGUI(RegexBackend backend) {
        this.backend = backend;
        this.setupGUI();
    }

    /**
     * Sets up the initial GUI, initializing variables along the way.
     */
    private void setupGUI() {

        // The background.
        this.background = new VBox();
        this.background.setStyle(Constants.BACKGROUND_STYLE);

        // The regex box for user input.
        this.regexBox = new TextField();
        this.regexBox.setStyle(Constants.REGEX_BOX_STYLE);
        this.regexBox.setFont(Constants.REGEX_BOX_FONT);

        // The container for the area that contains the regex box.
        BorderPane regexboxContainer = new BorderPane();
        regexboxContainer.setCenter(this.regexBox);

        // The description/user prompt.
        Label regexDescription = new Label(Constants.REGEX_BOX_DESCRIPTION);
        BorderPane.setMargin(regexDescription, Constants.REGEX_BOX_DESCRIPTION_PADDING);
        regexDescription.setFont(Constants.REGEX_BOX_DESCRIPTION_FONT);
        regexDescription.setTextFill(Constants.REGEX_BOX_DESCRIPTION_COLOR);
        regexboxContainer.setTop(regexDescription);
        regexboxContainer.setPadding(Constants.REGEX_BOX_PADDING);

        // The Label that displays info/warnings for the regex box.
        this.warnings = new Label(Constants.DEFAULT_WARNINGS_DISPLAY);
        this.warnings.setTextFill(Constants.WARNINGS_COLOR);
        regexboxContainer.setBottom(this.warnings);


        this.background.getChildren().add(regexboxContainer);
        this.mainScene = new Scene(this.background, Constants.DEFAULT_WINDOW_WIDTH, Constants.DEFAULT_WINDOW_HEIGHT);
    }

    @Override
    public void updateRegex(String newRegex) {
        this.regexBox.setText(newRegex);
    }

    @Override
    public void updateInput(String newInput) {

    }

    @Override
    public Scene getScene() {
        return this.mainScene;
    }
}
