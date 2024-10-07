import com.journalkeeper.controller.JournalController;
import com.journalkeeper.repository.JournalFileRepository;
import com.journalkeeper.repository.JournalRepository;
import com.journalkeeper.service.JournalService;
import com.journalkeeper.ui.ConsoleUI;
import com.journalkeeper.ui.GraphicalUI;
import com.journalkeeper.ui.UserInterface;

import java.nio.file.Path;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Path filePath = Path.of("journal.txt");

        JournalRepository repository = new JournalFileRepository(filePath);
        JournalService service = new JournalService(repository);
        JournalController controller = new JournalController(service);

        // For console UI
//        UserInterface ui = new ConsoleUI(new Scanner(System.in));

        // For JavaFX UI
        UserInterface ui = new GraphicalUI();

        ui.initialize(controller);
        ui.show();
    }
}
