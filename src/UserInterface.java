// Noah Drew - 8/22/18
// Program simulates a Call Attendant system

// Imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserInterface extends Application {

	// Main method to launch program
	public static void main(String[] args) {
		launch(args);
	}

	// Start method for Java FX
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Create Seat objects
		Seat seat1 = new Seat();
		Seat seat2 = new Seat();
		Seat seat3 = new Seat();
		Seat seat4 = new Seat();
		Seat seat5 = new Seat();
		
		// Set up main layout
		HBox root = new HBox(220);
		VBox leftSideVbox = new VBox(40);
		VBox rightSideVbox = new VBox(40);
		
		// Add 3 buttons to represent 3 seats
		Button buttonSeat1 = new Button("Seat 1 Call");
		buttonSeat1.setPrefSize(140, 140);
		Button buttonSeat2 = new Button("Seat 2 Call");
		buttonSeat2.setPrefSize(140, 140);
		Button buttonSeat3 = new Button("Seat 3 Call");
		buttonSeat3.setPrefSize(140, 140);
			
		leftSideVbox.getChildren().add(buttonSeat1);
		leftSideVbox.getChildren().add(buttonSeat2);
		leftSideVbox.getChildren().add(buttonSeat3);
		
		// Add 3 buttons to represent 3 more seats
		Button buttonSeat4 = new Button("Seat 4 Call");
		buttonSeat4.setPrefSize(140, 140);
		Button buttonSeat5 = new Button("Seat 5 Call");
		buttonSeat5.setPrefSize(140, 140);
		Button buttonAttendant = new Button("Attendant Off");
		buttonAttendant.setPrefSize(140, 140);
		
		rightSideVbox.getChildren().add(buttonSeat4);
		rightSideVbox.getChildren().add(buttonSeat5);
		rightSideVbox.getChildren().add(buttonAttendant);
		
		root.getChildren().add(leftSideVbox);
		root.getChildren().add(rightSideVbox);
		
		// Button on actions
		buttonSeat1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				toggleLight(seat1, buttonSeat1);
			}
		});
		
		buttonSeat2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				toggleLight(seat2, buttonSeat2);
			}
		});
		
		buttonSeat3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				toggleLight(seat3, buttonSeat3);
			}
		});
		
		buttonSeat4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				toggleLight(seat4, buttonSeat4);
			}
		});
		
		buttonSeat5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				toggleLight(seat5, buttonSeat5);
			}
		});	
		
		// When attendant button is pressed, turn off all lights
		buttonAttendant.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				seat1.turnOffCallLight();
				seat2.turnOffCallLight();
				seat3.turnOffCallLight();
				seat4.turnOffCallLight();
				seat5.turnOffCallLight();
				
				buttonSeat1.setStyle(null);
				buttonSeat2.setStyle(null);
				buttonSeat3.setStyle(null);
				buttonSeat4.setStyle(null);
				buttonSeat5.setStyle(null);
			}			
		});
		
		// Configure and show Scene and Stage
		Scene scene = new Scene(root,500,500);
		primaryStage.setTitle("Call Attendant Application");		
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	// Turn light on or off based on its current state
	private void toggleLight(Seat seat, Button button) {
		
		if (seat.getCallLightState()) {
			seat.turnOffCallLight();
			button.setStyle(null);
		} else {
			seat.turnOnCallLight();
			button.setStyle("-fx-background-color: #FFFF00;");
		}
	}
}
