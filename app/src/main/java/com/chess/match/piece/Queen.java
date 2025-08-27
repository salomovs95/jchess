package com.chess.match.piece;

import java.util.HashSet;
import java.util.Set;

import com.chess.board.ChessPiece;
import com.chess.constants.ChessConstants;
import com.chess.utils.ChessUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Queen implements ChessPiece {
  private final String role = "QUEEN";
  private String color;
  private String position;

  @Override
  public void move(String destination, ChessPiece[][] board) {
    Set<String> possibleMoves = calculatePossibleMoves(getPosition(), board);

    if (possibleMoves.contains(destination)) {
      ChessPiece.super.move(destination, board);
    }
  }

  @Override
  public Set<String> calculatePossibleMoves(String position, ChessPiece[][] board) {
    Set<String> possibleMoves = new HashSet<>();
    int[] positionVec = ChessUtils.mapPositionToBoardIndexes(position);

    // Iterate vertically up
    int[] nextPositionVec = { positionVec[0], positionVec[1]-1 };
    while(true) {
      if (nextPositionVec[1] < 0) break;

      ChessPiece piece = board[nextPositionVec[1]][nextPositionVec[0]];
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

      ChessPiece piece = board[nextPositionVec[1]][nextPositionVec[0]];
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

      ChessPiece piece = board[nextPositionVec[1]][nextPositionVec[0]];
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

      ChessPiece piece = board[nextPositionVec[1]][nextPositionVec[0]];
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

      ChessPiece piece = board[nextPositionVec[1]][nextPositionVec[0]];
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

      ChessPiece piece = board[nextPositionVec[1]][nextPositionVec[0]];
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

      ChessPiece piece = board[nextPositionVec[1]][nextPositionVec[0]];
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

      ChessPiece piece = board[nextPositionVec[1]][nextPositionVec[0]];
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

  @Override
  public String toString() {
    String textColor = String.format("TXT_COLOR_%s", getColor());

    return String.format(
      "%s%c",
      ChessConstants.BOARD_COLORS.get(textColor),
      ChessConstants.PIECE_ROLES.get(getRole())
    );
  } 
}
