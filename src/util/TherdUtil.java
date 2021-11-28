package util;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TherdUtil implements Runnable{
	
	private static String userId;
	private String objectId;
	private String avatarId;
	ArrayList<String> objs = new ArrayList<String>();
	public void setUserId(String idd) {
		userId = idd;
	}

	@Override
	public void run() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "SELECY * FROM user_object WHERE AND user_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			while (rs.next()) {
				objectId = rs.getString("id");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		sql = "SELECT u.id, d.avatar_id, o.object_id FROM user u, data d, user_object o  WHERE u.id = ? AND u.id = o.user_id LIKE o.id = '%?%'";
		
		try {
			pstmt = con.prepareStatement(sql);
//			쓰레드 넣어서 가져오기
			pstmt.setString(1, userId);
//			위에랑 같음
			pstmt.setString(2, userId);
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			if (rs.next()) {
				objs.add(rs.getString("o.object_id"));
				avatarId = rs.getString("d.avatar_id");
			}
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		while(true) {
//			toolkit.
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//toolkit.set
	}

}
