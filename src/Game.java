import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        List<String> wordsToGuess = readFile("words.txt");

        while (true) {

            Round round = new Round(pickRandomWord(wordsToGuess));

            round.start(scanner);
            System.out.println("Do you want to play again? Press Y to continue or N to quit.");
            String decision = scanner.nextLine();
            if (decision.equalsIgnoreCase("n")) {
                break;
            }

        }

    }
    private List<String> readFile(String fileName) {
        List<String> wordsFromFile = new ArrayList<>();
        try (Scanner reader = new Scanner(Paths.get(fileName))) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                wordsFromFile.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error! " + e);
        }
        return wordsFromFile;
    }

    public String pickRandomWord(List<String> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());

        return list.get(index).toUpperCase();
    }

}
