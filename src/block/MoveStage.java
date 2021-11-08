package block;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MoveStage {
	GridPane grid = new GridPane();
	
	public Block[] shopStage() {
		int[] shopPass = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0,
				1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Block[] shop = new Block[shopPass.length];
		int i = 0;
		for (int type : shopPass) {
			int pass = type;
			shop[i] = new Block(i, pass != 0, "shop", type);
			i++;
		}
		return shop;
	}
	
	public Block[] mainStage() {
		int[] shopPass = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0,
				1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Block[] shop = new Block[shopPass.length];
		int i = 0;
		for (int type : shopPass) {
			
			int pass = type;
			shop[i] = new Block(i, pass != 0, "shop", type);
			i++;
		}
		return shop;
	}
	public Block getPassBlock(int block, String stage) {
		Block[] shop = shopStage();
		if (stage.equals("shop")) {
			return shop[block];
		}
		return new Block(0, false, "ERROR", 0);
		
	}
}
