import java.util.Scanner;

public class Duke {
    public static final String LOGO =
            "██████╗ ███████╗███╗   ██╗███████╗██████╗ ██╗ ██████╗████████╗\n"
                    + "██╔══██╗██╔════╝████╗  ██║██╔════╝██╔══██╗██║██╔════╝╚══██╔══╝\n"
                    + "██████╔╝█████╗  ██╔██╗ ██║█████╗  ██║  ██║██║██║        ██║\n"
                    + "██╔══██╗██╔══╝  ██║╚██╗██║██╔══╝  ██║  ██║██║██║        ██║\n"
                    + "██████╔╝███████╗██║ ╚████║███████╗██████╔╝██║╚██████╗   ██║\n"
                    + "╚═════╝ ╚══════╝╚═╝  ╚═══╝╚══════╝╚═════╝ ╚═╝ ╚═════╝   ╚═╝\n";
    private static final String BYE = "bye";
    private static final String GOODBYE_MESSAGE = "Ok lor like that lor.";

    public static void main(String[] args) {
        System.out.println("Hi, I'm\n" + LOGO);
        Duke.displayMessage("What do you need this time 😫");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("> ");
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();

                if (command.equalsIgnoreCase(BYE)) {
                    break;
                } else {
                    Duke.displayMessage(command);
                    System.out.print("> ");
                }
            }

            Duke.displayMessage(GOODBYE_MESSAGE);
        }
    }

    private static void displayMessage(String message) {
        System.out.println("     ――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println("     " + message);
        System.out.println("     ――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println();
    }
}
