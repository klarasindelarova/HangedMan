import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> wordsToGuess = new ArrayList<>();

        try (Scanner reader = new Scanner(Paths.get("words.txt"))) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                wordsToGuess.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error! " + e);
        }
        int index = 0;
        Random randomNumber = new Random();
        index = randomNumber.nextInt(wordsToGuess.size());

        String finalWord = wordsToGuess.get(index).toUpperCase();
        int mistakes = 0;
        List<String> letters = new ArrayList<>();
        List<String> spaces = new ArrayList<>();
        List<String> usedLetters = new ArrayList<>();
        boolean victory = true;
        String[] parts = finalWord.split("(?!^)");
        for (int i = 0; i < finalWord.length(); i++) {
            letters.add(parts[i]);
            spaces.add("_");
        }
            System.out.println("Welcome to the game of Hanged man! Try guessing letters in the word, before the poor man gets hanged!");

            while (spaces.contains("_")) {
                System.out.println("");
                for (int i = 0; i < spaces.size(); i++) {
                    System.out.print(spaces.get(i) + " ");
                }

                System.out.println("");
                if (mistakes == 0) {
                    printGallows();
                }
                if (mistakes == 1) {
                    printHead();
                }
                if (mistakes == 2) {
                    printTorso();
                }
                if (mistakes == 3) {
                    printRightHand();
                }
                if (mistakes == 4) {
                    printLeftHand();
                }
                if (mistakes == 5) {
                    printRightLeg();
                }
                if (mistakes == 6) {
                    printLeftLeg();
                    System.out.println("Oh no! Poor man!");
                    System.out.println("The word was: " + finalWord);
                    victory = false;
                    break;
                }
                System.out.println("Already tried: " + usedLetters);
                System.out.println("Guess a letter: ");
                String input = scanner.nextLine().toUpperCase().trim();
                if (input.equals("")) {
                    continue;
                }
                usedLetters.add(input);
                boolean correct = false;
                for (int i = 0; i < letters.size(); i++) {
                    if (letters.get(i).equals(input)) {
                        spaces.set(i, input);
                        correct = true;
                    }
                }
                if (correct == false) {
                    System.out.println("Wrong guess!");
                    mistakes = mistakes + 1;
                }

            }

            if (victory == true) {
                System.out.println("Good job! The man survived!");
            }


    }


    public static void printGallows() {
        System.out.print("   _______\n" +
                "   |     |\n" +
                "   |    \n" +
                "   |    \n" +
                "   |   \n" +
                "   |    \n" +
                "   |\n" +
                "=============\n");
        System.out.println("");
    }

    public static void printHead() {
        System.out.print("   _______\n" +
                "   |     |\n" +
                "   |     O\n" +
                "   |    \n" +
                "   |   \n" +
                "   |    \n" +
                "   |\n" +
                "=============\n");
        System.out.println("");
    }

    public static void printTorso() {
        System.out.print("   _______\n" +
                "   |     |\n" +
                "   |     O\n" +
                "   |     |\n" +
                "   |   \n" +
                "   |    \n" +
                "   |\n" +
                "=============\n");
        System.out.println("");
    }

    public static void printRightHand() {
        System.out.print("   _______\n" +
                "   |     |\n" +
                "   |     O\n" +
                "   |    /|\n" +
                "   |       \n" +
                "   |    \n" +
                "   |\n" +
                "=============\n");
        System.out.println("");
    }

    public static void printLeftHand() {
        System.out.print("   _______\n" +
                "   |     |\n" +
                "   |     O\n" +
                "   |    /|\\\n" +
                "   |       \n" +
                "   |    \n" +
                "   |\n" +
                "=============\n");
        System.out.println("");
    }

    public static void printRightLeg() {
        System.out.print("   _______\n" +
                "   |     |\n" +
                "   |     O\n" +
                "   |    /|\\\n" +
                "   |    /  \n" +
                "   |    \n" +
                "   |\n" +
                "=============\n");
        System.out.println("");
    }

    public static void printLeftLeg() {
        System.out.print("   _______\n" +
                "   |     |\n" +
                "   |     O\n" +
                "   |    /|\\\n" +
                "   |    / \\ \n" +
                "   |    \n" +
                "   |\n" +
                "=============\n");
        System.out.println("");
    }


}