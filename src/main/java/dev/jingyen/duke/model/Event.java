package dev.jingyen.duke.model;

/**
 * An Event is a kind of Task that occurs within a certain period/time range.
 *
 * @author jingyenloh
 */
public class Event extends Task {
    private static final String SAVE_STRING = "EVENT|%s|%s|%s";
    private String timeRange;

    public Event(String taskName, String timeRange) {
        super(taskName);
        this.timeRange = timeRange;
    }

    public Event(boolean isDone, String taskName, String timeRange) {
        super(isDone, taskName);
        this.timeRange = timeRange;
    }

    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)", super.toString(), timeRange);
    }

    /**
     * Serializes the dev.jingyen.duke.model.Event into a String that is easy to parse. The String takes the form:
     * <code>dev.jingyen.duke.model.Event|isDone|taskName|timeRange</code>.
     *
     * @return A formatted String ready for saving into a file
     */
    @Override
    public String toSaveString() {
        return String.format(SAVE_STRING, super.isDone, super.taskName, timeRange);
    }
}
