package com.chess.match.piece;

import java.util.HashSet;
import java.util.Set;

import com.chess.board.ChessPiece;
import com.chess.utils.ChessUtils;

public class Pawn extends BoardPiece {
  public Pawn(String color, String position) {
    super("PAWN", color, position);
  }

  @Override
  public void move(String destination, ChessPiece[][] board) {
    var possibleMoves = calculatePossibleMoves(board);
    System.out.println(possibleMoves);

    if(possibleMoves.contains(destination)) {
      super.move(destination, board);
    }
  }

  @Override
  public Set<String> calculatePossibleMoves(ChessPiece[][] board) {
    int[] positionVector = ChessUtils.mapPositionToBoardIndexes(position);

    int nextRow = color.equals("WHITE") ? positionVector[1]-1 : positionVector[1]+1;
    Set<String> possiblePositionsSet = new HashSet<>();

    String nextPosition = "";

    if (positionVector[0]-1 > 0 && board[nextRow][positionVector[0]-1] != null) {
      int[] nextPositionIndexes = { positionVector[0]-1, nextRow };
      nextPosition = ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionIndexes);
      possiblePositionsSet.add(nextPosition);
    }

    if (positionVector[0]+1 < 8 && board[nextRow][positionVector[0]+1] != null) {
      int[] nextPositionIndexes = { positionVector[0]+1, nextRow };
      nextPosition = ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionIndexes);
      possiblePositionsSet.add(nextPosition);
    }

    if (board[nextRow][positionVector[0]] == null) {
      int[] nextPositionIndexes = { positionVector[0], nextRow };
      nextPosition = ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionIndexes);
      possiblePositionsSet.add(nextPosition);
    }

    if (ChessConstants.INIT_POSITIONS.get(color + "_" + role).contains(position)) {
      nextRow = color.equals("WHITE") ? positionVector[1]-2 : positionVector[1]+2;
      if (board[nextRow][positionVector[0]] == null) {
        int[] nextPositionIndexes = { positionVector[0], nextRow };
        nextPosition = ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionIndexes);
        possiblePositionsSet.add(nextPosition);
      }
    }

    return possiblePositionsSet;
  }
}
