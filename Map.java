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

        for (int i = 0 ; i < map.size() ; i++) {
            if (map.get(i).charAt(map.size()-1) == '0' ) {
                xfinal = i;
                yfinal = map.size()-1;
            }
        }

        for (int j = 0 ; j < map.size() ; j++) {
            if (map.get(map.size()-1).charAt(j) == '0') {
                xfinal = map.size()-1;
                yfinal = j;
            }
        }
    }

    public ArrayList<String> getMap() {
        return map;
    }

    public void setMap(ArrayList<String> newmap) {
        map = newmap;
    }

    public int getXFinal() {
        return xfinal;
    }

    public int getYFinal() {
        return yfinal;
    }

    public int getXStart() {
        return xstart;
    }

    public int getYStart() {
        return ystart;
    }
}