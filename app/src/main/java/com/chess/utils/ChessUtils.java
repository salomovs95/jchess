package com.chess.utils;

import java.util.stream.Collectors;

import com.chess.constants.ChessConstants;

public class ChessUtils {
  public static int[] mapPositionToBoardIndexes(String position) {
    int[] indexes = new int[2];
    String[] keys = position.split("");

    indexes[0] = ChessConstants.COL_KEYS.indexOf(keys[0].toUpperCase());
    indexes[1] = ChessConstants.ROW_KEYS.indexOf(keys[1]);

    return indexes;
  }

  public static String mapPositionIndexesToBoardPlaces(int[] boardIndexes) {
    String rawPosition = String.format("%s%s",
      ChessConstants.COL_KEYS.get(boardIndexes[0]),
      ChessConstants.ROW_KEYS.get(boardIndexes[1]));

    return rawPosition;
  }
}
