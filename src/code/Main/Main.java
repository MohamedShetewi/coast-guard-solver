package code.Main;

import code.Problem.GridGenerator;

public class Main {
    public static String GenGrid() {
        return (new GridGenerator()).toString();
    }

    public static void main(String[] args) {
        System.out.println(GenGrid());
    }
}
