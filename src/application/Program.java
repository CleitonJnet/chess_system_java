package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

import static java.lang.IO.print;
import static java.lang.IO.println;

public class Program {
    void main() {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while(true) {
            UI.printBoard(chessMatch.getPieces());
            println();
            print("Source: ");
            ChessPosition source = UI.readChessPosition(sc);

            println();
            print("Target: ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

        }
    }
}