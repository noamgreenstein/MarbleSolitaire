package cs3500.marblesolitaire.model.hw04;

/**
 * represents a game of European Solitaire that can be customized by side length and empty slot.
 */
public class EuropeanSolitaireModel extends AbstractSolitaire {

  /**
   * constructs an {@code EuropeanSolitaireModel}.
   */
  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * constructs an {@code EuropeanSolitaireModel}.
   *
   * @param sRow    the row coordinate of the empty marble spot
   * @param sColumn the column coordinate of the empty marble spot
   * @throws IllegalArgumentException when the column coordinates are invalid
   */
  public EuropeanSolitaireModel(int sRow, int sColumn) throws IllegalArgumentException {
    this(3, sRow, sColumn);
  }

  /**
   * constructs an {@code EuropeanSolitaireModel}.
   *
   * @param armThickness the arm thickness of the game
   * @throws IllegalArgumentException when the arm thickness is not a positive odd number
   */
  public EuropeanSolitaireModel(int armThickness) throws IllegalArgumentException {
    this(armThickness, (armThickness + (2 * armThickness - 2)) / 2,
            (armThickness + (2 * armThickness - 2)) / 2);
  }

  /**
   * constructs an {@code EuropeanSolitaireModel}.
   *
   * @param armThickness the arm thickness of the game
   * @param sRow         the row coordinate of the empty marble spot
   * @param sColumn      the column coordinate of the empty marble spot
   * @throws IllegalArgumentException when the arm thickness is not a positive odd number
   * @throws IllegalArgumentException when the column coordinates are invalid
   */
  public EuropeanSolitaireModel(int armThickness, int sRow, int sColumn)
          throws IllegalArgumentException {
    super(armThickness, sRow, sColumn);
    if (armThickness < 0 || armThickness % 2 == 0) {
      throw new IllegalArgumentException("Thickness is not a positive odd number");
    }
    if (sRow < 0 || sRow > (armThickness + (armThickness - 1) * 2) - 1
            || sColumn < 0 || sColumn > (armThickness + (armThickness - 1) * 2) - 1
            || ((sRow < armThickness - 1 || sRow > 2 * armThickness - 2)
            && (sColumn < armThickness - 1 || sColumn > 2 * armThickness - 2)
            && !isEuroSpot(armThickness, sRow, sColumn))) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + sRow + "," + sColumn + ")");

    }
  }


  /**
   * checks if the empty row is in the European only spots.
   *
   * @param sRow    empty row
   * @param sColumn empty column
   * @return whether the empty spot is one of the four spots
   */
  private boolean isEuroSpot(int armThickness, int sRow, int sColumn) {
    return (sRow < armThickness - 1 && sColumn >= armThickness - 1 - sRow
            && sColumn <= 2 * armThickness - 2 + sRow)
            || (sRow > 2 * armThickness - 2
            && sColumn >= armThickness - 1 - (3 * armThickness - 3 - sRow)
            && sColumn <= 2 * armThickness - 2 + (3 * armThickness - 3 - sRow));
  }

  /**
   * Creates a list of the marbles on the board.
   *
   * @param armThickness the thickness of the board
   * @return a new 2D array of {@code Marble}
   */
  protected SlotState[][] makeMarbles(int armThickness) {
    SlotState[][] temp = new SlotState[armThickness + (2 * armThickness - 2)]
            [armThickness + (2 * armThickness - 2)];
    for (int i = 0; i < armThickness + (2 * armThickness - 2); i++) {
      for (int j = 0; j < armThickness + (2 * armThickness - 2); j++) {
        if ((i < armThickness - 1 || i > 2 * armThickness - 2)
                && (j < armThickness - 1 || j > 2 * armThickness - 2)
                && !isEuroSpot(armThickness, i, j)) {
          temp[i][j] = SlotState.Invalid;
        } else if (i == this.sRow && j == this.sColumn) {
          temp[i][j] = SlotState.Empty;
        } else if (isEuroSpot(armThickness, i, j)) {
          temp[i][j] = SlotState.Marble;
        }  else {
          temp[i][j] = SlotState.Marble;
        }
      }
    }
    return temp;
  }



}
