package ks.hangedman;

public enum Colour {

    RED("\u001B[31m"),
    GREEN ("\u001B[32m"),
    BLACK ("\u001B[30m"),
    YELLOW ("\u001B[33m"),
    BLUE ("\u001B[34m"),
    PURPLE ("\u001B[35m"),
    CYAN ("\u001B[36m"),
    RESET ("\u001B[0m");

    private String colourCode;

    Colour(String colourCode) {
        this.colourCode = colourCode;
    }

    public String getColourCode() {
        return this.colourCode;
    }
}
