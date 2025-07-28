package com.chess;

import com.chess.board.ChessBoard;
import com.chess.match.MatchBoard;

public class JChess{
  public static void main(String[] args) {
    ChessBoard board = new MatchBoard();
    board.drawBoard();
  }
}
