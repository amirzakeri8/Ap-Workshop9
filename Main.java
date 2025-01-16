public class Main {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        try {
            ui.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
