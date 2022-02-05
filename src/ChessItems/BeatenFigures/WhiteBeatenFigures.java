package ChessItems.BeatenFigures;

import ChessItems.Items.ChessItem;
import ChessItems.WhiteFigures.Pawn.W_Pawn;

import java.util.ArrayList;
import java.util.Scanner;

public class WhiteBeatenFigures {
    private static ArrayList<ChessItem> whiteFigures = new ArrayList<>();

    private int printFigures() {
        System.out.print("Выберите фигуру для обмена:");
        for (int i = 0; i < whiteFigures.size(); i++) {
            System.out.println("   " + i + ": " + whiteFigures.get(i).getFigure());
        }
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public ChessItem swapFigure() {
        int positionInList = printFigures();
        if (positionInList != -1) {
            ChessItem tmp = whiteFigures.get(positionInList);
            whiteFigures.removeIf(x -> figuresEquals(x, tmp));
            return tmp;
        }
        return null;
    }

    public void addFigure(ChessItem figure) {
        if (!(figure instanceof W_Pawn))
            whiteFigures.add(figure);
    }

    private boolean figuresEquals(ChessItem figure, ChessItem figure2) {
        return figure.getFigure().equals(figure2.getFigure());
    }

    public ArrayList<ChessItem> getWhiteFigures() {
        return whiteFigures;
    }
}
