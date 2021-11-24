package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// UTF-8 濡� 媛쒕컻
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/test/TestLayout.fxml"));
			// Start -> Login -> (濡쒕뵫) -> Index
			AnchorPane ap = (AnchorPane) loader.load();
			Scene scene = new Scene(ap, 1100, 900);
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			primaryStage.setResizable(false); // Fix the screen size
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

