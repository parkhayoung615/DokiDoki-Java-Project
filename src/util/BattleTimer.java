package util;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.image.ImageView;

public class BattleTimer implements Runnable{
	public static double cnt = 0.96;
	private static ImageView enemy;
	private static ImageView lang;
	private static ImageView enemy2;
	private static ImageView lang2;
	
	@Override
	public void run() {
		try {
			enemy2.setOpacity(0);
			lang2.setOpacity(0);
			Thread.sleep(3000);
			
			for (double i = 1; i > 0; i -= 0.08) {
				enemy.setOpacity(i);
				lang.setOpacity(i);
				Thread.sleep(200);
			}
			enemy.setOpacity(0);
			lang.setOpacity(0);
			enemy2.setOpacity(1);
			lang2.setOpacity(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
	
	public void setimg(ImageView enemy, ImageView lang, ImageView enemy2, ImageView lang2) {
		this.enemy = enemy;
		this.lang = lang;
		this.lang2 = lang2;
		this.enemy2 = enemy2;
	}
	
	

}
