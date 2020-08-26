import java.util.List;

public class Ui {
    private static final String LOGO =
            "██████╗ ███████╗███╗   ██╗███████╗██████╗ ██╗ ██████╗████████╗\n"
                    + "██╔══██╗██╔════╝████╗  ██║██╔════╝██╔══██╗██║██╔════╝╚══██╔══╝\n"
                    + "██████╔╝█████╗  ██╔██╗ ██║█████╗  ██║  ██║██║██║        ██║\n"
                    + "██╔══██╗██╔══╝  ██║╚██╗██║██╔══╝  ██║  ██║██║██║        ██║\n"
                    + "██████╔╝███████╗██║ ╚████║███████╗██████╔╝██║╚██████╗   ██║\n"
                    + "╚═════╝ ╚══════╝╚═╝  ╚═══╝╚══════╝╚═════╝ ╚═╝ ╚═════╝   ╚═╝\n";
    private static final String GOODBYE_MESSAGE = "Ok lor like that lor.";

    public static void displayGreeting() {
        System.out.println("Hi, I'm ");
        System.out.println(LOGO);
        System.out.println("What do you need this time 😫");
    }

    public static void displayMessages(String...messages) {
        System.out.println("     ――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        for (String message : messages) {
            System.out.printf("     %s\n", message);
        }
        System.out.println("     ――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println();
    }

    public static void displayGreetingReminder(int count) {
        if (count == 0) {
            return;
        }
        Ui.displayMessages(
                "Don't forget you already have " + count + " things to do.",
                "But okay.");
    }

    public static void displayTasks(List<Task> tasks) {
        int noOfTasks = tasks.size();
        if (noOfTasks == 0) {
            Ui.displayMessages("You didn't tell me to remind you anything.");
        } else {
            String[] messages = new String[noOfTasks + 1];
            messages[0] = "Right, you said you wanted to:";

            for (int i = 0; i < noOfTasks; i++) {
                messages[i + 1] = String.format("%3d: %s", i + 1, TaskList.getTask(i));
            }

            Ui.displayMessages(messages);
        }
    }

    public static String getTasksLeftMessage(int noOfTasks) {
        return String.format(
                "Now you have %d thing%s you need me to remind you about.",
                noOfTasks,
                noOfTasks == 1 ? "" : "s");
    }

    public static void displayGoodbye() {
        Ui.displayMessages(GOODBYE_MESSAGE);
    }
}
