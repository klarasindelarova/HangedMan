import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public void start() {
        boolean playAgain = true;
        while (playAgain) {
            Scanner scanner = new Scanner(System.in);
            List<String> wordsToGuess = readAFile("words.txt");

            String finalWord = pickingRandomWord(wordsToGuess);

            List<String> alphabet = generateAlphabet();

            List<String> letters = new ArrayList<>();
            List<String> spaces = new ArrayList<>();
            List<String> usedLettersCorrect = new ArrayList<>();
            List<String> usedLettersWrong = new ArrayList<>();

            String[] parts = finalWord.split("(?!^)");
            for (int i = 0; i < finalWord.length(); i++) {
                letters.add(parts[i]);
                spaces.add("_");
            }
            System.out.println("");
            System.out.println("Welcome to the game of Hanged man! Try guessing letters in the word, before the poor man gets hanged!");
            boolean victory = true;
            int mistakes = 0;
            while (spaces.contains("_")) {
                System.out.println("");
                System.out.print("Word: ");
                for (int i = 0; i < spaces.size(); i++) {
                    System.out.print(spaces.get(i) + " ");
                }

                System.out.println("");
                printGallows(mistakes);
                if (mistakes == 6) {
                    System.out.println("Oh no! Poor man!");
                    System.out.println("The word was: " + finalWord);
                    victory = false;
                    break;
                }

                System.out.println("Letters to use. Already used letters are colored (red - incorrect, green - correct):");

                colourLettersGreen(alphabet, usedLettersCorrect);
                colourLettersRed(alphabet, usedLettersWrong);

                printColouredAlphabet(alphabet);

                System.out.println("");
                System.out.println("");

                System.out.println("Guess a letter: ");
                String input = scanner.nextLine().toUpperCase().trim();
                if (input.equals("")) {
                    continue;
                }
                boolean correct = false;
                for (int i = 0; i < letters.size(); i++) {
                    if (letters.get(i).equals(input)) {
                        spaces.set(i, input);
                        usedLettersCorrect.add(input);
                        correct = true;
                    }
                }
                if (!correct) {
                    System.out.println("Wrong guess!");
                    usedLettersWrong.add(input);
                    mistakes = mistakes + 1;
                }

            }

            if (victory) {
                System.out.print("Word: ");
                for (int i = 0; i < finalWord.length(); i++) {
                    System.out.print(finalWord.charAt(i) + " ");
                }
                System.out.println("");
                printGallows(mistakes);
                System.out.println("Good job! The man survived!");

                System.out.println("");
            }
            System.out.println("Do you want to play again? Press Y to continue or N to quit.");
            String decision = scanner.nextLine();
            if (decision.equalsIgnoreCase("n")) {
                playAgain = false;
            }

        }

    }

    public void colourLettersGreen(List<String> alphabet, List<String> correct) {
        for (int i = 0; i < alphabet.size(); i++) {
            if (correct.contains(alphabet.get(i))) {
                alphabet.set(i, ANSI_GREEN + alphabet.get(i) + ANSI_RESET);
            }
        }
    }
    public void colourLettersRed(List<String> alphabet, List<String> wrong) {
        for (int i = 0; i < alphabet.size(); i++) {
            if (wrong.contains(alphabet.get(i))) {
                alphabet.set(i, ANSI_RED + alphabet.get(i) + ANSI_RESET);
            }
        }
    }
    public List<String> generateAlphabet() {
        char abc = 0;
        List<String> alphabet = new ArrayList<>();
        for (abc = 'A'; abc <= 'Z'; abc++) {
            alphabet.add(String.valueOf(abc));
        }
        return alphabet;
    }

    public void printColouredAlphabet(List<String> alphabet) {
        for (String a : alphabet) {
            System.out.print(a + " ");
        }
    }
    public String pickingRandomWord(List<String> list) {
        int index = 0;
        Random randomNumber = new Random();
        index = randomNumber.nextInt(list.size());

        String finalWord = list.get(index).toUpperCase();

        return finalWord;
    }

    public List<String> readAFile(String file) {
        List<String> wordsFromFile = new ArrayList<>();
        try (Scanner reader = new Scanner(Paths.get(file))) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                wordsFromFile.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error! " + e);
        }
        return wordsFromFile;
    }

    public void printGallows(int mistakes) {
        switch (mistakes) {
            case 0:
                printDefaultGallows();
                break;
            case 1:
                printHead();
                break;
            case 2:
                printTorso();
                break;
            case 3:
                printRightHand();
                break;
            case 4:
                printLeftHand();
                break;
            case 5:
                printRightLeg();
                break;
            case 6:
                printLeftLeg();
                break;
        }
    }

    public void printDefaultGallows() {
        System.out.print("""
                   _______
                   |     |
                   |
                   |
                   |
                   |
                   |
                =============
                """);
        System.out.println("");
    }

    public void printHead() {
        System.out.print("""
                   _______
                   |     |
                   |     O
                   |
                   |
                   |
                   |
                =============
                """);
        System.out.println("");
    }

    public void printTorso() {
        System.out.print("""
                   _______
                   |     |
                   |     O
                   |     |
                   |
                   |
                   |
                =============
                """);
        System.out.println("");
    }

    public void printRightHand() {
        System.out.print("""
                   _______
                   |     |
                   |     O
                   |    /|
                   |
                   |
                   |
                =============
                """);
        System.out.println("");
    }

    public void printLeftHand() {
        System.out.print("""
                   _______
                   |     |
                   |     O
                   |    /|\\
                   |
                   |
                   |
                =============
                """);
        System.out.println("");
    }

    public void printRightLeg() {
        System.out.print("""
                   _______
                   |     |
                   |     O
                   |    /|\\
                   |    /
                   |
                   |
                =============
                """);
        System.out.println("");
    }

    public void printLeftLeg() {
        System.out.print("""
                   _______
                   |     |
                   |     O
                   |    /|\\
                   |    / \\
                   |
                   |
                =============
                """);
        System.out.println("");
    }

    public final String ANSI_RESET = "\u001B[0m";

    public final String ANSI_GREEN = "\u001B[32m";

    public final String ANSI_RED = "\u001B[31m";
}
