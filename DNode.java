public class DNode {
    
    // Atribut
    int x,y;
    double h,k;
    DNode next;

    // Method
    public DNode(int x, int y,DNode dn) {
        this.x = x;
        this.y = y;
        h = 0;
        k = 0;
        next = dn;
    }

    public DNode(int x, int y, double h, double k, DNode dn) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.k = k;
        this.next = dn;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getH() {
        return h;
    }

    public double getK() {
        return k;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setK(double k) {
        this.k = k;
    }

    public DNode getNext() {
        return next;
    }

    public boolean isEqual(DNode n) {
        return (x == n.getX() && y == n.getY());
    }

    public void print() {
        System.out.printf("%d,%d,%f,%f\n",x,y,h,k);
    }
}