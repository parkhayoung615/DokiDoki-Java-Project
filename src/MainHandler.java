import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MainHandler implements Initializable {
	@FXML
	private MediaView mediaView;
	@FXML
	private ImageView imageView;
	@FXML
	private Button buttonPlay;
	@FXML
	private Button buttonPause;
	@FXML
	private Button buttonStop;

	private boolean booEnd;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 미디어 객체를 소스 폴더의 video.mp4를 이용해만들어 줍니다.
		// 미디어 플레이어에 사용할 파일을 정해 줍니다.
		Media media = new Media(getClass().getResource("resource/loading.mp4").toString());

		// 미디어 플레이어 생성 및 미디어 뷰에 설정
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);

		// 해당 상태가 되면 실행할 Runnable 설정
		mediaPlayer.setOnReady(new Runnable() {

			// 화면이 동영상이 실행 되는 쓰레드 사용합니다.
			@Override
			public void run() {

				// 시작시 플레이 버튼만 활성화 하고
				// 나머지는 비활성화 함.
				buttonPlay.setDisable(false);
				buttonPause.setDisable(true);
				buttonStop.setDisable(true);

			}
		});

		// 플레이 뒤고 있을 경우의 버튼 활성 비활성의 상태
		// 아래의 경우도 똑 같은 경우입니다.

		mediaPlayer.setOnPlaying(() -> {
			buttonPlay.setDisable(true);
			buttonPause.setDisable(false);
			buttonStop.setDisable(false);
		});

		mediaPlayer.setOnPaused(() -> {
			buttonPlay.setDisable(false);
			buttonPause.setDisable(true);
			buttonStop.setDisable(false);
		});
		
		//비디오가 끝났을 경우의 처리
		//booEnd 변수에  true 를 넣어  재생 버튼을 눌렀을 때
		//처음 부터 실행 할것인지를 결정 하게 한다.
		
		mediaPlayer.setOnEndOfMedia(() -> {
			booEnd = true;
			buttonPlay.setDisable(false);
			buttonPause.setDisable(true);
			buttonStop.setDisable(true);
		});
		mediaPlayer.setOnStopped(() -> {
			mediaPlayer.seek(mediaPlayer.getStartTime());
			buttonPlay.setDisable(false);
			buttonPause.setDisable(true);
			buttonStop.setDisable(true);
		});

		// 버튼 ActionEvent 처리
		buttonPlay.setOnAction(event -> {
			
			//플레이 버튼을 눌렀을때 
			//동영상이 끝날상태 즉 booEnd 에 true  가 들어 가있을 경우에는 
			//종료하고 처음으로 재생시점을 이동한다.
			//그리고 다시booEnd에 false 를 대입해 지금 동영상이 
			//끝이 아니라는 것을 알려준다.
			if (booEnd) {  
				mediaPlayer.stop();
				mediaPlayer.seek(mediaPlayer.getStartTime());
			}
			mediaPlayer.play();
			booEnd = false;
		});
		
		//각가의 버튼을 선택 했을 때의 기능을 설정 하는 부분
		buttonPause.setOnAction(event -> mediaPlayer.pause());
		buttonStop.setOnAction(event -> mediaPlayer.stop());
	}
}