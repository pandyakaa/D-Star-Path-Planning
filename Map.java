import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Map {
    
    // Atribut
    ArrayList<String> map = new ArrayList<String>();
    int xstart,ystart;
    int xfinal,yfinal;

    // Method
    public Map() throws Exception {
        File newfile = new File("map.txt");
        Scanner newscan = new Scanner(newfile);
        while(newscan.hasNextLine()) {
            map.add(newscan.nextLine());
        }
        newscan.close();

        for (int i = 0 ; i < map.size() ; i++) {
            if (map.get(i).charAt(0) == '0') {
                xstart = i;
                ystart = 0;
            }
        }

        for (int j = 0 ; j < map.size() ; j++) {
            if (map.get(0).charAt(j) == '0' ) {
                xstart = 0;
                ystart = j;
            } 
        }
    }

    public ArrayList<String> getMap() {
        return map;
    }

    public void setMap(ArrayList<String> newmap) {
        map = newmap;
    }

    public static void main(String[] args) {
        try {
            Map newmap = new Map();
            System.out.println(newmap.getMap().get(2).charAt(2));
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}