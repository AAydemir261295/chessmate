package ChessItems.BlackFigures;

public enum BlackFigures {

    BISHOP("\u265D "),
    CASTLE("\u265C "),
    KNIGHT("\u265E "),
    PAWN("\u265F "),
    QUEEN("\u265B "),
    KING("\u265A "),
    CELL(" \u25A0");

    private String figure;

    BlackFigures(String figure) {
        this.figure = figure;
    }

    public String getFigure() {
        return figure;
    }
}
