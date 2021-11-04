package block;

import javafx.scene.image.ImageView;

public class Stage {

	public Block[] shopStage() {
		int[] shopPass = {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
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
		for (int pass : shopPass) {
			shop[i] = new Block(i, pass != 0, "shop");
			i++;
		}
		return shop;
	}
	public Block getPassBlock(int block, String stage) {
		Block[] shop = shopStage();
		if (stage.equals("shop")) {
			return shop[block];
		}
		return new Block(0, false, "ERROR");
		
	}
}
