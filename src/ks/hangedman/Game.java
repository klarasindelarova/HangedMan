package ks.hangedman;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game {

    public void start(String sourceFileName) {
        Scanner scanner = new Scanner(System.in);
        List<String> wordsToGuess = readFile(sourceFileName);
        if (wordsToGuess.isEmpty()) {
            System.out.println("Reading of your file has failed. Hanged man is launched"
                    + " with a default set of words.");
            wordsToGuess = readFile("words.txt");
        }
        ProgressIndicator progressIndicator = new RightGallows();


        while (true) {

            Round round = new Round(pickRandomWord(wordsToGuess), progressIndicator);

            round.start(scanner);
            System.out.println("Do you want to play again? Press Y to continue. Any other letter quits the game.");
            String decision = scanner.nextLine();
            if (!decision.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    private List<String> readFile(String fileName) {
        List<String> wordsFromFile = new ArrayList<>();
        try (Scanner reader = new Scanner(Paths.get(fileName))) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine().toLowerCase();
                String[] singleWords = row.split("\\s+");
                if (singleWords.length > 1) {
                    System.out.println("Unacceptable format. There are more characters than one word on each line in your file.");
                    wordsFromFile.clear();
                    break;
                } else if (singleWords.length < 1) {
                    System.out.println("Unacceptable format. There is at least one empty line in your file.");
                    wordsFromFile.clear();
                    break;
                } else {
                    if (isAlphabetic(singleWords[0])) {
                        wordsFromFile.add(singleWords[0]);
                    } else {
                        System.out.println("Unacceptable format. There are special characters in your file.");
                        wordsFromFile.clear();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error! " + e);
        }
        return wordsFromFile;
    }

    public boolean isAlphabetic(String word) {
        return word.matches("^[a-zA-Z]+$");
    }

    public String pickRandomWord(List<String> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());

        return list.get(index).toUpperCase();
    }

}
