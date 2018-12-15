import java.util.Random;

class shape {
    int[][] coords = new int[4][2];
    int x, y, shapeNo;
    public String shape;

    public void rotation(String option) {

        char[] str = shape.toCharArray();
        for (int i = 0; i < shape.length(); i++) {
            if (option.equals("l")) {
                if (str[i] == 'd')
                    str[i] = 'r';
                else if (str[i] == 'r')
                    str[i] = 'u';
                else if (str[i] == 'u')
                    str[i] = 'l';
                else if (str[i] == 'l')
                    str[i] = 'd';
            }

            else if (option.equals("r")) {
                if (str[i] == 'd')
                    str[i] = 'l';
                else if (str[i] == 'r')
                    str[i] = 'd';
                else if (str[i] == 'u')
                    str[i] = 'r';
                else if (str[i] == 'l')
                    str[i] = 'u';
            }
        }
        shape = new String(str);
    }

    public void movement(String move) {
        if (move.equals("s")) {
            for (int i = 0; i < 4; i++) {
                coords[i][0]++;
            }
        }
        if (move.equals("d")) {
            for (int i = 0; i < 4; i++) {
                coords[i][1]++;
            }
        }
        if (move.equals("a")) {
            for (int i = 0; i < 4; i++) {
                coords[i][1]--;
            }
        }
    }

    public void generator(String shape) {
        coords[0][0] = x;
        coords[0][1] = y;
        int k = 1, f;
        for (int i = 0; i < shape.length(); i++) {
            f = 0;
            if (shape.charAt(i) == 'x') {
                i++;
                f++;
                if (shape.charAt(i) == 'd') {
                    x++;
                } else if (shape.charAt(i) == 'r') {
                    y++;
                } else if (shape.charAt(i) == 'l') {
                    y--;
                } else if (shape.charAt(i) == 'u') {
                    x--;
                }
            }

            else if (shape.charAt(i) == 'd') {
                x++;
            } else if (shape.charAt(i) == 'r') {
                y++;
            } else if (shape.charAt(i) == 'l') {
                y--;
            } else if (shape.charAt(i) == 'u') {
                x--;
            }
            if (f == 0) {
                coords[k][0] = x;
                coords[k][1] = y;
                k++;
            }
        }

    }

    public void check() {
        x = 0;
        y = 13;
        Random rand = new Random();
        shapeNo = rand.nextInt(7);
        System.out.println("-->" + shapeNo);
        switch (shapeNo) {
        case 1:
            shape = new String("rrr");
            generator(shape);
            break;
        case 2:
            shape = new String("rdr");
            generator(shape);
            break;
        case 3:
            shape = new String("drd");
            generator(shape);
            break;
        case 4:
            shape = new String("rdl");
            generator(shape);
            break;
        case 5:
            shape = new String("ddr");
            generator(shape);
            break;
        case 6:
            shape = new String("ddl");
            generator(shape);
            break;
        case 0:
            shape = new String("dlxrr");
            generator(shape);
            break;
        default:
            shape = new String("Invalid");
            break;
        }
    }
}