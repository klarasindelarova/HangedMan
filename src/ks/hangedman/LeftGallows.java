package ks.hangedman;

public class LeftGallows extends AbstractGallows {

    @Override
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

    @Override
    protected void printHead() {
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

    @Override
    protected void printTorso() {
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

    @Override
    protected void printRightHand() {
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

    @Override
    protected void printLeftHand() {
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

    @Override
    protected void printRightLeg() {
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

    @Override
    protected void printLeftLeg() {
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
