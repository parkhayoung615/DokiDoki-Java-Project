package test;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import test.SpriteAnimation;
import block.Block;
import block.MoveStage;
import block.Pass;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainController implements Initializable {

	private HashMap<KeyCode, Boolean> keys = new HashMap<>();
	@FXML
	private ImageView Mario;
	@FXML
	private ImageView Mario2;
//	@FXML
//	private AnchorPane testBack;

	Pass pass = new Pass();
	MoveStage s = new MoveStage();
	
	private int width;
	private int height;
	private String view = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		test();
		Mario.setX(550);
		Mario.setY(600);
//		testBack.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
//		    public void handle(KeyEvent event) {
//		        if (event.getCode() == KeyCode.I) {
//		            KeyInventory(event);
//		        }
//		    }
//		});
		Mario.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				moveMario(event);
				System.out.println(pass.blockGet(Mario.getX(), Mario.getY(), 22));
			}
		});
		Mario.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				animation.stop();
			}
		});
	}

		
	// 키보드 이벤트
	public void moveMario(KeyEvent event) {
		KeyCode keyCode = event.getCode();
		if (keyCode.equals(KeyCode.RIGHT)) {
			if (!s.getPassBlock(pass.blockGet(Mario.getX() + 48, Mario.getY() +48, 22), "shop").getPass() && !s.getPassBlock(pass.blockGet(Mario.getX() + 48, Mario.getY() + 5, 22), "shop").getPass()
					&& Mario.getX() + 0 <= 1100) {
				Mario.setX(Mario.getX() + 5);
				
			}
			if (!s.getPassBlock(pass.blockGet(Mario.getX() + 48, Mario.getY() +48, 22), "shop").getPass() && !s.getPassBlock(pass.blockGet(Mario.getX() + 48, Mario.getY() + 5, 22), "shop").getPass()
					&& Mario.getX() + 0 <= 1100) {
				Mario.setX(Mario.getX() + 5);
				
			}
			animation.play();
			animation.setOffsetY(96);
			view = "right";
		} else if (keyCode.equals(KeyCode.LEFT)) {
			if (!s.getPassBlock(pass.blockGet(Mario.getX() - 5, Mario.getY() + 48, 22), "shop").getPass() && !s.getPassBlock(pass.blockGet(Mario.getX() - 5, Mario.getY() + 5, 22), "shop").getPass()
					&& Mario.getX() - 0 >= 0) {
				Mario.setX(Mario.getX() - 5);
				
			}
			if (!s.getPassBlock(pass.blockGet(Mario.getX() - 5, Mario.getY() + 48, 22), "shop").getPass() && !s.getPassBlock(pass.blockGet(Mario.getX() - 5, Mario.getY() + 5, 22), "shop").getPass()
					&& Mario.getX() - 0 >= 0) {
				Mario.setX(Mario.getX() - 5);
				
			}
			animation.play();
			animation.setOffsetY(48);
			view = "left";

		} else if (keyCode.equals(KeyCode.UP)) {
			if (!s.getPassBlock(pass.blockGet(Mario.getX() +38, Mario.getY() - 5, 22), "shop").getPass() && !s.getPassBlock(pass.blockGet(Mario.getX() +0, Mario.getY() - 5, 22), "shop").getPass()
					&& Mario.getY() - 5 >= 0) {
				Mario.setY(Mario.getY() - 5);
				
			}
			if (!s.getPassBlock(pass.blockGet(Mario.getX() +38, Mario.getY() - 5, 22), "shop").getPass() && !s.getPassBlock(pass.blockGet(Mario.getX() +0, Mario.getY() - 5, 22), "shop").getPass()
					&& Mario.getY() - 5 >= 0) {
				Mario.setY(Mario.getY() - 5);
				
			}
			animation.play();
			animation.setOffsetY(144);
			view = "up";
		} else if (keyCode.equals(KeyCode.DOWN)) {
			if (!s.getPassBlock(pass.blockGet(Mario.getX() + 38, Mario.getY() + 55, 22), "shop").getPass() && !s.getPassBlock(pass.blockGet(Mario.getX() + 0, Mario.getY() + 55, 22), "shop").getPass()
					&& Mario.getY() + 48 < 900) {
				Mario.setY(Mario.getY() + 5);
				
			}
			if (!s.getPassBlock(pass.blockGet(Mario.getX() + 38, Mario.getY() + 55, 22), "shop").getPass() && !s.getPassBlock(pass.blockGet(Mario.getX() + 0, Mario.getY() + 55, 22), "shop").getPass()
					&& Mario.getY() + 48 < 900) {
				Mario.setY(Mario.getY() + 5);
				
			}
			
			animation.play();
			animation.setOffsetY(0);
			view = "down";
		} else if (keyCode.equals(KeyCode.SPACE)) {
			mapMove(s.getPassBlock(pass.blockGet(Mario.getX(), Mario.getY() + 20, 22), "shop"));
		}

		System.out.println(Mario.getX() + " " + Mario.getY());
	}

	SpriteAnimation animation;

	public void mapMove(Block b) {
		try {
			if (b.getType() == 100) {
				Parent sN = FXMLLoader.load(getClass().getResource("/layout/Login.fxml"));
				Scene scene = new Scene(sN);
				Stage primaryStage = (Stage) Mario.getScene().getWindow();
				primaryStage.setScene(scene);
			} else if (b.getType() == 101) {
				Parent sN = FXMLLoader.load(getClass().getResource("/battle/BattleLayout.fxml"));
				Scene scene = new Scene(sN);
				Stage primaryStage = (Stage) Mario.getScene().getWindow();
				primaryStage.setScene(scene);
			} else if (b.getType() == 3 && view == "right") {
				Parent sN = FXMLLoader.load(getClass().getResource("/battle/BattleLayout.fxml"));
				Scene scene = new Scene(sN);
				Stage primaryStage = (Stage) Mario.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void test() {
		Mario.setImage(new Image("/imgs/avatar/yong1.png"));
//		Mario.setImage(new Image("./imgs/200x200(px)/TypeScript.png"));
		
		Mario.setScaleY(1.2);
		Mario.setScaleX(1.2);
		animation = new SpriteAnimation(Mario, Duration.millis(500), 3, 4, 0, 0, 48, 48);
		
		Mario2.setImage(new Image("/imgs/avatar/h2.png"));
		Mario2.setScaleX(1.2);
		Mario2.setScaleY(1.2);
		Mario2.setViewport(new Rectangle2D(48, 48, 48, 48));

	}

	public void GoInventory() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("popup.fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Inventory");
			stage.setScene(new Scene(root));
			stage.show(); // popup.show(primaryStage, anchorX, anchorY); 지정된 좌표에서 실행
		} catch (Exception e) {

		}
	}

	public void KeyInventory(KeyEvent event) {
		KeyCode keyCode = event.getCode();
		if (keyCode.equals(KeyCode.I)) {
			System.out.println("인벤토리창 이동");
			GoInventory();
		}
	}

}
