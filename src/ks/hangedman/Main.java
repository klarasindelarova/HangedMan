package ks.hangedman;

public class Main {
    public static void main(String[] args) {
        String sourceFileName = "words.txt";
        if (args.length < 1) {
            System.out.println("You haven't inserted any list of words as an argument. Hanged man will be" +
                    " launched with a default set of words.");
        } else if (args.length > 1) {
            System.out.println("You have inserted more than 1 argument. Hanged man will be launched with" +
                    " a default set of words.");
        } else {
            sourceFileName = args[0];
        }

        Game newGame = new Game();
        newGame.start(sourceFileName);



    }
}