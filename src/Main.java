import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the game of Hanged man! Try guessing letters in the word, before the poor man gets hanged!");

        String finalWord = "HAMSTER";
        int mistakes = 0;
        List<String> letters = new ArrayList<>();
        List<String> spaces = new ArrayList<>();
        boolean victory = true;
        String[] parts = finalWord.split("(?!^)");
        for (int i = 0; i < finalWord.length(); i++) {
            letters.add(parts[i]);
            spaces.add("_");
        }

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
                victory = false;
                break;
            }
            System.out.println("Guess a letter: ");
            String input = scanner.nextLine().toUpperCase().trim();
            if (input.equals("")) {
                continue;
            }
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
                "=============");
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
                "=============");
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
                "=============");
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
                "=============");
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
                "=============");
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
                "=============");
        System.out.println("");
    }


}