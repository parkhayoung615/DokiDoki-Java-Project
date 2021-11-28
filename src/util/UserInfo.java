package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInfo implements Runnable{
	private static String userId;
	private static String stage;
	
	public static String getUserId() {
		return userId;
	}
	public static void setUserId(String userId) {
		UserInfo.userId = userId;
	}
	public static String getStage() {
		return stage;
	}
	public static void setStage(String stage) {
		UserInfo.stage = stage;
	}
	@Override
	public void run() {
		try {
			while (true) {
				JDBCUtil db = new JDBCUtil();
				Connection con = db.getConnection();
				PreparedStatement pstmt = null;
				
				String sql = "UPDATE `data` SET ` `last_map`=? WHERE `user_id` = ?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, stage);
					pstmt.setString(2, userId);
					pstmt.execute();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}
