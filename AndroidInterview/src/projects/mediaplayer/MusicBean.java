package projects.mediaplayer;
/**
 * @author lv
 *
 */
public class MusicBean {
	private String path;
	private String title;

	public MusicBean(String path, String title) {
		this.path = path;
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public String getTitle() {
		return title;
	}

}
