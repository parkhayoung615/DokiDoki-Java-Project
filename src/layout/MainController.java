package layout;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

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

public class MainController implements Initializable {

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
	private Button Setting;
	@FXML
	private Button EndGame;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	// Start -> Login -> (로딩) -> Index
	// 화면 전환
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

	// Start 화면에서 Login 화면으로 이동
	public void StartChangeLogin() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/Login.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) StartBtn.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// EndGame 누르면 Start 화면으로 이동
	public void ChangeStart() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/Start.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) EndGame.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// setting 누르면 setting 화면으로 이동
		public void ChangeSetting() {
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/layout/Setting.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) Setting.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	// 코멘트
	public void commentH() {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("개발자 코멘트");
			alert.setHeaderText("10103 박하영");
			alert.setContentText("세상에... 피곤하다 아직도 목요일이라니");
			alert.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void commentG() {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("개발자 코멘트");
			alert.setHeaderText("10111 김건우");
			alert.setContentText("코멘트를 입력하세요");
			alert.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void commentKH() {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("개발자 코멘트");
			alert.setHeaderText("10115 김환");
			alert.setContentText("코멘트를 입력하세요");
			alert.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void commentY() {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("개발자 코멘트");
			alert.setHeaderText("10105 임수연");
			alert.setContentText("코멘트를 입력하세요");
			alert.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 로그인
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
			alert.setTitle("빈 값이 있습니다!");
			alert.setHeaderText("Warning Dialog");
			alert.setContentText("아이디와 비밀번호 입력에 오류가 있습니다!");
			alert.show();
		}

		String sql = "SELECT `id`, `password` FROM `user` WHERE `id` = ? AND `password` = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPw);
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// login에서 loading으로 화면 전환*****
				try {
					Parent login = FXMLLoader.load(getClass().getResource("/layout/Index.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
					scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
					primaryStage.setScene(scene);

					// loadMp4(); // loadMp4 실행(미디어뷰)

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				alert.setTitle("오류가 있습니다!");
				alert.setHeaderText("Warning Dialog");
				alert.setContentText("아이디와 비밀번호 입력에 오류가 있습니다!");
				alert.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
			alert.setTitle("오류가 있습니다!");
			alert.setHeaderText("Warning Dialog");
			alert.setContentText("아이디와 비밀번호 입력에 오류가 있습니다!");
			alert.show();
		}
	}

	// 회원가입
	public void join() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String inputJoinId = joinId.getText();
		String inputJoinPw = joinPw.getText();
		Alert alert = new Alert(AlertType.WARNING);

		if (inputJoinId.isEmpty() && inputJoinPw.isEmpty()) {
			alert.setTitle("빈 값이 있습니다!");
			alert.setHeaderText("Warning Dialog");
			alert.setContentText("입력에 오류가 있습니다!");
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
				alert.setTitle("오류가 있습니다!");
				alert.setHeaderText("Warning Dialog");
				alert.setContentText("입력에 오류가 있습니다!");
				alert.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
			alert.setTitle("오류가 있습니다!");
			alert.setHeaderText("Warning Dialog");
			alert.setContentText("입력에 오류가 있습니다!");
			alert.show();
		}
	}

	// 로딩 소스 재생
	public void loadMp4() {
		// 미디어 객체를 소스 폴더의 video.mp4를 이용해만들어 줍니다.
		// 미디어 플레이어에 사용할 파일을 정해 줍니다.
		Media media = new Media(getClass().getResource("/resource/loading.mp4").toString());

		// 미디어 플레이어 생성 및 미디어 뷰에 설정
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);

		// 해당 상태가 되면 실행할 Runnable 설정
		mediaPlayer.setOnReady(new Runnable() {

			// 화면이 동영상이 실행 되는 쓰레드 사용합니다.
			@Override
			public void run() {

				// 시작시 플레이 버튼만 활성화 하고
				// 나머지는 비활성화 함.
				loginBtn.setDisable(false);

			}
		});

		// 플레이 되고 있을 경우의 버튼 활성 비활성의 상태
		// 아래의 경우도 똑 같은 경우입니다.

		mediaPlayer.setOnPlaying(() -> {
			loginBtn.setDisable(true);
		});

		mediaPlayer.setOnPaused(() -> {
			loginBtn.setDisable(false);
		});

		// 비디오가 끝났을 경우의 처리
		// booEnd 변수에 true 를 넣어 재생 버튼을 눌렀을 때
		// 처음 부터 실행 할것인지를 결정 하게 한다.

		
		mediaPlayer.setOnEndOfMedia(() -> { booEnd = true;
		loginBtn.setDisable(false); }); mediaPlayer.setOnStopped(() -> {
		mediaPlayer.seek(mediaPlayer.getStartTime()); loginBtn.setDisable(false); });
		

		// 버튼 ActionEvent 처리
		loginBtn.setOnAction(event -> {

			// 플레이 버튼을 눌렀을때
			// 동영상이 끝날상태 즉 booEnd 에 true 가 들어 가있을 경우에는
			// 종료하고 처음으로 재생시점을 이동한다.
			// 그리고 다시booEnd에 false 를 대입해 지금 동영상이
			// 끝이 아니라는 것을 알려준다.
			if (booEnd) {
				mediaPlayer.stop();
				 mediaPlayer.seek(mediaPlayer.getStartTime());

			}
			 mediaPlayer.play();
			 booEnd = false;
		});

	}
	

	// 창 닫기
	public void closeProgram() { // 현재의 스테이지를 받아서 close를 해주어야 함
		Stage pop = (Stage) EndProgram.getScene().getWindow(); // 버튼을 통해서 현재 스테이지를 알아냄
		pop.close();
	}

//		게임 시작 (새 게임 버튼 눌렀을 때부터)

	public void StartGame() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/StartGame/Start_Narration.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) NewGame.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게임 불러오기 눌렀을 때
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

	
	
}
