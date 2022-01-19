package main;

import gui.guiFreizeitbaeder.FreizeitbaederControl;
import gui.guiSportstaetten.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		new FreizeitbaederControl(primaryStage);
		Stage fensterSportstaetten = new Stage();
		new SportstaettenControl(fensterSportstaetten);
	}

	public static void main(String[] args) {
		launch(args);
	
	}
}