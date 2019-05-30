import java.util.ArrayList;

public class DStar {
    
    // Atribut
    Map ma;
    PrioQueue pq;

    // Method
    public DStar(String filename) {
    /* Konstruktor dari kelas DStar,
       Inisialisasi atribut ma dari kelas Map */
        try {
            ma = new Map(filename);
        } catch (Exception e) {
            System.out.println("Map file not found :(");
        }
    }

    public Map getMap() {
    /* Getter untuk atribut ma */
        return ma;
    }

    public void setMap(Map ma) {
    /* Setter untuk atribut ma */
        this.ma = ma;
    }

    public PrioQueue getPrioQueue() {
    /* Getter untuk atribut pq */
        return pq;
    }

    public void setPrioQueue(PrioQueue pq) {
    /* Setter untuk atribut pq */
        this.pq = pq;
    }

    public DNode startDS(int xstart, int ystart, int xfinal, int yfinal) {
    /* Method startDS
       @return DNode dimana merupakan titik start jika path berhasil ditemukan 
       dan return null jika path tidak ditemukan */
        pq = new PrioQueue();
    
        DNode finalNode = new DNode(xfinal,yfinal,0,0,null);
        pq.add(finalNode);

        while (!(pq.isEmpty())) {
            DNode current_node = pq.delete();
            ma.setPoint(current_node.getX(),current_node.getY(),'3');

            if (current_node.getX() == xstart && current_node.getY() == ystart) {
                return current_node;
            }

            ArrayList<DNode> children = new ArrayList<DNode>();
            int position[][] = { {0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {-1,-1}, {-1,1}, {1,-1} };
            for (int[] pos : position) {
                int curr_x = current_node.getX() + pos[0];
                int curr_y = current_node.getY() + pos[1];

                if (!(ma.isValidPos(curr_x,curr_y))) {
                    continue;
                }                

                DNode child = new DNode(curr_x,curr_y,current_node);
                children.add(child);

                if ( Math.abs(pos[0]-pos[1]) == 1 ) {
                    child.setH(current_node.getH() + 1);
                    child.setK(child.getH());
                } else {
                    child.setH(current_node.getH() + Math.sqrt(2));
                    child.setK(child.getH());
                }

                pq.add(child);
            }
        }
        return null;
    }

    public void findPathUtil(int xs, int ys, int xf, int yf) {
    /* Digunakan sebagai utilitas untuk fungsi yang akan dipanggil di program utama
       @param int xs = x start, int ys = ystart, int xf = xfinal, int yf = yfinal */

        DNode dn = startDS(xs, ys, xf, yf);

        if (dn == null) {
            ma.showSolution();
            System.out.println("PATH NOT FOUND");
        } else {
            ma.setPoint(xf,yf,'4');
            
            /* PERUBAHAN OBSTACLE */
            //ma.setPoint(2,4,'1');
            /* ================== */

            boolean isObstacle = false;
            while (dn.getNext() != null && !isObstacle ) {
                int nx = dn.getX();
                int ny = dn.getY();

                System.out.println("=====================");
                dn.print();

                if (ma.getLand(dn.getNext().getX(),dn.getNext().getY()) == '1') {
                    isObstacle = true;
                } else {
                    dn = dn.getNext();
                }
                ma.setPoint(nx,ny,'4');
                ma.showSolution();
                System.out.println("=====================");
            }

            dn.print();
            ma.showSolution();
            System.out.println("=====================");

            if (isObstacle) {
                xs = dn.getX();
                ys = dn.getY();
                findPathUtil(xs, ys, xf, yf);    
            }
        }
    }

    public void findPath() {
    /* Fungsi utama yang akan dipanggil pada fungsi Main*/
        int xs = ma.getXStart();
        int ys = ma.getYStart();
        int xf = ma.getXFinal();
        int yf = ma.getYFinal();

        findPathUtil(xs, ys, xf, yf);
    }
}