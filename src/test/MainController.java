package test;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import battle.BattleController;
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
	@FXML
	private GridPane testBack;

	Pass pass = new Pass();
	MoveStage s = new MoveStage();
	BattleController btc = new BattleController();
	

	private int width;
	private int height;
	private String view = null;
	static String loc = "Start";
	static String map = "BasicMap";

	
	public void setloc(String l) {
		loc = l;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		test();
		if (loc.equals("Start")) {
			Mario.setX(550);
			Mario.setY(600);
		} else if (loc.equals("s01")) {
			view = "right";
			loc = "Start";
			Mario.setX(655);
			Mario.setY(250);
			Mario.setViewport(new Rectangle2D(48, 96, 48, 48));
			
		} else if (loc.equals("Dto3")) {
			Mario.setX(160);
			Mario.setY(485);
			Mario.setViewport(new Rectangle2D(48, 96, 48, 48));
			view = "right";
		} else if (loc.equals("Bto3")) {
			Mario.setX(160);
			Mario.setY(235);
			Mario.setViewport(new Rectangle2D(48, 96, 48, 48));
			view = "right";
		} else if (loc.equals("3toD")) {
			Mario.setX(945);
			Mario.setY(305);
			Mario.setViewport(new Rectangle2D(48, 48, 48, 48));
			view = "left";
		} else if (loc.equals("3toB")) {
			Mario.setX(220);
			Mario.setY(260);
			Mario.setViewport(new Rectangle2D(48, 96, 48, 48));
			view = "right";
		} else if (loc.equals("3to2")) {
			Mario.setX(300);
			Mario.setY(785);
			Mario.setViewport(new Rectangle2D(48, 144, 48, 48));
			view = "up";
		} else if (loc.equals("2to3")) {
			Mario.setX(700);
			Mario.setY(785);
			Mario.setViewport(new Rectangle2D(48, 144, 48, 48));
			view = "up";
		} else if (loc.equals("2to1")) {
			Mario.setX(700);
			Mario.setY(55);
			Mario.setViewport(new Rectangle2D(48, 0, 48, 48));
			view = "down";
		} else if (loc.equals("1to2")) {
			Mario.setX(700);
			Mario.setY(785);
			Mario.setViewport(new Rectangle2D(48, 144, 48, 48));
			view = "up";
		} else if (loc.equals("2tos")) {
			Mario.setX(280);
			Mario.setY(600);
			Mario.setViewport(new Rectangle2D(48, 144, 48, 48));
			view = "up";
		} else if (loc.equals("sto2")) {
			Mario.setX(160);
			Mario.setY(435);
			Mario.setViewport(new Rectangle2D(48, 96, 48, 48));
			view = "right";
		} else if (loc.equals("stoL")) {
			Mario.setX(695);
			Mario.setY(660);
			Mario.setViewport(new Rectangle2D(48, 48, 48, 48));
			view = "left";
		} else if (loc.equals("Ltos")) {
			Mario.setX(110);
			Mario.setY(440);
			Mario.setViewport(new Rectangle2D(48, 96, 48, 48));
			view = "right";
		} else if (loc.equals("stoM")) {
			Mario.setX(250);
			Mario.setY(735);
			Mario.setViewport(new Rectangle2D(48, 144, 48, 48));
			view = "up";
		} else if (loc.equals("Mtos")) {
			Mario.setX(280);
			Mario.setY(335);
			Mario.setViewport(new Rectangle2D(48, 0, 48, 48));
			view = "down";
		} else if (loc.equals("stoR")) {
			Mario.setX(160);
			Mario.setY(540);
			Mario.setViewport(new Rectangle2D(48, 96, 48, 48));
			view = "right";
		} else if (loc.equals("Rtos")) {
			Mario.setX(945);
			Mario.setY(435);
			Mario.setViewport(new Rectangle2D(48, 48, 48, 48));
			view = "left";
		} else if (loc.equals("BattleH")) {
			Mario.setX(405);
			Mario.setY(495);
			Mario.setViewport(new Rectangle2D(48, 96, 48, 48));
			view = "right";
		}
 		

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
			if (!s.getPassBlock(pass.blockGet(Mario.getX() + 48, Mario.getY() + 48, 22), map).getPass()
					&& !s.getPassBlock(pass.blockGet(Mario.getX() + 48, Mario.getY() + 25, 22), map).getPass()
					&& Mario.getX() + 0 <= 1100) {
				Mario.setX(Mario.getX() + 5);

			}
			if (!s.getPassBlock(pass.blockGet(Mario.getX() + 48, Mario.getY() + 48, 22), map).getPass()
					&& !s.getPassBlock(pass.blockGet(Mario.getX() + 48, Mario.getY() + 25, 22), map).getPass()
					&& Mario.getX() + 0 <= 1100) {
				Mario.setX(Mario.getX() + 5);

			}
			animation.play();
			animation.setOffsetY(96);
			view = "right";
		} else if (keyCode.equals(KeyCode.LEFT)) {
			if (!s.getPassBlock(pass.blockGet(Mario.getX() - 5, Mario.getY() + 48, 22), map).getPass()
					&& !s.getPassBlock(pass.blockGet(Mario.getX() - 5, Mario.getY() + 25, 22), map).getPass()
					&& Mario.getX() - 0 >= 0) {
				Mario.setX(Mario.getX() - 5);

			}
			if (!s.getPassBlock(pass.blockGet(Mario.getX() - 5, Mario.getY() + 48, 22), map).getPass()
					&& !s.getPassBlock(pass.blockGet(Mario.getX() - 5, Mario.getY() + 25, 22), map).getPass()
					&& Mario.getX() - 0 >= 0) {
				Mario.setX(Mario.getX() - 5);

			}
			animation.play();
			animation.setOffsetY(48);
			view = "left";

		} else if (keyCode.equals(KeyCode.UP)) {
			if (!s.getPassBlock(pass.blockGet(Mario.getX() + 38, Mario.getY() + 20, 22), map).getPass()
					&& !s.getPassBlock(pass.blockGet(Mario.getX() + 0, Mario.getY() + 20, 22), map).getPass()
					&& Mario.getY() - 5 >= 0) {
				Mario.setY(Mario.getY() - 5);

			}
			if (!s.getPassBlock(pass.blockGet(Mario.getX() + 38, Mario.getY() + 20, 22), map).getPass()
					&& !s.getPassBlock(pass.blockGet(Mario.getX() + 0, Mario.getY() + 20, 22), map).getPass()
					&& Mario.getY() - 5 >= 0) {
				Mario.setY(Mario.getY() - 5);

			}
			animation.play();
			animation.setOffsetY(144);
			view = "up";
		} else if (keyCode.equals(KeyCode.DOWN)) {
			if (!s.getPassBlock(pass.blockGet(Mario.getX() + 38, Mario.getY() + 55, 22), map).getPass()
					&& !s.getPassBlock(pass.blockGet(Mario.getX() + 0, Mario.getY() + 55, 22), map).getPass()
					&& Mario.getY() + 48 < 900) {
				Mario.setY(Mario.getY() + 5);

			}
			if (!s.getPassBlock(pass.blockGet(Mario.getX() + 38, Mario.getY() + 55, 22), map).getPass()
					&& !s.getPassBlock(pass.blockGet(Mario.getX() + 0, Mario.getY() + 55, 22), map).getPass()
					&& Mario.getY() + 48 < 900) {
				Mario.setY(Mario.getY() + 5);

			}

			animation.play();
			animation.setOffsetY(0);
			view = "down";
		} else if (keyCode.equals(KeyCode.SPACE)) {
			mapMove(s.getPassBlock(pass.blockGet(Mario.getX(), Mario.getY() + 25, 22), map));
		} else if (keyCode.equals(KeyCode.I)) {
			System.out.println("인벤토리창 이동");
			GoInventory();
		} else if (keyCode.equals(KeyCode.Q)) {
			System.out.println("상점창 이동");
			GoStore();
		} else if (keyCode.equals(KeyCode.E)) {
			System.out.println("도움말창 이동");
			GoGuide();
		}

		System.out.println(Mario.getX() + " " + Mario.getY());
	}

	SpriteAnimation animation;

	public void mapMove(Block b) {
		try {
			if (b.getType() == 100 && view == "up") {
				Parent sN = FXMLLoader.load(getClass().getResource("/layout/Save.fxml"));
				Scene scene = new Scene(sN);
				Stage primaryStage = (Stage) Mario.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
			} else if (b.getType() == 3 && view == "right") {
				loc = "s01";
				Parent sN = FXMLLoader.load(getClass().getResource("/battle/BattleLayout.fxml"));
				Scene scene = new Scene(sN);
				Stage primaryStage = (Stage) Mario.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
			} else if (b.getType() == 101) {
				chgMap("Dto3", "3level");
				
			} else if (b.getType() == 103) {
				chgMap("3toB", "BasicMap");
				
			} else if (b.getType() == 102) {
				chgMap("Bto3", "3level");
				
			} else if (b.getType() == 99) {
				chgMap("3toD", "DeepMap");
				
			} else if (b.getType() == 104) {
				chgMap("3to2", "2level");
				
			} else if (b.getType() == 105) {
				chgMap("2to3", "3level");
				
			} else if (b.getType() == 106) {
				chgMap("2to1", "1level");
				
			} else if (b.getType() == 107) {
				chgMap("1to2", "2level");
				
			} else if (b.getType() == 108) {
				chgMap("2tos", "SkillsHW");
				
			} else if (b.getType() == 109) {
				chgMap("stoL", "SkillsL");
				
			} else if (b.getType() == 110) {
				chgMap("sto2", "2level");
				
			} else if (b.getType() == 111) {
				chgMap("Ltos", "SkillsHW");
				
			} else if (b.getType() == 112) {
				chgMap("stoM", "SkillsM");
				
			} else if (b.getType() == 113) {
				chgMap("Mtos", "SkillsHW");
				
			} else if (b.getType() == 114) {
				chgMap("stoR", "SkillsR");
				
			} else if (b.getType() == 115) {
				chgMap("Rtos", "SkillsHW");
				
			} else if (b.getType() == 201 && view.equals("right")) {
				btc.setenemy("S-01", "3level");
				goBattle("BattleH");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void test() {
		Mario.setImage(new Image("/imgs/avatar/bae2.png"));
//		Mario.setImage(new Image("./imgs/200x200(px)/TypeScript.png"));

		Mario.setScaleY(1.2);
		Mario.setScaleX(1.2);
		animation = new SpriteAnimation(Mario, Duration.millis(500), 3, 4, 0, 0, 48, 48);

		if (map.equals("shop") || map.equals("BasicMap")) {
			Mario2.setImage(new Image("/imgs/avatar/Min1.png"));
			Mario2.setScaleX(1.2);
			Mario2.setScaleY(1.2);
			Mario2.setViewport(new Rectangle2D(48, 48, 48, 48));
		} else if (map.equals("3level")) {
			Mario2.setImage(new Image("/imgs/avatar/h2.png"));
			Mario2.setScaleX(1.2);
			Mario2.setScaleY(1.2);
			Mario2.setViewport(new Rectangle2D(48, 0, 48, 48));
		} else if (map.equals("DeepMap")) {
			Mario2.setImage(new Image("/imgs/avatar/yong1.png"));
			Mario2.setScaleX(1.2);
			Mario2.setScaleY(1.2);
			Mario2.setViewport(new Rectangle2D(48, 0, 48, 48));
		}
		

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

	public void GoStore() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("popup1.fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Store");
			stage.setScene(new Scene(root));
			stage.show(); // popup.show(primaryStage, anchorX, anchorY); 지정된 좌표에서 실행
		} catch (Exception e) {

		}
	}

	public void GoGuide() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("popup2.fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Guide");
			stage.setScene(new Scene(root));
			stage.show(); // popup.show(primaryStage, anchorX, anchorY); 지정된 좌표에서 실행
		} catch (Exception e) {

		}
	}
	public void chgMap(String l, String m) {
		try {
			loc = l;
			map = m;
			Parent sN = FXMLLoader.load(getClass().getResource("/layout/map/" + m + ".fxml"));
			Scene scene = new Scene(sN);
			Stage primaryStage = (Stage) Mario.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void goBattle(String l) {
		loc = l;
		try {
			Parent sN = FXMLLoader.load(getClass().getResource("/battle/BattleLayout.fxml"));
			Scene scene = new Scene(sN);
			Stage primaryStage = (Stage) Mario.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
