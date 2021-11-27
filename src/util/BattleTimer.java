package util;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.image.ImageView;

public class BattleTimer {
	public static double cnt;
	
	public static void main(String[] args) {
		ImageView image = new ImageView("img/battle/Bae.png");
		cnt = 0.96;
		
		Timer imgTimer = new Timer();
		TimerTask imgTask = new TimerTask() {
			
			@Override
			public void run() {
				if(cnt > 0) {
					//일정 퍼센트만큼 이미지 투명도 감소
					image.setOpacity(cnt);
					cnt -= 0.08;
				} else {
					imgTimer.cancel();
				}
			}
		};
		
		imgTimer.schedule(imgTask, 500, 200);
	}

}
