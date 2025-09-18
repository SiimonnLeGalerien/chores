import java.util.Date;

public class Task {
	private String title;
	private Date beginDate;
	private Date endDate;
	private boolean inProgress;
	private boolean finished;

	public Task(String title) {
		this.title = title;
		this.beginDate = new Date();
		this.inProgress = true;
		this.finished = false;
		this.endDate = new Date(this.beginDate.getTime());
	}

	public Task(String title, boolean inProgress, long beginDate) {
		this.title = title;
		this.beginDate = new Date(beginDate);
		this.inProgress = inProgress;
		this.finished = (inProgress) ? false : true;
		this.endDate = new Date(this.beginDate.getTime());
	}

	public Task(String title, boolean inProgress, long beginDate, long endDate) {
		this.title = title;
		this.beginDate = new Date(beginDate);
		this.inProgress = inProgress;
		this.finished = (inProgress) ? false : true;
		this.endDate = new Date(endDate);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public boolean getInProgress() {
		return this.inProgress;
	}

	public void setFinished() {
		this.finished = true;
		this.inProgress = false;
		this.endDate = new Date();
	}

	public void setInProgress() {
		this.inProgress = true;
		this.finished = false;
		this.endDate = new Date(this.beginDate.getTime());
	}

	public String toString() {
		return this.title + " : " + ((this.inProgress) ? "in progress": "finished") +
			" : " +  this.beginDate.toString() + ((this.beginDate.getTime() == 
						this.endDate.getTime()) ? "" : (" : " + this.endDate.toString()));
	}

	public static Task parseTask(String line) {
		String[] parts = line.split(",");
		if (parts.length == 4) {
			return new Task(parts[0], (parts[1].equals("true"))?true:false, Long.parseLong(parts[2]), Long.parseLong(parts[3]));
		}
		return null;
	}
	public String toCSV() {
		return this.title + "," + ((this.inProgress) ? "true" : "false") +
			"," + Long.toString(this.beginDate.getTime()) + "," +
			Long.toString(this.endDate.getTime());
	}
}
