import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileAnalysis implements Runnable {
    private final Path filePath;
    private final Results results;

    public FileAnalysis(Path filePath, Results results) {
        this.filePath = filePath;
        this.results = results;
    }

    @Override
    public void run() {
        try {
            List<String> lines = Files.readAllLines(filePath);
            Set<String> uniqueWords = new HashSet<>();
            int totalLength = 0;
            String longestWord = "";
            String shortestWord = lines.isEmpty() ? "" : lines.get(0);
            int wordCount = 0;

            for (String line : lines) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }

                    uniqueWords.add(word);
                    totalLength += word.length();
                    wordCount++;
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                    if (word.length() < shortestWord.length()) {
                        shortestWord = word;
                    }
                }
            }

            double averageLength;
            if (wordCount == 0) {
                averageLength = 0;
            } else {
                averageLength = (double) totalLength / wordCount;
            }

            synchronized (results) {
                results.updateResults(uniqueWords.size(), longestWord, shortestWord, averageLength);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
