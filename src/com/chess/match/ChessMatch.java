package com.chess.match;

import java.util.Scanner;
import com.chess.board.ChessBoard;

public class ChessMatch {
  private String currentPlayer = "WHITE";
  private ChessBoard board;

  public ChessMatch() {
    board = new MatchBoard();
  }

  public void startMatch() {
    board.drawBoard();
    boolean quit = false;
    while(!quit) {
      Scanner scan = null;

      try {
        scan = new Scanner(System.in);
        System.out.println("Current player: " + currentPlayer);

        System.out.print("Piece to move: ");
        String source = scan.nextLine();

        System.out.print("Where to move piece: ");
        String destination = scan.nextLine();

        board.movePiece(currentPlayer, source, destination);
        currentPlayer = currentPlayer.equals("WHITE") ? "BLACK" : "WHITE";
      } catch (Exception e) {
        System.out.println("Invalid movement! Current player: " + currentPlayer + ". Player tried to move invalid piece.");
        if (scan != null) {
          System.out.print("Quit? (y/N) ");
          quit = scan.nextLine().toUpperCase().equals("Y");
          scan.close();
        }
      }
    }
  }
}
