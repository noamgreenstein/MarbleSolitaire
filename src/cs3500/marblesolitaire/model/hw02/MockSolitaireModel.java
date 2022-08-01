package cs3500.marblesolitaire.model.hw02;

import java.util.Objects;

/**
 * Represents a mock English Solitaire Model used to test user inputs into the controller.
 */
public class MockSolitaireModel implements MarbleSolitaireModel {

  final StringBuilder log;

  /**
   * Constructs a {@code MockSolitaireModel}.
   *
   * @param log the inputted string builder
   */
  public MockSolitaireModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  /**
   * Adds all four inputted values to the reader.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if move is invlaid
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append(String.format("From Row: %d, From Col: %d, To Row: %d, To Col: %d",
            fromRow, fromCol, toRow, toCol));
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
