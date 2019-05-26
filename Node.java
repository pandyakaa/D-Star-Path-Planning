public class Node {
    
    // Atribut
    int x,y;
    float h,k;

    // Method
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        h = 0;
        k = 0;
    }

    public Node(int x, int y, float h, float k) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.k = k;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getH() {
        return h;
    }

    public float getK() {
        return k;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setH(float h) {
        this.h = h;
    }

    public void setK(float k) {
        this.k = k;
    }

    public boolean isEqual(Node n) {
        return (x == n.getX() && y == n.getY());
    }
}