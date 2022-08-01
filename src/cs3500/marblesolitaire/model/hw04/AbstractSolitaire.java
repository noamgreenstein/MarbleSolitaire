package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract class for a solitaire game.
 */
public abstract class AbstractSolitaire implements MarbleSolitaireModel {

  protected final int dimension;
  protected final int sRow;
  protected final int sColumn;
  protected SlotState[][] marbles;

  /**
   * Constructs an abstract solitaire game.
   *
   * @param dimension the dimension of the game
   * @param sRow      the empty row co-ordinate
   * @param sColumn   the empty column co-ordinate
   * @throws IllegalArgumentException if any of the inputs are invalid
   */
  protected AbstractSolitaire(int dimension, int sRow, int sColumn)
          throws IllegalArgumentException {
    if (dimension < 1) {
      throw new IllegalArgumentException("invalid dimension");
    }
    this.dimension = dimension;
    this.sRow = sRow;
    this.sColumn = sColumn;
    this.marbles = makeMarbles(dimension);
  }


  protected abstract SlotState[][] makeMarbles(int dimension);

  /**
   * moves a Marble.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the inputted To or From co-ordinates are not on the board,
   *                                  or are invalid, or if to the to spot is not empty,
   *                                  or if the from spot is not a marble,
   *                                  or if the from spot is not two spaces up, right,
   *                                  left, or down from the from spot.
   *                                  Will also throw an exception if the space in between the to
   *                                  and from is not a marble.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (cannotMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Co-ordinates invalid");
    } else if (fromCol == toCol) {
      if (fromRow + 2 == toRow && marbles[fromRow + 1][fromCol] == SlotState.Marble) {
        marbles[toRow][toCol] = SlotState.Marble;
        marbles[fromRow][fromCol] = SlotState.Empty;
        marbles[fromRow + 1][fromCol] = SlotState.Empty;
      } else if (fromRow == toRow + 2 && marbles[fromRow - 1][fromCol] == SlotState.Marble) {
        marbles[toRow][toCol] = SlotState.Marble;
        marbles[fromRow][fromCol] = SlotState.Empty;
        marbles[fromRow - 1][fromCol] = SlotState.Empty;
      } else {
        throw new IllegalArgumentException("cannot jump here");
      }
    } else if (fromRow == toRow) {
      if (fromCol + 2 == toCol && marbles[fromRow][fromCol + 1] == SlotState.Marble) {
        marbles[toRow][toCol] = SlotState.Marble;
        marbles[fromRow][fromCol] = SlotState.Empty;
        marbles[fromRow][fromCol + 1] = SlotState.Empty;
      } else if (fromCol == toCol + 2 && marbles[fromRow][fromCol - 1] == SlotState.Marble) {
        marbles[toRow][toCol] = SlotState.Marble;
        marbles[fromRow][fromCol] = SlotState.Empty;
        marbles[fromRow][fromCol - 1] = SlotState.Empty;
      } else {
        throw new IllegalArgumentException("cannot jump here");
      }
    }
  }

  /**
   * Helper method for move that checks if the move cannot happen.
   *
   * @param fromRow the from row
   * @param fromCol the from column
   * @param toRow   the to row
   * @param toCol   the to column
   * @return true if it cannot move
   */
  protected boolean cannotMove(int fromRow, int fromCol, int toRow, int toCol) {
    return fromRow < 0 || fromRow > dimension + (2 * dimension - 2) - 1
            || fromCol < 0 || fromCol > dimension + (2 * dimension - 2) - 1
            || toRow < 0 || toRow > dimension + (2 * dimension - 2) - 1
            || toCol < 0 || toCol > dimension + (2 * dimension - 2) - 1
            || marbles[fromRow][fromCol] != SlotState.Marble
            || marbles[toRow][toCol] != SlotState.Empty
            || !(fromRow + 2 == toRow && fromCol == toCol
            || fromRow == toRow && fromCol + 2 == toCol
            || fromRow == toRow + 2 && fromCol == toCol
            || fromRow == toRow && fromCol == toCol + 2);
  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (marbles[i][j] == SlotState.Marble) {
          if (i < 2) {
            if (marbles[i + 1][j] == SlotState.Marble && marbles[i + 2][j] == SlotState.Empty) {
              return false;
            }
          }
          if (j < 2) {
            if (marbles[i][j + 1] == SlotState.Marble && marbles[i][j + 2] == SlotState.Empty) {
              return false;
            }
          }
          if (i > this.getBoardSize() - 3) {
            if (marbles[i - 1][j] == SlotState.Marble && marbles[i - 2][j] == SlotState.Empty) {
              return false;
            }
          }
          if (j > this.getBoardSize() - 3) {
            if (marbles[i][j - 1] == SlotState.Marble && marbles[i][j - 2] == SlotState.Empty) {
              return false;
            }
          }
          if (i > 1 && i < this.getBoardSize() - 2) {
            if (marbles[i + 1][j] == SlotState.Marble && marbles[i + 2][j] == SlotState.Empty) {
              return false;
            }
            if (marbles[i - 1][j] == SlotState.Marble && marbles[i - 2][j] == SlotState.Empty) {
              return false;
            }
          }
          if (j > 1 && j < this.getBoardSize() - 2) {
            if (marbles[i][j + 1] == SlotState.Marble && marbles[i][j + 2] == SlotState.Empty) {
              return false;
            }
            if (marbles[i][j - 1] == SlotState.Marble && marbles[i][j - 2] == SlotState.Empty) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  @Override
  public int getBoardSize() {
    return this.dimension + (2 * dimension - 2);
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row > dimension + (2 * dimension - 2) - 1 ||
            col < 0 || col > dimension + (2 * dimension - 2) - 1) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + row + "," + col + ")");
    } else {
      return marbles[row][col];
    }
  }

  @Override
  public int getScore() {
    int score = 0;
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if (getSlotAt(i, j) == SlotState.Marble) {
          score++;
        }
      }
    }
    return score;
  }
}
