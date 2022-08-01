package cs3500.marblesolitaire.model.hw04;

/**
 * Represents a game of Triangle Solitaire that can be customized by dimension and empty spot.
 */
public class TriangleSolitaireModel extends AbstractSolitaire {

  /**
   * Constructs a game of Triangle Solitaire.
   *
   * @throws IllegalArgumentException if any inputs are invalid
   */
  public TriangleSolitaireModel() throws IllegalArgumentException {
    this(5, 0, 0);
  }

  /**
   * Constructs a game of Triangle Solitaire.
   *
   * @param dimension the dimension of the game
   * @throws IllegalArgumentException if any inputs are invalid
   */
  public TriangleSolitaireModel(int dimension) throws IllegalArgumentException {
    this(dimension, 0, 0);
  }

  /**
   * Constructs a game of Triangle Solitaire.
   *
   * @param sRow    the empty row co-ordinate
   * @param sColumn the empty column co-ordinate
   * @throws IllegalArgumentException if any inputs are invalid
   */
  public TriangleSolitaireModel(int sRow, int sColumn) throws IllegalArgumentException {
    this(5, sRow, sColumn);
  }

  /**
   * Constructs a game of Triangle Solitaire.
   *
   * @param dimension the dimension of the game
   * @param sRow      the empty row co-ordinate
   * @param sColumn   the empty column co-ordinate
   * @throws IllegalArgumentException if any inputs are invalid
   */
  public TriangleSolitaireModel(int dimension, int sRow, int sColumn)
          throws IllegalArgumentException {
    super(dimension, sRow, sColumn);
    if (dimension < 1) {
      throw new IllegalArgumentException("invalid dimension");
    }
    if (sColumn > sRow || sRow >= dimension || sRow < 0 || sColumn < 0) {
      throw new IllegalArgumentException(String.format("Invalid empty co-ordinates: (%d,%d)",
              sRow, sColumn));
    }
  }

  /**
   * Initializes the board of the game.
   *
   * @param dimension the dimension of the board
   * @return a 2D array of marble states to represent the board
   */
  protected SlotState[][] makeMarbles(int dimension) {
    SlotState[][] temp = new SlotState[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        if (i >= j) {
          temp[i][j] = SlotState.Marble;
          if (sRow == i && sColumn == j) {
            temp[i][j] = SlotState.Empty;
          }
        } else {
          temp[i][j] = SlotState.Invalid;
        }
      }
    }
    return temp;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (cannotMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Invalid Co-ordinates");
    }
    //move right
    else if (fromRow == toRow && fromCol == toCol - 2
            && marbles[fromRow][fromCol + 1] == SlotState.Marble) {
      marbles[fromRow][fromCol] = SlotState.Empty;
      marbles[fromRow][fromCol + 1] = SlotState.Empty;
      marbles[fromRow][fromCol + 2] = SlotState.Marble;
    }
    // move left
    else if (fromRow == toRow && fromCol == toCol + 2
            && marbles[fromRow][fromCol - 1] == SlotState.Marble) {
      marbles[fromRow][fromCol] = SlotState.Empty;
      marbles[fromRow][fromCol - 1] = SlotState.Empty;
      marbles[fromRow][fromCol - 2] = SlotState.Marble;
    }
    // move up right
    else if (fromCol == toCol && fromRow == toRow + 2
            && marbles[fromRow - 1][fromCol] == SlotState.Marble) {
      marbles[fromRow][fromCol] = SlotState.Empty;
      marbles[fromRow - 1][fromCol] = SlotState.Empty;
      marbles[fromRow - 2][fromCol] = SlotState.Marble;
    }
    // move down left
    else if (fromCol == toCol && fromRow == toRow - 2
            && marbles[fromRow + 1][fromCol] == SlotState.Marble) {
      marbles[fromRow][fromCol] = SlotState.Empty;
      marbles[fromRow + 1][fromCol] = SlotState.Empty;
      marbles[fromRow + 2][fromCol] = SlotState.Marble;
    }
    // move up left
    else if (fromRow == toRow + 2 && fromCol == toCol + 2
            && marbles[fromRow - 1][fromCol - 1] == SlotState.Marble) {
      marbles[fromRow][fromCol] = SlotState.Empty;
      marbles[fromRow - 1][fromCol - 1] = SlotState.Empty;
      marbles[fromRow - 2][fromCol - 2] = SlotState.Marble;
    }
    // move down right
    else if (fromRow == toRow - 2 && fromCol == toCol - 2
            && marbles[fromRow + 1][fromCol + 1] == SlotState.Marble) {
      marbles[fromRow][fromCol] = SlotState.Empty;
      marbles[fromRow + 1][fromCol + 1] = SlotState.Empty;
      marbles[fromRow + 2][fromCol + 2] = SlotState.Marble;
    } else {
      throw new IllegalArgumentException("Invalid Move");
    }
  }

  protected boolean cannotMove(int fromRow, int fromCol, int toRow, int toCol) {
    return fromRow < 0 || fromRow > dimension - 1
            || fromCol < 0 || fromCol > dimension - 1
            || toRow < 0 || toRow > dimension - 1
            || toCol < 0 || toCol > dimension - 1
            || marbles[fromRow][fromCol] != SlotState.Marble
            || marbles[toRow][toCol] != SlotState.Empty;

  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (marbles[i][j] == SlotState.Marble) {
          //check left
          if (j > 1 && marbles[i][j - 1] == SlotState.Marble
                  && marbles[i][j - 2] == SlotState.Empty) {
            return false;
          }
          //check right
          if (j < dimension - 2 && marbles[i][j + 1] == SlotState.Marble
                  && marbles[i][j + 2] == SlotState.Empty) {
            return false;
          }
          //check up right
          if (i > 1 && marbles[i - 1][j] == SlotState.Marble
                  && marbles[i - 2][j] == SlotState.Empty) {
            return false;
          }
          //check down left
          if (i < dimension - 2 && marbles[i + 1][j] == SlotState.Marble
                  && marbles[i + 2][j] == SlotState.Empty) {
            return false;
          }
          //check up left
          if (i > 1 && j > 1 && marbles[i - 1][j - 1] == SlotState.Marble
                  && marbles[i - 2][j - 2] == SlotState.Empty) {
            return false;
          }
          //check down right
          if (i < dimension - 2 && j < dimension - 2 && marbles[i + 1][j + 1] == SlotState.Marble
                  && marbles[i + 2][j + 2] == SlotState.Empty) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public int getBoardSize() {
    return dimension;
  }

}
