public class DNode {
    
    // Atribut
    int x,y;
    double h,k;
    DNode next;

    // Method
    public DNode(int x, int y, DNode dn) {
    /*  Merupakan konstruktor user-defined dari kelas DNode
        @param : Koordinat dari node (int x dan int y), serta next node */
        this.x = x;
        this.y = y;
        h = 0;
        k = 0;
        next = dn;
    }

    public DNode(int x, int y, double h, double k, DNode dn) {
    /*  Merupakan konstruktor user-defined dari kelas DNode
        @param : Koordinat dari node (int x dan int y), State dari node (double h dan double k)
        serta next node */
        this.x = x;
        this.y = y;
        this.h = h;
        this.k = k;
        this.next = dn;
    }

    public int getX() {
    /* Getter untuk atribut koordinat X */
        return x;
    }

    public int getY() {
    /* Getter untuk atribut koordinat Y */
        return y;
    }

    public double getH() {
    /* Getter untuk atribut state H */
        return h;
    }

    public double getK() {
    /* Getter untuk atribut state K */
        return k;
    }

    public void setX(int x) {
    /* Setter untuk atribut koordinat X */
        this.x = x;
    }

    public void setY(int y) {
    /* Setter untuk atribut koordinat Y */
        this.y = y;
    }

    public void setH(double h) {
    /* Setter untuk atribut state H */
        this.h = h;
    }

    public void setK(double k) {
    /* Setter untuk atribut state K */
        this.k = k;
    }

    public DNode getNext() {
    /* Getter untuk next node */
        return next;
    }

    public void print() {
    /* Method untuk print koordinat node serta state dari node */
        System.out.printf("Node : ( x : %d , y : %d) with State : ( h : %f, k : %f)\n",x,y,h,k);
    }
}