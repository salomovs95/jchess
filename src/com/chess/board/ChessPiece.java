package com.chess.board;

import com.chess.board.constants.ChessConstants;

public abstract class ChessPiece {
  protected String role;
  protected String color;
  protected String position;

  public ChessPiece(String role, String color, String position) {
    this.color = color;
    this.role = role;
    this.position = position;
  }

  public String toString() {
    return String.format("%c", ChessConstants.PIECE_ROLES.get(role));
  }
}
