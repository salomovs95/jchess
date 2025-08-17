package com.chess.board;

import java.util.Set;

import com.chess.utils.ChessUtils;
import com.chess.constants.ChessConstants;

public interface ChessPiece {
  public Set<String> calculatePossibleMoves(ChessPiece[][] board);
  public String getColor();
  public String getPosition();
  public String getRole();
  public void setPosition(String position);

  default void move(String destination, ChessPiece[][] board) {
    int[] sPosition = ChessUtils.mapPositionToBoardIndexes(getPosition());
    int[] dPosition = ChessUtils.mapPositionToBoardIndexes(destination);

    setPosition(destination);

    board[dPosition[1]][dPosition[0]] = this;
    board[sPosition[1]][sPosition[0]] = null;
  }
}
