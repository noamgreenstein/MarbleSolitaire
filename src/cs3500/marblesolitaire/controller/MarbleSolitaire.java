package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Runs the {@code MarbleSolitaireControllerImpl}.
 */
public final class MarbleSolitaire {
  enum board { Tri, English, Euro }

  /**
   * The main method to run the controller.
   *
   * @param args the arguments
   * @throws IOException if input or output is unreadable
   */
  public static void main(String[] args) throws IOException {
    int size = 3;
    int sRow = 3;
    int sCol = 3;

    MarbleSolitaireModel model = null;
    MarbleSolitaireView view = null;
    Readable rd = new InputStreamReader(System.in);
    MarbleSolitaireControllerImpl c;
    board b = null;
    for (int i = 0; i < args.length; i++) {
      switch (args[i].toLowerCase(Locale.ROOT)) {
        case ("english"):
          b = board.English;
          break;
        case ("european"):
          b = board.Euro;
          break;
        case ("triangular"):
          size = 5;
          sRow = 0;
          sCol = 0;
          b = board.Tri;
          break;
        case ("-size"):
          size = Integer.parseInt(args[i + 1]);
          break;
        case ("-hole"):
          sRow = Integer.parseInt(args[i + 1]);
          sCol = Integer.parseInt(args[i + 1]);
          break;
        default:
          break;
      }
    }
    if (b == board.English) {
      model = new EnglishSolitaireModel(size, sRow, sCol);
      view = new MarbleSolitaireTextView(model);
    } else if (b == board.Euro) {
      model = new EuropeanSolitaireModel(size, sRow, sCol);
      view = new MarbleSolitaireTextView(model);
    } else {
      model = new TriangleSolitaireModel(size, sRow, sCol);
      view = new TriangleSolitaireTextView(model);
    }
    c = new MarbleSolitaireControllerImpl(model, view, rd);
    c.playGame();
  }


}
