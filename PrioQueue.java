import java.util.ArrayList;

public class PrioQueue {
    
    // Atribut
    ArrayList<Node> arrnode;

    // Method
    public PrioQueue() {
        arrnode = new ArrayList<Node>();
    }

    public void add(Node n) {
        if (arrnode.size() == 0) {
            arrnode.add(n);
        } else {
            //sort
        }
    }

}