package com.chess.match.piece;

import java.util.HashSet;
import java.util.Set;

import com.chess.board.ChessPiece;
import com.chess.utils.ChessUtils;

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
    int[] positionVec = ChessUtils.mapPositionToBoardIndexes(getPosition());
    Set<String> possibleMoves = new HashSet<>();

    if (positionVec[1]-2 >= 0) {
      if (positionVec[0]-1 >= 0) {
        int[] destPositionVec = { positionVec[0]-1,positionVec[1]-2 };
        BoardPiece piece = (BoardPiece) board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }

      if (positionVec[0]+1 < 8) {
        int[] destPositionVec = { positionVec[0]+1,positionVec[1]-2 };
        BoardPiece piece = (BoardPiece) board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }
    }

    if (positionVec[1]+2 < 8) {
      if (positionVec[0]-1 >= 0) {
        int[] destPositionVec = { positionVec[0]-1, positionVec[1]+2 };
        BoardPiece piece = (BoardPiece) board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }

      if (positionVec[0]+1 < 8) {
        int[] destPositionVec = { positionVec[0]+1,positionVec[1]+2 };
        BoardPiece piece = (BoardPiece) board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }
    }

    if (positionVec[0]-2 >= 0) {
      if (positionVec[1]-1 >= 0) {
        int[] destPositionVec = { positionVec[0]-2,positionVec[1]-1 };
        BoardPiece piece = (BoardPiece) board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }

      if (positionVec[1]+1 < 8) {
        int[] destPositionVec = { positionVec[0]-2,positionVec[1]+1 };
        BoardPiece piece = (BoardPiece) board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }
    }

    if (positionVec[0]+2 < 8 ) {
      if (positionVec[1]-1 >= 0) {
        int[] destPositionVec = { positionVec[0]+2,positionVec[1]-1 };
        BoardPiece piece = (BoardPiece) board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }

      if (positionVec[1]+1 < 8) {
        int[] destPositionVec = { positionVec[0]+2,positionVec[1]+1 };
        BoardPiece piece = (BoardPiece) board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }
    }

    return possibleMoves;
  }
}
