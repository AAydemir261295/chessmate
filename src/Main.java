import ChessItems.Items.Board;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Engine engine = new Engine();
        if(engine.startTheGame() == 1){
            System.out.println("Игра окончена");
        }
    }
}
