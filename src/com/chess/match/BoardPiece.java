package com.chess.match;

import com.chess.board.ChessPiece;
import com.chess.board.constants.ChessConstants;

public class BoardPiece extends ChessPiece {
  public BoardPiece(String role, String color, String position) {
    super(role, color, position);
  }

  public String getColor() {
    return this.color;
  }

  public String getRole() {
    return this.role;
  }

  public String getPosition() {
    return this.position;
  }

  public void move(String destination, ChessPiece[][] board) {
    int[] sPosition = ChessConstants.mapPositionToBoardIndexes(position);
    int[] dPosition = ChessConstants.mapPositionToBoardIndexes(destination);

    position = destination;
    board[dPosition[1]][dPosition[0]] = this;
    board[sPosition[1]][sPosition[0]] = null;
  }

  // public void setPosition(String position) {
  //   this.position = destination;
  // }
}
