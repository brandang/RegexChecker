import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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

    // The text box for entering the input to test the regex on.
    private TextField inputBox;

    // Label that displays any error when user types in a regex.
    private Label warnings;

    // The text display box that shows which parts of the string the user entered are matched by the regex.
    private TextFlow display;

    // The Label that displays information relating to the matches.
    private Label infoLabel;

    // The button that allows the user to clear all text fields.
    private Button clearButton;

    // The button that closes window and exits the program.
    private Button closeButton;

    /**
     * Create a new GUI that represents the program.
     */
    public MainGUI() {
        this.setupGUI();
    }

    /**
     * Sets up the initial GUI, initializing variables along the way.
     */
    private void setupGUI() {

        // The background.
        this.background = new VBox();
        this.background.setStyle(Constants.BACKGROUND_STYLE);

        // The regex box for user input to get the regex pattern.
        this.regexBox = new TextField();
        this.regexBox.setStyle(Constants.TEXTBOX_STYLE);
        this.regexBox.setFont(Constants.TEXTBOX_FONT);
        // Add listener for when user types something.
        this.regexBox.textProperty().addListener((observable, oldValue, newValue) -> {
            this.regexUpdated();
        });

        // The input box so that user can enter String to test regex on.
        this.inputBox = new TextField();
        this.inputBox.setStyle(Constants.TEXTBOX_STYLE);
        this.inputBox.setFont(Constants.TEXTBOX_FONT);
        // Add listener for when user types something.
        this.inputBox.textProperty().addListener((observable, oldValue, newValue) -> {
            this.inputUpdated();
        });

        // The container for the area that contains the regex box.
        BorderPane regexboxContainer = new BorderPane();
        regexboxContainer.setCenter(this.regexBox);

        // The description/user prompt.
        Label regexDescription = new Label(Constants.REGEX_BOX_DESCRIPTION);
        BorderPane.setMargin(regexDescription, Constants.DESCRIPTION_PADDING);
        regexDescription.setFont(Constants.DESCRIPTION_FONT);
        regexDescription.setTextFill(Constants.DESCRIPTION_COLOR);
        regexboxContainer.setTop(regexDescription);
        regexboxContainer.setPadding(Constants.TEXTBOX_PADDING);

        // The Label that displays info/warnings for the regex box.
        this.warnings = new Label(Constants.DEFAULT_WARNINGS_DISPLAY);
        this.warnings.setTextFill(Constants.WARNINGS_COLOR);
        regexboxContainer.setBottom(this.warnings);

        // The container that holds the input box.
        BorderPane inputboxContainer = new BorderPane();
        inputboxContainer.setCenter(this.inputBox);

        // Prompt user to enter input in input box.
        Label inputDescription = new Label(Constants.INPUT_BOX_DESCRIPTION);
        BorderPane.setMargin(inputDescription, Constants.DESCRIPTION_PADDING);
        inputDescription.setFont(Constants.DESCRIPTION_FONT);
        inputDescription.setTextFill(Constants.DESCRIPTION_COLOR);
        inputboxContainer.setTop(inputDescription);
        inputboxContainer.setPadding(Constants.TEXTBOX_PADDING);

        // The display box that shows the matches from the given input.
        this.display = new TextFlow();

        // The description for the display box. Initially show that there are no matches.
        this.infoLabel = new Label(0 + Constants.DISPLAY_DESCRIPTION);
        BorderPane.setMargin(this.infoLabel, Constants.DESCRIPTION_PADDING);
        this.infoLabel.setTextFill(Constants.DISPLAY_DESCRIPTION_COLOR);

        // The container for the area that contains the display box.
        BorderPane displayContainer = new BorderPane();
        displayContainer.setTop(this.infoLabel);
        displayContainer.setCenter(this.display);
        displayContainer.setPadding(Constants.TEXTBOX_PADDING);
        // Initial text that the display shows.
        Text text = new Text();
        this.display.getChildren().add(text);
        this.display.setStyle(Constants.DISPLAY_STYLE);

        // Clear button.
        this.clearButton = new Button(Constants.CLEAR_BUTTON_TEXT);
        this.clearButton.setPrefWidth(Constants.BUTTON_WIDTH);
        this.clearButton.setOnAction(event -> this.backend.clearButtonPressed());

        // Close button.
        this.closeButton = new Button(Constants.CLOSE_BUTTON_TEXT);
        this.closeButton.setPrefWidth(Constants.BUTTON_WIDTH);
        this.closeButton.setOnAction(event -> this.backend.closeButtonPressed());

        HBox buttonContainer = new HBox();
        buttonContainer.setPadding(Constants.TEXTBOX_PADDING);
        buttonContainer.getChildren().add(this.clearButton);
        buttonContainer.getChildren().add(this.closeButton);
        buttonContainer.setAlignment(Pos.BASELINE_RIGHT);
        buttonContainer.setSpacing(Constants.BUTTON_SPACING);

        // Add components, create Scene.
        this.background.getChildren().addAll(regexboxContainer, inputboxContainer, displayContainer, buttonContainer);
        this.mainScene = new Scene(this.background, Constants.DEFAULT_WINDOW_WIDTH, Constants.DEFAULT_WINDOW_HEIGHT);
    }

    /**
     * The user has modified the Regex box, act accordingly.
     */
    private void regexUpdated() {
        this.backend.regexUpdated(this.regexBox.getText());
    }

    /**
     * The user has modified the Input box, so act accordingly.
     */
    private void inputUpdated() {
        this.backend.inputUpdated(this.inputBox.getText());
    }

    @Override
    public void updateRegex(String newRegex) {
        this.regexBox.setText(newRegex);
    }

    @Override
    public void updateInput(String newInput) {
        this.inputBox.setText(newInput);
    }

    @Override
    public void updateDisplay(MatchedString matchedString) {
        // Clear the previous elements from the display.
        this.display.getChildren().clear();

        for (SubSequence sequence : matchedString) {
            Text text = new Text(sequence.getValue());
            // The sequences matches, highlight it.
            if (sequence.isMatch()) {
                text.setFill(Constants.DISPLAY_MATCH_COLOR);
            }
            else {
                text.setFill(Constants.DISPLAY_UNMATCHED_COLOR);
            }
            this.display.getChildren().add(text);
        }

        // If there is nothing to display, just display an empty String so that the TextFlow maintains it's shape.
        if (matchedString.getSize() == 0) {
            Text emptyText = new Text();
            this.display.getChildren().add(emptyText);
        }

        // Update the info description.
        this.infoLabel.setText(matchedString.getNumMatches() + Constants.DISPLAY_DESCRIPTION);
    }

    @Override
    public void updateWarnings(String newWarnings) {
        this.warnings.setText(newWarnings);
    }

    @Override
    public Scene getScene() {
        return this.mainScene;
    }

    @Override
    public void setBackend(RegexBackend backend) {
        this.backend = backend;
    }
}
