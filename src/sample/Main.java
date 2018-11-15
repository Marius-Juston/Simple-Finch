package sample;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

  private static final Finch finch = new Finch();
  private static final int velocity = 1;

  public static void main(String[] args) {
    launch(args);
  }

  private static void handleKeyInput(KeyEvent keyEvent) {
    if (keyEvent.getCode() == KeyCode.UP) {
      finch.setWheelVelocities(velocity, velocity);
    } else if (keyEvent.getCode() == KeyCode.DOWN) {
      finch.setWheelVelocities(-velocity, -velocity);
    } else if (keyEvent.getCode() == KeyCode.RIGHT) {
      finch.setWheelVelocities(velocity, -velocity);
    } else if (keyEvent.getCode() == KeyCode.LEFT) {
      finch.setWheelVelocities(-velocity, velocity);
    } else {
      finch.setWheelVelocities(0, 0);
    }

  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Finch Moving");
    primaryStage.setScene(new Scene(new Pane(), 10, 10));

    primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, Main::handleKeyInput);
    primaryStage.show();
  }
}
