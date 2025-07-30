package com.chess.match.piece;

import com.chess.board.ChessPiece;
import com.chess.utils.ChessUtils;

public class Pawn extends BoardPiece {
  public Pawn(String color, String position) {
    super("PAWN", color, position);
  }

  @Override
  public void move(String destination, ChessPiece[][] board) {
    if (this.validateMove(destination, board)) {
      super.move(destination, board);
    }
  }

  @Override
  public boolean validateMove(String destination, ChessPiece[][] board) {
    int[] destinationVector = ChessUtils.mapPositionToBoardIndexes(destination);
    int[] positionVector = ChessUtils.mapPositionToBoardIndexes(position);

    int nextRow = color.equals("WHITE") ? positionVector[1]-1 : positionVector[1]+1;

    if ((destinationVector[0] == positionVector[0]+1 && destinationVector[1] == nextRow) && board[destinationVector[1]][destinationVector[0]] != null) return true;
    if ((destinationVector[0] == positionVector[0]+1 && destinationVector[1] == nextRow) && board[destinationVector[1]][destinationVector[0]] != null) return true;
    if ((destinationVector[0] == positionVector[0] && destinationVector[1] == nextRow) && board[destinationVector[1]][destinationVector[0]] == null) return true;

    return false;
  }
}
