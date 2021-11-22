package battle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private ProgressBar hpBar2;
	@FXML
	private ProgressBar hpBar1;
	@FXML
	private Button BtnChat;
	@FXML
	private ImageView langImg;
	@FXML
	private ImageView enemyImg;
	
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
	private int enemySkill;
	private int langSkill;

	public void loadBattle(int langId, String type) {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		Alert alert = new Alert(AlertType.WARNING);
		String sql = "SELECT * FROM `object` WHERE `id` = ?";
		ResultSet rs = null;
		Skill[] skills = new Skill[4];
		Button[] skillButtons = {Btn1, Btn2, Btn3, Btn4};
		int maxHP = 0;
		String langName = null;
		String name = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, langId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				langName = rs.getString("name");
				maxHP = rs.getInt("hp");
				name = rs.getString("name");
			}
		} catch (Exception e) {
			System.out.println(2);
		}
		sql = "SELECT * FROM skills s, object o WHERE o.id = ? AND s.object_id = ? AND s.id = ?";

		int j = 0;
		try {
			for (int i = 1; i < 5; i++) {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, langId);
				pstmt.setInt(2, langId);
				String id = langName + "_0" + i;
				System.out.println(id);
				pstmt.setString(3, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					skills[j] = new Skill(id, rs.getString("s.name"), rs.getInt("s.dmg"));
					System.out.println(rs.getString("s.name"));
					j++;
				}
				
			}
			System.out.println(j);

		} catch (Exception e) {
			System.out.println("오류1");
		}
		try {
			if (type.equals("lang")) {
				lang.setSkills(skills);
				lang.setId(langId);
				lang.setHp(maxHP);
				lang.setMaxHp(maxHP);
				lang.setName(name);
				langImg.setImage(new Image("/imgs/200x200(px)/" + name + ".png"));
				skillButtons[0].setText(lang.getSkills()[0].getName());
				skillButtons[1].setText(lang.getSkills()[1].getName());
				skillButtons[2].setText(lang.getSkills()[2].getName());
				skillButtons[3].setText(lang.getSkills()[3].getName());
				System.out.println(12121);
				Hp2.setText("HP : " + maxHP + " / " + maxHP);
				setBar("lang");
				
			} else if (type.equals("enemy")){
				enemy.setSkills(skills);
				enemy.setId(langId);
				enemy.setHp(maxHP);
				enemy.setMaxHp(maxHP);
				enemy.setName(name);
				enemyImg.setImage(new Image("/imgs/200x200(px)/" + name + ".png"));
				Hp1.setText("HP : " + maxHP + " / " + maxHP);
				setBar("enemy");
			}
		} catch (Exception e) {
			System.out.println("zz");
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
	public void battle(int num) {
		langSkill = num;
		try {
			Random r = new Random();
			enemySkill = r.nextInt(4);
			System.out.println(enemySkill);
			enemy.setHp(enemy.getHp() - lang.getSkills()[num].getDmg());
			lang.setHp(lang.getHp()  - enemy.getSkills()[enemySkill].getDmg());
			
			if (lang.getHp() <= 0 && enemy.getHp() <= 0) {
				lang.setHp(0);
				enemy.setHp(0);
			} else if (lang.getHp() <= 0) {
				lang.setHp(0);
			} else if (enemy.getHp() <= 0) {
				enemy.setHp(0);
			} else {
				
			}
			setBar("lang");
			setBar("enemy");
			Hp1.setText("HP : " + enemy.getHp() + " / " + enemy.getMaxHp() );
			Hp2.setText("HP : " + lang.getHp() + " / " + lang.getMaxHp() );
			chat("battle");
			
		} catch (Exception e) {
			
			// TODO: handle exception
		}
		
	}
	public void win() {
		
	}
	@FXML
	public void skillO() {
		System.out.println(lang.getSkills()[0].getName());
		battle(0);
	}
	@FXML
	public void skillTw() {
		System.out.println(lang.getSkills()[1].getName());
		battle(1);
	}
	@FXML
	public void skillT() {
		System.out.println(lang.getSkills()[2].getName());
		battle(2);
	}
	@FXML
	public void skillF() {
		System.out.println(lang.getSkills()[3].getName());
		battle(3);
	}
	public void setBar(String type) {
		if (type.equals("lang")) {
			hpBar2.setProgress(((double) (int) ((double)lang.getHp() / (double)lang.getMaxHp() * 1000)) / 1000);
		} else if (type.equals("enemy")) {
			hpBar1.setProgress(((double) (int) ((double)enemy.getHp() / (double)enemy.getMaxHp() * 1000)) / 1000);
		}
		
		
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
				pstmt.setString(1, "1");
				pstmt.setString(2, "test");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					list.add(rs.getString("script_data"));
				}
					
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else if (battle.equals("battle")) {
			String s = lang.getName();
			String e = enemy.getName();
			list.add("'배인영'의 " + s + "은(는) " + e + "에게 \n" + lang.getSkills()[langSkill].getName() + "을(를) 사용했다.");
			list.add(s + "은(는) " + e + "에게 " + lang.getSkills()[langSkill].getDmg() + "데미지를 입혔다.");
			list.add(e + "은(는) " + s + "에게 \n" + enemy.getSkills()[enemySkill].getName() + "을(를) 사용했다.");
			list.add(e + "은(는) " + s + "에게 " + enemy.getSkills()[enemySkill].getDmg() + "데미지를 입혔다.");
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
	@FXML
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
			idx = 0;
			list.clear();
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
