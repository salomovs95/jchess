package com.chess.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.chess.board.exception.BoardException;
import com.chess.board.ChessBoard;
import com.chess.board.ChessPiece;
import com.chess.constants.ChessConstants;
import com.chess.utils.ChessUtils;

public class MatchBoard implements ChessBoard {
  private String currentTurn = "WHITE";
  private ChessPiece[][] board;

  public MatchBoard() {
    this.board = new ChessPiece[8][8];
    Set<String> initPositionsKeySet = ChessConstants.INIT_POSITIONS.keySet();

    for (String key : initPositionsKeySet) {
      Set<String> initialPositionSet = ChessConstants.INIT_POSITIONS.get(key);

      String role = key.split("_")[1];
      String color = key.split("_")[0];

      for (String rawPosition : initialPositionSet) {
        int[] position = ChessUtils.mapPositionToBoardIndexes(rawPosition);
        ChessPiece piece = ChessPiece.createPiece(role, color, rawPosition);
        board[position[1]][position[0]] = piece;
      }
    };
  }

  public ChessPiece[][] getBoard() {
    return board;
  }

  @Override
  public void movePiece(String source, String destination) {
    int[] srcPosition = ChessUtils.mapPositionToBoardIndexes(source);

    ChessPiece[][] board = getBoard();
    ChessPiece piece =  board[srcPosition[1]][srcPosition[0]];

    if (piece == null)
      throw new BoardException("Invalid Move! No piece is at provided source.");

    if (!piece.getColor().equals(currentTurn))
      throw new BoardException("Inavlid movement, player " + " was trying to move " + piece.getColor() + " piece , current player is: " + currentTurn);

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
      String bgColor = "BG_COLOR_YELLOW";

      for (int colIndex = 0; colIndex<row.length; colIndex++) {
        ChessPiece piece = row[colIndex];

        if (rowIndex%2==0) {
          bgColor = colIndex%2==0 ? "BG_COLOR_YELLOW" : "BG_COLOR_GREEN";
        } else {
          bgColor = colIndex%2==0 ? "BG_COLOR_GREEN" : "BG_COLOR_YELLOW";
        }

        builder.append(String.format(
          "%s %s %s",
          ChessConstants.BOARD_COLORS.get(bgColor),
          piece == null ? " " : piece,
          ChessConstants.BOARD_COLORS.get("COLOR_RESET")
        ));
      }

      if (rowIndex == 0) {
        builder.append(String.format("    PLAYER: %s", currentTurn));
      }

      if (rowIndex != board.length-1) {
        builder.append("\n");
      }
    }

    builder.append("\n   A  B  C  D  E  F  G  H");
    System.out.println(builder.toString());
  }

  @Override
  public void updateBoard() {
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
      throw new BoardException(e.getLocalizedMessage());
    }
  }
}
