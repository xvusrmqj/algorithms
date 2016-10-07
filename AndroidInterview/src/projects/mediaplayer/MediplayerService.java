package projects.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * TODO 使用后台服务播放音乐
 * FIXME 如何实现后台播放？ 应该在子线程中运行，而不是在主线程中运行
 * 官方教程里这部分说得很好：https://developer.android.com/guide/topics/media/mediaplayer.html?hl=zh-cn
 * @author lv
 *
 */
public class MediplayerService extends Service implements MediaPlayer.OnPreparedListener, OnErrorListener{
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
		if (mediaPlayer == null){
			mediaPlayer = new MediaPlayer();
			mediaPlayer.setOnPreparedListener(this);
			mediaPlayer.setOnErrorListener(this);
		}
		try {
			mediaPlayer.setDataSource(musicPath);
			mediaPlayer.prepare();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		mediaPlayer.start();
		updateLrc();
	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		System.out.println("this is something error happened!");
		mediaPlayer.reset();
		return false;
	}

}
