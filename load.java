import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class load {

    char[][] loadMat(char[][] mat) {

        try {
            FileReader fp1 = new FileReader("/home/anmolmalhotra97/Desktop/Tetris/save/matSave.txt");
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 25; j++) {
                    // if(fp.read()!="\n")
                    mat[i][j] = (char) fp1.read();

                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return mat;

    }

    int[][] loadCoords(int[][] coords) {
        try {
            Scanner fp1 = new Scanner(new File("/home/anmolmalhotra97/Desktop/Tetris/save/coordsSave.txt"));
            for (int i = 0; i < 4; i++) {
                coords[i][0] = Integer.parseInt(fp1.next());
                coords[i][1] = Integer.parseInt(fp1.next());
                System.err.println(coords[i][0] + " " + coords[i][1]);
            }
            fp1.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return coords;

    }

    String loadPrev(String shape) {
        try {
            // FileReader("/home/anmolmalhotra97/Desktop/Tetris/save/cooordsSave.txt");
            shape = new String(
                    Files.readAllBytes(Paths.get("/home/anmolmalhotra97/Desktop/Tetris/save/coordsSave.txt")));
            System.out.println("shape: " + shape);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return shape;

    }
}
