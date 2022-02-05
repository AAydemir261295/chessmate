package ChessItems.WhiteFigures;

public enum WhiteFigures {

    BISHOP("\u2657 "),
    CASTLE("\u2656 "),
    KNIGHT("\u2658 "),
    PAWN("\u2659 "),
    QUEEN("\u2655 "),
    KING("\u2654 "),
    CELL(" \u25A1");

    private String figure;

    WhiteFigures(String figure) {
        this.figure = figure;
    }

    public String getFigure() {
        return figure;
    }
}
