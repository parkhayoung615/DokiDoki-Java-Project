package layout.StartGame;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import util.JDBCUtil;

public class MainController implements Initializable {

	@FXML
	private Button NarraStartBtn;
	@FXML
	private Label NStartName;
	@FXML
	private Label NarraLabel;
	@FXML
	private Button Next;

	@FXML
	private Button EntryBtn;
	@FXML
	private Button ScratchBtn;

	private int idx = 0;
	private ArrayList<String> list = new ArrayList<String>();
	static int chatNum = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (chatNum == 0) {
			chatLoad("StartNRS1");
			chatNum++;
		} else if (chatNum == 1) {
			chatLoad("StartNRS2");
		} else if (chatNum == 2) {
			chatLoad("StartS");
		} else if (chatNum == 3) {
			chatLoad("StartE");
		}
		
	}

	public void chatLoad(String point) {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT s.script_data FROM script s WHERE s.id LIKE ?";
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + point + "%");
			rs = pstmt.executeQuery();
			System.out.println(1);
			while (rs.next()) {
				list.add(rs.getString("s.script_data"));
			}
		} catch (Exception e) {
		}
	}
	
	@FXML
	public void nextChat() {
		if (idx < list.size()) {
			NarraLabel.setText(list.get(idx));
			idx++;
		} else {
			idx = 0;
			list.clear();
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/layout/StartGame/Start_illustration.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) NarraStartBtn.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
//	일러스트 넘기기
	@FXML
	public void next1() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/StartGame/Start_Min.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Next.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// 고르는 화면으로 넘ㄴ어가기
	@FXML
	public void nextChat02() {
		if (idx < list.size()) {
			NarraLabel.setText(list.get(idx));
			idx++;
		} else {
			idx = 0;
			list.clear();
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/layout/StartGame/Select.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) NarraStartBtn.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

//
////	일러스트 이후 ...
//	public void chatLoad02(String point) {
//		JDBCUtil db = new JDBCUtil();
//		Connection con = db.getConnection();
//		PreparedStatement pstmt = null;
//		String sql = "SELECT s.script_data FROM script s WHERE s.id LIKE LIKE ?";
//		ResultSet rs = null;
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, "%" + point + "%");
//			rs = pstmt.executeQuery();
//			System.out.println(2);
//			while (rs.next()) {
//				list.add(rs.getString("s.script_data"));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
// 
//	
//	
//	public void chatLoad03(String point) {
//		JDBCUtil db = new JDBCUtil();
//		Connection con = db.getConnection();
//		PreparedStatement pstmt = null;
//		String sql = "SELECT s.script_data FROM script s WHERE s.id LIKE LIKE ?";
//		ResultSet rs = null;
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, "%" + point + "%");
//			rs = pstmt.executeQuery();
//			System.out.println(2);
//			while (rs.next()) {
//				list.add(rs.getString("s.script_data"));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

	
	

	
//	엔트리 골랐을 때
	public void SelectObjEntry() {
		chatNum += 2;
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/layout/StartGame/SelectAfter.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) EntryBtn.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			chatNum = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	스크래치 골랐ㅇ르 때
	public void SelectObjScratch() {
		chatNum++;
//		JDBCUtil db = new JDBCUtil();
//		Connection con = db.getConnection();
//		PreparedStatement pstmt = null;
//		String sql = "INSERT INTO `user_object`(`id`, `object_id`, `user_id`) VALUES (?,'14',?)";
		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, inputJoinId);
//			pstmt.setString(2, inputJoinName);
//			pstmt.executeUpdate();
//			try {
				Parent login = FXMLLoader.load(getClass().getResource("/layout/StartGame/SelectAfter.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) ScratchBtn.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
				chatLoad("StartS");
				chatNum = 0;
//			} catch (Exception e) {
//				
//			}
		} catch (Exception e) {
		}
	}
	
	public void JavaScript() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO `user_object`(`id`, `object_id`, `user_id`) VALUES (?,'5',?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputJoinId);
			pstmt.setString(2, inputJoinName);
			pstmt.executeUpdate();
			util.AppUtil.alert("자바스크립트를 배우셨습니다.", null);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// 게임 화면으로 넘어가기
	@FXML
	public void nextChat03() {
		if (idx < list.size()) {
			NarraLabel.setText(list.get(idx));
			idx++;
		} else {
			idx = 0;
			list.clear();
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/layout/map/BasicMap.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) NarraStartBtn.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
