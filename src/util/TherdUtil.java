package util;

import java.awt.Toolkit;

public class TherdUtil implements Runnable{

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		while(true) {
			toolkit.beep();
			System.out.println("삐빅!");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
