package com.chess.board;

import java.util.Set;

public interface ChessPiece {
  public void move(String destination, ChessPiece[][] board);
  public Set<String> calculatePossibleMoves(ChessPiece[][] board);
}
