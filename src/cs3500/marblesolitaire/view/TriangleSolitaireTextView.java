package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents how one can view a game of Triangle Solitaire.
 */
public class TriangleSolitaireTextView extends AbstractView {
  /**
   * constructs a {@code MarbleSolitaireTextView}.
   *
   * @param board the board to be printed out
   * @throw IllegalArgumentException if the board is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState board)
          throws IllegalArgumentException {
    this(board, System.out);
  }

  /**
   * constructs a {@code MarbleSolitaireTextView}.
   *
   * @param board the board to be printed out
   * @param ap    the appendable object
   * @throws IllegalArgumentException if the board or the appendable is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState board, Appendable ap)
          throws IllegalArgumentException {
    super(board, ap);
  }

  /**
   * Converts the given board to a String.
   *
   * @return how the board looks as a String
   */
  public String toString() {
    String view = "";
    for (int i = 0; i < board.getBoardSize(); i++) {
      if (i != 0) {
        view += "\n";
      }
      int spaces = board.getBoardSize() - 2 - i;
      for (int j = 0; j < board.getBoardSize(); j++) {
        if (spaces >= 0 && j == 0) {
          for (int k = 0; k < spaces + 1; k++) {
            view += " ";
          }
        }
        if (i == j) {
          if (board.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
            view += "_";
          }
          if (board.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
            view += "O";
          }
        }
        if (i > j) {
          if (board.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
            view += "_ ";
          }
          if (board.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
            view += "O ";
          }
        }
      }
    }
    return view;
  }
}
