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
    public Map(String filename) throws Exception {
    /* Konstruktor dari kelas Map
       Akan membuat sebuah matriks dari file eksternal map.txt 
       Sekaligus mencari koordinat mulai dan koordinat akhir
       serta banyak kolom(length) dan banyak baris(width) */
        File newfile = new File(filename);
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
    /* Getter untuk atribut map */
        return map;
    }

    public void setMap(ArrayList<StringBuilder> newmap) {
    /* Setter untuk atribut map */    
        map = newmap;
    }

    public int getXFinal() {
    /* Getter untuk atribut koordinat X Final */    
        return xfinal;
    }

    public int getYFinal() {
    /* Getter untuk atribut koordinat Y Final */      
        return yfinal;
    }

    public int getXStart() {
    /* Getter untuk atribut koordinat X Start */  
        return xstart;
    }

    public int getYStart() {
    /* Getter untuk atribut koordinat Y Start */  
        return ystart;
    }

    public int getLand(int x, int y) {
    /* Getter untuk atribut yang ada matriks[x][y] */  
        return map.get(x).charAt(y);
    }

    public void setPoint(int x, int y, char n) {
    /* Setter untuk atribut yang ada matriks[x][y] */  
        map.get(x).setCharAt(y, n);
    }

    public int getLength() {
    /* Getter untuk atribut length */  
        return length;
    }

    public int getWidth() {
    /* Getter untuk atribut width */  
        return width;
    }

    public void showMap() {
    /* Print pada map awal,
       menunjukkan jalur yang bisa dilewati dan obstacle */
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

    public boolean isValidPos(int i, int j, String func) {
    /* @return true jika sebuah titik merupakan titik yang valid untuk dilalui */
        if (func.equals("recc")) {
            if (i < width && j < length && i >= 0 && j >= 0) {
                if (map.get(i).charAt(j) == '0' || map.get(i).charAt(j) == '4' || map.get(i).charAt(j) == '3' ) {
                    return true;
                }
            }
        } else {
            if (i < width && j < length && i >= 0 && j >= 0) {
                if (map.get(i).charAt(j) == '0' || map.get(i).charAt(j) == '4' ) {
                    return true;
                }
            } 
        }


        return false;
    }

    public void showSolution() {
    /* Print pada map setelah dilakukan searching,
       menunjukkan jalur yang sudah di explore dan obstacle */
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