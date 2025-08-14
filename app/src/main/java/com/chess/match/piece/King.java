package com.chess.match.piece;

import java.util.HashSet;
import java.util.Set;

import com.chess.board.ChessPiece;
import com.chess.utils.ChessUtils;

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
    Set<String> possibleMoves = new HashSet<>();
    int[] positionVec = ChessUtils.mapPositionToBoardIndexes(getPosition());

    if (positionVec[1]-1 >= 0) {
      // TODO: Position Above
      BoardPiece piece = (BoardPiece) board[positionVec[1]-1][positionVec[0]];
      if (validatePiece(piece)) {
        int[] nextPositionVec = { positionVec[0], positionVec[1]-1 };
        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      }

      // TODO: Position Above-Left
      if (positionVec[0]-1 >= 0) {
        piece = (BoardPiece) board[positionVec[0]-1][positionVec[1]-1];
        if (validatePiece(piece)) {
          int[] nextPositionVec = { positionVec[0]-1, positionVec[1]-1 };
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        }
      }

      // TODO: Position Above-Right
      if (positionVec[0]+1 < 8) {
        piece = (BoardPiece) board[positionVec[0]+1][positionVec[1]-1];
          if (validatePiece(piece)) {
          int[] nextPositionVec = { positionVec[0]+1, positionVec[1]-1 };
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        }
      }
    }

    if (positionVec[1]+1 < 8) {
      // TODO: Piece Below
      BoardPiece piece = (BoardPiece) board[positionVec[1]+1][positionVec[0]];
      if (validatePiece(piece)) {
        int[] nextPositionVec = { positionVec[0], positionVec[1]+1};
        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      }

      // TODO: Piece At Bottom Left
      if (positionVec[0]-1 >= 0) {
        piece = (BoardPiece) board[positionVec[1]+1][positionVec[0]-1];
        if (validatePiece(piece)) {
          int[] nextPositionVec = { positionVec[0]-1, positionVec[1]+1};
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        }
      }

      // TODO: Piece At Bottom Right
      if (positionVec[0]+1 < 8) {
        piece = (BoardPiece) board[positionVec[1]+1][positionVec[0]+1];
        if (validatePiece(piece)) {
          int[] nextPositionVec = { positionVec[0]+1, positionVec[1]+1};
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        }
      }
    }

    // TODO: Piece At Left Side
    if (positionVec[0]-1 >= 0) {
      BoardPiece piece = (BoardPiece) board[positionVec[1]][positionVec[0]-1];
      if (validatePiece(piece)) {
        int[] nextPositionVec = { positionVec[0], positionVec[1]+1};
        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      }
    }

    // TODO: Piece At Right Side
    if (positionVec[0]+1 < 8) {
      BoardPiece piece = (BoardPiece) board[positionVec[1]][positionVec[0]+1];
      if (validatePiece(piece)) {
        int[] nextPositionVec = { positionVec[0], positionVec[1]+1 };
        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      }
    }

    return possibleMoves;
  }

  private boolean validatePiece(BoardPiece piece) {
    if (piece == null) return true;
    if (piece != null && !this.getColor().equals(piece.getColor())) return true;

    return false;
  }
}
