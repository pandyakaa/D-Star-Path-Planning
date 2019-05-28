import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Map {
    
    // Atribut
    ArrayList<StringBuilder> map = new ArrayList<StringBuilder>();
    int xstart,ystart;
    int xfinal,yfinal;
    int length,width;

    // Method
    public Map() throws Exception {
        File newfile = new File("map.txt");
        Scanner newscan = new Scanner(newfile);
        while(newscan.hasNextLine()) {
            StringBuilder temp = new StringBuilder(newscan.nextLine());
            map.add(temp);
        }
        newscan.close();

        length = map.get(0).length(); //kolom
        width = map.size(); //baris

        for (int i = 0 ; i < width ; i++) {
            if (map.get(i).charAt(0) == '0') {
                xstart = i;
                ystart = 0;
            }
        }

        for (int j = 0 ; j < length ; j++) {
            if (map.get(0).charAt(j) == '0' ) {
                xstart = 0;
                ystart = j;
            } 
        }

        for (int i = 0 ; i < width ; i++) {
            if (map.get(i).charAt(length-1) == '0' ) {
                xfinal = i;
                yfinal = length-1;
            }
        }

        for (int j = 0 ; j < length ; j++) {
            if (map.get(width-1).charAt(j) == '0') {
                xfinal = width-1;
                yfinal = j;
            }
        }
    }

    public ArrayList<StringBuilder> getMap() {
        return map;
    }

    public void setMap(ArrayList<StringBuilder> newmap) {
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

    public void setPoint(int x, int y, char n) {
        map.get(x).setCharAt(y, n);
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void showMap() {
        for(int i = 0 ; i < width; i++ ) {
            for (int j = 0 ; j < length ; j++ ) {
                if (map.get(i).charAt(j) == '0' ) {
                    System.out.print("   ");
                } else {
                    System.out.print(" # ");
                }
            }
            System.out.println();
        }
    }

    public boolean isValidPos(int i, int j) {
        if (i < width && j < length) {
            if (map.get(i).charAt(j) == '0') {
                return true;
            }
        }

        return false;
    }

    public void showSolution() {
        for (int i = 0 ; i < width ; i++) {
            for (int j = 0 ; j < length ; j++) {
                if (map.get(i).charAt(j) == '0') {
                    System.out.print("   ");
                } else if (map.get(i).charAt(j) == '1') {
                    System.out.print(" # ");
                } else if (map.get(i).charAt(j) == '4'){
                    System.out.print(" X ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}