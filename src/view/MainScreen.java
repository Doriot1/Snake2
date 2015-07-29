package view;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.Context;
import model.Snake;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Daniel on 18.7.2015.
 */
public class MainScreen extends GridPane {

    private final Context context;
    private Canvas canvas;
    private GraphicsContext gc;
    private Snake snake;
    private Button button;
    private Timer timer = new Timer();


    public MainScreen(Context context) {
        this.context = context;

        canvas = new Canvas(720, 720);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 4000, 4000);
        add(canvas, 0, 0);
        snake = new Snake();


        initView();
    }

    protected void initView() {
        setWidth(720);
        setHeight(720);
        button = new Button("begin");
        add(button, 2, 2);
        setHgap(10);
        setVgap(10);
        setGridLinesVisible(false);

        button.setOnAction(e -> timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (snake.isAlive())
                        render(snake);
                    else
                        cancel();
                });

            }

        }, 0L, 100L));


        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W)
                snake.setDirection(0);
            else if (e.getCode() == KeyCode.D)
                snake.setDirection(1);
            else if (e.getCode() == KeyCode.S)
                snake.setDirection(2);
            else if (e.getCode() == KeyCode.A)
                snake.setDirection(3);
        });
    }

    public void render(Snake snake) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 720, 720);
        gc.setStroke(Color.WHEAT);
        gc.setLineWidth(4);
        snake.move();
        if (snake.getDirection() == 0)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition(), snake.getYPosition() - 4);
        if (snake.getDirection() == 1)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition() - 4, snake.getYPosition());
        if (snake.getDirection() == 2)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition(), snake.getYPosition() + 4);
        if (snake.getDirection() == 3)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition() + 4, snake.getYPosition());
    }


}
