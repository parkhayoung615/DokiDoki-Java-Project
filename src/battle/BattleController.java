package battle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
	
	public void chat() {
		disBtn(Btn1);
		disBtn(Btn2);
		disBtn(Btn3);
		disBtn(Btn4);
		disBtn(BtnBattle);
		disBtn(BtnChg);
		disBtn(BtnBag);
		disBtn(BtnRun);
		
	}
	
	public void disBtn(Button Btn) {
		Btn.setVisible(false);
		Btn.setDisable(true);
	}
	
}
