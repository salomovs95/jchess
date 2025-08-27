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
public class Pawn implements ChessPiece {
  private final String role = "PAWN";
  private String color;
  private String position;

  @Override
  public void move(String destination, ChessPiece[][] board) {
    var possibleMoves = calculatePossibleMoves(getPosition(), board);

    if(possibleMoves.contains(destination)) {
      ChessPiece.super.move(destination, board);
    }
  }

  @Override
  public Set<String> calculatePossibleMoves(String position, ChessPiece[][] board) {
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

      if ((nextRow >= 0 || nextRow < 8) && board[nextRow][positionVector[0]] == null) {
        int[] nextPositionIndexes = { positionVector[0], nextRow };
        nextPosition = ChessUtils.mapPositionIndexesToBoardPlaces(nextPositionIndexes);
        possiblePositionsSet.add(nextPosition);
      }
    }

    return possiblePositionsSet;
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
