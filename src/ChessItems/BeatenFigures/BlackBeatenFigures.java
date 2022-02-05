package ChessItems.BeatenFigures;

import ChessItems.BlackFigures.Pawn.B_Pawn;
import ChessItems.Items.ChessItem;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackBeatenFigures {
    //Класс собирающий битые фигуры
    //Для обмена на пешку
    private static ArrayList<ChessItem> blackFigures = new ArrayList<>();

    //Принт для выбобра фигуры
    public int printFigures() {
        for (int i = 0; i < blackFigures.size(); i++) {
            System.out.println(i + ": " + blackFigures.get(i).getFigure());
        }
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    //Свапает фигуры
    public ChessItem swapFigure() {
        int positionInList = printFigures();
        if (positionInList != -1) {
            ChessItem tmp = blackFigures.get(positionInList);
            blackFigures.removeIf(x -> figuresEquals(x, tmp));
            return tmp;
        }
        return null;
    }

    public void addFigure(ChessItem figure) {
        if (!(figure instanceof B_Pawn)) {
            blackFigures.add(figure);
        }
    }

    private boolean figuresEquals(ChessItem figure, ChessItem figure2) {
        return figure.getFigure().equals(figure2.getFigure());
    }

    public ArrayList<ChessItem> getBlackFigures() {
        return blackFigures;
    }
}
