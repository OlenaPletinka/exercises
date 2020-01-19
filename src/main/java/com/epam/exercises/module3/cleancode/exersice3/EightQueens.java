package com.epam.exercises.module3.cleancode.exersice3;

import java.util.ArrayList;

/**
 * This class simulate the game,main aim of the game is to find all possible locations of the char 'q'
 * on the given array.
 */
class EightQueens {
  private static final char QUEEN = 'q';
  private static final char DOT = '.';

  /**
   * Constructor without parameters.
   */
  public EightQueens() {
  }

  /**
   * This method find all possible locations of the char 'q' on the given array.
   *
   * @param board     given parameter.
   * @param col       given parameter.
   * @param solutions given parameter.
   */
  @SuppressWarnings("checkstyle:Indentation")
  public void solveAllNQueens(char[][] board, final int col, ArrayList<char[][]> solutions) {

    if (col == board.length) {
      char[][] copy = new char[board.length][board[0].length];
      for (int r = 0; r < board.length; r++) {
        System.arraycopy(board[r], 0, copy[r], 0, board[0].length);
      }
      solutions.add(copy);
    } else {
      for (int row = 0; row < board.length; row++) {
        board[row][col] = QUEEN;
        boolean canBeSafe = true;

        canBeSafe = isCanBeSafe(board, canBeSafe);

        if (canBeSafe) {
          solveAllNQueens(board, col + 1, solutions);
        }
        board[row][col] = DOT;
      }
    }
  }

  private boolean isCanBeSafe(final char[][] board, boolean canBeSafe) {
    for (char[] chars : board) {
      boolean found = false;
      for (int j = 0; j < board.length; j++) {
        final char charFromBoard = chars[j];
        if (charFromBoard == QUEEN) {
          canBeSafe = isFound(canBeSafe, found);

          found = true;
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      boolean found = false;
      for (char[] chars : board) {
        final char charFromBoard = chars[i];
        if (charFromBoard == QUEEN) {
          canBeSafe = isFound(canBeSafe, found);

          found = true;
        }
      }
    }

    for (int offset = -board.length; offset < board.length; offset++) {
      boolean found = false;
      for (int i = 0; i < board.length; i++) {
        if (inbounds(i, i + offset, board)) {
          final char charFromBoard = board[i][i + offset];
          if (charFromBoard == QUEEN) {
            canBeSafe = isFound(canBeSafe, found);

            found = true;
          }
        }
      }
    }

    for (int offset = -board.length; offset < board.length; offset++) {
      boolean found = false;
      for (int i = 0; i < board.length; i++) {
        if (inbounds(i, board.length - offset - i - 1, board)) {
          final char charFromBoard = board[i][board.length - offset - i - 1];

          if (charFromBoard == QUEEN) {
            canBeSafe = isFound(canBeSafe, found);

            found = true;
          }
        }
      }
    }
    return canBeSafe;
  }

  private boolean isFound(boolean canBeSafe, final boolean found) {
    if (found) {
      canBeSafe = false;
    }
    return canBeSafe;
  }

  private boolean inbounds(final int row, final int col, final char[][] mat) {
    return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length;
  }
}
