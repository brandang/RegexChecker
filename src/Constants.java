import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Class that stores the Constant values for the program.
 */
public class Constants {

    // ** Window **

    // Window sizes.
    final public static int DEFAULT_WINDOW_WIDTH = 600;
    final public static int DEFAULT_WINDOW_HEIGHT = 400;

    // Name of window.
    final public static String WINDOW_NAME = "RegexChecker";


    // ** Background of the GUI **

    // The style of the background.
    final public static String BACKGROUND_STYLE = "-fx-background-color: #464646";


    // ** The text boxes for entering in information **

    // The style of the text boxes.
    final public static String TEXTBOX_STYLE = "-fx-padding: 5;";

    // Padding for the text boxes.
    final public static Insets TEXTBOX_PADDING = new Insets(20,20, 20, 20);

    // Font for the text boxes.
    final public static Font TEXTBOX_FONT = new Font(12);


    // ** Description for the text boxes **

    // Font for the description.
    final public static Font DESCRIPTION_FONT = new Font(12);

    // Padding for the description.
    final public static Insets DESCRIPTION_PADDING = new Insets(0,0,10,0);

    // Color for the description.
    final public static Color DESCRIPTION_COLOR = Color.WHITE;


    // ** Description for the regex box **

    // Description for the regex box.
    final public static String REGEX_BOX_DESCRIPTION = "Enter Regex here: ";


    // ** Description for the Input box **

    // Text of the description.
    final public static String INPUT_BOX_DESCRIPTION = "Enter the String to test the regex pattern on: ";


    // ** Warnings/errors Label for the regex text box **

    // Color.
    final public static Color WARNINGS_COLOR = Color.RED;

    // Default thing to display.
    final public static String DEFAULT_WARNINGS_DISPLAY = "";

    // Starting of the message when there is an error.
    final public static String START_WARNINGS_ERROR = "Error compiling regex: ";


    // ** Description for the Display box **

    // Text to display.
    final public static String DISPLAY_DESCRIPTION = " matches";

    // Colour.
    final public static Color DISPLAY_DESCRIPTION_COLOR = Color.WHITE;


    // ** Display to show matches on the String from the regex **

    // The style for the display.
    final public static String DISPLAY_STYLE = "-fx-background-color: #FFFEFF; -fx-padding: 5; " +
            "-fx-background-radius: 3 3 3 3;";

    // Color for text representing match.
    final public static Color DISPLAY_MATCH_COLOR = Color.RED;

    // Color for text representing unmatches.
    final public static Color DISPLAY_UNMATCHED_COLOR = Color.BLACK;
}