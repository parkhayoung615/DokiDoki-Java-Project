package block;

import javafx.scene.image.ImageView;

public class Move {
	public Boolean MoveBlock(ImageView img) {
		int x = (int) img.getX();
		int y = (int) img.getY();
		Pass pass = new Pass();
		MoveStage s = new MoveStage();
		if (!s.getPassBlock(pass.blockGet(img.getX(), img.getY(), 22), "shop").getPass() && img.getX() - 10 >= 0) {
			
		}
		return true;
	}
}
