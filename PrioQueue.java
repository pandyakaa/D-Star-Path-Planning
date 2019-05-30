import java.util.ArrayList;

public class PrioQueue {
    
    // Atribut
    ArrayList<DNode> arrnode;

    // Method
    public PrioQueue() {
    /* Merupakan konstruktor dari kelas PrioQueue
       Menciptakan sebuah ArrayList baru dengan tipe DNode */
        arrnode = new ArrayList<DNode>();
    }

    public boolean isEmpty() {
    /* @return true jika ArrayList kosong */
        return (arrnode.size() == 0);
    }

    public void add(DNode n) {
    /* Menambahkan sebuah DNode ke dalam ArrayList */
        arrnode.add(n);
    }

    public DNode delete() {
    /* @return sebuah DNode yang memiliki state K terkecil 
       dan menghapus DNode tersebut dari ArrayList */
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