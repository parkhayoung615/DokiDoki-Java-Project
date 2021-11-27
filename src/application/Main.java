package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// UTF-8 로 개발
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/layout/map/1level.fxml"));
			// Start -> Login -> (로딩) -> Index
			AnchorPane ap = (AnchorPane) loader.load();
			Scene scene = new Scene(ap, 1100, 900);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			primaryStage.setResizable(false); // Fix the screen size
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
