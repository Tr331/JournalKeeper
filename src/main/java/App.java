import com.journalkeeper.ui.UserInterface;

import java.nio.file.Path;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path filePath = Path.of("data.txt");

        UserInterface userInterface = new UserInterface(scanner,filePath);
        userInterface.start();
    }
}
