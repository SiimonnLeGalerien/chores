import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
	public static void loadCSV(String filename, TaskManager manager) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			boolean first = true;
			while ((line = reader.readLine()) != null) {
				if (first) {
					first = false;
					continue;
				}
				Task task = Task.parseTask(line);
				if (task != null)
					manager.addTask(task);
			}
		} catch (IOException e) {
			System.err.println("Reading file error : " + e.getMessage());
		}
	}

	public static void saveCSV(String filename, TaskManager manager) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			writer.write("title,inProgress,beginDate,endDate");
			writer.newLine();
			for (int i = 0; i < manager.getInProgressList().size(); i++) {
				writer.write(manager.getInProgressList().get(i).toCSV());
				writer.newLine();
			}
			for (int i = 0; i < manager.getFinishedList().size(); i++) {
				writer.write(manager.getFinishedList().get(i).toCSV());
				writer.newLine();
			}
		}
		catch (IOException e) {
			System.err.println("Saving file Error : " + e.getMessage());
		}
	}
}
