package test;

import java.net.URL;
import java.util.ResourceBundle;

import block.Block;
import block.MoveStage;
import block.Pass;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MainController implements Initializable {

	@FXML
	private ImageView Mario;

	Pass pass = new Pass();
	MoveStage s = new MoveStage();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Mario.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				moveMario(event);
				System.out.println(pass.blockGet(Mario.getX(), Mario.getY(), 11));
			}
		});
	}

	// 키보드 이벤트
	public void moveMario(KeyEvent event) {
		KeyCode keyCode = event.getCode();
		if (keyCode.equals(KeyCode.RIGHT)) {
			if (!s.getPassBlock(pass.blockGet(Mario.getX() + 10, Mario.getY(), 11), "shop").getPass()
					&& Mario.getX() + 10 <= 1000) {
				Mario.setX(Mario.getX() + 10);
			}

		} else if (keyCode.equals(KeyCode.LEFT)) {
			if (!s.getPassBlock(pass.blockGet(Mario.getX() - 10, Mario.getY(), 11), "shop").getPass()
					&& Mario.getX() - 10 >= 0) {
				Mario.setX(Mario.getX() - 10);
			}

		} else if (keyCode.equals(KeyCode.UP)) {
			if (!s.getPassBlock(pass.blockGet(Mario.getX(), Mario.getY() - 10, 11), "shop").getPass()
					&& Mario.getY() - 10 >= 0) {
				Mario.setY(Mario.getY() - 10);
			}

		} else if (keyCode.equals(KeyCode.DOWN)) {
			if (!s.getPassBlock(pass.blockGet(Mario.getX(), Mario.getY() + 10, 11), "shop").getPass()
					&& Mario.getY() < 800) {
				Mario.setY(Mario.getY() + 10);
			}
		} else if (keyCode.equals(KeyCode.SPACE)) {
			mapMove(s.getPassBlock(pass.blockGet(Mario.getX(), Mario.getY() + 10, 11), "shop"));
		}
		
		System.out.println(Mario.getX() + " " + Mario.getY());
	}

	public void mapMove(Block b) {
		try {
			if (b.getType() == 100) {
				Parent sN = FXMLLoader.load(getClass().getResource("/layout/Login.fxml"));
				Scene scene = new Scene(sN);
				Stage primaryStage = (Stage) Mario.getScene().getWindow();
				primaryStage.setScene(scene);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
