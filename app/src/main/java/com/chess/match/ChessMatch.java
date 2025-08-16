package com.chess.match;

import java.util.Scanner;
import com.chess.board.ChessBoard;

public class ChessMatch {
  private ChessBoard board;

  public ChessMatch() {
    board = new MatchBoard();
  }

  public void startMatch() {
    board.drawBoard();

    Scanner scan = null;
    boolean quit = false;

    while(!quit) {
      try {
        scan = new Scanner(System.in);
        System.out.print("Piece to move: ");
        String source = scan.nextLine().toUpperCase();

        System.out.print("Where to move piece: ");
        String destination = scan.nextLine().toUpperCase();

        board.movePiece(source, destination);
      } catch (Exception e) {
        System.out.println("EXCEPTION: " + e.getLocalizedMessage());

        if (scan != null) {
          System.out.print("Quit? (y/N) ");
          quit = scan.nextLine().toUpperCase().equals("Y");
          scan.close();
        }
      }
    }
  }
}
