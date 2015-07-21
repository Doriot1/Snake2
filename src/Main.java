import javafx.application.Application;
import javafx.stage.Stage;
import model.Context;
import view.MainScreen;

/**
 * Created by Daniel on 18.7.2015.
 */
public class Main extends Application {

    private Context context;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        context = new Context(primaryStage);
        context.switchScene(new MainScreen(context));
    }
}
