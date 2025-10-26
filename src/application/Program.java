package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.IO.print;
import static java.lang.IO.println;

public class Program {
    void main() {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while(!chessMatch.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                println();
                print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                println();
                print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                if (capturedPiece != null)
                    captured.add(capturedPiece);
                if (chessMatch.getPromoted() != null) {
                    print("Enter piece for promotion (B/N/R/Q): ");
                    String type = sc.nextLine();
                    chessMatch.replacePromotedPiece(type);
                }


            } catch (ChessException e) {
                println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}