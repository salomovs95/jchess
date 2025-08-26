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
public class Rook implements ChessPiece {
  private final String role = "ROOK";
  private String color;
  private String position;

  @Override
  public void move(String destination, ChessPiece[][] board) {
    var possibleMoves = calculatePossibleMoves(board);

    if (possibleMoves.contains(destination)) {
      ChessPiece.super.move(destination, board);
    }
  }

  @Override
  public Set<String> calculatePossibleMoves(ChessPiece[][] board) {
    int[] positionVector = ChessUtils.mapPositionToBoardIndexes(position);
    Set<String> availablePositions = new HashSet<>();

    for (int index=positionVector[1]; index>0; index--) {
      if (index==positionVector[1]) continue;

      ChessPiece piece = board[index][positionVector[0]];

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

      ChessPiece piece = board[index][positionVector[0]];

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

      ChessPiece piece = board[positionVector[1]][index];

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

      ChessPiece piece = board[positionVector[1]][index];

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
