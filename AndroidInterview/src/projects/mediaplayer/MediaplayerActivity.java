package projects.mediaplayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.example.androidinterview.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

public class MediaplayerActivity extends Activity {
	private MediaPlayer mediaPlayer;
	String sdcardPath = Environment.getExternalStorageDirectory().getPath();
	private String lrcPath = sdcardPath + "/moststar.lrc";
	private String musicPath = sdcardPath + "/moststar.mp3";
	Lrcview view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mediaplayer_main);
		view = (Lrcview) findViewById(R.id.lrcView);
		try {
			view.setList(parseLRC(lrcPath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		play();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (mediaPlayer.isPlaying()) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					view.setCurrentIndex(mediaPlayer.getCurrentPosition()/1000);
				}
			}
		}).start();
	}

	private void play() {
		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource(musicPath);
			mediaPlayer.prepare();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mediaPlayer.start();
	}
	
	private List<LrcContent> parseLRC(String lrcPath) throws IOException {
		List<LrcContent> list = new ArrayList<LrcContent>();
		File file = new File(lrcPath);
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
		while((line = br.readLine())!=null){
			String[] split = line.split("]");
			if (split.length == 2) {
				String content = split[1];
				int maohao = split[0].indexOf(":");
				int dian = split[0].indexOf(".");
				String minus = split[0].substring(1, maohao); //[00:06.01]
				String second = split[0].substring(maohao + 1, dian); //[00:06.01]
				int startTime = Integer.parseInt(minus) * 60 + Integer.parseInt(second);
				System.out.println("startTime="+startTime);
				list.add(new LrcContent(content, startTime));
			}
		}
		br.close();
		return list;
	}

	public void back(View v) {
		System.out.println("--back--");
	}

	public void forward(View v) {

		System.out.println("--forward--");
	}

	public void start_pause(View v) {
		Button b = (Button) v;
		if (mediaPlayer != null)
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.pause();
				b.setText("start");
				System.out.println("--start_pause--");
			} else {
				b.setText("pause");
				mediaPlayer.start();
			}
	}
}
