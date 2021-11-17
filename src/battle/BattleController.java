package battle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import util.JDBCUtil;

public class BattleController {
	
	@FXML
	public void initialize() {
		chat();
	}
	
	@FXML
	private Button Btn1;
	@FXML
	private Button Btn2;
	@FXML
	private Button Btn3;
	@FXML
	private Button Btn4;
	@FXML
	private Button BtnBattle;
	@FXML
	private Button BtnChg;
	@FXML
	private Button BtnBag;
	@FXML
	private Button BtnRun;
	@FXML
	private Label Txt1;
	@FXML
	private Label Txt2;
	@FXML
	private Label Txt3;
	@FXML
	private Button BtnChat;
	
	private Language lang = new Language();
	public void loadBattle() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		Alert alert = new Alert(AlertType.WARNING);
		String sql = "SELECT * FROM `language` WHERE `id` = ?";
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 1);
			rs = pstmt.executeQuery();
			int hp;
			int[] skills = new int[4];
			if (rs.next()) {
				hp = rs.getInt("hp");
				skills[0] = rs.getInt("skillfi");
				skills[1] = rs.getInt("skillse");
				skills[2] = rs.getInt("skillth");
				skills[3] = rs.getInt("skillfo");
				sql = "SELECT * FOM `skills` WHERE `id` = ?";
				try {
					for (int i : skills) {
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, i);
						rs = pstmt.executeQuery();
						if (rs.next()) {
//							lang.setSkills({new Skill(rs.getInt("id")), new Skill(rs.getString("name")), new Skill(rs.getInt("dmg"))]);
						}
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@FXML
	public void battle() {
		disBtn(BtnBattle);
		asBtn(Btn1);
		asBtn(Btn2);
		asBtn(Btn3);
		asBtn(Btn4);
		 	
	}
	@FXML
	public void skillO() {
		chat();
	}
	@FXML
	public void skillTw() {
		chat();
	}
	@FXML
	public void skillT() {
		chat();
	}
	@FXML
	public void skillF() {
		chat();
	}
	public void chat() {
		disBtn(Btn1);
		disBtn(Btn2);
		disBtn(Btn3);
		disBtn(Btn4);
		disBtn(BtnBattle);
		disBtn(BtnChg);
		disBtn(BtnBag);
		disBtn(BtnRun);
		asLabel();
		BtnChat.setDisable(false);
		BtnChat.setVisible(true);
		
	}
	public void nextChat() {
		BtnChat.setDisable(true);
		Btn1.setVisible(true);
		Btn2.setVisible(true);
		Btn3.setVisible(true);
		Btn4.setVisible(true);
		asBtn(BtnChat);
		asBtn(BtnRun);
		asBtn(BtnChg);
		asBtn(BtnBag);
		asBtn(BtnBattle);
		disBtn(BtnChat);
		disLabel();
	}
	
	public void disBtn(Button Btn) {
		Btn.setVisible(false);
		Btn.setDisable(true);
	}
	public void asBtn(Button Btn) {
		Btn.setVisible(true);
		Btn.setDisable(false);
	}
	public void disLabel() {
		Txt1.setVisible(false);
		Txt1.setDisable(true);
		Txt2.setVisible(false);
		Txt2.setDisable(true);
		Txt3.setVisible(false);
		Txt3.setDisable(true);
	}
	public void asLabel() {
		Txt1.setVisible(true);
		Txt1.setDisable(false);
		Txt2.setVisible(true);
		Txt2.setDisable(false);
		Txt3.setVisible(true);
		Txt3.setDisable(false);
	}
}
