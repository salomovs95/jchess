package com.chess.board.constants;

import java.util.List;
import java.util.Map;

public abstract class ChessConstants {
  public static Map<String, Character> PIECE_ROLES = Map.ofEntries(
    Map.entry("PAWN",   '♟'),
    Map.entry("KNIGHT", '♞'),
    Map.entry("BISHOP", '♝'),
    Map.entry("ROOK",   '♜'),
    Map.entry("QUEEN",  '♛'),
    Map.entry("KING",   '♚')
  );

  public static Map<String, List<String>> INIT_POSITIONS = Map.ofEntries(
    Map.entry("BLACK_PAWN",    List.of("A7","B7","C7","D7","E7","F7","G7","H7")),
    Map.entry("BLACK_KNIGHT",  List.of("B8", "G8")),
    Map.entry("BLACK_BISHOP",  List.of("C8","F8")),
    Map.entry("BLACK_ROOK",    List.of("A8", "H8")),
    Map.entry("BLACK_QUEEN",   List.of("D8")),
    Map.entry("BLACK_KING",    List.of("E8")),
    Map.entry("WHITE_PAWN",    List.of("A2","B2","C2","D2","E2","F2","G2","H2")),
    Map.entry("WHITE_KNIGHT",  List.of("B1","G1")),
    Map.entry("WHITE_BISHOP",  List.of("C1","F1")),
    Map.entry("WHITE_ROOK",    List.of("A1","H1")),
    Map.entry("WHITE_QUEEN",   List.of("D1")),
    Map.entry("WHITE_KING",    List.of("E1"))
  );

  public static int[] mapPositionToBoardIndexes(String position) {
    Map<String, Integer> keysMap = Map.ofEntries(
      Map.entry("A", 0),
      Map.entry("B", 1),
      Map.entry("C", 2),
      Map.entry("D", 3),
      Map.entry("E", 4),
      Map.entry("F", 5),
      Map.entry("G", 6),
      Map.entry("H", 7)
    );

    int[] indexes = new int[2];
    String[] keys = position.split("");

    indexes[0] = keysMap.get(keys[0].toUpperCase());
    indexes[1] = Integer.parseInt(keys[1])-1;

    return indexes;
  }
}
