package com.chess.board;

public abstract class ChessPiece {
  protected String role;
  protected String color;
  protected String position;

  public ChessPiece(String role, String color, String position) {
    this.color = color;
    this.role = role;
    this.position = position;
  }
}
