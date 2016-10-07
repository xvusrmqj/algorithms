package projects.mediaplayer;

import com.example.androidinterview.R;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChooseMusicFragment extends ListFragment {
	String[] presidents = { "Dwight D. Eisenhower", "John F. Kennedy", "Lyndon B. Johnson", "Richard Nixon",
			"Gerald Ford", "Jimmy Carter", "Ronald Reagan", "George H. W. Bush", "Bill Clinton", "George W. Bush",
			"Barack Obama" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_choose_music, container, false);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, presidents));
	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		toLrcFragment();
	}

	private void toLrcFragment() {
		MediaplayerActivity activity = (MediaplayerActivity) getActivity();
		activity.toLrcFragment(new MusicBean("path", "tittle"));
	}
}
