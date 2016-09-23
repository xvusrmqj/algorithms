package projects.mediaplayer;

import com.example.androidinterview.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mediaplayer_main);
		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource("/mnt/sdcard/moststar.mp3");
			mediaPlayer.prepare();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mediaPlayer.start();
	}

	public void back(View v) {
		System.out.println("--back--");
	}

	public void forward(View v) {

		System.out.println("--forward--");
	}

	public void start_pause(View v) {
		Button b = (Button) v;
		if(mediaPlayer!=null)
			if(mediaPlayer.isPlaying()){
				mediaPlayer.pause();
				b.setText("start");
				System.out.println("--start_pause--");
			}else{
				b.setText("pause");
				mediaPlayer.start();
			}
	}
}
