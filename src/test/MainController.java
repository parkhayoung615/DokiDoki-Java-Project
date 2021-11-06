package test;

import java.net.URL;
import java.util.ResourceBundle;

import block.Pass;
import block.Stage;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainController implements Initializable{
	
	@FXML
	private ImageView Mario;
	
	
	Pass pass = new Pass();
	Stage s = new Stage();
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
    
	// 罹먮┃�꽣 �궎蹂대뱶 �씠�룞
	public void moveMario(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        if (keyCode.equals(KeyCode.RIGHT)) {
        	if (!s.getPassBlock(pass.blockGet(Mario.getX()+10, Mario.getY(), 11), "shop").getPass() && Mario.getX()+10 <= 1000) {
        		Mario.setX(Mario.getX() + 10);
        	}
            
        } else if (keyCode.equals(KeyCode.LEFT)) {
        	if (!s.getPassBlock(pass.blockGet(Mario.getX()-10, Mario.getY(), 11), "shop").getPass() && Mario.getX()-10 >= 0) {
        		Mario.setX(Mario.getX() - 10);
            }
            
        } else if (keyCode.equals(KeyCode.UP)) {
        	if (!s.getPassBlock(pass.blockGet(Mario.getX(), Mario.getY()-10, 11), "shop").getPass() && Mario.getY()-10 >= 0 ) {
        		Mario.setY(Mario.getY() - 10);
            }
            
        } else if (keyCode.equals(KeyCode.DOWN)) {
            if (!s.getPassBlock(pass.blockGet(Mario.getX(), Mario.getY()+10, 11), "shop").getPass() && Mario.getY() < 800) {
            	Mario.setY(Mario.getY() + 10);
            }
        }
        System.out.println(Mario.getX() + " " + Mario.getY());
    }
	
	
	
}
