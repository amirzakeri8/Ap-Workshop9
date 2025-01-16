import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConsoleUI {
    public void start() throws InterruptedException {
        Path folderPath = Paths.get("assets");
        Results results = new Results();
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            Files.list(folderPath).forEach(filePath -> {
                executorService.submit(new FileAnalysis(filePath, results));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to word analyzer!");
            System.out.println("Please choose an option!");
            System.out.println("1. Words count");
            System.out.println("2. Longest word and its length");
            System.out.println("3. Shortest word and its length");
            System.out.println("4. All words length average");
            System.out.println("5. Every detail");
            System.out.println("Exit. to close app");
            String option = scanner.nextLine();

            if (option.equals("1")) {
                System.out.println("Unique words: " + results.getUniqueWords());
            } else if (option.equals("2")) {
                System.out.println("Longest word: " + results.getLongestWord() + " -> " + results.getLongestWord().length());
            } else if (option.equals("3")) {
                System.out.println("Shortest word: " + results.getShortestWord() + " -> " + results.getShortestWord().length());
            } else if (option.equals("4")) {
                System.out.println("Avg of words: " + results.getLengthAvg() / results.getFiles());
            } else if (option.equals("5")) {
                results.printResults();
            } else if (option.equals("Exit")) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }
}
