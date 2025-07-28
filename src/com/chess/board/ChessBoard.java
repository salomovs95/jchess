package com.chess.board;

public abstract class ChessBoard {
  ChessPiece[][] boardPieces;

  public ChessBoard() {
    boardPieces = new ChessPiece[8][8];
  }

  public void drawBoard() {}

  public ChessPiece[][] getBoard() {
    return boardPieces;
  }
}
