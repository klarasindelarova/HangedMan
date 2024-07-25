import java.util.*;

public class Round {
    private String wordToGuess;
    private List<String> alphabet = generateAlphabet();
    private List<String> letters = new ArrayList<>();
    private List<String> underscores = new ArrayList<>();
    private Set<String> usedLettersCorrect = new HashSet<>();
    private Set<String> usedLettersWrong = new HashSet<>();

    private ProgressIndicator progressIndicator;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    public Round(String word, ProgressIndicator progressIndicator) {
        this.wordToGuess = word;
        this.progressIndicator = progressIndicator;
    }

    public void start(Scanner scanner){
        System.out.println("");
        System.out.println("Welcome to the game of Hanged man! Try guessing letters in the word, before the poor man gets hanged!");

        splitTheWord(this.wordToGuess, letters, underscores);
        boolean victory = true;
        int mistakes = 0;

        while (underscores.contains("_")) {
            printUnderscores(underscores);

            progressIndicator.print(mistakes);
            if (mistakes == 6) {
                printDefeatText();
                victory = false;
                break;
            }

            System.out.println("Letters to use. Already used letters are colored (red - incorrect, green - correct):");

            colourLetters(alphabet, usedLettersCorrect, ANSI_GREEN);
            colourLetters(alphabet, usedLettersWrong, ANSI_RED);

            printAlphabet(alphabet);

            System.out.println("");
            System.out.println("");

            System.out.println("Guess a letter: ");
            String input = scanner.nextLine().toUpperCase().trim();
            if (input.equals("")) {
                continue;
            }
            int index = letters.indexOf(input);
            if (index == -1) {
                System.out.println("Wrong guess!");
                usedLettersWrong.add(input);
                mistakes = mistakes + 1;
            } else {
                underscores.set(index, input);
                usedLettersCorrect.add(input);
            }
        }

        if (victory) {
            printVictoryText(mistakes);
        }

    }

    private void printDefeatText() {
        System.out.println("Oh no! Poor man!");
        printTheWholeWord(this.wordToGuess);
        System.out.println("");
        System.out.println("");
    }

    private void printVictoryText(int mistakes) {
        printTheWholeWord(this.wordToGuess);
        System.out.println("");
        progressIndicator.print(mistakes);
        System.out.println("Good job! The man survived!");

        System.out.println("");
    }

    private void colourLetters(List<String> list, Set<String> toColour, String colour) {
        for (int i = 0; i < list.size(); i++) {
            if (toColour.contains(list.get(i))) {
                list.set(i, colour + list.get(i) + ANSI_RESET);
            }
        }
    }
    public void printUnderscores(List<String> spaces) {
        System.out.println("");
        System.out.print("Word: ");
        for (String a : spaces) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public void splitTheWord(String word, List<String> letters, List<String> spaces) {
        String [] parts = word.split("(?!^)");
        for (int i = 0; i < word.length(); i++) {
            letters.add(parts[i]);
            spaces.add("_");
        }
    }
    public List<String> generateAlphabet() {
        List<String> alphabet = new ArrayList<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            alphabet.add(String.valueOf(ch));
        }
        return alphabet;
    }
    public void printTheWholeWord(String word) {
        System.out.print("Word: ");
        for (int i = 0; i < word.length(); i++) {
            System.out.print(word.charAt(i) + " ");
        }
    }

    public void printAlphabet(List<String> alphabet) {
        for (String a : alphabet) {
            System.out.print(a + " ");
        }
    }

}
