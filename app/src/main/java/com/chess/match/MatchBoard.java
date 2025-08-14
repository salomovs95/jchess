package com.chess.match;

import com.chess.board.ChessBoard;
import com.chess.board.ChessPiece;
import com.chess.match.piece.Bishop;
import com.chess.match.piece.BoardPiece;
import com.chess.match.piece.King;
import com.chess.match.piece.Knight;
import com.chess.match.piece.Pawn;
import com.chess.match.piece.Queen;
import com.chess.match.piece.Rook;
import com.chess.constants.ChessConstants;
import com.chess.utils.ChessUtils;

public class MatchBoard extends ChessBoard {
  private String currentTurn = "WHITE";

  public MatchBoard() {
    ChessPiece[][] board = getBoard();

    ChessConstants
      .INIT_POSITIONS
      .keySet()
      .forEach(key->{
        String role = key.split("_")[1];
        String color = key.split("_")[0];

        for (String rawPosition : ChessConstants.INIT_POSITIONS.get(key)) {
          int[] position = ChessUtils.mapPositionToBoardIndexes(rawPosition);
          switch(role) {
            case "KING":
              BoardPiece king = new King(color, rawPosition);
              board[position[1]][position[0]] = king;
              break;
            case "QUEEN":
              BoardPiece queen = new Queen(color, rawPosition);
              board[position[1]][position[0]] = queen;
              break;
            case "BISHOP":
              BoardPiece bishop = new Bishop(color, rawPosition);
              board[position[1]][position[0]] = bishop;
              break;
            case "KNIGHT":
              BoardPiece knight = new Knight(color, rawPosition);
              board[position[1]][position[0]] = knight;
              break;
            case "ROOK":
              BoardPiece rook = new Rook(color, rawPosition);
              board[position[1]][position[0]] = rook;
              break;
            case "PAWN":
            default:
              BoardPiece pawn = new Pawn(color, rawPosition);
              board[position[1]][position[0]] = pawn;
              break;
          }
        }
      });
  }

  @Override
  public void movePiece(String source, String destination) {
    int[] srcPosition = ChessUtils.mapPositionToBoardIndexes(source);

    ChessPiece[][] board = getBoard();
    BoardPiece piece = (BoardPiece) board[srcPosition[1]][srcPosition[0]];

    if (piece == null)
      throw new RuntimeException("Invalid Move! No piece is at provided source.");

    if (!piece.getColor().equals(currentTurn))
      throw new RuntimeException("Inavlid movement, player " + " was trying to move " + piece.getColor() + " piece , current player is: " + currentTurn);

    piece.move(destination, board);
    currentTurn = currentTurn.equals("WHITE") ? "BLACK" : "WHITE";
    updateBoard();
  }

  @Override
  public void drawBoard() {
    int[] rowHeaders = {8,7,6,5,4,3,2,1,0};
    StringBuilder builder = new StringBuilder();
    ChessPiece[][] board = getBoard();

    for (int rowIndex=0; rowIndex<board.length; rowIndex++) {
      ChessPiece[] row = board[rowIndex];
      builder.append(String.format("%d ", rowHeaders[rowIndex]));

      for (int colIndex = 0; colIndex<row.length; colIndex++) {
        ChessPiece piece = row[colIndex];

        builder.append(String.format(" %s ", piece == null ? " " : piece));

        if (colIndex < row.length-1) {
          builder.append("|");
        }
      }

      if (rowIndex == 0) {
        builder.append(String.format("    PLAYER: %s", currentTurn));
      }

      if (rowIndex != board.length-1) {
        builder.append("\n  -------------------------------\n");
      }
    }

    builder.append("\n   A   B   C   D   E   F   G   H");

    System.out.println(builder.toString());
  }

  private void updateBoard() {
    await(1000);
    clearBoard();
    drawBoard();
  }
  private void clearBoard() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private static void await(int arg0) {
    try {
      Thread.sleep(arg0);
    } catch(Exception e) {
      System.out.println("EXCEPTION: " + e.getLocalizedMessage());
    }
  }
}
