package projects.mediaplayer;

import com.example.androidinterview.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.provider.MediaStore;
import android.view.View;
import projects.mediaplayer.MediplayerService.MediaplayerBinder;

/**
 * 音乐播放器的实现
 * @author lv
 *
 */
public class MediaplayerActivity extends Activity implements LoaderCallbacks<Cursor> {

	MediplayerService mediaplayerService;
	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mediaplayerService = null;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			MediplayerService.MediaplayerBinder binder = (MediaplayerBinder) service;
			mediaplayerService = binder.getService();
			mediaplayerService.play(Environment.getExternalStorageDirectory().getPath() + "/moststar.mp3");
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mediaplayer_main);
		getLoaderManager().initLoader(0, null, this);
		toLrcFragment(null);
	}

	public void back(View v) {
		System.out.println("--back--");
	}

	public void forward(View v) {

		System.out.println("--forward--");
	}

	public void start(View v) {
		Intent intent = new Intent(this, MediplayerService.class);
		startService(intent);
		bindService(intent, conn, Context.BIND_AUTO_CREATE);
	}

	public void stop(View v) {
		unbindService(conn);
		stopService(new Intent(this, MediplayerService.class));//FIXME 应该允许后台播放，但是什么时候停止？
	}

	public void choose(View v) {
		toChooseFragment();
		System.out.println("--choose--");
	}

	private void toChooseFragment() {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.replace(R.id.framelayout, new ChooseMusicFragment());
		transaction.commit();
	}

	public void toLrcFragment(MusicBean music) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		LrcFragment fragment = new LrcFragment();
		if(music!=null)
			fragment.setMusic(music);
		transaction.replace(R.id.framelayout,fragment );
		transaction.commit();
	}

	String[] columns = { MediaStore.Audio.Media.DATA, //
			MediaStore.Audio.Media._ID, //
			MediaStore.Audio.Media.TITLE, //
			MediaStore.Audio.Media.DISPLAY_NAME, //
	};

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		System.out.println("onCreateLoader");
		Uri baseUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
		return new CursorLoader(this, baseUri, columns, null, null, null);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
		System.out.println("onLoadFinished");
		// TODO Auto-generated method stub
		if (cursor != null) {
			while (cursor.moveToNext()) {
				String _ID = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
				String DATA = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
				String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
				String displayName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
				System.out.println("onLoadFinished--_ID" + _ID);
				System.out.println("onLoadFinished--DATA" + DATA);
				System.out.println("onLoadFinished--title" + title);
				System.out.println("onLoadFinished--displayName" + displayName);
			}
		}
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		System.out.println("onLoaderReset");
		// TODO Auto-generated method stub
	}

}
