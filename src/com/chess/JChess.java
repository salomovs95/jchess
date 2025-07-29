package com.chess;

import com.chess.match.ChessMatch;

public class JChess{
  public static void main(String[] args) {
    try {
      ChessMatch match = new ChessMatch();
      match.startMatch();
    } catch (Exception e) {
      System.out.println("EXCEPTION: " + e.getLocalizedMessage());
    }
  }
}
