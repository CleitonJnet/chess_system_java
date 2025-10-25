package application;

import boardgame.Board;
import chess.ChessMatch;

public class Program {
    void main() {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}