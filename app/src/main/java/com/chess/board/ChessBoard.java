package com.chess.board;

public interface ChessBoard {
  void drawBoard();
  void movePiece(String source, String destination);
  void updateBoard();
}
