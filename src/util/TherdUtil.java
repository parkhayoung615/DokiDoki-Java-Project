package util;

import java.awt.Toolkit;

public class TherdUtil implements Runnable{

	public TherdUtil(String userId, String user_Boss, String user_Obj) {
		
	}

	@Override
	public void run() {
//		String userId;
//		String user_Boss;
//		String user_Obj;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		while(true) {
//			toolkit.
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
