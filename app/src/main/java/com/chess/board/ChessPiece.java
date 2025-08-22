package com.chess.board;

import java.util.Set;

import com.chess.utils.ChessUtils;
import com.chess.match.piece.*;
import com.chess.constants.ChessConstants;

public interface ChessPiece {
  Set<String> calculatePossibleMoves(ChessPiece[][] board);
  String getColor();
  String getPosition();
  String getRole();
  void setPosition(String position);

  default void move(String destination, ChessPiece[][] board) {
    int[] sPosition = ChessUtils.mapPositionToBoardIndexes(getPosition());
    int[] dPosition = ChessUtils.mapPositionToBoardIndexes(destination);

    setPosition(destination);

    board[dPosition[1]][dPosition[0]] = this;
    board[sPosition[1]][sPosition[0]] = null;
  }

  static ChessPiece createPiece(String role, String color, String position) {
    ChessPiece piece = null;

    switch (role) {
      case "BISHOP":
        piece = new Bishop(color, position);
        break;
      case "HOOK":
        piece = new Rook(color, position);
        break;
      case "KING":
        piece = new King(color, position);
        break;
      case "KNIGHT":
        piece = new Knight(color, position);
        break;
      case "QUEEN":
        piece = new Queen(color, position);
        break;
      case "PAWN":
      default:
        piece = new Pawn(color, position);
        break;
    }

    return piece;
  }
}
