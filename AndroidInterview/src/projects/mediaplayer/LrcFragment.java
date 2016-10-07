package projects.mediaplayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.example.androidinterview.R;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class LrcFragment extends Fragment {
	MusicBean music;

	public void setMusic(MusicBean music) {
		this.music = music;
	}

	String sdcardPath = Environment.getExternalStorageDirectory().getPath();
	private String lrcPath = sdcardPath + "/moststar.lrc";
	private String musicPath = sdcardPath + "/moststar.mp3";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_lrc, container, false);
	}

	@Override
	public void onResume() {
		IntentFilter filter = new IntentFilter();
		filter.addAction("projects.mediaplayer.updateLrc");
		filter.setPriority(Integer.MAX_VALUE);
		getActivity().registerReceiver(myReceiver, filter);
		super.onResume();
	}

	@Override
	public void onDestroyView() {
		getActivity().unregisterReceiver(myReceiver);
		super.onDestroyView();
	}

	private BroadcastReceiver myReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			System.out.println("onReceive");
			lrcView.setCurrentIndex(intent.getIntExtra("currentPosition", 0));
		}

	};
	private Lrcview lrcView;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		lrcView = (Lrcview) getActivity().findViewById(R.id.lrcView);
		try {
			lrcView.setList(parseLRC(lrcPath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		super.onActivityCreated(savedInstanceState);
	}

	/**
	 * 解析LRC歌词为一个List
	 * @param lrcPath
	 * @return
	 * @throws IOException
	 */
	private List<LrcLineBean> parseLRC(String lrcPath) throws IOException {
		List<LrcLineBean> list = new ArrayList<LrcLineBean>();
		File file = new File(lrcPath);
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
		while ((line = br.readLine()) != null) {
			String[] split = line.split("]");
			if (split.length == 2) {
				String content = split[1];
				int maohao = split[0].indexOf(":");
				int dian = split[0].indexOf(".");
				String minus = split[0].substring(1, maohao); //[00:06.01]
				String second = split[0].substring(maohao + 1, dian); //[00:06.01]
				int startTime = Integer.parseInt(minus) * 60 + Integer.parseInt(second);
				System.out.println("startTime=" + startTime);
				list.add(new LrcLineBean(content, startTime));
			}
		}
		br.close();
		return list;
	}
}
