package com.chess.board;

public interface ChessPiece {
  public void move(String destination, ChessPiece[][] board);
  public void validateMove(String destination);
}
