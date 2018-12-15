
import java.io.*;

class saveGame {

    void save(char[][] mat, int[][] coords, String shape) {
        try {
            FileWriter fp1 = new FileWriter("/home/anmolmalhotra97/Desktop/Tetris/save/matSave.txt");
            System.out.println("\n\n");
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 25; j++) {
                    if (mat[i][j] != '\0')
                        fp1.write((char) mat[i][j]);
                    else
                        fp1.write(" ");
                    // System.out.print(mat[i][j]);
                }
                // fp1.write("\n");
                // System.out.println();
            }
            fp1.close();
            File fp2 = new File("/home/anmolmalhotra97/Desktop/Tetris/save/coordsSave.txt");
            PrintStream o = new PrintStream(fp2);

            // Store current System.out before assigning a new value
            PrintStream console = System.out;
            System.setOut(o);
            for (int i = 0; i < 4; i++) {
                System.out.print(coords[i][0] + " " + coords[i][1] + " ");
            }
            System.setOut(console);
            // fp2.close();
            FileWriter fp3 = new FileWriter("/home/anmolmalhotra97/Desktop/Tetris/save/shapeSave.txt");
            fp3.write(shape);
            fp3.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}