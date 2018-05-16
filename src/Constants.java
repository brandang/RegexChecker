import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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


    // ** The text box for entering in the Regex **

    // The style of the text box for entering the regex.
    final public static String REGEX_BOX_STYLE = "-fx-padding: 5;";

    // Padding for the regex text box.
    final public static Insets REGEX_BOX_PADDING = new Insets(20,20, 20, 20);

    // Font for the regex text box.
    final public static Font REGEX_BOX_FONT = new Font(12);


    // ** Description for the regex text box **

    // Font for the description.
    final public static Font REGEX_BOX_DESCRIPTION_FONT = new Font(12);

    // Description for the regex box.
    final public static String REGEX_BOX_DESCRIPTION = "Enter Regex here: ";

    // Padding for the description.
    final public static Insets REGEX_BOX_DESCRIPTION_PADDING = new Insets(0,0,10,0);

    // Color for the description.
    final public static Color REGEX_BOX_DESCRIPTION_COLOR = Color.WHITE;


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