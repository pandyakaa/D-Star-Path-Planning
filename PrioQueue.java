import java.util.ArrayList;

public class PrioQueue {
    
    // Atribut
    ArrayList<DNode> arrnode;

    // Method
    public PrioQueue() {
        arrnode = new ArrayList<DNode>();
    }

    public boolean isEmpty() {
        return (arrnode.size() == 0);
    }

    public void add(DNode n) {
        arrnode.add(n);
    }

    public DNode delete() {
        if (!isEmpty()) {
            DNode temp = new DNode(0,0,0,999,null);
            for (int i = 0 ; i < arrnode.size() ; i++) {
                if (arrnode.get(i).k < temp.k) {
                    temp = arrnode.get(i);
                }
            }
            arrnode.remove(temp);
            return temp;
        } else {
            return null;
        }
    }
}