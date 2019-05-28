public class Main {

    // Atribut

    // Method
    public static void main(String[] args) {
        DStar ds = new DStar();
        ds.getMap().showMap();
        System.out.println("==================");
        DNode dn = ds.startDS();
        if (dn != null) {
            ds.getMap().showSolution();
            System.out.println("==================");
            dn.print();
        }
        System.out.println("==================");
        while(dn.getNext() != null ) {
            ds.getMap().setPoint(dn.getX(),dn.getY(),'4');
            dn = dn.getNext();
        }
        ds.getMap().setPoint(dn.getX(),dn.getY(),'4');
        ds.getMap().showSolution();
    }
}