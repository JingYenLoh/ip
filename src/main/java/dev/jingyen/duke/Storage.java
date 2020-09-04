package dev.jingyen.duke;

import dev.jingyen.duke.model.Task;
import dev.jingyen.duke.parser.TaskParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Deserializes a list of tasks stored at a given path into a list of Tasks.
     *
     * @return a list of Tasks that were stored at the path at <code>filePath</code>.
     * @throws IOException if a problem was encountered while trying to access the file at <code>filePath</code>
     */
    // TODO: 26/8/20 Add more relevant error for parsing
    public List<Task> load() throws IOException {
        List<Task> tasks = new ArrayList<>();
        try (var br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Task task = TaskParser.parse(line);
                tasks.add(task);
            }
        }
        return tasks;
    }

    // TODO: 26/8/20 consider a more robust check

    /**
     * Checks if the file at <code>filePath</code> exists.
     *
     * @return true if the file exists, otherwise false
     */
    public boolean hasSavedTasks() {
        return new File(filePath).exists();
    }

    /**
     * Saves a list of tasks into a file.
     *
     * @param tasks the list of tasks to serialize and save
     * @throws IOException if a problem was encountered while trying to access the file at <code>filePath</code>
     */
    public void saveTasks(List<Task> tasks) throws IOException {
        File saveFile = new File(filePath);
        if (!saveFile.exists()) {
            boolean directoryCreated = saveFile.getParentFile().mkdirs();
            if (!directoryCreated) {
                throw new IOException("Unable to create parent directories to save file");
            }
            boolean saveFileCreated = saveFile.createNewFile();
            if (!saveFileCreated) {
                throw new IOException("Unable to create save file");
            }
        }

        // Use PrintWriter wrapping BufferedWriter in FileWriter
        try (var out = new PrintWriter(new BufferedWriter(new FileWriter(filePath)))) {
            for (Task task : tasks) {
                out.println(task.toSaveString());
            }
        }
    }

}