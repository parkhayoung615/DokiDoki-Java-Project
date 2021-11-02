package test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainController implements Initializable{
	
	@FXML
	private ImageView Mario;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Mario.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                moveMario(event);
            }
        });
	}
    
	// 캐릭터 키보드 이동
	public void moveMario(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        if (keyCode.equals(KeyCode.RIGHT)) {
            Mario.setX(Mario.getX() + 10);
        } else if (keyCode.equals(KeyCode.LEFT)) {
            Mario.setX(Mario.getX() - 10);
        } else if (keyCode.equals(KeyCode.UP)) {
            Mario.setY(Mario.getY() - 10);
        } else if (keyCode.equals(KeyCode.DOWN)) {
            Mario.setY(Mario.getY() + 10);
        }
    }
}
