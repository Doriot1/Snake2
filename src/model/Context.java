package model;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Daniel on 18.7.2015.
 */

public class Context {
    private Stage primaryStage;
    private Scene currScene;

    public Context(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public void switchScene(Parent root){
        currScene = (new Scene(root));
        primaryStage.setScene(currScene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        primaryStage.show();
    }

}
