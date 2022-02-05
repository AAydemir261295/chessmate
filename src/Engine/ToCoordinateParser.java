package Engine;

public class ToCoordinateParser {
    // ошибки здесь не обработаны и все примитивно так как игра в консоли это временное решение

    int x;
    int y;

    public ToCoordinateParser(String coordinate) {
        char charX = coordinate.charAt(0);
        switch (charX) {
            case 'A':
                x = 1;
                break;
            case 'B':
                x = 2;
                break;
            case 'C':
                x = 3;
                break;
            case 'D':
                x = 4;
                break;
            case 'E':
                x = 5;
                break;
            case 'F':
                x = 6;
                break;
            case 'G':
                x = 7;
                break;
            case 'H':
                x = 8;
                break;
        }
        y = Integer.parseInt(Character.toString(coordinate.charAt(1)));
    }

    public ToCoordinateParser(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean coordinatesIsSame(ToCoordinateParser first, ToCoordinateParser second) {
        return first.getX() == second.getX() && first.getY() == second.getY();
    }
}
