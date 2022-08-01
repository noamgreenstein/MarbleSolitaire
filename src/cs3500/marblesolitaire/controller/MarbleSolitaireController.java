package cs3500.marblesolitaire.controller;

/**
 * represents an interface for a controller that can play marble solitaire game with user input.
 */
public interface MarbleSolitaireController {
  /**
   * plays a game of marble Solitaire.
   *
   * @throws IllegalStateException if the controller is unable to read input or transmit output
   */
  void playGame() throws IllegalStateException;
}
