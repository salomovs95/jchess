package com.chess.match.piece;

import java.util.Set;

import com.chess.board.ChessPiece;

public class King extends BoardPiece {
  public King(String color, String position) {
    super("KING", color, position);
  }

  @Override
  public void move(String destination, ChessPiece[][] board) {
    Set<String> possibleMoves = calculatePossibleMoves(board);
    System.out.println(possibleMoves);

    if (possibleMoves.contains(destination)) {
      super.move(destination, board);
    }
  }

  @Override
  public Set<String> calculatePossibleMoves(ChessPiece[][] board) {
    // TODO Auto-generated method stub
    return Set.of();
  }
}
