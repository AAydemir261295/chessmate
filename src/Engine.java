import ChessItems.BeatenFigures.BlackBeatenFigures;
import ChessItems.BeatenFigures.WhiteBeatenFigures;
import ChessItems.BlackFigures.BlackFigure;
import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;
import ChessItems.WhiteFigures.WhiteFigure;
import Engine.CheckForBlack;
import Engine.CheckForWhite;
import Engine.Mate.MateForBlack;
import Engine.Mate.MateForWhite;
import Engine.ToCoordinateParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Engine {
    // ЗДЕСЬ ОЧЕНЬ ГРЯЗНО
    private int mate = 0;
    private ArrayList<Integer> lastTurn = new ArrayList<>();
    private ToCoordinateParser coordParserBefore;
    private ToCoordinateParser coordParserAfter;

    public int startTheGame() throws IOException, ClassNotFoundException {
        Board board = new Board();
        int whiteMove = 1;
        int blackMove = 0;
        CheckForWhite checkForWhite = new CheckForWhite();
        CheckForBlack checkForBlack = new CheckForBlack();
        MateForWhite forWhite = new MateForWhite();
        MateForBlack forBlack = new MateForBlack();

        while (mate == 0) {
            board.printBoard();
            System.out.println("Пример ВВОДА хода : A7 на A5, D8 на D5");

            if (lastTurn.isEmpty()) {
                int moveIsNotCorrect = -1;
                while (moveIsNotCorrect == -1) {
                    getMoveCoordinate();
                    if (selectedFigureIsWhite(coordParserBefore)) {
                        saveBeatenFigure(coordParserAfter);
                        moveIsNotCorrect = board.move(coordParserBefore, coordParserAfter);
                        if (moveIsNotCorrect == 1) {
                            lastTurn.add(whiteMove);
                            saveTurn();
                            return startTheGame();
                        } else return startTheGame();
                    }
                }
            }

            if (itBlackTurn()) {
                int moveIsNotCorrect = -1;
                while (moveIsNotCorrect == -1) {
                    getMoveCoordinate();
                    if (selectedFigureIsBlack(coordParserBefore)) {
                        saveBeatenFigure(coordParserAfter);
                        moveIsNotCorrect = board.move(coordParserBefore, coordParserAfter);
                        checkForBlack.isCheck();
                        if (checkForWhite.isCheck() == 1) {
                            if (forWhite.isMate(coordParserAfter)) {
                                mate = 1;
                                return startTheGame();
                            }
                        }
                        if (bMoveNotSaveFromCheck(moveIsNotCorrect, checkForBlack)) {
                            getPreviousBTurn();
                            return startTheGame();
                        } else if (correctBMoveAndNotCheck(moveIsNotCorrect, checkForBlack)) {
                            lastTurn.add(blackMove);
                            saveSecondTurn();
                            return startTheGame();
                        }
                    } else return startTheGame();
                }
            }

            if (itWhiteTurn()) {
                int moveIsNotCorrect = -1;
                while (moveIsNotCorrect == -1) {
                    getMoveCoordinate();
                    if (selectedFigureIsWhite(coordParserBefore)) {
                        saveBeatenFigure(coordParserAfter);
                        moveIsNotCorrect = board.move(coordParserBefore, coordParserAfter);
                        checkForWhite.isCheck();
                        if (checkForBlack.isCheck() == 1) {
                            if (forBlack.isMate(coordParserAfter)) {
                                mate = 1;
                                return startTheGame();
                            }
                        }
                        if (wMoveNotSaveFromCheck(moveIsNotCorrect, checkForWhite)) {
                            getPreviousWTurn();
                            return startTheGame();
                        } else if (correctWMoveAndNotCheck(moveIsNotCorrect, checkForWhite)) {
                            lastTurn.add(whiteMove);
                            saveTurn();
                            return startTheGame();
                        }
                    } else return startTheGame();
                }
            }
        }
        return mate;
    }

    private boolean correctWMoveAndNotCheck(int moveResult, CheckForWhite checkIt) {
        return moveResult == 1 && !(isCheckForWhite(checkIt));
    }

    private boolean wMoveNotSaveFromCheck(int moveResult, CheckForWhite checkIt) {
        return moveResult == 1 && isCheckForWhite(checkIt);
    }

    private void getPreviousWTurn() throws IOException, ClassNotFoundException {
        new Board().setBoard(getPreviousTurnForWhite(2));
    }

    private boolean correctBMoveAndNotCheck(int moveResult, CheckForBlack checkIt) {
        return moveResult == 1 && !(isCheckForBlack(checkIt));
    }

    private boolean bMoveNotSaveFromCheck(int moveResult, CheckForBlack checkIt) {
        return moveResult == 1 && isCheckForBlack(checkIt);
    }

    private void getPreviousBTurn() throws IOException, ClassNotFoundException {
        new Board().setBoard(getPreviousTurnForWhite(1));
    }

    private void getMoveCoordinate() {
        String coordBeforeMove;
        String coordAfterMove;
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите фигуру: ");
        coordBeforeMove = sc.nextLine();
        System.out.println("Сделайте ход: ");
        coordAfterMove = sc.nextLine();
        coordParserBefore = new ToCoordinateParser(coordBeforeMove);
        coordParserAfter = new ToCoordinateParser(coordAfterMove);
    }

    private void saveBeatenFigure(ToCoordinateParser beatenFigurePosition) {
        ChessItem beatenFigure = getFigure(beatenFigurePosition);
        BlackBeatenFigures blackBeatenFigures = new BlackBeatenFigures();
        WhiteBeatenFigures whiteBeatenFigures = new WhiteBeatenFigures();

        if (selectedFigureIsBlack(beatenFigurePosition)) {
            blackBeatenFigures.addFigure(beatenFigure);
        } else if (selectedFigureIsWhite(beatenFigurePosition)) {
            whiteBeatenFigures.addFigure(beatenFigure);
        }
    }


    private boolean selectedFigureIsBlack(ToCoordinateParser figurePos) {
        return new Board().getItemFromCoordinate(figurePos) instanceof BlackFigure;
    }

    private boolean selectedFigureIsWhite(ToCoordinateParser figurePos) {
        return new Board().getItemFromCoordinate(figurePos) instanceof WhiteFigure;
    }

    private ChessItem getFigure(ToCoordinateParser figurePos) {
        return new Board().getItemFromCoordinate(figurePos);
    }

    private boolean itBlackTurn() {
        return lastTurn.get(lastTurn.size() - 1) == 1;
    }

    private boolean itWhiteTurn() {
        return lastTurn.get(lastTurn.size() - 1) == 0;
    }

    private boolean isCheckForWhite(CheckForWhite checkForWhite) {
        return checkForWhite.getIsCheck() == 1;
    }

    private boolean isCheckForBlack(CheckForBlack checkForBlack) {
        return checkForBlack.getIsCheck() == 1;
    }

    private void saveTurn() throws IOException {
        ArrayList<ChessItem> tmp = new Board().getBoard();
        //try catch
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\posto\\Desktop\\temp\\save1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(tmp);
        objectOutputStream.close();
    }

    private void saveSecondTurn() throws IOException {
        ArrayList<ChessItem> tmp = new Board().getBoard();
        //try catch
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\posto\\Desktop\\temp\\save2.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(tmp);
        objectOutputStream.close();
    }

    private ArrayList<ChessItem> getPreviousTurnForWhite(int a) throws IOException, ClassNotFoundException {
        ArrayList<ChessItem> items = new ArrayList<>();
        String fileName = "save" + a + ".txt";
        //try catch
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\posto\\Desktop\\temp\\" + fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        items = (ArrayList<ChessItem>) objectInputStream.readObject();
        objectInputStream.close();
        return items;
    }

}
