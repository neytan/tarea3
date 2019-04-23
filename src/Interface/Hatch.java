package Interface;

import java.util.Random;
import javafx.application.Application;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//import javafx.stage.WindowEvent;

public class Hatch extends Application implements Runnable{

    private final int WIDTH = 600;
    private final int HEIGHT = 500;
    private Pane pane;
    private Scene scene;
    private Canvas canvas;
    private Thread thread;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Random Graphics");
        initComponents(primaryStage);
        primaryStage.show();
    }

    private void initComponents(Stage primaryStage) {
        this.pane = new Pane();
        this.scene = new Scene(this.pane, WIDTH, HEIGHT);
        this.canvas = new Canvas(WIDTH, HEIGHT);
        
        this.thread = new Thread(this);
        this.thread.start();
        
        this.pane.getChildren().add(this.canvas);
        primaryStage.setScene(this.scene);
        //primaryStage.setOnCloseRequest(exit);
    }

    private void myDraw(GraphicsContext gc) {
        Random rand = new Random();
        while(true){    
            try {
                gc.clearRect(0, 0, WIDTH, HEIGHT);
                gc.setFill(Color.GREEN);
                gc.fillRect(rand.nextInt(WIDTH-HEIGHT)+200,rand.nextInt(WIDTH-HEIGHT)+200, 100, 100);
                
                gc.setFill(Color.BLACK);
                gc.fillOval(rand.nextInt(WIDTH-400)+200,rand.nextInt(HEIGHT-400)+100, 100, 100);
                Thread.sleep(500);
            } 
            catch (InterruptedException ex) {}
        }
    }

    @Override
    public void run() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        myDraw(gc);
    }
    
    /*EventHandler<WindowEvent> exit = new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            System.exit(0);
        }
    };*/
}