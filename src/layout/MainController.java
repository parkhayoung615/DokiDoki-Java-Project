package layout;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
	private Button NewGame;
	@FXML
	private Button LoadGame;
	@FXML
	private Button Setting;
	@FXML
	private Button EndGame;
	@FXML
	private TextField userId;
	@FXML
	private TextField userPw;
	@FXML
	private TextField joinId;
	@FXML
	private TextField joinPw;

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
				// login에서 MainLayout으로 화면 전환
				try {
						Parent login = FXMLLoader.load(getClass().getResource("/layout/Index.fxml"));
						Scene scene = new Scene(login);
						Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
						scene.getStylesheets()
								.add(getClass().getResource("/application/application.css").toExternalForm());
						primaryStage.setScene(scene);
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
	

}
