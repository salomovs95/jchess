package com.chess.match;

import com.chess.board.ChessPiece;

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
}
