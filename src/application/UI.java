package application;

import chess.ChessPiece;

import static java.lang.IO.print;
import static java.lang.IO.println;

public class UI {
    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j]);
            }
            println();
        }
        println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            print("-");
        }else {
            print(piece);
        }
        print(" ");
    }
}
