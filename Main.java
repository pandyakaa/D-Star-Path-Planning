public class Main {

    // Atribut

    // Method
    public static void main(String[] args) {
        DStar ds = new DStar();

        /* Show Initial Map */
        System.out.println("====================");
        System.out.println("INITIAL MAP");
        System.out.println("====================");
        ds.getMap().showMap();
        DNode dn = ds.startDS(ds.getMap().getXStart(),ds.getMap().getYStart(),ds.getMap().getXFinal(),ds.getMap().getYFinal());

        /* Show exploration map */
        if (dn != null) {
            System.out.println("====================");
            System.out.println("EXPLORATION MAP");
            System.out.println("====================");
            ds.getMap().showSolution();
        } else {
            ds.getMap().showSolution();
            System.out.println("Path not found!");
        }

        /* Show shortest path */
        System.out.println("====================");
        System.out.println("SHORTEST PATH WITHOUT REPLANNING");
        System.out.println("====================");
        while(dn.getNext() != null ) {
            ds.getMap().setPoint(dn.getX(),dn.getY(),'4');
            dn = dn.getNext();
        }
        ds.getMap().setPoint(dn.getX(),dn.getY(),'4');
        ds.getMap().showSolution();

        /* Change the initial map */
        System.out.println("====================");
        System.out.println("HAVING AN OBSTACLE AFTER SEARCHING");
        System.out.println("====================");
        DStar dx = new DStar();
        DNode dz = dx.startDS(dx.getMap().getXStart(),dx.getMap().getYStart(),dx.getMap().getXFinal(),dx.getMap().getYFinal());
        dx.getMap().setPoint(2,4,'1');
        boolean isObstacle = false;
        while (dz.getNext() != null && !isObstacle) {
            dx.getMap().setPoint(dz.getX(),dz.getY(),'4');
            dz = dz.getNext();
            if (dx.getMap().getLand(dz.getNext().getX(),dz.getNext().getY()) == '1') {
                isObstacle = true;
            }
        }
        dx.getMap().setPoint(dz.getX(),dz.getY(),'4');
        dx.getMap().showSolution();
        
        System.out.println("====================");
        System.out.println("NEW PATH WITH REPLANNING");
        System.out.println("====================");
        if (isObstacle) {
            DNode dv = dx.startDS(dz.getX(),dz.getY(),dx.getMap().getXFinal(),dx.getMap().getYFinal());
            while (dv.getNext() != null) {
                dx.getMap().setPoint(dv.getX(),dv.getY(),'4');
                dv = dv.getNext();
            }
            dx.getMap().setPoint(dv.getX(),dv.getY(),'4');
        }
        
        dx.getMap().showSolution();
    }
}