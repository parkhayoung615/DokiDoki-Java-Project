package battle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import test.MainController;
import javafx.scene.control.Alert.AlertType;
import util.BattleTimer;
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
	private Label name1;
	@FXML
	private Label name2;
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
	private Pane myLangs;
	@FXML
	private Pane lang1;
	@FXML
	private Pane lang2;
	@FXML
	private Pane lang3;
	@FXML
	private Pane lang4;
	@FXML
	private Pane lang5;
	@FXML
	private Pane lang6;
	@FXML
	private Label nameLang1;
	@FXML
	private Label nameLang2;
	@FXML
	private Label nameLang3;
	@FXML
	private Label nameLang4;
	@FXML
	private Label nameLang5;
	@FXML
	private Label nameLang6;
	@FXML
	private Label langHp1;
	@FXML
	private Label langHp2;
	@FXML
	private Label langHp3;
	@FXML
	private Label langHp4;
	@FXML
	private Label langHp5;
	@FXML
	private Label langHp6;
	@FXML
	private ImageView langImg1;
	@FXML
	private ImageView langImg2;
	@FXML
	private ImageView langImg3;
	@FXML
	private ImageView langImg4;
	@FXML
	private ImageView langImg5;
	@FXML
	private ImageView langImg6;
	@FXML
	private Button langBtn1;
	@FXML
	private Button langBtn2;
	@FXML
	private Button langBtn3;
	@FXML
	private Button langBtn4;
	@FXML
	private Button langBtn5;
	@FXML
	private Button langBtn6;
	@FXML
	private ImageView langavatar;
	@FXML
	private ImageView enemyavatar;
	
	
	@FXML
	public void initialize() {
		enemyavatar.setImage(new Image("/imgs/battle/Su.png"));
		BattleTimer aab = new BattleTimer();
		aab.setimg(enemyavatar, langavatar);
		Thread t = new Thread(new BattleTimer());
		t.start();
		
		loc = "s01";
		chat("start");
		loadAll();
		loadEnemy("S-01");
		loadLang("12");
		int k = 0;
		for (Integer a : langList) {
			loadBattle(a, "lang", k);
			Language langh = new Language(lang.getName(), lang.getId(), lang.getHp(), lang.getMaxHp(),
					lang.getSkills());
			langs[k] = langh;
			k++;
		}
		System.out.println(langs[0].getHp() + langs[1].getName() + langs[2].getName() + langs[3].getName());
		k = 0;
		for (Integer a : enemyList) {
			loadBattle(a, "enemy", k);
			Language enemyh = new Language(enemy.getName(), enemy.getId(), enemy.getHp(), enemy.getMaxHp(),
					enemy.getSkills());
			enemys[k] = enemyh;
			k++;
		}
		loadBattle(langs[0].getId(), "lang", 0);
		loadBattle(enemys[0].getId(), "enemy", 0);
		rstGame = "game";
	}

	private String loc = null;
	private int langIdx = 0;
	private int enemyIdx = 0;
	private int idx = 0;
	private Language[] langs = new Language[6];
	private Language[] enemys = new Language[6];
	private Language lang = new Language();
	private Language enemy = new Language();
	private ArrayList<Integer> langList = new ArrayList<Integer>();
	private ArrayList<Integer> enemyList = new ArrayList<Integer>();
	private ArrayList<String> list = new ArrayList<String>();
	private int enemySkill;
	private int langSkill;
	private String rstGame = null;

	
	public void loadBattle(int langId, String type, int langNum) {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM `object` WHERE `id` = ?";
		ResultSet rs = null;
		Skill[] skills = new Skill[4];
		Button[] skillButtons = { Btn1, Btn2, Btn3, Btn4 };
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
				if (langName.equals("JavaScript")) {
					langName = "Js";
				}
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
				lang.setMaxHp(maxHP);
				lang.setName(name);
				if (langs[langNum].getName().equals("null")) {
					lang.setHp(maxHP);
				} else {
					lang.setHp(langs[langNum].getHp());
				}
				langImg.setImage(new Image("/imgs/200x200(px)/" + name + ".png"));
				skillButtons[0].setText(lang.getSkills()[0].getName());
				skillButtons[1].setText(lang.getSkills()[1].getName());
				skillButtons[2].setText(lang.getSkills()[2].getName());
				skillButtons[3].setText(lang.getSkills()[3].getName());
				System.out.println(12121);
				Hp2.setText("HP : " + lang.getHp() + " / " + maxHP);
				name2.setText(name);
				setBar("lang");

			} else if (type.equals("enemy")) {
				enemy.setSkills(skills);
				enemy.setId(langId);
				enemy.setMaxHp(maxHP);
				enemy.setName(name);
				if (enemys[langNum].getName().equals("null")) {
					enemy.setHp(maxHP);
				} else {
					enemy.setHp(enemys[langNum].getHp());
				}
				enemyImg.setImage(new Image("/imgs/200x200(px)/" + name + ".png"));
				Hp1.setText("HP : " + enemy.getHp() + " / " + maxHP);
				name1.setText(name);
				setBar("enemy");
			}
		} catch (Exception e) {
			System.out.println("zz");
		}

	}

	public void loadEnemy(String a_id) {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT a.object_id FROM object u, avatar_object a WHERE a.object_id = u.id AND a.avatar_id = ?";
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				enemyList.add(rs.getInt("a.object_id"));
				System.out.println(rs.getInt("a.object_id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void loadLang(String u_id) {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT u.object_id FROM object o, user_object u WHERE o.id = u.object_id AND u.user_id = ?";
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				langList.add(rs.getInt("u.object_id"));
				System.out.println(rs.getInt("u.object_id") + "1111111111111111111111111111111111111");
			}
		} catch (Exception e) {
			// TODO: handle exception
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
			if (enemy.getHp() > 0) {
				lang.setHp(lang.getHp() - enemy.getSkills()[enemySkill].getDmg());
			}

			System.out.println(enemy.getHp());
			if (lang.getHp() <= 0 && enemy.getHp() <= 0) {
				lang.setHp(0);
				enemy.setHp(0);
				rstGame = "turnTie";
			} else if (lang.getHp() <= 0) {
				lang.setHp(0);
				rstGame = "turnLose";
			} else if (enemy.getHp() <= 0) {
				enemy.setHp(0);
				rstGame = "turnWin";
			} else {

			}
			System.out.println(1);
			langs[langIdx].setHp(lang.getHp());
			enemys[enemyIdx].setHp(enemy.getHp());
			setBar("lang");
			setBar("enemy");
			Hp1.setText("HP : " + enemy.getHp() + " / " + enemy.getMaxHp());
			Hp2.setText("HP : " + lang.getHp() + " / " + lang.getMaxHp());
			System.out.println(2);
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
			hpBar2.setProgress(((double) (int) ((double) lang.getHp() / (double) lang.getMaxHp() * 1000)) / 1000);
		} else if (type.equals("enemy")) {
			hpBar1.setProgress(((double) (int) ((double) enemy.getHp() / (double) enemy.getMaxHp() * 1000)) / 1000);
		}

	}

	public void loadAll() {
		for (int i = 0; i < 6; i++) {
			Skill[] skills = { new Skill(null, null, 0), new Skill(null, null, 0), new Skill(null, null, 0),
					new Skill(null, null, 0) };
			langs[i] = new Language("null", 1, 0, 0, skills);
			enemys[i] = new Language("null", 1, 0, 0, skills);

		}
	}

	public void chatLoad(String battle) {
		if (battle.equals("start")) {
			JDBCUtil db = new JDBCUtil();
			Connection con = db.getConnection();
			PreparedStatement pstmt = null;
			String sql = "SELECT * FROM `script` WHERE `char_id` = ? AND id LIKE ? ORDER BY `id` DESCSS";
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
			if (!rstGame.equals("turnWin")) {
				list.add(e + "은(는) " + s + "에게 \n" + enemy.getSkills()[enemySkill].getName() + "을(를) 사용했다.");
				list.add(e + "은(는) " + s + "에게 " + enemy.getSkills()[enemySkill].getDmg() + "데미지를 입혔다.");
			}
		} else if (battle.equals("end")) {
			if (rstGame.equals("win")) {
				list.add("'배인영'은 " + enemy.getName() + "을 쓰러트렸다.");
			}
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
		System.out.println(1);
		chatLoad(battle);

	}

	@FXML
	public void nextChat() {
		if (idx < list.size()) {
			Txt.setText(list.get(idx));
			idx++;
		} else {
			if (rstGame.equals("game")) {
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
			} else if (rstGame.equals("end")) {

			} else if (rstGame.equals("turnWin")) {
				enemyIdx++;
				nextEnemy();
				rstGame = "game";
				asBtn(BtnChat);
				asBtn(BtnRun);
				asBtn(BtnChg);
				asBtn(BtnBag);
				asBtn(BtnBattle);
				disBtn(BtnChat);
				disLabel();
				idx = 0;
				list.clear();

			} else if (rstGame.equals("turnLose")) {
				if (langs[0].getHp() <= 0 && langs[1].getHp() <= 0 && langs[2].getHp() <= 0 && langs[3].getHp() <= 0
						&& langs[4].getHp() <= 0 && langs[5].getHp() <= 0) {
					MainController mc = new MainController();
					mc.setloc(loc);
					try {
						Parent over = FXMLLoader.load(getClass().getResource("/layout/Gover.fxml"));
						Scene scene = new Scene(over);
						Stage primaryStage = (Stage) langImg.getScene().getWindow();
						scene.getStylesheets()
								.add(getClass().getResource("/application/application.css").toExternalForm());
						primaryStage.setScene(scene);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (rstGame.equals("turnTie")) {
				} else {
					asBtn(BtnRun);
					asBtn(BtnChg);
					asBtn(BtnBag);
					disBtn(BtnChat);
					disLabel();
					idx = 0;
					list.clear();
				}

			}

		}

	}

	public void nextEnemy() {
		if (!enemys[enemyIdx].getName().equals("null") && enemys[enemyIdx].getHp() > 0) {
			loadBattle(enemys[enemyIdx].getId(), "enemy", enemyIdx);
		} else {
			try {
				Parent win = FXMLLoader.load(getClass().getResource("/test/TestLayout.fxml"));
				Scene scene = new Scene(win);
				Stage primaryStage = (Stage) BtnChat.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	@FXML
	public void langsel1() {
		if (langs[0].getHp() > 0 && !langs[0].getName().equals("null")) {
			langIdx = 0;
			rstGame = "game";
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
			myLangs.setVisible(false);
			myLangs.setDisable(true);
			loadBattle(langs[0].getId(), "lang", 0);
		}

	}

	@FXML
	public void langsel2() {
		if (langs[1].getHp() > 0 && !langs[1].getName().equals("null")) {
			langIdx = 1;
			rstGame = "game";
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
			myLangs.setVisible(false);
			myLangs.setDisable(true);
			loadBattle(langs[1].getId(), "lang", 1);
		}

	}

	@FXML
	public void langsel3() {
		if (langs[2].getHp() > 0 && !langs[2].getName().equals("null")) {
			langIdx = 2;
			rstGame = "game";
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
			myLangs.setVisible(false);
			myLangs.setDisable(true);
			loadBattle(langs[2].getId(), "lang", 2);
		}
	}

	@FXML
	public void langsel4() {
		if (langs[3].getHp() > 0 && !langs[3].getName().equals("null")) {
			langIdx = 3;
			rstGame = "game";
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
			myLangs.setVisible(false);
			myLangs.setDisable(true);
			loadBattle(langs[3].getId(), "lang", 3);
		}
	}

	@FXML
	public void langsel5() {
		if (langs[4].getHp() > 0 && !langs[4].getName().equals("null")) {
			langIdx = 4;
			rstGame = "game";
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
			myLangs.setVisible(false);
			myLangs.setDisable(true);
			loadBattle(langs[4].getId(), "lang", 4);
		}
	}

	@FXML
	public void langsel6() {
		if (langs[5].getHp() > 0 && !langs[5].getName().equals("null")) {
			langIdx = 5;
			rstGame = "game";
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
			myLangs.setVisible(false);
			myLangs.setDisable(true);
			loadBattle(langs[5].getId(), "lang", 5);
		}
	}

	@FXML
	public void loadMyLangs() {
		disBattleBtn();
		myLangs.setVisible(true);
		myLangs.setDisable(false);
		if (!langs[0].getName().equals("null")) {
			lang1.setDisable(false);
			lang1.setVisible(true);
			langHp1.setText("HP : " + langs[0].getHp() + " / " + langs[0].getMaxHp());
			nameLang1.setText(langs[0].getName());
			langBtn1.setDisable(false);
			langImg1.setImage(new Image("/imgs/200x200(px)/" + langs[0].getName() + ".png"));
		}
		if (!langs[1].getName().equals("null")) {
			lang2.setDisable(false);
			lang2.setVisible(true);
			langHp2.setText("HP : " + langs[1].getHp() + " / " + langs[1].getMaxHp());
			nameLang2.setText(langs[1].getName());
			langBtn2.setDisable(false);
			langImg2.setImage(new Image("/imgs/200x200(px)/" + langs[1].getName() + ".png"));
		}
		if (!langs[2].getName().equals("null")) {
			lang3.setDisable(false);
			lang3.setVisible(true);
			langHp3.setText("HP : " + langs[2].getHp() + " / " + langs[2].getMaxHp());
			nameLang3.setText(langs[2].getName());
			langBtn3.setDisable(false);
			langImg3.setImage(new Image("/imgs/200x200(px)/" + langs[2].getName() + ".png"));
		}
		if (!langs[3].getName().equals("null")) {
			lang4.setDisable(false);
			lang4.setVisible(true);
			langHp4.setText("HP : " + langs[3].getHp() + " / " + langs[3].getMaxHp());
			nameLang4.setText(langs[3].getName());
			langBtn4.setDisable(false);
			langImg4.setImage(new Image("/imgs/200x200(px)/" + langs[3].getName() + ".png"));
		}
		if (!langs[4].getName().equals("null")) {
			lang5.setDisable(false);
			lang5.setVisible(true);
			langHp5.setText("HP : " + langs[4].getHp() + " / " + langs[4].getMaxHp());
			nameLang5.setText(langs[4].getName());
			langBtn5.setDisable(false);
			langImg5.setImage(new Image("/imgs/200x200(px)/" + langs[4].getName() + ".png"));
		}
		if (!langs[5].getName().equals("null")) {
			lang6.setDisable(false);
			lang6.setVisible(true);
			langHp6.setText("HP : " + langs[5].getHp() + " / " + langs[5].getMaxHp());
			nameLang6.setText(langs[5].getName());
			langBtn6.setDisable(false);
			langImg6.setImage(new Image("/imgs/200x200(px)/" + langs[5].getName() + ".png"));
		}
	}

	@FXML
	public void backBattle() {
		if (rstGame.equals("turnLose")) {
			asBtn(BtnRun);
			asBtn(BtnChg);
			asBtn(BtnBag);
			myLangs.setVisible(false);
			myLangs.setDisable(true);
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
			myLangs.setVisible(false);
			myLangs.setDisable(true);
		}

	}

	public void disBattleBtn() {
		disBtn(Btn1);
		disBtn(Btn2);
		disBtn(Btn3);
		disBtn(Btn4);
		disBtn(BtnBattle);
		disBtn(BtnChg);
		disBtn(BtnBag);
		disBtn(BtnRun);
		disBtn(BtnChat);
		disLabel();

	}

	public String getloc() {
		return loc;
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
