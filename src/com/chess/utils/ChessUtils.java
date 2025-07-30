package com.chess.utils;

import com.chess.constants.ChessConstants;

public class ChessUtils {
  public static int[] mapPositionToBoardIndexes(String position) {
    int[] indexes = new int[2];
    String[] keys = position.split("");

    indexes[0] = ChessConstants.CELS.get(keys[0].toUpperCase());
    indexes[1] = ChessConstants.CELS.get(keys[1]);

    return indexes;
  }
}
