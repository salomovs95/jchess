package com.chess.match.piece;

import java.util.HashSet;
import java.util.Set;

import com.chess.board.ChessPiece;
import com.chess.utils.ChessUtils;

public class Rook extends BoardPiece {
  public Rook(String color, String position) {
    super("ROOK", color, position);
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
    int[] positionVector = ChessUtils.mapPositionToBoardIndexes(position);
    Set<String> availablePositions = new HashSet<>();

    for (int index=positionVector[1]; index>0; index--) {
      if (index==positionVector[1]) continue;

      BoardPiece piece = (BoardPiece) board[index][positionVector[0]];

      if (piece != null) {
        if (piece.getColor().equals(this.getColor())) break;

        int[] posiVec = { positionVector[0], index };
        availablePositions.add(ChessUtils.mapPositionIndexesToBoardPlaces(posiVec));
        break;
      }

      int[] posiVec = { positionVector[0], index };
      availablePositions.add(ChessUtils.mapPositionIndexesToBoardPlaces(posiVec));
      continue;
    }

    for (int index=positionVector[1]; index<8; index++) {
      if (index==positionVector[1]) continue;

      BoardPiece piece = (BoardPiece) board[index][positionVector[0]];

      if (piece != null) {
        if (piece.getColor().equals(this.getColor())) break;

        int[] posiVec = { positionVector[0], index };
        availablePositions.add(ChessUtils.mapPositionIndexesToBoardPlaces(posiVec));
        break;
      }

      int[] posiVec = { positionVector[0], index };
      availablePositions.add(ChessUtils.mapPositionIndexesToBoardPlaces(posiVec));
      continue;
    }

    for (int index=positionVector[0]; index>0; index--) {
      if (index==positionVector[0]) continue;

      BoardPiece piece = (BoardPiece) board[positionVector[1]][index];

      if (piece != null) {
        if (piece.getColor().equals(this.getColor())) break;

        int[] posiVec = { index, positionVector[1] };
        availablePositions.add(ChessUtils.mapPositionIndexesToBoardPlaces(posiVec));
        break;
      }

      int[] posiVec = { index, positionVector[1] };
      availablePositions.add(ChessUtils.mapPositionIndexesToBoardPlaces(posiVec));
      continue;
    }

    for (int index=positionVector[0]; index<8; index++) {
      if (index==positionVector[0]) continue;

      BoardPiece piece = (BoardPiece) board[positionVector[1]][index];

      if (piece != null) {
        if (piece.getColor().equals(this.getColor())) break;

        int[] posiVec = { index, positionVector[1] };
        availablePositions.add(ChessUtils.mapPositionIndexesToBoardPlaces(posiVec));
        break;
      }

      int[] posiVec = { index, positionVector[1] };
      availablePositions.add(ChessUtils.mapPositionIndexesToBoardPlaces(posiVec));
      continue;
    }

    return availablePositions;
  }
}
