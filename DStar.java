import java.util.ArrayList;

public class DStar {
    
    // Atribut
    Map ma;
    PrioQueue pq;

    // Method
    public DStar() {
        try {
            ma = new Map();
        } catch (Exception e) {
            System.out.println("Map file not found :(");
        }
    }

    public Map getMap() {
        return ma;
    }

    public void setMap(Map ma) {
        this.ma = ma;
    }

    public PrioQueue getPrioQueue() {
        return pq;
    }

    public void setPrioQueue(PrioQueue pq) {
        this.pq = pq;
    }

    public DNode startDS(int xstart, int ystart, int xfinal, int yfinal) {
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
}