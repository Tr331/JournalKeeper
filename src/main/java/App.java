import com.journalkeeper.controller.JournalController;
import com.journalkeeper.repository.JournalFileRepository;
import com.journalkeeper.repository.JournalRepository;
import com.journalkeeper.service.JournalService;
import com.journalkeeper.ui.ConsoleUI;
import com.journalkeeper.ui.UserInterface;

import java.nio.file.Path;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path filePath = Path.of("data.txt");

        JournalRepository journalRepository = new JournalFileRepository(filePath);
        JournalService journalService = new JournalService(journalRepository);
        JournalController journalController = new JournalController(journalService);

        UserInterface userInterface = new ConsoleUI(scanner,journalController);
        userInterface.start();
    }
}
