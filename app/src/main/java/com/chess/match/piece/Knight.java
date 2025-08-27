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
public class Knight implements ChessPiece {
  private final String role = "KNIGHT";
  private String color;
  private String position;

  @Override
  public void move(String destination, ChessPiece[][] board) {
    var possibleMoves = calculatePossibleMoves(getPosition(), board);

    if (possibleMoves.contains(destination)) {
      ChessPiece.super.move(destination, board);
    }   
  }

  @Override
  public Set<String> calculatePossibleMoves(String position, ChessPiece[][] board) {
    int[] positionVec = ChessUtils.mapPositionToBoardIndexes(position);
    Set<String> possibleMoves = new HashSet<>();

    if (positionVec[1]-2 >= 0) {
      if (positionVec[0]-1 >= 0) {
        int[] destPositionVec = { positionVec[0]-1,positionVec[1]-2 };
        ChessPiece piece = board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }

      if (positionVec[0]+1 < 8) {
        int[] destPositionVec = { positionVec[0]+1,positionVec[1]-2 };
        ChessPiece piece = board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }
    }

    if (positionVec[1]+2 < 8) {
      if (positionVec[0]-1 >= 0) {
        int[] destPositionVec = { positionVec[0]-1, positionVec[1]+2 };
        ChessPiece piece = board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }

      if (positionVec[0]+1 < 8) {
        int[] destPositionVec = { positionVec[0]+1,positionVec[1]+2 };
        ChessPiece piece = board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }
    }

    if (positionVec[0]-2 >= 0) {
      if (positionVec[1]-1 >= 0) {
        int[] destPositionVec = { positionVec[0]-2,positionVec[1]-1 };
        ChessPiece piece = board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }

      if (positionVec[1]+1 < 8) {
        int[] destPositionVec = { positionVec[0]-2,positionVec[1]+1 };
        ChessPiece piece = board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }
    }

    if (positionVec[0]+2 < 8 ) {
      if (positionVec[1]-1 >= 0) {
        int[] destPositionVec = { positionVec[0]+2,positionVec[1]-1 };
        ChessPiece piece = board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }

      if (positionVec[1]+1 < 8) {
        int[] destPositionVec = { positionVec[0]+2,positionVec[1]+1 };
        ChessPiece piece = board[destPositionVec[1]][destPositionVec[0]];

        if (piece == null || (piece != null && !getColor().equals(piece.getColor()))) {
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(destPositionVec));
        }
      }
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
