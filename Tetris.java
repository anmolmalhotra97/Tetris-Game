import java.util.*;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class Tetris {
      void copy(int[][] prev, int coords[][]) {
            for (int i = 0; i < 4; i++) {
                  prev[i][0] = coords[i][0];
                  prev[i][1] = coords[i][1];
            }
      }

      public static void main(String[] args) {
            board b = new board();
            int[][] prev = new int[4][2];
            Tetris tm = new Tetris();
            Scanner bucky = new Scanner(System.in);
            shape s = new shape();
            System.out.println("press 1 for a new Game and 0 to load a saved Game");
            int op = bucky.nextInt();
            int save = 0;
            if (op == 0) {
                  load lsg = new load();
                  b.mat = lsg.loadMat(b.mat);
                  s.coords = lsg.loadCoords(s.coords);
                  s.shape = lsg.loadPrev(s.shape);
                  System.out.println("shape checked is: " + s.shape);
                  save = 1;
            }
            if (save != 1) {
                  s.check();// decides and generates a random shape using generator function in shape class
                  b.setBoard(s.coords);// sets the shape value on matrix
            }
            b.printBoard();// prints everything visible on console
            String move;
            int flag = 0;
            for (int i = 0;; i++) {
                  if (flag == 1) {
                        s = new shape();
                        s.check();// decides and generates a random shape using generator function in shape class
                        b.setBoard(s.coords);// sets the shape value on matrix
                        b.printBoard();// prints everything visible on console
                        flag = 0;
                  }
                  tm.copy(prev, s.coords);// stores copy of a previous move;
                  String prevShape = new String(s.shape);
                  move = bucky.next();// asks user for next input
                  if (move.equals("z")) {
                        System.out.println("press 'q' to QUIT or 's' to SAVE");
                        String option = bucky.next();
                        if (option.equals("s")) {
                              saveGame sav = new saveGame();
                              sav.save(b.mat, s.coords, s.shape);
                              System.out.println("\nyou performed a save operation\n");
                              System.exit(1);
                        } else if (option.equals("q"))
                              System.exit(1);

                  } else if (move.equals("r") || move.equals("l")) // to check if user wants to rotate
                  {
                        s.rotation(move);// first rotate
                        s.x = prev[0][0];// sets the x coordinate for the pivot
                        s.y = prev[0][1];// sets the y coordinate for the pivot
                        s.generator(s.shape);
                        int temp = b.checkValid(s.coords);
                        if (temp == 69) {
                              b.cleaner(prev);
                              b.setBoard(s.coords);
                        } else {
                              s.shape = new String(prevShape);
                              tm.copy(s.coords, prev);
                        }
                  } else {
                        s.movement(move);// normal working acc to move user wants to make
                        int temp = b.checkValid(s.coords);
                        if (temp == 69) {
                              b.cleaner(prev);
                              b.setBoard(s.coords);
                        } else if (temp == 1) {
                              b.cleaner(prev);
                              b.fixate(s.coords);
                              int shift = b.checkFull(b.fixRow);
                              System.out.println("total Elements in row " + b.fixRow + " is " + shift);
                              if (shift == 23)
                                    b.shift(b.fixRow);
                              flag = 1;
                        } else {
                              tm.copy(s.coords, prev);
                        }
                  }
                  b.printBoard();
            }
      }
}
