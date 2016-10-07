package projects.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * TODO 使用后台服务播放音乐
 * @author lv
 *
 */
public class MediplayerService extends Service {
	public class MediaplayerBinder extends Binder {
		MediplayerService getService() {
			return MediplayerService.this;
		}
	}

	private final IBinder myBinder = new MediaplayerBinder();
	private MediaPlayer mediaPlayer;

	@Override
	public IBinder onBind(Intent intent) {
		return myBinder;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		stop();
		super.onDestroy();
	}

	public void stop() {
		if (mediaPlayer.isPlaying())
			mediaPlayer.stop();
		mediaPlayer.release();
	}

	/**
	 * 更新歌词
	 */
	private void updateLrc() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (mediaPlayer.isPlaying()) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Intent intent = new Intent("projects.mediaplayer.updateLrc");
					intent.putExtra("currentPosition", mediaPlayer.getCurrentPosition() / 1000);
					sendBroadcast(intent);
				}
			}
		}).start();
	}
	/**
	 * 播放
	 */
	public void play(String musicPath) {
		Log.e("play--musicPath---", musicPath);
		if (mediaPlayer == null)
			mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource(musicPath);
			mediaPlayer.prepare();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mediaPlayer.start();
		updateLrc();
	}

}
