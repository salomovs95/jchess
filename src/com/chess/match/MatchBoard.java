package com.chess.match;

import com.chess.board.ChessBoard;
import com.chess.board.ChessPiece;
import com.chess.board.constants.ChessConstants;

public class MatchBoard extends ChessBoard {
  public MatchBoard() {
    ChessConstants
      .INIT_POSITIONS
      .keySet()
      .forEach(key->{
        String role = key.substring(6);
        String color = key.substring(0, 5);

        for (String rawPosition : ChessConstants.INIT_POSITIONS.get(key)) {
          int[] position = ChessConstants.mapPositionToBoardIndexes(rawPosition);
          this.getBoard()[position[1]][position[0]] = new BoardPiece(role, color, rawPosition);
        }
      });
  }

  @Override
  public void drawBoard() {
    int[] rowHeaders = {8,7,6,5,4,3,2,1,0};
    StringBuilder builder = new StringBuilder();
    ChessPiece[][] board = this.getBoard();

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

      if (rowIndex != board.length-1) {
        builder.append("\n  -------------------------------\n");
      }
    }

    builder.append("\n   A   B   C   D   E   F   G   H");

    System.out.println(builder.toString());
  }
}
