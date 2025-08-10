package com.chess.match.piece;

import java.util.Set;

import com.chess.board.ChessPiece;

public class Knight extends BoardPiece {
  public Knight(String color, String position) {
    super("KNIGHT", color, position);
  }

  @Override
  public void move(String destination, ChessPiece[][] board) {
    var possibleMoves = calculatePossibleMoves(board);
    System.out.println(possibleMoves);

    if (possibleMoves.contains(destination)) {
      super.move(destination, board);
    }   
  }

  @Override
  public Set<String> calculatePossibleMoves(ChessPiece[][] board) {
    return Set.of();
  }
}
