package com.chess.board;

public interface ChessPiece {
  public void move(String destination, ChessPiece[][] board);
  public boolean validateMove(String destination, ChessPiece[][] board);
}
