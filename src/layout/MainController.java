package layout;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.util.ResourceBundle;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import util.JDBCUtil;
import util.TherdUtil;
import util.UserData;

public class MainController implements Initializable {

	MediaPlayer mp; // �쓬�븙�옱�깮 �씪�씠釉뚮윭由�
	Media m = null; // �쓬�븙 �냼�뒪
	
	//false: �쓬�븙 �굹�삤�뒗 以�
	public boolean mediaMute = false;

	@FXML
	private Button StartBtn;
	@FXML
	private Button ChangeJoinBtn;
	@FXML
	private Button ChangeLoginBtn;
	@FXML
	private Button joinBtn;
	@FXML
	private Button loginBtn;
	@FXML
	private Button loadingBtn;
	@FXML
	private Button NewGame;
	@FXML
	private Button EndProgram;
	@FXML
	private Button EndSave;
	@FXML
	private Button commentH;
	@FXML
	private Button commentG;
	@FXML
	private Button commentI;
	@FXML
	private Button commentK;
	@FXML
	private Button LoadGame;
	@FXML
	private Button EndGame;
	@FXML
	private Button SubmitBtn;
	@FXML
	private TextField userId;
	@FXML
	private PasswordField userPw;
	@FXML
	private TextField joinId;
	@FXML
	private PasswordField joinPw;
	@FXML
	private MediaView mediaView;
	@FXML
	private ImageView imageView;
	@FXML
	private Button buttonPlay;

	private boolean booEnd;
	
	@FXML
	private Button SaveBtn;
	@FXML
	private Label userIDDate;
	@FXML
	private Label userObjDate;
	@FXML
	private Label userBossDate;
	
	@FXML
	private Button ReStartBtn;
	@FXML
	private Button ReLoadBtn;
	@FXML
	private Button LifeEndBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}	
//	public void EndLife() {
//		try {
////			m = new Media(getClass().getResource("/resourse/Doki.mp3").toString());
////			mp = new MediaPlayer(m);
////			Runnable onEnd = new Runnable() {
////				public void run() {
////					mp.dispose();
////					mp = new MediaPlayer(m);
////					mp.play();
////					mp.setOnEndOfMedia(this);
////				}
////			};
////			mp.setOnEndOfMedia(onEnd);
////			mp.play();
//
//			Parent login = FXMLLoader.load(getClass().getResource("/layout/Index3.fxml"));
//			Scene scene = new Scene(login);
//			Stage primaryStage = (Stage) LifeEndBtn.getScene().getWindow();
//			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
//			primaryStage.setScene(scene);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public void ReLoad() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/LoadGame.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) ReLoadBtn.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ReStart() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/StartGame/Start_Narration.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) ReStartBtn.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ChangeJoin() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/Join.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) ChangeJoinBtn.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
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
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Start �솕硫댁뿉�꽌 Login �솕硫댁쑝濡� �씠�룞
	public void StartChangeLogin() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/Login.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) StartBtn.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);

//			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("/resourse/Cursor3.ogg"));
//			Clip clip = AudioSystem.getClip();
//			clip.stop();
//			clip.open(ais);
//			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// EndGame �늻瑜대㈃ Start �솕硫댁쑝濡� �씠�룞
	public void ChangeStart() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/Start.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) EndGame.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			
//			// Index�뿉�꽌 �굹�삤�뜕 �쓬�븙 �쓬�냼嫄�
//			mp.setMute(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 肄붾찘�듃
	public void commentH() {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("媛쒕컻�옄 肄붾찘�듃");
			alert.setHeaderText("10103 諛뺥븯�쁺");
			alert.setContentText("利먭컧 bit.ly/3HZxTeC");
			alert.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void commentG() {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("媛쒕컻�옄 肄붾찘�듃");
			alert.setHeaderText("10111 源�嫄댁슦");
			alert.setContentText("媛쒕컻以묐떒");
			alert.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void commentKH() {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("媛쒕컻�옄 肄붾찘�듃");
			alert.setHeaderText("10115 源��솚");
			alert.setContentText("肄붾찘�듃瑜� �엯�젰�븯�꽭�슂");
			alert.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void commentY() {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("媛쒕컻�옄 肄붾찘�듃");
			alert.setHeaderText("10105 �엫�닔�뿰");
			alert.setContentText("遺덉튇�젅�씠 而⑥뀎�씤 寃뚯엫");
			alert.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 濡쒓렇�씤
	public String userN;
	public String AuserID;
	

	public void loginCheck() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String loginId = userId.getText();
		String loginPw = userPw.getText();
		Alert alert = new Alert(AlertType.WARNING);

		if (loginId.isEmpty() && loginPw.isEmpty()) {
			alert.setTitle("鍮� 媛믪씠 �엳�뒿�땲�떎!");
			alert.setHeaderText("Warning Dialog");
			alert.setContentText("�븘�씠�뵒�� 鍮꾨�踰덊샇 �엯�젰�뿉 �삤瑜섍� �엳�뒿�땲�떎!");
			alert.show();
		}

		String sql = "SELECT `id`, `password` FROM `user` WHERE `id` = ? AND `password` = ?";
//		SELECT u.id, u.password, d.avatar_id, o.object_id FROM user u, data d, user_object o  WHERE u.id = 12 AND u.password = 1234 AND u.id = o.user_id LIKE o.id = '%12%'

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPw);
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			if (rs.next()) {
				try {
					sql = "INSERT INTO `NowData`(`id`, `user_id`, `Boss_id`, `object_id`) VALUES (?,?,?,?)";
					try {
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, 1);
						pstmt.setString(2, loginId);
						pstmt.setString(3, "");
						pstmt.setString(4, "");
						pstmt.executeUpdate();
					} catch (Exception e) {
						// TODO: handle exception
					}

					Parent login = FXMLLoader.load(getClass().getResource("/layout/Index.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
					scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
					primaryStage.setScene(scene);
					
					// �벐�젅�뱶�뿉 濡쒓렇�씤 �젙蹂� �떞湲�
					//Thread t = new Thread(new TherdUtil(loginId));
					//t.start();

					m = new Media(getClass().getResource("/resourse/Index.mp3").toString());
					mp = new MediaPlayer(m);
					Runnable onEnd = new Runnable() {
						public void run() {
							mp.dispose();
							mp = new MediaPlayer(m);
							mp.play();
							mp.setOnEndOfMedia(this);
						}
					};
					mp.setOnEndOfMedia(onEnd);
					mp.play();

//					�냼由� �꼫臾� �겮!!

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				alert.setTitle("�삤瑜섍� �엳�뒿�땲�떎!");
				alert.setHeaderText("Warning Dialog");
				alert.setContentText("�븘�씠�뵒�� 鍮꾨�踰덊샇 �엯�젰�뿉 �삤瑜섍� �엳�뒿�땲�떎!");
				alert.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
			alert.setTitle("�삤瑜섍� �엳�뒿�땲�떎!");
			alert.setHeaderText("Warning Dialog");
			alert.setContentText("�븘�씠�뵒�� 鍮꾨�踰덊샇 �엯�젰�뿉 �삤瑜섍� �엳�뒿�땲�떎!");
			alert.show();
		}
	}
	
	

	// �쉶�썝媛��엯
	public void join() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String inputJoinId = joinId.getText();
		String inputJoinPw = joinPw.getText();
		Alert alert = new Alert(AlertType.WARNING);

		if (inputJoinId.isEmpty() && inputJoinPw.isEmpty()) {
			alert.setTitle("鍮� 媛믪씠 �엳�뒿�땲�떎!");
			alert.setHeaderText("Warning Dialog");
			alert.setContentText("�엯�젰�뿉 �삤瑜섍� �엳�뒿�땲�떎!");
			alert.show();
		}

		String sql = "INSERT INTO `user`(`id`, `password`) VALUES (?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputJoinId);
			pstmt.setString(2, inputJoinPw);
			pstmt.executeUpdate();
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/layout/Login.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) joinBtn.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
				alert.setTitle("�삤瑜섍� �엳�뒿�땲�떎!");
				alert.setHeaderText("Warning Dialog");
				alert.setContentText("�엯�젰�뿉 �삤瑜섍� �엳�뒿�땲�떎!");
				alert.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
			alert.setTitle("�삤瑜섍� �엳�뒿�땲�떎!");
			alert.setHeaderText("Warning Dialog");
			alert.setContentText("�엯�젰�뿉 �삤瑜섍� �엳�뒿�땲�떎!");
			alert.show();
		}
	}

	// 濡쒕뵫 �냼�뒪 �옱�깮
	public void loadMp4() {
		// 誘몃뵒�뼱 媛앹껜瑜� �냼�뒪 �뤃�뜑�쓽 video.mp4瑜� �씠�슜�빐留뚮뱾�뼱 以띾땲�떎.
		// 誘몃뵒�뼱 �뵆�젅�씠�뼱�뿉 �궗�슜�븷 �뙆�씪�쓣 �젙�빐 以띾땲�떎.
		Media media = new Media(getClass().getResource("/resource/loading.mp4").toString());
		// 誘몃뵒�뼱 �뵆�젅�씠�뼱 �깮�꽦 諛� 誘몃뵒�뼱 酉곗뿉 �꽕�젙
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		// �빐�떦 �긽�깭媛� �릺硫� �떎�뻾�븷 Runnable �꽕�젙
		mediaPlayer.setOnReady(new Runnable() {
			// �솕硫댁씠 �룞�쁺�긽�씠 �떎�뻾 �릺�뒗 �벐�젅�뱶 �궗�슜�빀�땲�떎.
			@Override
			public void run() {
				// �떆�옉�떆 �뵆�젅�씠 踰꾪듉留� �솢�꽦�솕 �븯怨�
				// �굹癒몄��뒗 鍮꾪솢�꽦�솕 �븿.
				loginBtn.setDisable(false);
			}
		});
		// �뵆�젅�씠 �릺怨� �엳�쓣 寃쎌슦�쓽 踰꾪듉 �솢�꽦 鍮꾪솢�꽦�쓽 �긽�깭
		// �븘�옒�쓽 寃쎌슦�룄 �삊 媛숈� 寃쎌슦�엯�땲�떎.
		mediaPlayer.setOnPlaying(() -> {
			loginBtn.setDisable(true);
		});

		mediaPlayer.setOnPaused(() -> {
			loginBtn.setDisable(false);
		});
		// 鍮꾨뵒�삤媛� �걹�궗�쓣 寃쎌슦�쓽 泥섎━
		// booEnd 蹂��닔�뿉 true 瑜� �꽔�뼱 �옱�깮 踰꾪듉�쓣 �닃���쓣 �븣
		// 泥섏쓬遺��꽣 �떎�뻾 �븷寃껋씤吏�瑜� 寃곗젙 �븯寃� �븳�떎.
		mediaPlayer.setOnEndOfMedia(() -> {
			booEnd = true;
			loginBtn.setDisable(false);
		});
		mediaPlayer.setOnStopped(() -> {
			mediaPlayer.seek(mediaPlayer.getStartTime());
			loginBtn.setDisable(false);
		});

		// 踰꾪듉 ActionEvent 泥섎━
		loginBtn.setOnAction(event -> {
			// �뵆�젅�씠 踰꾪듉�쓣 �닃���쓣�븣
			// �룞�쁺�긽�씠 �걹�궇�긽�깭 利� booEnd �뿉 true 媛� �뱾�뼱 媛��엳�쓣 寃쎌슦�뿉�뒗
			// 醫낅즺�븯怨� 泥섏쓬�쑝濡� �옱�깮�떆�젏�쓣 �씠�룞�븳�떎.
			// 洹몃━怨� �떎�떆booEnd�뿉 false 瑜� ���엯�빐 吏�湲� �룞�쁺�긽�씠
			// �걹�씠 �븘�땲�씪�뒗 寃껋쓣 �븣�젮以��떎.
			if (booEnd) {
				mediaPlayer.stop();
				mediaPlayer.seek(mediaPlayer.getStartTime());
			}
			mediaPlayer.play();
			booEnd = false;
		});
	}

	// 李� �떕湲�
	public void closeProgram() { // �쁽�옱�쓽 �뒪�뀒�씠吏�瑜� 諛쏆븘�꽌 close瑜� �빐二쇱뼱�빞 �븿
		Stage pop = (Stage) EndProgram.getScene().getWindow(); // 踰꾪듉�쓣 �넻�빐�꽌 �쁽�옱 �뒪�뀒�씠吏�瑜� �븣�븘�깂
		pop.close();
		
//		// Index�뿉�꽌 �굹�삤�뜕 �쓬�븙 �쓬�냼嫄�
//		mp.setMute(true);
	}
	
	public void EndSave() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/map/BasicMap.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) EndSave.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


//		寃뚯엫 �떆�옉 (�깉 寃뚯엫 踰꾪듉 �닃���쓣 �븣遺��꽣)
	public void StartGame() {
		try {

			Parent login = FXMLLoader.load(getClass().getResource("/layout/StartGame/Start_Narration.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) NewGame.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			
			// Index�뿉�꽌 �굹�삤�뜕 �쓬�븙 �쓬�냼嫄�
//			mediaMute = true;
//			if(mediaMute == true) {
//				mp.setMute(mediaMute);
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 寃뚯엫 遺덈윭�삤湲� �닃���쓣 �븣
	public void LoadGame() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/LoadGame.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) LoadGame.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SubChg() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/Clear.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) SubmitBtn.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
