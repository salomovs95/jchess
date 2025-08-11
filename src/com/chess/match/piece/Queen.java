package com.chess.match.piece;

import java.util.Set;

import com.chess.board.ChessPiece;

public class Queen extends BoardPiece {
  public Queen(String color, String position) {
    super("QUEEN", color, position);
  }

  @Override
  public void move(String destination, ChessPiece[][] board) {
    Set<String> possibleMoves = calculatePossibleMoves(board);
    if (possibleMoves.contains(destination)) {
      super.move(destination, board);
    }
  }

  @Override
  public Set<String> calculatePossibleMoves(ChessPiece[][] board) {
    return Set.of();
  }
}
