package hangedMan.domain;

public abstract class AbstractGallows implements ProgressIndicator {

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
    protected abstract void printDefaultGallows();
    protected abstract void printHead();
    protected abstract void printTorso();
    protected abstract void printRightHand();
    protected abstract void printLeftHand();
    protected abstract void printRightLeg();
    protected abstract void printLeftLeg();

}
