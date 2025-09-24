import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	private ArrayList<Task> inProgress;
	private ArrayList<Task> finished;

	public TaskManager() {
		this.inProgress = new ArrayList<Task>();
		this.finished = new ArrayList<Task>();
	}

	public void addTask(Task task) {
		if (task.getInProgress())
			inProgress.add(task);
		else
			finished.add(task);
	}

	public void printInProgress() {
		System.out.println("TODO :\n");
		if (inProgress.size() == 0)
			System.out.println("No task todo...");
		for (int i = 0; i < inProgress.size(); i++) {
			System.out.println(Integer.valueOf(i).toString() + " : " + inProgress.get(i).toString());
		}
		System.out.println();
	}
	public void printFinished() {
		System.out.println("Finished :\n");
		if (finished.size() == 0)
			System.out.println("No task finished...");
		for (int i = 0; i < finished.size(); i++) {
			System.out.println(Integer.valueOf(i).toString() + " : " + finished.get(i).toString());
		}
		System.out.println();
	}

	public void setFinishedById(int id) {
		try {
			inProgress.get(id).setFinished();
			finished.add(inProgress.remove(id));
		} catch (IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void setInProgressById(int id) {
		try {
			finished.get(id).setInProgress();
			inProgress.add(finished.remove(id));
		} catch (IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
	}

	public void removeInProgressById(int id) {
		try {
			inProgress.remove(id);
		} catch (IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
	}

	public void removeFinishedById(int id) {
		try {
			finished.remove(id);
		} catch (IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
	}

	public void searchTitlesInProgress(String title) {
		for (int i = 0; i < inProgress.size(); i++) {
			if (inProgress.get(i).getTitle().contains(title))
				System.out.println(Integer.valueOf(i).toString() + " : " + inProgress.get(i).toString());
		}
	}
	public void searchTitlesFinished(String title) {
		for (int i = 0; i < finished.size(); i++) {
			if (finished.get(i).getTitle().contains(title))
				System.out.println(Integer.valueOf(i).toString() + " : " + finished.get(i).toString());
		}
	}

	public ArrayList<Task> getInProgressList() {
		return this.inProgress;
	}

	public ArrayList<Task> getFinishedList() {
		return this.finished;
	}
}
