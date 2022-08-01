package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents an abstract class for the view of any marble solitaire game.
 */
public abstract class AbstractView implements MarbleSolitaireView {

  MarbleSolitaireModelState board;
  Appendable ap;

  /**
   * constructs an abstract view.
   *
   * @param board the board of the game
   * @param ap    the appendable object
   * @throws IllegalArgumentException if either the board or appendable are null
   */
  public AbstractView(MarbleSolitaireModelState board, Appendable ap)
          throws IllegalArgumentException {
    if (board == null) {
      throw new IllegalArgumentException("board is null");
    }
    if (ap == null) {
      throw new IllegalArgumentException("appendable is null");
    }
    this.board = board;
    this.ap = ap;
  }

  public abstract String toString();

  @Override
  public void renderBoard() throws IOException {
    this.ap.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.ap.append(message);
  }
}
