package projects.mediaplayer;
/**
 * 封装每一行的歌词
 * @author lv
 *
 */
public class LrcLineBean {
	private String lrcString;
	private int startTime;

	public LrcLineBean(String lrcString, int startTime) {
		this.lrcString = lrcString;
		this.startTime = startTime;
	}

	public String getLrcString() {
		return lrcString;
	}

	public int getStartTime() {
		return startTime;
	}
	
}
