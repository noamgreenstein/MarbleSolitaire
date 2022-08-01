package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents the view of the board given the current state of the model.
 */
public class MarbleSolitaireTextView extends AbstractView {
  /**
   * constructs a {@code MarbleSolitaireTextView}.
   *
   * @param board the board to be printed out
   * @throw IllegalArgumentException if the board is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState board) throws IllegalArgumentException {
    this(board, System.out);
  }

  /**
   * constructs a {@code MarbleSolitaireTextView}.
   *
   * @param board the board to be printed out
   * @param ap    the appendable object
   * @throws IllegalArgumentException if the board or the appendable is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState board, Appendable ap)
          throws IllegalArgumentException {
    super(board, ap);
  }


  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  public String toString() {
    String view = "";
    for (int i = 0; i < board.getBoardSize(); i++) {
      if (i != 0) {
        view += "\n";
      }
      for (int j = 0; j < board.getBoardSize(); j++) {
        if (j == 0) {
          if (board.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
            view += "O";
          }
          if (board.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
            view += "_";
          }
          if (board.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid) {
            view += " ";
          }
        } else {
          if (j < board.getBoardSize() / 2) {
            if (board.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid) {
              view += "  ";
            }
          }
          if (board.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
            view += " _";
          }
          if (board.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
            view += " O";
          }
        }

      }


    }

    return view;

  }
}