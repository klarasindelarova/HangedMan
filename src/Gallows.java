public class Gallows implements ProgressIndicator {

    @Override
    public void print(int mistakes) {
        switch (mistakes) {
            case 0 -> printDefaultGallows();
            case 1 -> printHead();
            case 2 -> printTorso();
            case 3 -> printRightHand();
            case 4 -> printLeftHand();
            case 5 -> printRightLeg();
            case 6 -> printLeftLeg();
        }
    }
    protected void printDefaultGallows() {
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

    protected void printHead() {
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

    protected void printTorso() {
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

    protected void printRightHand() {
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

    protected void printLeftHand() {
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

    protected void printRightLeg() {
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

    protected void printLeftLeg() {
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

}
