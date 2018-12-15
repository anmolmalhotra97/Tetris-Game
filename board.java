import sun.util.calendar.AbstractCalendar;

public class board {
    char[][] mat = new char[20][25];

    int[][] freq = new int[20][1];
    int fixRow = 0;

    public void shift(int row) {
        for (int i = row; i > 0; i--) {
            for (int j = 1; j <= 23; j++) {
                mat[i][j] = mat[i - 1][j];
            }
        }
        for (int i = 1; i < 24; i++) {
            mat[0][i] = ' ';
        }
    }

    public void fixate(int[][] coords) {
        for (int i = 0; i < 4; i++) {
            mat[coords[i][0]][coords[i][1]] = '@';
        }
        int row = coords[0][0];
        freq[row][0] = checkFull(row);
        if (freq[row][0] == 23)
            shift(row);
    }

    public int checkValid(int[][] coords) {
        for (int i = 0; i < 4; i++) {
            if (coords[i][1] == 24 || coords[i][1] == 0) {
                System.out.println("Caught on walll");
                return 0;// invalid move;
            } else if (coords[i][0] == 19) {
                fixRow = coords[i][0];
                return 1;// fixate
            } else {
                for (int j = 0; j < 4; j++) {
                    if (mat[coords[i][0] + 1][coords[i][1]] == '@') {
                        fixRow = coords[i][0] + 1;
                        return 1;
                    }
                }
            }
        }
        return 69;
    }

    void cleaner(int[][] remove) {
        for (int i = 0; i < 4; i++) {
            System.out.println("removed " + remove[i][0] + "\t" + remove[i][1]);
            mat[remove[i][0]][remove[i][1]] = ' ';
        }
    }

    void setBoard(int[][] coords) {
        for (int i = 0; i < 4; i++) {
            System.out.println(coords[i][0] + " " + coords[i][1]);
            mat[coords[i][0]][coords[i][1]] = '#';
        }
    }

    void printBoard() {

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 25; j++) {
                if (j == 0 || j == 24)// side walls
                    System.out.print("|");
                else if (mat[i][j] == '\0')// inside the board
                    System.out.print(" ");
                else
                    System.out.print(mat[i][j]);
            }
            System.out.println();

        }
        for (int i = 0; i < 25; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
