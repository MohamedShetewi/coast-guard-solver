package code.Main;

import code.Problem.*;
public class Main {
    public static String GenGrid() {
        return (new GridGenerator()).toString();
    }

    public static void main(String[] args) throws Exception {
        String s = (new GridGenerator(5, 10)).toString();
        System.out.println(s);
        Visualizer visualizer = new Visualizer();
        CoastGuardParser parser = new CoastGuardParser(s);
        CoastGuardState state = parser.parse();
        Node node = new Node(state, null, new Move(Direction.LEFT), 0, 0);
        System.out.println(visualizer.visualize(node));
    }
}
