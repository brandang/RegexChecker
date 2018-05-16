import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainGUI gui = new MainGUI();
        RegexChecker checker = new RegexChecker();
        gui.setBackend(checker);
        checker.setFrontend(gui);
        primaryStage.setTitle(Constants.WINDOW_NAME);
        primaryStage.setScene(gui.getScene());
        primaryStage.getIcons().add(new Image(Launcher.class.getResourceAsStream("RegexCheckerIcon.png")));
        primaryStage.show();
    }
}
