import java.lang.Thread;

public class Main {
	public static void main(String args[]) throws InterruptedException {
		TaskManager manager = new TaskManager();
		FileManager.loadCSV(args[0], manager);
		if (args.length > 1) {
			if (args.length == 2) {
				manager.printInProgress();
				manager.printFinished();
			} else {
				try {
					switch (args[1]) {
						case "print":
							switch (args[2]) {
								case "todo":
									manager.printInProgress();
									break;
								case "finished":
									manager.printFinished();
									break;
								default:
									System.err.println("Usage: chore print <todo|progress|finished>");
									break;
							}
							break;
						case "add":
							manager.addTask(new Task(args[2]));
							break;
						case "remove":
							switch (args[2]) {
								case "progress":
									manager.removeInProgressById(Integer.parseInt(args[3]));
									break;
								case "finished":
									manager.removeFinishedById(Integer.parseInt(args[3]));
									break;
								default:
									manager.removeInProgressById(Integer.parseInt(args[2]));
									break;
							}
							break;
						case "set":
							switch (args[2]) {
								case "finished":
									manager.setFinishedById(Integer.parseInt(args[3]));
									break;
								case "progress":
									manager.setInProgressById(Integer.parseInt(args[3]));
									break;
								case "todo":
									manager.setInProgressById(Integer.parseInt(args[3]));
									break;
								default:
									System.err.println("Usage: chore set <progress|todo|finished> <id>");
									break;
							}
					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
			FileManager.saveCSV(args[0], manager);
		}
	}
}
