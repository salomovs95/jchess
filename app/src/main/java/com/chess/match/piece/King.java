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
public class King implements ChessPiece {
  private final String role = "KING";
  private String color;
  private String position;

  @Override
  public void move(String destination, ChessPiece[][] board) {
    Set<String> possibleMoves = calculatePossibleMoves(board);

    if (possibleMoves.contains(destination)) {
      ChessPiece.super.move(destination, board);
    }
  }

  @Override
  public Set<String> calculatePossibleMoves(ChessPiece[][] board) {
    Set<String> possibleMoves = new HashSet<>();
    int[] positionVec = ChessUtils.mapPositionToBoardIndexes(getPosition());

    if (positionVec[1]-1 >= 0) {
      // TODO: Position Above
      ChessPiece piece = board[positionVec[1]-1][positionVec[0]];
      if (validatePiece(piece)) {
        int[] nextPositionVec = { positionVec[0], positionVec[1]-1 };
        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      }

      // TODO: Position Above-Left
      if (positionVec[0]-1 >= 0) {
        piece = board[positionVec[0]-1][positionVec[1]-1];
        if (validatePiece(piece)) {
          int[] nextPositionVec = { positionVec[0]-1, positionVec[1]-1 };
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        }
      }

      // TODO: Position Above-Right
      if (positionVec[0]+1 < 8) {
        piece = board[positionVec[0]+1][positionVec[1]-1];
          if (validatePiece(piece)) {
          int[] nextPositionVec = { positionVec[0]+1, positionVec[1]-1 };
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        }
      }
    }

    if (positionVec[1]+1 < 8) {
      // TODO: Piece Below
      ChessPiece piece = board[positionVec[1]+1][positionVec[0]];
      if (validatePiece(piece)) {
        int[] nextPositionVec = { positionVec[0], positionVec[1]+1};
        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      }

      // TODO: Piece At Bottom Left
      if (positionVec[0]-1 >= 0) {
        piece = board[positionVec[1]+1][positionVec[0]-1];
        if (validatePiece(piece)) {
          int[] nextPositionVec = { positionVec[0]-1, positionVec[1]+1};
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        }
      }

      // TODO: Piece At Bottom Right
      if (positionVec[0]+1 < 8) {
        piece = board[positionVec[1]+1][positionVec[0]+1];
        if (validatePiece(piece)) {
          int[] nextPositionVec = { positionVec[0]+1, positionVec[1]+1};
          possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
        }
      }
    }

    // TODO: Piece At Left Side
    if (positionVec[0]-1 >= 0) {
      ChessPiece piece = board[positionVec[1]][positionVec[0]-1];
      if (validatePiece(piece)) {
        int[] nextPositionVec = { positionVec[0], positionVec[1]+1};
        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      }
    }

    // TODO: Piece At Right Side
    if (positionVec[0]+1 < 8) {
      ChessPiece piece = board[positionVec[1]][positionVec[0]+1];
      if (validatePiece(piece)) {
        int[] nextPositionVec = { positionVec[0], positionVec[1]+1 };
        possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionVec));
      }
    }

    return possibleMoves;
  }

  private boolean validatePiece(ChessPiece piece) {
    if (piece == null) return true;
    if (piece != null && !this.getColor().equals(piece.getColor())) return true;

    return false;
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
