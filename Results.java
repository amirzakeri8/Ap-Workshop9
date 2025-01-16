public class Results {
    private int uniqueWords = 0;
    private String longestWord = "";
    private String shortestWord = "";
    private double lengthAvg = 0;
    private int files = 0;

    public synchronized void updateResults(int uniqueWords, String longestWord, String shortestWord, double lengthAvg) {
        this.uniqueWords += uniqueWords;
        if (longestWord.length() > this.longestWord.length()) {
            this.longestWord = longestWord;
        }
        if (this.shortestWord.isEmpty() || shortestWord.length() < this.shortestWord.length()) {
            this.shortestWord = shortestWord;
        }
        this.lengthAvg += lengthAvg;
        this.files++;
    }

    public synchronized void printResults() {
        double finalAverageLength = this.files == 0 ? 0 : this.lengthAvg / this.files;
        System.out.println("Total Unique Words: " + this.uniqueWords);
        System.out.println("Longest Word: " + this.longestWord + " -> " + this.longestWord.length());
        System.out.println("Shortest Word: " + this.shortestWord + " -> " + this.shortestWord.length());
        System.out.println("Average Word Length: " + finalAverageLength);
    }

    public int getUniqueWords() {
        return uniqueWords;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public String getShortestWord() {
        return shortestWord;
    }

    public double getLengthAvg() {
        return lengthAvg;
    }

    public int getFiles() {
        return files;
    }
}
