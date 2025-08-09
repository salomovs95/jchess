package com.chess.match.piece;

import java.util.Set;

import com.chess.board.ChessPiece;

public class Bishop extends BoardPiece {
  public Bishop(String color, String position) {
    super("BISHOP", color, position);
  }

  @Override
  public void move(String destination, ChessPiece[][] board) {
    var possibleMoves = calculatePossibleMoves(board);
    if (possibleMoves.contains(destination)) {
      super.move(destination, board);
    }
  }

  @Override
  public Set<String> calculatePossibleMoves(ChessPiece[][] board) {
    // TODO: iterate over each possible position in diagonal
    return Set.of();
  }
}
