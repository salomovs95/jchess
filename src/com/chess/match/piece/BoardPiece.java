package com.chess.match.piece;

import com.chess.board.ChessPiece;
import com.chess.board.constants.ChessConstants;

public class BoardPiece implements ChessPiece {
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
    int[] sPosition = ChessConstants.mapPositionToBoardIndexes(position);
    int[] dPosition = ChessConstants.mapPositionToBoardIndexes(destination);

    position = destination;

    board[dPosition[1]][dPosition[0]] = this;
    board[sPosition[1]][sPosition[0]] = null;
  }

  public void validateMove(String destination) {}

  public String toString() {
    return String.format("%c", ChessConstants.PIECE_ROLES.get(role));
  }
}
