package com.chess.board;

public abstract class ChessBoard {
  private ChessPiece[][] boardPieces;

  public ChessBoard() {
    boardPieces = new ChessPiece[8][8];
  }

  public void drawBoard() {}
  public void movePiece(String source, String destination) {}

  public ChessPiece[][] getBoard() {
    return boardPieces;
  }
}
