package com.chess.utils;

import java.util.stream.Collectors;

import com.chess.constants.ChessConstants;

public class ChessUtils {
  public static int[] mapPositionToBoardIndexes(String position) {
    int[] indexes = new int[2];
    String[] keys = position.split("");

    indexes[0] = ChessConstants.CELS.get(keys[0].toUpperCase());
    indexes[1] = ChessConstants.CELS.get(keys[1]);

    return indexes;
  }

  public static String mapBoardIndexesToPosition(int[] indexes) {
    StringBuilder b = new StringBuilder();
    var columnKeys = ChessConstants.CELS.keySet().stream().collect(Collectors.toList()).subList(0, 8);
    var rowKeys = ChessConstants.CELS.keySet().stream().collect(Collectors.toList()).subList(8, 16);

    for (String key : columnKeys) {
      if (ChessConstants.CELS.get(key).equals(indexes[0])) {
        b.append(key);
      }
    }

    for (String key : rowKeys) {
      if (ChessConstants.CELS.get(key).equals(indexes[1])) {
        b.append(key);
      }
    }

    return b.toString();
  }
}
