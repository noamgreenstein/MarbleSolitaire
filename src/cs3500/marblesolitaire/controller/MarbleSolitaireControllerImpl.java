package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * The implementation of {@code MarbleSolitaireController}, this object possesses the code
 * that runs the program.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable r;

  /**
   * Constructs a {@code MarbleSolitaireControllerImpl}.
   *
   * @param model the model of the board
   * @param view  the view of the board
   * @param r     th readable object of the game
   * @throws IllegalArgumentException if any of the inputted objects are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view,
                                       Readable r) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("model is null");
    }
    if (view == null) {
      throw new IllegalArgumentException("view is null");
    }
    if (r == null) {
      throw new IllegalArgumentException("readable is null");
    }
    this.model = model;
    this.view = view;
    this.r = r;
  }

  @Override
  public void playGame() throws IllegalStateException {
    int fromRow = -1;
    int fromCol = -1;
    int toRow = -1;
    int toCol = -1;
    String message;
    try {

      Scanner s = new Scanner(r);
      startGame();
      while (!model.isGameOver()) {
        try {
          s.hasNext();
        } catch (NoSuchElementException e) {
          throw new IllegalStateException("no such element");
        }
        try {
          if (fromRow == -1) {
            fromRow = s.nextInt();
          }
          if (fromCol == -1) {
            fromCol = s.nextInt();
          }
          if (toRow == -1) {
            toRow = s.nextInt();
          }
          if (toCol == -1) {
            toCol = s.nextInt();
            try {
              model.move(fromRow - 1, fromCol - 1, toRow - 1, toCol - 1);
              fromRow = -1;
              fromCol = -1;
              toRow = -1;
              toCol = -1;
              view.renderBoard();
              view.renderMessage("\n");
              view.renderMessage(String.format("Score: %d\n", model.getScore()));
            } catch (IllegalArgumentException e) {
              fromRow = -1;
              fromCol = -1;
              toRow = -1;
              toCol = -1;
              view.renderMessage("Invalid move. Play again. " + e.getMessage() + "\n");
            }
          }
        } catch (InputMismatchException e) {
          message = s.next();
          if (message.equalsIgnoreCase("q")) {
            quitGame();
            break;
          } else {
            view.renderMessage("Please re-enter numbers\n");
          }
        }
      }
      if (model.isGameOver()) {
        endGame();
      }
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    } catch (NoSuchElementException e) {
      throw new IllegalStateException("no such element");
    }
  }

  /**
   * Displays the beginning of the game.
   *
   * @throws IOException if unable to read input or transmit output
   */
  protected void startGame() throws IOException {
    view.renderMessage("Type in your from and to co-ordinates or 'q' to quit\n");
    view.renderBoard();
    view.renderMessage("\n");
    view.renderMessage(String.format("Score: %d\n", model.getScore()));
  }

  /**
   * displays the end of the game.
   *
   * @throws IOException if unable to read input or transmit output
   */
  protected void endGame() throws IOException {
    view.renderMessage("Game over!\n");
    view.renderBoard();
    view.renderMessage("\n");
    view.renderMessage(String.format("Score: %d\n", model.getScore()));
  }

  /**
   * Displays the quit game screen.
   *
   * @throws IOException if unable to read input or transmit output
   */
  protected void quitGame() throws IOException {
    view.renderMessage("Game quit!\n");
    view.renderMessage("State of game when quit:\n");
    view.renderBoard();
    view.renderMessage("\n");
    view.renderMessage(String.format("Score: %d", model.getScore()));
  }
}
