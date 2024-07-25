public class MirroredGallows implements ProgressIndicator {

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
    private void printDefaultGallows() {
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

    private void printHead() {
        System.out.print("""
                   _______
                   |     |
                   O     |
                         |
                         |
                         |
                         |
                =============
                """);
        System.out.println("");
    }

    private void printTorso() {
        System.out.print("""
                   _______
                   |     |
                   O     |
                   |     |
                         |
                         |
                         |
                =============
                """);
        System.out.println("");
    }

    private void printRightHand() {
        System.out.print("""
                   _______
                   |     |
                   O     |
                  /|     |
                         |
                         |
                         |
                =============
                """);
        System.out.println("");
    }

    private void printLeftHand() {
        System.out.print("""
                   _______
                   |     |
                   O     |
                  /|\\    |
                         |
                         |
                         |
                =============
                """);
        System.out.println("");
    }

    private void printRightLeg() {
        System.out.print("""
                   _______
                   |     |
                   O     |
                  /|\\    |
                  /      |
                         |
                         |
                =============
                """);
        System.out.println("");
    }

    private void printLeftLeg() {
        System.out.print("""
                   _______
                   |     |
                   O     |
                  /|\\    |
                  /|\\    |
                         |
                         |
                =============
                """);
        System.out.println("");
    }
}
