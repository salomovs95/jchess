package com.chess.constants;

import java.util.List;
import java.util.Set;
import java.util.Map;

public abstract class ChessConstants {
  public static Map<String, String> BOARD_COLORS = Map.ofEntries(
    Map.entry("BG_COLOR_YELLOW", "\033[48;2;235;236;205m"),
    Map.entry("BG_COLOR_GREEN", "\033[48;2;117;146;85m"),
    Map.entry("TXT_COLOR_WHITE", "\033[37m"),
    Map.entry("TXT_COLOR_BLACK", "\033[30m"),
    Map.entry("COLOR_RESET", "\033[0m")
  );

  public static Map<String, Character> PIECE_ROLES = Map.ofEntries(
    Map.entry("PAWN",   '♟'),
    Map.entry("KNIGHT", '♞'),
    Map.entry("BISHOP", '♝'),
    Map.entry("ROOK",   '♜'),
    Map.entry("QUEEN",  '♛'),
    Map.entry("KING",   '♚')
  );

  public static Map<String, Set<String>> INIT_POSITIONS = Map.ofEntries(
    Map.entry("BLACK_PAWN",    Set.of("A7","B7","C7","D7","E7","F7","G7","H7")),
    Map.entry("WHITE_PAWN",    Set.of("A2","B2","C2","D2","E2","F2","G2","H2")),

    Map.entry("BLACK_KNIGHT",  Set.of("B8", "G8")),
    Map.entry("WHITE_KNIGHT",  Set.of("B1","G1")),

    Map.entry("BLACK_BISHOP",  Set.of("C8","F8")),
    Map.entry("WHITE_BISHOP",  Set.of("C1","F1")),

    Map.entry("BLACK_ROOK",    Set.of("A8", "H8")),
    Map.entry("WHITE_ROOK",    Set.of("A1","H1")),

    Map.entry("BLACK_QUEEN",   Set.of("D8")),
    Map.entry("WHITE_QUEEN",   Set.of("D1")),

    Map.entry("BLACK_KING",    Set.of("E8")),
    Map.entry("WHITE_KING",    Set.of("E1"))
  );

  public static List<String> COL_KEYS = List.of("A","B","C","D","E","F","G","H");
  public static List<String> ROW_KEYS = List.of("8","7","6","5","4","3","2","1");
}
