package hangedMan.domain;

import hangedMan.domain.ProgressIndicator;

public class Score implements ProgressIndicator {

    @Override
    public void print(int mistakes) {
        System.out.println(mistakes + "/6");
    }
}
