package ChessItems.Items;

import ChessItems.BlackFigures.Bishop.BlackBishop;
import ChessItems.BlackFigures.BlackCell;
import ChessItems.BlackFigures.BlackFigures;
import ChessItems.BlackFigures.Castle.BlackCastle;
import ChessItems.BlackFigures.King.BlackKing;
import ChessItems.BlackFigures.Knight.BlackKnight;
import ChessItems.BlackFigures.Pawn.BlackPawn;
import ChessItems.BlackFigures.Queen.BlackQueen;
import ChessItems.WhiteFigures.Bishop.WhiteBishop;
import ChessItems.WhiteFigures.Castle.WhiteCastle;
import ChessItems.WhiteFigures.King.WhiteKing;
import ChessItems.WhiteFigures.Knight.WhiteKnight;
import ChessItems.WhiteFigures.Pawn.WhitePawn;
import ChessItems.WhiteFigures.Queen.WhiteQueen;
import ChessItems.WhiteFigures.WhiteCell;
import ChessItems.WhiteFigures.WhiteFigures;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

import java.util.ArrayList;
import java.util.Arrays;

public class Board extends ChessItem {
    // Извините за хардкодинг

    private static ArrayList<ChessItem> board = new ArrayList<>();

    static {
        addBlackFigures();
        addCells();
        addWhiteFigures();
    }


    public ArrayList<ChessItem> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ChessItem> board) {
        Board.board = board;
    }

    public ChessItem getItemFromCoordinate(ToCoordinateParser coordinate) {
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).getX() == coordinate.getX()
                    && board.get(i).getY() == coordinate.getY()) {
                return board.get(i);
            }
        }
        return null;
    }

    public ToCoordinateParser getCoordinate(int index) {
        int x = board.get(index).getX();
        int y = board.get(index).getY();
        return new ToCoordinateParser(x, y);
    }

    public int getIndexOfCoordinate(ToCoordinateParser coordinate) {
        int result = -1;
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).getX() == coordinate.getX()
                    && board.get(i).getY() == coordinate.getY()) {
                return i;
            }
        }
        return result;
    }

    private static void addWhiteFigures() {
        for (int i = 1; i < 9; i++, i++) {
            board.add(new WhitePawn(i, 2, "white", WhiteFigures.PAWN.getFigure()));
            board.add(new WhitePawn(i + 1, 2, "black", WhiteFigures.PAWN.getFigure()));
        }
        board.add(new WhiteCastle(1, 1, "black", WhiteFigures.CASTLE.getFigure(), 0));
        board.add(new WhiteKnight(2, 1, "white", WhiteFigures.KNIGHT.getFigure()));
        board.add(new WhiteBishop(3, 1, "black", WhiteFigures.BISHOP.getFigure()));
        board.add(new WhiteQueen(4, 1, "white", WhiteFigures.QUEEN.getFigure()));
        board.add(new WhiteKing(5, 1, "black", WhiteFigures.KING.getFigure(), 0));
        board.add(new WhiteBishop(6, 1, "white", WhiteFigures.BISHOP.getFigure()));
        board.add(new WhiteKnight(7, 1, "black", WhiteFigures.KNIGHT.getFigure()));
        board.add(new WhiteCastle(8, 1, "white", WhiteFigures.CASTLE.getFigure(), 0));
    }

    private static void addCells() {
        addCellsFirstIsWhite(6);
        addCellsFirstIsBlack(5);
        addCellsFirstIsWhite(4);
        addCellsFirstIsBlack(3);
    }

    private static void addCellsFirstIsWhite(int y) {
        for (int i = 1; i < 9; i++, i++) {
            board.add(new WhiteCell(i, y, "white", WhiteFigures.CELL.getFigure()));
            board.add((new BlackCell(i + 1, y, "black", BlackFigures.CELL.getFigure())));
        }
    }

    private static void addCellsFirstIsBlack(int y) {
        for (int i = 1; i < 9; i++, i++) {
            board.add(new BlackCell(i, y, "black", BlackFigures.CELL.getFigure()));
            board.add(new WhiteCell(i + 1, y, "white", WhiteFigures.CELL.getFigure()));
        }
    }

    private static void addBlackFigures() {
        board.add(new BlackCastle(1, 8, "white", BlackFigures.CASTLE.getFigure(), 0));
        board.add(new BlackKnight(2, 8, "black", BlackFigures.KNIGHT.getFigure()));
        board.add(new BlackBishop(3, 8, "white", BlackFigures.BISHOP.getFigure()));
        board.add(new BlackQueen(4, 8, "black", BlackFigures.QUEEN.getFigure()));
        board.add(new BlackKing(5, 8, "white", BlackFigures.KING.getFigure(), 0));
        board.add(new BlackBishop(6, 8, "black", BlackFigures.BISHOP.getFigure()));
        board.add(new BlackKnight(7, 8, "white", BlackFigures.KNIGHT.getFigure()));
        board.add(new BlackCastle(8, 8, "black", BlackFigures.CASTLE.getFigure(), 0));

        for (int i = 1; i < 9; i++, i++) {
            board.add(new BlackPawn(i, 7, "black", BlackFigures.PAWN.getFigure()));
            board.add(new BlackPawn(i + 1, 7, "white", BlackFigures.PAWN.getFigure()));
        }
    }

    public void printBoard() {
        int counter = 0;
        int numbs = 7;
        String[] tmp = {" A ", " B ", " C ", "D ", " E ", " F ", "G ", " H"};

        System.out.print("8");
        for (int i = 0; i < board.size(); i++) {
            System.out.print(board.get(i).getFigure());
            counter++;
            if (counter == 8 && numbs != 0) {
                System.out.print("\n");
                System.out.print(numbs);
                counter = 0;
                numbs--;

            }
        }
        System.out.print("\n");
        Arrays.stream(tmp).forEach(System.out::print);
        System.out.print("\n");
    }

    @Override
    public int move(ToCoordinateParser before, ToCoordinateParser after) {
        int beforeMoveIndex = getIndexOfCoordinate(before);
        return moveFigure(before, after, beforeMoveIndex);
    }

    @Override
    public HasDirection getDirection() {
        return null;
    }

    private int moveFigure(ToCoordinateParser before, ToCoordinateParser after, int index) {
        return board.get(index).move(before, after);

    }
}
