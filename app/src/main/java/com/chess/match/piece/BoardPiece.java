package com.chess.match.piece;

import com.chess.board.ChessPiece;
import com.chess.constants.ChessConstants;
import com.chess.utils.ChessUtils;

public abstract class BoardPiece implements ChessPiece {
  protected String role;
  protected String color;
  protected String position;

  public BoardPiece(String role, String color, String position) {
    this.role = role;
    this.color = color;
    this.position = position;
  }

  public String getColor() { return this.color; }
  public String getRole() { return this.role; }
  public String getPosition() { return this.position; }

  public void move(String destination, ChessPiece[][] board) {
    int[] sPosition = ChessUtils.mapPositionToBoardIndexes(position);
    int[] dPosition = ChessUtils.mapPositionToBoardIndexes(destination);

    position = destination;

    board[dPosition[1]][dPosition[0]] = this;
    board[sPosition[1]][sPosition[0]] = null;
  }

  public String toString() {
    String color = ChessConstants.BOARD_COLORS.get(String.format("TXT_COLOR_%s", getColor()));
    return String.format(
      "%s%c",
      color,
      ChessConstants.PIECE_ROLES.get(role)
    );
  }
}
