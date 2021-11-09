package layout;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController implements Initializable {

	@FXML
	private Button StartBtn;

	@FXML
	private Button ChangeJoinBtn;
	
	@FXML
	private Button ChangeLoginBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void ChangeJoin() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/Join.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) ChangeJoinBtn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public void ChangeLogin() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/Login.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) ChangeLoginBtn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	

}
