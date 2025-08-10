package com.chess.match.piece;

import java.util.HashSet;
import java.util.Set;

import com.chess.board.ChessPiece;
import com.chess.utils.ChessUtils;

public class Bishop extends BoardPiece {
  public Bishop(String color, String position) {
    super("BISHOP", color, position);
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
    Set<String> possibleMoves = new HashSet<>();
    int[] positionVec = ChessUtils.mapPositionToBoardIndexes(getPosition());

    while(true) {
      if (positionVec[0]<0 || positionVec[1]<0) break;

      if(ChessUtils.mapPositionIndexesToBoardPlaces(positionVec).equals(getPosition())) {
        positionVec[0] = positionVec[0]-1;
        positionVec[1] = positionVec[1]-1;
        continue;
      }

      BoardPiece piece = (BoardPiece) board[positionVec[1]][positionVec[0]];
      if (!checkPiece(piece)) break;

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(positionVec));

      positionVec[0] = positionVec[0]-1;
      positionVec[1] = positionVec[1]-1;
    }

    positionVec = ChessUtils.mapPositionToBoardIndexes(getPosition());
    while(true) {
      if (positionVec[0]>=8 || positionVec[1]>=8) break;

      if(ChessUtils.mapPositionIndexesToBoardPlaces(positionVec).equals(getPosition())) {
        positionVec[0] = positionVec[0]+1;
        positionVec[1] = positionVec[1]+1;
        continue;
      }

      BoardPiece piece = (BoardPiece) board[positionVec[1]][positionVec[0]];
      if (!checkPiece(piece)) break;

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(positionVec));

      positionVec[0] = positionVec[0]+1;
      positionVec[1] = positionVec[1]+1;
    }

    positionVec = ChessUtils.mapPositionToBoardIndexes(getPosition());
    while(true) {
      if (positionVec[0]<0 || positionVec[1]>=8) break;

      if (ChessUtils.mapPositionIndexesToBoardPlaces(positionVec).equals(getPosition())) {
        positionVec[0] = positionVec[0]-1;
        positionVec[1] = positionVec[1]+1;
        continue;
      }

      BoardPiece piece = (BoardPiece) board[positionVec[1]][positionVec[0]];
      if (!checkPiece(piece)) break;

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(positionVec));

      positionVec[0] = positionVec[0]-1;
      positionVec[1] = positionVec[1]+1;
    }

    positionVec = ChessUtils.mapPositionToBoardIndexes(getPosition());
    while(true) {
      if (positionVec[0]>=8 || positionVec[1]<0) break;

      if (ChessUtils.mapPositionIndexesToBoardPlaces(positionVec).equals(getPosition())) {
        positionVec[0] = positionVec[0]+1;
        positionVec[1] = positionVec[1]-1;
        continue;
      }

      BoardPiece piece = (BoardPiece) board[positionVec[1]][positionVec[0]];
      if (!checkPiece(piece)) break;

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(positionVec));

      positionVec[0] = positionVec[0]+1;
      positionVec[1] = positionVec[1]-1;
    }

    return possibleMoves;
  }

  private boolean checkPiece(BoardPiece piece) {
    if (piece == null) return true;
    return !getColor().equals(piece.getColor());
  }
}
