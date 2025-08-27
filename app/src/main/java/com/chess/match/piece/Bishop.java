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
public class Bishop implements ChessPiece {
  private final String role = "BISHOP";
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
    Set<String> possibleMoves = new HashSet<>();
    int[] positionVec = ChessUtils.mapPositionToBoardIndexes(position);

    while(true) {
      if (positionVec[0]<0 || positionVec[1]<0) break;

      if(ChessUtils.mapPositionIndexesToBoardPlaces(positionVec).equals(getPosition())) {
        positionVec[0] = positionVec[0]-1;
        positionVec[1] = positionVec[1]-1;
        continue;
      }

      ChessPiece piece = board[positionVec[1]][positionVec[0]];
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

      ChessPiece piece = board[positionVec[1]][positionVec[0]];
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

      ChessPiece piece = board[positionVec[1]][positionVec[0]];
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

      ChessPiece piece = board[positionVec[1]][positionVec[0]];
      if (!checkPiece(piece)) break;

      possibleMoves.add(ChessUtils.mapPositionIndexesToBoardPlaces(positionVec));

      positionVec[0] = positionVec[0]+1;
      positionVec[1] = positionVec[1]-1;
    }

    return possibleMoves;
  }

  private boolean checkPiece(ChessPiece piece) {
    if (piece == null) return true;
    return !getColor().equals(piece.getColor());
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
