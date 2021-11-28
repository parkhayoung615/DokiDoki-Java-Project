package util;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.image.ImageView;

public class BattleTimer implements Runnable{
	public static double cnt = 0.96;
	private static ImageView enemy;
	private static ImageView lang;
	
	@Override
	public void run() {
		try {
			for (double i = 1; i > 0; i -= 0.08) {
				enemy.setOpacity(i);
				lang.setOpacity(i);
				Thread.sleep(400);
			}
			enemy.setOpacity(0);
			lang.setOpacity(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
	
	public void setimg(ImageView enemy, ImageView lang) {
		this.enemy = enemy;
		this.lang = lang;
	}
	
	

}
