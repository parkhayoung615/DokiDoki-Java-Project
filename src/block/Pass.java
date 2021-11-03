package block;

public class Pass {

	public int blockGet(double x, double y, int maxBlockX) {
		if (x >= 0 && y >= 0 && maxBlockX > 0) {
			int blockX = (int) x / 100;
			int blockY = (int) y / 100;
			if (blockY == 0) {
				return blockX;
			} else {
				return blockX + blockY * maxBlockX;
			}
		} else {
			return 0;
		}
	}
}
