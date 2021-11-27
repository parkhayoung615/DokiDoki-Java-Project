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
	private Button NarBtn;
	@FXML
	private Label NarLabel;

	private int idx = 0;
	private ArrayList<String> list = new ArrayList<String>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chatLoad("StartNRS1");
		chatLoad02("StartNRS2");
	}
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

	public void chatLoad(String point) {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM script s WHERE s.id LIKE ?";
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
			// TODO: handle exception
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
	
	public void chatLoad02(String point) {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM script s WHERE s.id LIKE ?";
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
			// TODO: handle exception
		}
	}

	@FXML
	public void nextChat02() {
		if (idx < list.size()) {
			NarLabel.setText(list.get(idx));
			idx++;
		} else {
			idx = 0;
			list.clear();
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/layout/StartGame/Start_illustration.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) NarBtn.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}
