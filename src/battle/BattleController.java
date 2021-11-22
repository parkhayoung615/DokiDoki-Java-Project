package battle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import util.JDBCUtil;

public class BattleController {
	
	
	
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
	private Label Txt;
	@FXML
	private Label Hp1;
	@FXML
	private Label Hp2;

	@FXML
	private Button BtnChat;
	
	
	@FXML
	public void initialize() {
		chat("start");
		loadBattle(1, "lang");
		loadBattle(2, "enemy");
	}
	
	private int idx = 0;
	private Language lang = new Language();
	private Language enemy = new Language();
	private ArrayList<String> list = new ArrayList<String>();
	

	public void loadBattle(int langId, String type) {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		Alert alert = new Alert(AlertType.WARNING);
		String sql = "SELECT * FROM `object` WHERE `id` = ?";
		ResultSet rs = null;
		int maxHP = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, langId);
			rs = pstmt.executeQuery();
			Skill[] skills = new Skill[4];
			Button[] skillButtons = {Btn1, Btn2, Btn3, Btn4};
			if (rs.next()) {
				maxHP = rs.getInt("maxHP");
				sql = "SELECT * FROM skills s, object o WHERE o.id = s.object_id = ? AND s.id = ?";
				int j = 0;
				try {
					for (int i = 1; i < 5; i++) {
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, langId);
						pstmt.setInt(2, i);
						rs = pstmt.executeQuery();
						if (rs.next()) {
							skills[j] = new Skill(i, rs.getString("s.name"), rs.getInt("s.dmg"));
							j++;
						}
					}
					
				} catch (Exception e) {
					System.out.println("오류1");
				}
			}
			if (type.equals("lang")) {
				lang.setSkills(skills);
				lang.setId(1);
				lang.setHp(maxHP);
				skillButtons[0].setText(lang.getSkills()[0].getName());
				skillButtons[1].setText(lang.getSkills()[1].getName());
				skillButtons[2].setText(lang.getSkills()[2].getName());
				skillButtons[3].setText(lang.getSkills()[3].getName());
				Hp2.setText("HP : " + maxHP + " / " + maxHP );
			} else {
				enemy.setSkills(skills);
				enemy.setId(1);
				enemy.setHp(maxHP);
				Hp1.setText("HP : " + maxHP + " / " + maxHP );
			}
			
		} catch (Exception e) {
			System.out.println("오류2");
		}
	}
	
	
	@FXML
	public void gobattle() {
		disBtn(BtnBattle);
		asBtn(Btn1);
		asBtn(Btn2);
		asBtn(Btn3);
		asBtn(Btn4);
		 	
	}
	@FXML
	public void skillO() {
		chat();
		System.out.println(lang.getSkills()[0].getName());
	}
	@FXML
	public void skillTw() {
		chat();
		System.out.println(lang.getSkills()[1].getName());
	}
	@FXML
	public void skillT() {
		chat();
		System.out.println(lang.getSkills()[2].getName());
	}
	@FXML
	public void skillF() {
		chat();
		System.out.println(lang.getSkills()[3].getName());
	}
	public void chatLoad(String battle) {
		if (battle.equals("start")) {
			JDBCUtil db = new JDBCUtil();
			Connection con = db.getConnection();
			PreparedStatement pstmt = null;
			Alert alert = new Alert(AlertType.WARNING);
			String sql = "SELECT * FROM `script` WHERE `char_id` = ? AND `scene_id` = ? ORDER BY `id` DESC";
			ResultSet rs = null;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "S-02");
				pstmt.setString(2, "test");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					list.add(rs.getString("script_data"));
				}
					
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else if (battle.equals("battle")) {
			
		} else if (battle.equals("end")) {
			
		}
		
	}
	public void chat(String battle) {
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
		Txt.setText("");
		
		chatLoad(battle);
		
	}
	public void nextChat() {

		if (idx < list.size()) {
			Txt.setText(list.get(idx));
			idx++;
		} else {
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
		Txt.setVisible(false);
		Txt.setDisable(true);
	}
	public void asLabel() {
		Txt.setVisible(true);
		Txt.setDisable(false);
	}
}
