package com.chess.match.piece;

import java.util.HashSet;
import java.util.Set;

import com.chess.board.ChessPiece;
import com.chess.utils.ChessUtils;

public class Queen extends BoardPiece {
  public Queen(String color, String position) {
    super("QUEEN", color, position);
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

    // Iterate vertically up
    int[] nextPositionVec = { positionVec[0], positionVec[1]-1 };
    while(true) {
      if (nextPositionVec[1] < 0) break;

      BoardPiece piece = (BoardPiece) board[nextPositionVec[1]][nextPositionVec[0]];
      if (piece != null) {
        if (this.getColor().equals(piece.getColor())) break;

        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        break;
      }

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      nextPositionVec[1] = nextPositionVec[1]-1;
    }

    // Iterate vertically down
    nextPositionVec[1] = positionVec[1]+1;
    while(true) {
      if (nextPositionVec[1] >= 8) break;

      BoardPiece piece = (BoardPiece) board[nextPositionVec[1]][nextPositionVec[0]];
      if (piece != null) {
        if (this.getColor().equals(piece.getColor())) break;

        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        break;
      }

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      nextPositionVec[1] = nextPositionVec[1]+1;
    }

    // Iterate horizontally left
    nextPositionVec[0] = positionVec[0]-1;
    nextPositionVec[1] = positionVec[1];
    while(true) {
      if (nextPositionVec[0] < 0) break;

      BoardPiece piece = (BoardPiece) board[nextPositionVec[1]][nextPositionVec[0]];
      if(piece != null) {
        if (this.getColor().equals(piece.getColor())) break;

        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        break;
      }

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      nextPositionVec[0] = nextPositionVec[0]-1;
    }

    // Iterate horizontally right
    nextPositionVec[0] = positionVec[0]+1;
    while(true) {
      if (nextPositionVec[0] >= 8) break;

      BoardPiece piece = (BoardPiece) board[nextPositionVec[1]][nextPositionVec[0]];
      if (piece != null) {
        if (this.getColor().equals(piece.getColor())) break;
 
        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        break;
      }

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      nextPositionVec[0] = nextPositionVec[0]+1;
    }

    // Iterate diagonally up left
    nextPositionVec[0] = positionVec[0]-1;
    nextPositionVec[1] = positionVec[1]-1;
    while(true) {
      if (nextPositionVec[0] < 0 || nextPositionVec[1] < 0) break;

      BoardPiece piece = (BoardPiece) board[nextPositionVec[1]][nextPositionVec[0]];
      if (piece != null) {
        if (this.getColor().equals(piece.getColor())) break;

        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        break;
      }

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      nextPositionVec[0] = nextPositionVec[0]-1;
      nextPositionVec[1] = nextPositionVec[1]-1;
    }

    // Iterate diagonally up right
    nextPositionVec[0] = positionVec[0]+1;
    nextPositionVec[1] = positionVec[1]-1;
    while(true) {
      if (nextPositionVec[1] < 0 || nextPositionVec[0] >= 8) break;

      BoardPiece piece = (BoardPiece) board[nextPositionVec[1]][nextPositionVec[0]];
      if (piece != null) {
        if (this.getColor().equals(piece.getColor())) break;

        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        break;
      }

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      nextPositionVec[0] = nextPositionVec[0]+1;
      nextPositionVec[1] = nextPositionVec[1]-1;
    }

    // Iterate diagonally down left
    nextPositionVec[0] = positionVec[0]-1;
    nextPositionVec[1] = positionVec[1]+1;
    while(true) {
      if (nextPositionVec[0] < 0 || nextPositionVec[1] >= 8) break;

      BoardPiece piece = (BoardPiece) board[nextPositionVec[1]][nextPositionVec[0]];
      if (piece != null) {
        if (this.getColor().equals(piece.getColor())) break;

        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        break;
      }

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      nextPositionVec[0] = nextPositionVec[0]-1;
      nextPositionVec[1] = nextPositionVec[1]+1;
    }

    // Iterate diagonally down right
    nextPositionVec[0] = positionVec[0]+1;
    nextPositionVec[1] = positionVec[1]+1;
    while(true) {
      if (nextPositionVec[0] >= 8 || nextPositionVec[1] >= 8) break;

      BoardPiece piece = (BoardPiece) board[nextPositionVec[1]][nextPositionVec[0]];
      if (piece != null) {
        if (this.getColor().equals(piece.getColor())) break;

        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        break;
      }

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      nextPositionVec[0] = nextPositionVec[0]+1;
      nextPositionVec[1] = nextPositionVec[1]+1;
    }

    return possibleMoves;
  }
}
