import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Class that controls the main GUI.
 */
public class MainGUI implements RegexFrontend {

    // The scene.
    private Scene mainScene;

    // The background of the mainScene.
    private VBox background;

    // The text box for entering regex.
    private TextField regexBox;

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

        // The regex box for user input.
        this.regexBox = new TextField();
        this.regexBox.setStyle(Constants.REGEX_BOX_STYLE);
        this.regexBox.setFont(Constants.REGEX_BOX_FONT);

        // The container for the area that contains the regex box.
        BorderPane regexboxContainer = new BorderPane();
        regexboxContainer.setCenter(this.regexBox);
        Label regexDescription = new Label(Constants.REGEX_BOX_DESCRIPTION);
        BorderPane.setMargin(regexDescription, Constants.REGEX_BOX_DESCRIPTION_PADDING);
        regexDescription.setFont(Constants.REGEX_BOX_DESCRIPTION_FONT);
        regexDescription.setTextFill(Constants.REGEX_BOX_DESCRIPTION_COLOR);
        regexboxContainer.setTop(regexDescription);
        regexboxContainer.setPadding(Constants.REGEX_BOX_PADDING);


        this.background.getChildren().add(regexboxContainer);
        this.mainScene = new Scene(this.background, Constants.DEFAULT_WINDOW_WIDTH, Constants.DEFAULT_WINDOW_HEIGHT);
    }

    @Override
    public void updateRegex(String newRegex) {

    }

    @Override
    public void updateInput(String newInput) {

    }

    @Override
    public Scene getScene() {
        return this.mainScene;
    }
}
