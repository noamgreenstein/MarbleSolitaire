import org.junit.Test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MockSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * Tests that the inputs into the controller are interpreted correctly using a mock.
 */
public class MockSolitaireModelTest {
  @Test
  public void testQuitInput() {
    Reader in = new StringReader("q");
    MarbleSolitaireModel m = new EnglishSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MockSolitaireModel(log);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);

    controller.playGame();

    assertEquals("Type in your from and to co-ordinates or 'q' to quit",
            ap.toString().split("\n")[0]);
    assertEquals("    O O O",
            ap.toString().split("\n")[1]);
    assertEquals("    O O O",
            ap.toString().split("\n")[2]);
    assertEquals("O O O O O O O",
            ap.toString().split("\n")[3]);
    assertEquals("O O O _ O O O",
            ap.toString().split("\n")[4]);
    assertEquals("O O O O O O O",
            ap.toString().split("\n")[5]);
    assertEquals("    O O O",
            ap.toString().split("\n")[6]);
    assertEquals("    O O O",
            ap.toString().split("\n")[7]);
    assertEquals("Score: 0",
            ap.toString().split("\n")[8]);
    assertEquals("Game quit!",
            ap.toString().split("\n")[9]);
    assertEquals("State of game when quit:",
            ap.toString().split("\n")[10]);
    assertEquals("    O O O",
            ap.toString().split("\n")[11]);
    assertEquals("    O O O",
            ap.toString().split("\n")[12]);
    assertEquals("O O O O O O O",
            ap.toString().split("\n")[13]);
    assertEquals("O O O _ O O O",
            ap.toString().split("\n")[14]);
    assertEquals("O O O O O O O",
            ap.toString().split("\n")[15]);
    assertEquals("    O O O",
            ap.toString().split("\n")[16]);
    assertEquals("    O O O",
            ap.toString().split("\n")[17]);
    assertEquals("Score: 0",
            ap.toString().split("\n")[18]);

    Reader in2 = new StringReader("Q");
    MarbleSolitaireModel m2 = new EnglishSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(m2, ap2);

    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireModel mock2 = new MockSolitaireModel(log2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(mock2, view2, in2);

    controller2.playGame();

    assertEquals("Type in your from and to co-ordinates or 'q' to quit",
            ap2.toString().split("\n")[0]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[1]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[2]);
    assertEquals("O O O O O O O",
            ap2.toString().split("\n")[3]);
    assertEquals("O O O _ O O O",
            ap2.toString().split("\n")[4]);
    assertEquals("O O O O O O O",
            ap2.toString().split("\n")[5]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[6]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[7]);
    assertEquals("Score: 0",
            ap2.toString().split("\n")[8]);
    assertEquals("Game quit!",
            ap2.toString().split("\n")[9]);
    assertEquals("State of game when quit:",
            ap2.toString().split("\n")[10]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[11]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[12]);
    assertEquals("O O O O O O O",
            ap2.toString().split("\n")[13]);
    assertEquals("O O O _ O O O",
            ap2.toString().split("\n")[14]);
    assertEquals("O O O O O O O",
            ap2.toString().split("\n")[15]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[16]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[17]);
    assertEquals("Score: 0",
            ap2.toString().split("\n")[18]);

    Reader in3 = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel m3 = new EnglishSolitaireModel();
    Appendable ap3 = new StringBuilder();
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(m3, ap3);

    MarbleSolitaireController c3 = new MarbleSolitaireControllerImpl(m3, view3, in3);
    c3.playGame();
    assertEquals("    O O O",
            ap3.toString().split("\n")[9]);
    assertEquals("    O O O",
            ap3.toString().split("\n")[10]);
    assertEquals("O O O O O O O",
            ap3.toString().split("\n")[11]);
    assertEquals("O _ _ O O O O",
            ap3.toString().split("\n")[12]);
    assertEquals("O O O O O O O",
            ap3.toString().split("\n")[13]);
    assertEquals("    O O O",
            ap3.toString().split("\n")[14]);
    assertEquals("    O O O",
            ap3.toString().split("\n")[15]);
    assertEquals("Score: 31",
            ap3.toString().split("\n")[16]);
    assertEquals("Game quit!",
            ap3.toString().split("\n")[17]);
    assertEquals("State of game when quit:",
            ap3.toString().split("\n")[18]);
    assertEquals("    O O O",
            ap3.toString().split("\n")[19]);
    assertEquals("    O O O",
            ap3.toString().split("\n")[20]);
    assertEquals("O O O O O O O",
            ap3.toString().split("\n")[21]);
    assertEquals("O _ _ O O O O",
            ap3.toString().split("\n")[22]);
    assertEquals("O O O O O O O",
            ap3.toString().split("\n")[23]);
    assertEquals("    O O O",
            ap3.toString().split("\n")[24]);
    assertEquals("    O O O",
            ap3.toString().split("\n")[25]);
    assertEquals("Score: 31",
            ap3.toString().split("\n")[26]);

    Reader in4 = new StringReader("q");
    MarbleSolitaireModel m4 = new EuropeanSolitaireModel();
    Appendable ap4 = new StringBuilder();
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(m4, ap4);

    MarbleSolitaireController controller4 = new MarbleSolitaireControllerImpl(m4, view4, in4);

    controller4.playGame();

    assertEquals("Type in your from and to co-ordinates or 'q' to quit",
            ap4.toString().split("\n")[0]);
    assertEquals("    O O O",
            ap4.toString().split("\n")[1]);
    assertEquals("  O O O O O",
            ap4.toString().split("\n")[2]);
    assertEquals("O O O O O O O",
            ap4.toString().split("\n")[3]);
    assertEquals("O O O _ O O O",
            ap4.toString().split("\n")[4]);
    assertEquals("O O O O O O O",
            ap4.toString().split("\n")[5]);
    assertEquals("  O O O O O",
            ap4.toString().split("\n")[6]);
    assertEquals("    O O O",
            ap4.toString().split("\n")[7]);
    assertEquals("Score: 36",
            ap4.toString().split("\n")[8]);
    assertEquals("Game quit!",
            ap4.toString().split("\n")[9]);
    assertEquals("State of game when quit:",
            ap4.toString().split("\n")[10]);
    assertEquals("    O O O",
            ap4.toString().split("\n")[11]);
    assertEquals("  O O O O O",
            ap4.toString().split("\n")[12]);
    assertEquals("O O O O O O O",
            ap4.toString().split("\n")[13]);
    assertEquals("O O O _ O O O",
            ap4.toString().split("\n")[14]);
    assertEquals("O O O O O O O",
            ap4.toString().split("\n")[15]);
    assertEquals("  O O O O O",
            ap4.toString().split("\n")[16]);
    assertEquals("    O O O",
            ap4.toString().split("\n")[17]);
    assertEquals("Score: 36",
            ap4.toString().split("\n")[18]);

    Reader in5 = new StringReader("q");
    MarbleSolitaireModel m5 = new TriangleSolitaireModel();
    Appendable ap5 = new StringBuilder();
    MarbleSolitaireView view5 = new TriangleSolitaireTextView(m5, ap5);

    MarbleSolitaireController controller5 = new MarbleSolitaireControllerImpl(m5, view5, in5);

    controller5.playGame();

    assertEquals("Type in your from and to co-ordinates or 'q' to quit",
            ap5.toString().split("\n")[0]);
    assertEquals("    _",
            ap5.toString().split("\n")[1]);
    assertEquals("   O O",
            ap5.toString().split("\n")[2]);
    assertEquals("  O O O",
            ap5.toString().split("\n")[3]);
    assertEquals(" O O O O",
            ap5.toString().split("\n")[4]);
    assertEquals("O O O O O",
            ap5.toString().split("\n")[5]);
    assertEquals("Score: 14",
            ap5.toString().split("\n")[6]);
    assertEquals("Game quit!",
            ap5.toString().split("\n")[7]);
    assertEquals("State of game when quit:",
            ap5.toString().split("\n")[8]);
    assertEquals("    _",
            ap5.toString().split("\n")[9]);
    assertEquals("   O O",
            ap5.toString().split("\n")[10]);
    assertEquals("  O O O",
            ap5.toString().split("\n")[11]);
    assertEquals(" O O O O",
            ap5.toString().split("\n")[12]);
    assertEquals("O O O O O",
            ap5.toString().split("\n")[13]);
    assertEquals("Score: 14",
            ap5.toString().split("\n")[14]);

    Reader in6 = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel m6 = new EuropeanSolitaireModel();
    Appendable ap6 = new StringBuilder();
    MarbleSolitaireView view6 = new MarbleSolitaireTextView(m6, ap6);

    MarbleSolitaireController controller6 = new MarbleSolitaireControllerImpl(m6, view6, in6);

    controller6.playGame();


    assertEquals("    O O O",
            ap6.toString().split("\n")[9]);
    assertEquals("  O O O O O",
            ap6.toString().split("\n")[10]);
    assertEquals("O O O O O O O",
            ap6.toString().split("\n")[11]);
    assertEquals("O _ _ O O O O",
            ap6.toString().split("\n")[12]);
    assertEquals("O O O O O O O",
            ap6.toString().split("\n")[13]);
    assertEquals("  O O O O O",
            ap6.toString().split("\n")[14]);
    assertEquals("    O O O",
            ap6.toString().split("\n")[15]);
    assertEquals("Score: 35",
            ap6.toString().split("\n")[16]);
    assertEquals("Game quit!",
            ap6.toString().split("\n")[17]);
    assertEquals("State of game when quit:",
            ap6.toString().split("\n")[18]);
    assertEquals("    O O O",
            ap6.toString().split("\n")[19]);
    assertEquals("  O O O O O",
            ap6.toString().split("\n")[20]);
    assertEquals("O O O O O O O",
            ap6.toString().split("\n")[21]);
    assertEquals("O _ _ O O O O",
            ap6.toString().split("\n")[22]);
    assertEquals("O O O O O O O",
            ap6.toString().split("\n")[23]);
    assertEquals("  O O O O O",
            ap6.toString().split("\n")[24]);
    assertEquals("    O O O",
            ap6.toString().split("\n")[25]);
    assertEquals("Score: 35",
            ap6.toString().split("\n")[26]);

    Reader in7 = new StringReader("3 1 1 1 q");
    MarbleSolitaireModel m7 = new TriangleSolitaireModel();
    Appendable ap7 = new StringBuilder();
    MarbleSolitaireView view7 = new TriangleSolitaireTextView(m7, ap7);

    MarbleSolitaireController controller7 = new MarbleSolitaireControllerImpl(m7, view7, in7);

    controller7.playGame();

    assertEquals("    O",
            ap7.toString().split("\n")[7]);
    assertEquals("   _ O",
            ap7.toString().split("\n")[8]);
    assertEquals("  _ O O",
            ap7.toString().split("\n")[9]);
    assertEquals(" O O O O",
            ap7.toString().split("\n")[10]);
    assertEquals("O O O O O",
            ap7.toString().split("\n")[11]);
    assertEquals("Score: 13",
            ap7.toString().split("\n")[12]);
    assertEquals("Game quit!",
            ap7.toString().split("\n")[13]);
    assertEquals("State of game when quit:",
            ap7.toString().split("\n")[14]);
    assertEquals("    O",
            ap7.toString().split("\n")[15]);
    assertEquals("   _ O",
            ap7.toString().split("\n")[16]);
    assertEquals("  _ O O",
            ap7.toString().split("\n")[17]);
    assertEquals(" O O O O",
            ap7.toString().split("\n")[18]);
    assertEquals("O O O O O",
            ap7.toString().split("\n")[19]);
    assertEquals("Score: 13",
            ap7.toString().split("\n")[20]);
  }

  @Test
  public void testValidInputs() {
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel m = new EnglishSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MockSolitaireModel(log);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);

    controller.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log.toString());

    Reader in2 = new StringReader("4 2 4 q");
    MarbleSolitaireModel m2 = new EnglishSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(m2, ap2);

    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireModel mock2 = new MockSolitaireModel(log2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(mock2, view2, in2);

    controller2.playGame();
    assertEquals("", log2.toString());

    Reader in3 = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel m3 = new EnglishSolitaireModel();
    Appendable ap3 = new StringBuilder();
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(m3, ap3);

    StringBuilder log3 = new StringBuilder();
    MarbleSolitaireModel mock3 = new MockSolitaireModel(log3);

    MarbleSolitaireController controller3 = new MarbleSolitaireControllerImpl(mock3, view3, in3);

    controller3.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log3.toString());

    Reader in4 = new StringReader("4 q");
    MarbleSolitaireModel m4 = new EnglishSolitaireModel();
    Appendable ap4 = new StringBuilder();
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(m4, ap4);

    StringBuilder log4 = new StringBuilder();
    MarbleSolitaireModel mock4 = new MockSolitaireModel(log4);

    MarbleSolitaireController controller4 = new MarbleSolitaireControllerImpl(mock4, view4, in4);

    controller4.playGame();
    assertEquals("", log4.toString());

    Reader in5 = new StringReader("a q");
    MarbleSolitaireModel m5 = new EnglishSolitaireModel();
    Appendable ap5 = new StringBuilder();
    MarbleSolitaireView view5 = new MarbleSolitaireTextView(m5, ap5);

    StringBuilder log5 = new StringBuilder();
    MarbleSolitaireModel mock5 = new MockSolitaireModel(log5);

    MarbleSolitaireController controller5 = new MarbleSolitaireControllerImpl(mock5, view5, in5);

    controller5.playGame();
    assertEquals("", log5.toString());

    Reader in6 = new StringReader("4 4 q");
    MarbleSolitaireModel m6 = new EnglishSolitaireModel();
    Appendable ap6 = new StringBuilder();
    MarbleSolitaireView view6 = new MarbleSolitaireTextView(m6, ap6);

    StringBuilder log6 = new StringBuilder();
    MarbleSolitaireModel mock6 = new MockSolitaireModel(log6);

    MarbleSolitaireController controller6 = new MarbleSolitaireControllerImpl(mock6, view6, in6);

    controller6.playGame();
    assertEquals("", log6.toString());
  }

  @Test
  public void testValidEuro() {
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel m = new EuropeanSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MockSolitaireModel(log);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);

    controller.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log.toString());

    Reader in2 = new StringReader("4 2 4 q");
    MarbleSolitaireModel m2 = new EuropeanSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(m2, ap2);

    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireModel mock2 = new MockSolitaireModel(log2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(mock2, view2, in2);

    controller2.playGame();
    assertEquals("", log2.toString());

    Reader in3 = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel m3 = new EuropeanSolitaireModel();
    Appendable ap3 = new StringBuilder();
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(m3, ap3);

    StringBuilder log3 = new StringBuilder();
    MarbleSolitaireModel mock3 = new MockSolitaireModel(log3);

    MarbleSolitaireController controller3 = new MarbleSolitaireControllerImpl(mock3, view3, in3);

    controller3.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log3.toString());

    Reader in4 = new StringReader("4 q");
    MarbleSolitaireModel m4 = new EuropeanSolitaireModel();
    Appendable ap4 = new StringBuilder();
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(m4, ap4);

    StringBuilder log4 = new StringBuilder();
    MarbleSolitaireModel mock4 = new MockSolitaireModel(log4);

    MarbleSolitaireController controller4 = new MarbleSolitaireControllerImpl(mock4, view4, in4);

    controller4.playGame();
    assertEquals("", log4.toString());

    Reader in5 = new StringReader("a q");
    MarbleSolitaireModel m5 = new EuropeanSolitaireModel();
    Appendable ap5 = new StringBuilder();
    MarbleSolitaireView view5 = new MarbleSolitaireTextView(m5, ap5);

    StringBuilder log5 = new StringBuilder();
    MarbleSolitaireModel mock5 = new MockSolitaireModel(log5);

    MarbleSolitaireController controller5 = new MarbleSolitaireControllerImpl(mock5, view5, in5);

    controller5.playGame();
    assertEquals("", log5.toString());

    Reader in6 = new StringReader("4 4 q");
    MarbleSolitaireModel m6 = new EuropeanSolitaireModel();
    Appendable ap6 = new StringBuilder();
    MarbleSolitaireView view6 = new MarbleSolitaireTextView(m6, ap6);

    StringBuilder log6 = new StringBuilder();
    MarbleSolitaireModel mock6 = new MockSolitaireModel(log6);

    MarbleSolitaireController controller6 = new MarbleSolitaireControllerImpl(mock6, view6, in6);

    controller6.playGame();
    assertEquals("", log6.toString());
  }

  @Test
  public void testValidTri() {
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(m, ap);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MockSolitaireModel(log);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);

    controller.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log.toString());

    Reader in2 = new StringReader("4 2 4 q");
    MarbleSolitaireModel m2 = new TriangleSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new TriangleSolitaireTextView(m2, ap2);

    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireModel mock2 = new MockSolitaireModel(log2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(mock2, view2, in2);

    controller2.playGame();
    assertEquals("", log2.toString());

    Reader in3 = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel m3 = new TriangleSolitaireModel();
    Appendable ap3 = new StringBuilder();
    MarbleSolitaireView view3 = new TriangleSolitaireTextView(m3, ap3);

    StringBuilder log3 = new StringBuilder();
    MarbleSolitaireModel mock3 = new MockSolitaireModel(log3);

    MarbleSolitaireController controller3 = new MarbleSolitaireControllerImpl(mock3, view3, in3);

    controller3.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log3.toString());

    Reader in4 = new StringReader("4 q");
    MarbleSolitaireModel m4 = new TriangleSolitaireModel();
    Appendable ap4 = new StringBuilder();
    MarbleSolitaireView view4 = new TriangleSolitaireTextView(m4, ap4);

    StringBuilder log4 = new StringBuilder();
    MarbleSolitaireModel mock4 = new MockSolitaireModel(log4);

    MarbleSolitaireController controller4 = new MarbleSolitaireControllerImpl(mock4, view4, in4);

    controller4.playGame();
    assertEquals("", log4.toString());

    Reader in5 = new StringReader("a q");
    MarbleSolitaireModel m5 = new TriangleSolitaireModel();
    Appendable ap5 = new StringBuilder();
    MarbleSolitaireView view5 = new TriangleSolitaireTextView(m5, ap5);

    StringBuilder log5 = new StringBuilder();
    MarbleSolitaireModel mock5 = new MockSolitaireModel(log5);

    MarbleSolitaireController controller5 = new MarbleSolitaireControllerImpl(mock5, view5, in5);

    controller5.playGame();
    assertEquals("", log5.toString());

    Reader in6 = new StringReader("4 4 q");
    MarbleSolitaireModel m6 = new TriangleSolitaireModel();
    Appendable ap6 = new StringBuilder();
    MarbleSolitaireView view6 = new TriangleSolitaireTextView(m6, ap6);

    StringBuilder log6 = new StringBuilder();
    MarbleSolitaireModel mock6 = new MockSolitaireModel(log6);

    MarbleSolitaireController controller6 = new MarbleSolitaireControllerImpl(mock6, view6, in6);

    controller6.playGame();
    assertEquals("", log6.toString());
  }

  @Test
  public void testValidMockInitialization() {
    StringBuilder log = new StringBuilder("a");
    MockSolitaireModel m = new MockSolitaireModel(log);

    assertEquals("a", log.toString());
  }

  @Test
  public void testInvalidMockInitialization() {
    try {
      new MockSolitaireModel(null);
    } catch (NullPointerException n) {
      assertNull(n.getMessage());
    }
  }

  @Test
  public void testValidControllerInitialization() {
    MarbleSolitaireModel m = new EnglishSolitaireModel();
    MarbleSolitaireView v = new MarbleSolitaireTextView(m);
    Readable r = new StringReader("4 2 4 4 q");

    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(m, v, r);
    c.playGame();
    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", v.toString());

    MarbleSolitaireModel m2 = new EuropeanSolitaireModel();
    MarbleSolitaireView v2 = new MarbleSolitaireTextView(m2);
    Readable r2 = new StringReader("4 2 4 4 q");

    MarbleSolitaireController c2 = new MarbleSolitaireControllerImpl(m2, v2, r2);
    c2.playGame();
    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", v2.toString());

    MarbleSolitaireModel m3 = new TriangleSolitaireModel();
    MarbleSolitaireView v3 = new TriangleSolitaireTextView(m3);
    Readable r3 = new StringReader("3 1 1 1 q");

    MarbleSolitaireController c3 = new MarbleSolitaireControllerImpl(m3, v3, r3);
    c3.playGame();
    assertEquals(
            "    O\n" +
                    "   _ O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O", v3.toString());
  }

  @Test
  public void testInvalidControllerInitialization() {
    MarbleSolitaireModel m = new EnglishSolitaireModel();
    MarbleSolitaireView v = new MarbleSolitaireTextView(m);
    MarbleSolitaireModel m2 = new EuropeanSolitaireModel();
    MarbleSolitaireView v2 = new MarbleSolitaireTextView(m2);
    MarbleSolitaireModel t = new TriangleSolitaireModel();
    MarbleSolitaireView vt = new TriangleSolitaireTextView(t);
    Readable r = new InputStreamReader(System.in);

    try {
      new MarbleSolitaireControllerImpl(null, v, r);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("model is null", e.getMessage());
    }

    try {
      new MarbleSolitaireControllerImpl(null, v2, r);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("model is null", e.getMessage());
    }

    try {
      new MarbleSolitaireControllerImpl(null, vt, r);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("model is null", e.getMessage());
    }

    try {
      new MarbleSolitaireControllerImpl(m, null, r);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("view is null", e.getMessage());
    }

    try {
      new MarbleSolitaireControllerImpl(m2, null, r);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("view is null", e.getMessage());
    }

    try {
      new MarbleSolitaireControllerImpl(t, null, r);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("view is null", e.getMessage());
    }

    try {
      new MarbleSolitaireControllerImpl(m, v, null);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("readable is null", e.getMessage());
    }

    try {
      new MarbleSolitaireControllerImpl(m2, v2, null);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("readable is null", e.getMessage());
    }

    try {
      new MarbleSolitaireControllerImpl(t, vt, null);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("readable is null", e.getMessage());
    }
  }

  @Test
  public void testMessyValidInputs() {
    Reader in = new StringReader("4 2 e 4 4 q");
    MarbleSolitaireModel m = new EnglishSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MockSolitaireModel(log);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);

    controller.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log.toString());

    Reader in2 = new StringReader("4 w 2 4 4 q");
    MarbleSolitaireModel m2 = new EnglishSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(m2, ap2);

    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireModel mock2 = new MockSolitaireModel(log2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(mock2, view2, in2);

    controller2.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log2.toString());

    Reader in3 = new StringReader("4 2 4 & 4 q");
    MarbleSolitaireModel m3 = new EnglishSolitaireModel();
    Appendable ap3 = new StringBuilder();
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(m3, ap3);

    StringBuilder log3 = new StringBuilder();
    MarbleSolitaireModel mock3 = new MockSolitaireModel(log3);

    MarbleSolitaireController controller3 = new MarbleSolitaireControllerImpl(mock3, view3, in3);

    controller3.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log3.toString());

    Reader in4 = new StringReader("' 4 2 4 4 q");
    MarbleSolitaireModel m4 = new EnglishSolitaireModel();
    Appendable ap4 = new StringBuilder();
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(m4, ap4);

    StringBuilder log4 = new StringBuilder();
    MarbleSolitaireModel mock4 = new MockSolitaireModel(log4);

    MarbleSolitaireController controller4 = new MarbleSolitaireControllerImpl(mock4, view4, in4);

    controller4.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log4.toString());

    Reader in5 = new StringReader("4 2 4 4 b q");
    MarbleSolitaireModel m5 = new EnglishSolitaireModel();
    Appendable ap5 = new StringBuilder();
    MarbleSolitaireView view5 = new MarbleSolitaireTextView(m5, ap5);

    StringBuilder log5 = new StringBuilder();
    MarbleSolitaireModel mock5 = new MockSolitaireModel(log5);

    MarbleSolitaireController controller5 = new MarbleSolitaireControllerImpl(mock5, view5, in5);

    controller5.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log4.toString());

    Reader in6 = new StringReader("4 2 e 4 4 e r 4 5 r 4 3 2 q");
    MarbleSolitaireModel m6 = new EnglishSolitaireModel();
    Appendable ap6 = new StringBuilder();
    MarbleSolitaireView view6 = new MarbleSolitaireTextView(m6, ap6);

    StringBuilder log6 = new StringBuilder();
    MarbleSolitaireModel mock6 = new MockSolitaireModel(log6);

    MarbleSolitaireController controller6 = new MarbleSolitaireControllerImpl(mock6, view6, in6);

    controller6.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3" +
            "From Row: 3, From Col: 4, To Row: 3, To Col: 2", log6.toString());

    Reader in7 = new StringReader("4 2 4 b q");
    MarbleSolitaireModel m7 = new EnglishSolitaireModel();
    Appendable ap7 = new StringBuilder();
    MarbleSolitaireView view7 = new MarbleSolitaireTextView(m7, ap7);

    StringBuilder log7 = new StringBuilder();
    MarbleSolitaireModel mock7 = new MockSolitaireModel(log7);

    MarbleSolitaireController controller7 = new MarbleSolitaireControllerImpl(mock7, view7, in7);

    controller7.playGame();
    assertEquals("", log7.toString());
  }

  @Test
  public void testMessyEuro() {
    Reader in = new StringReader("4 2 e 4 4 q");
    MarbleSolitaireModel m = new EuropeanSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MockSolitaireModel(log);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);

    controller.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log.toString());

    Reader in2 = new StringReader("4 w 2 4 4 q");
    MarbleSolitaireModel m2 = new EuropeanSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(m2, ap2);

    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireModel mock2 = new MockSolitaireModel(log2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(mock2, view2, in2);

    controller2.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log2.toString());

    Reader in3 = new StringReader("4 2 4 & 4 q");
    MarbleSolitaireModel m3 = new EuropeanSolitaireModel();
    Appendable ap3 = new StringBuilder();
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(m3, ap3);

    StringBuilder log3 = new StringBuilder();
    MarbleSolitaireModel mock3 = new MockSolitaireModel(log3);

    MarbleSolitaireController controller3 = new MarbleSolitaireControllerImpl(mock3, view3, in3);

    controller3.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log3.toString());

    Reader in4 = new StringReader("' 4 2 4 4 q");
    MarbleSolitaireModel m4 = new EuropeanSolitaireModel();
    Appendable ap4 = new StringBuilder();
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(m4, ap4);

    StringBuilder log4 = new StringBuilder();
    MarbleSolitaireModel mock4 = new MockSolitaireModel(log4);

    MarbleSolitaireController controller4 = new MarbleSolitaireControllerImpl(mock4, view4, in4);

    controller4.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log4.toString());

    Reader in5 = new StringReader("4 2 4 4 b q");
    MarbleSolitaireModel m5 = new EuropeanSolitaireModel();
    Appendable ap5 = new StringBuilder();
    MarbleSolitaireView view5 = new MarbleSolitaireTextView(m5, ap5);

    StringBuilder log5 = new StringBuilder();
    MarbleSolitaireModel mock5 = new MockSolitaireModel(log5);

    MarbleSolitaireController controller5 = new MarbleSolitaireControllerImpl(mock5, view5, in5);

    controller5.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log4.toString());

    Reader in6 = new StringReader("4 2 e 4 4 e r 4 5 r 4 3 2 q");
    MarbleSolitaireModel m6 = new EuropeanSolitaireModel();
    Appendable ap6 = new StringBuilder();
    MarbleSolitaireView view6 = new MarbleSolitaireTextView(m6, ap6);

    StringBuilder log6 = new StringBuilder();
    MarbleSolitaireModel mock6 = new MockSolitaireModel(log6);

    MarbleSolitaireController controller6 = new MarbleSolitaireControllerImpl(mock6, view6, in6);

    controller6.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3" +
            "From Row: 3, From Col: 4, To Row: 3, To Col: 2", log6.toString());

    Reader in7 = new StringReader("4 2 4 b q");
    MarbleSolitaireModel m7 = new EuropeanSolitaireModel();
    Appendable ap7 = new StringBuilder();
    MarbleSolitaireView view7 = new MarbleSolitaireTextView(m7, ap7);

    StringBuilder log7 = new StringBuilder();
    MarbleSolitaireModel mock7 = new MockSolitaireModel(log7);

    MarbleSolitaireController controller7 = new MarbleSolitaireControllerImpl(mock7, view7, in7);

    controller7.playGame();
    assertEquals("", log7.toString());
  }

  @Test
  public void testMessyTri() {
    Reader in = new StringReader("4 2 e 4 4 q");
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(m, ap);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MockSolitaireModel(log);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);

    controller.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log.toString());

    Reader in2 = new StringReader("4 w 2 4 4 q");
    MarbleSolitaireModel m2 = new TriangleSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new TriangleSolitaireTextView(m2, ap2);

    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireModel mock2 = new MockSolitaireModel(log2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(mock2, view2, in2);

    controller2.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log2.toString());

    Reader in3 = new StringReader("4 2 4 & 4 q");
    MarbleSolitaireModel m3 = new TriangleSolitaireModel();
    Appendable ap3 = new StringBuilder();
    MarbleSolitaireView view3 = new TriangleSolitaireTextView(m3, ap3);

    StringBuilder log3 = new StringBuilder();
    MarbleSolitaireModel mock3 = new MockSolitaireModel(log3);

    MarbleSolitaireController controller3 = new MarbleSolitaireControllerImpl(mock3, view3, in3);

    controller3.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log3.toString());

    Reader in4 = new StringReader("' 4 2 4 4 q");
    MarbleSolitaireModel m4 = new TriangleSolitaireModel();
    Appendable ap4 = new StringBuilder();
    MarbleSolitaireView view4 = new TriangleSolitaireTextView(m4, ap4);

    StringBuilder log4 = new StringBuilder();
    MarbleSolitaireModel mock4 = new MockSolitaireModel(log4);

    MarbleSolitaireController controller4 = new MarbleSolitaireControllerImpl(mock4, view4, in4);

    controller4.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log4.toString());

    Reader in5 = new StringReader("4 2 4 4 b q");
    MarbleSolitaireModel m5 = new TriangleSolitaireModel();
    Appendable ap5 = new StringBuilder();
    MarbleSolitaireView view5 = new TriangleSolitaireTextView(m5, ap5);

    StringBuilder log5 = new StringBuilder();
    MarbleSolitaireModel mock5 = new MockSolitaireModel(log5);

    MarbleSolitaireController controller5 = new MarbleSolitaireControllerImpl(mock5, view5, in5);

    controller5.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3", log4.toString());

    Reader in6 = new StringReader("4 2 e 4 4 e r 4 5 r 4 3 2 q");
    MarbleSolitaireModel m6 = new TriangleSolitaireModel();
    Appendable ap6 = new StringBuilder();
    MarbleSolitaireView view6 = new TriangleSolitaireTextView(m6, ap6);

    StringBuilder log6 = new StringBuilder();
    MarbleSolitaireModel mock6 = new MockSolitaireModel(log6);

    MarbleSolitaireController controller6 = new MarbleSolitaireControllerImpl(mock6, view6, in6);

    controller6.playGame();
    assertEquals("From Row: 3, From Col: 1, To Row: 3, To Col: 3" +
            "From Row: 3, From Col: 4, To Row: 3, To Col: 2", log6.toString());

    Reader in7 = new StringReader("4 2 4 b q");
    MarbleSolitaireModel m7 = new TriangleSolitaireModel();
    Appendable ap7 = new StringBuilder();
    MarbleSolitaireView view7 = new TriangleSolitaireTextView(m7, ap7);

    StringBuilder log7 = new StringBuilder();
    MarbleSolitaireModel mock7 = new MockSolitaireModel(log7);

    MarbleSolitaireController controller7 = new MarbleSolitaireControllerImpl(mock7, view7, in7);

    controller7.playGame();
    assertEquals("", log7.toString());
  }

  @Test
  public void testInvalidInputs() {
    Reader in = new StringReader("e q");
    MarbleSolitaireModel m = new EnglishSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MockSolitaireModel(log);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);

    controller.playGame();

    assertEquals("Type in your from and to co-ordinates or 'q' to quit",
            ap.toString().split("\n")[0]);
    assertEquals("    O O O",
            ap.toString().split("\n")[1]);
    assertEquals("    O O O",
            ap.toString().split("\n")[2]);
    assertEquals("O O O O O O O",
            ap.toString().split("\n")[3]);
    assertEquals("O O O _ O O O",
            ap.toString().split("\n")[4]);
    assertEquals("O O O O O O O",
            ap.toString().split("\n")[5]);
    assertEquals("    O O O",
            ap.toString().split("\n")[6]);
    assertEquals("    O O O",
            ap.toString().split("\n")[7]);
    assertEquals("Score: 0",
            ap.toString().split("\n")[8]);
    assertEquals("Please re-enter numbers",
            ap.toString().split("\n")[9]);

    Reader in2 = new StringReader("% q");
    MarbleSolitaireModel m2 = new EnglishSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(m2, ap2);

    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireModel mock2 = new MockSolitaireModel(log2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(mock2, view2, in2);

    controller2.playGame();

    assertEquals("Type in your from and to co-ordinates or 'q' to quit",
            ap2.toString().split("\n")[0]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[1]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[2]);
    assertEquals("O O O O O O O",
            ap2.toString().split("\n")[3]);
    assertEquals("O O O _ O O O",
            ap2.toString().split("\n")[4]);
    assertEquals("O O O O O O O",
            ap2.toString().split("\n")[5]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[6]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[7]);
    assertEquals("Score: 0",
            ap2.toString().split("\n")[8]);
    assertEquals("Please re-enter numbers",
            ap2.toString().split("\n")[9]);
  }

  @Test
  public void testInvalidEuro() {
    Reader in = new StringReader("e q");
    MarbleSolitaireModel m = new EuropeanSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MockSolitaireModel(log);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);

    controller.playGame();

    assertEquals("Type in your from and to co-ordinates or 'q' to quit",
            ap.toString().split("\n")[0]);
    assertEquals("    O O O",
            ap.toString().split("\n")[1]);
    assertEquals("  O O O O O",
            ap.toString().split("\n")[2]);
    assertEquals("O O O O O O O",
            ap.toString().split("\n")[3]);
    assertEquals("O O O _ O O O",
            ap.toString().split("\n")[4]);
    assertEquals("O O O O O O O",
            ap.toString().split("\n")[5]);
    assertEquals("  O O O O O",
            ap.toString().split("\n")[6]);
    assertEquals("    O O O",
            ap.toString().split("\n")[7]);
    assertEquals("Score: 0",
            ap.toString().split("\n")[8]);
    assertEquals("Please re-enter numbers",
            ap.toString().split("\n")[9]);

    Reader in2 = new StringReader("% q");
    MarbleSolitaireModel m2 = new EuropeanSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(m2, ap2);

    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireModel mock2 = new MockSolitaireModel(log2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(mock2, view2, in2);

    controller2.playGame();

    assertEquals("Type in your from and to co-ordinates or 'q' to quit",
            ap2.toString().split("\n")[0]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[1]);
    assertEquals("  O O O O O",
            ap2.toString().split("\n")[2]);
    assertEquals("O O O O O O O",
            ap2.toString().split("\n")[3]);
    assertEquals("O O O _ O O O",
            ap2.toString().split("\n")[4]);
    assertEquals("O O O O O O O",
            ap2.toString().split("\n")[5]);
    assertEquals("  O O O O O",
            ap2.toString().split("\n")[6]);
    assertEquals("    O O O",
            ap2.toString().split("\n")[7]);
    assertEquals("Score: 0",
            ap2.toString().split("\n")[8]);
    assertEquals("Please re-enter numbers",
            ap2.toString().split("\n")[9]);
  }

  @Test
  public void testInvalidTri() {
    Reader in = new StringReader("b q");
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(m, ap);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MockSolitaireModel(log);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);

    controller.playGame();

    assertEquals("Type in your from and to co-ordinates or 'q' to quit",
            ap.toString().split("\n")[0]);
    assertEquals("    _",
            ap.toString().split("\n")[1]);
    assertEquals("   O O",
            ap.toString().split("\n")[2]);
    assertEquals("  O O O",
            ap.toString().split("\n")[3]);
    assertEquals(" O O O O",
            ap.toString().split("\n")[4]);
    assertEquals("O O O O O",
            ap.toString().split("\n")[5]);
    assertEquals("Score: 0",
            ap.toString().split("\n")[6]);
    assertEquals("Please re-enter numbers",
            ap.toString().split("\n")[7]);

    Reader in2 = new StringReader("( q");
    MarbleSolitaireModel m2 = new TriangleSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new TriangleSolitaireTextView(m2, ap2);

    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireModel mock2 = new MockSolitaireModel(log2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(mock2, view2, in2);

    controller2.playGame();

    assertEquals("Type in your from and to co-ordinates or 'q' to quit",
            ap.toString().split("\n")[0]);
    assertEquals("    _",
            ap.toString().split("\n")[1]);
    assertEquals("   O O",
            ap.toString().split("\n")[2]);
    assertEquals("  O O O",
            ap.toString().split("\n")[3]);
    assertEquals(" O O O O",
            ap.toString().split("\n")[4]);
    assertEquals("O O O O O",
            ap.toString().split("\n")[5]);
    assertEquals("Score: 0",
            ap.toString().split("\n")[6]);
    assertEquals("Please re-enter numbers",
            ap.toString().split("\n")[7]);
  }

  @Test
  public void testInvalidMoves() {
    Reader in = new StringReader("2 3 -1 4 q");
    MarbleSolitaireModel m = new EnglishSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(m, view, in);

    controller.playGame();
    assertEquals("Invalid move. Play again. Co-ordinates invalid",
            ap.toString().split("\n")[9]);

    Reader in2 = new StringReader("3 1 3 3 q");
    MarbleSolitaireModel m2 = new EnglishSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(m2, ap2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(m2, view2, in2);

    controller2.playGame();
    assertEquals("Invalid move. Play again. Co-ordinates invalid",
            ap.toString().split("\n")[9]);
  }

  @Test
  public void testInvalidMovesEuro() {
    Reader in = new StringReader("2 3 -1 4 q");
    MarbleSolitaireModel m = new EuropeanSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(m, view, in);

    controller.playGame();
    assertEquals("Invalid move. Play again. Co-ordinates invalid",
            ap.toString().split("\n")[9]);

    Reader in2 = new StringReader("3 1 3 3 q");
    MarbleSolitaireModel m2 = new EuropeanSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(m2, ap2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(m2, view2, in2);

    controller2.playGame();
    assertEquals("Invalid move. Play again. Co-ordinates invalid",
            ap.toString().split("\n")[9]);
  }

  @Test
  public void testInvalidMovesTri() {
    Reader in = new StringReader("2 3 -1 4 q");
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(m, ap);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(m, view, in);

    controller.playGame();
    assertEquals("Invalid move. Play again. Invalid Co-ordinates",
            ap.toString().split("\n")[7]);

    Reader in2 = new StringReader("3 1 3 3 q");
    MarbleSolitaireModel m2 = new TriangleSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new TriangleSolitaireTextView(m2, ap2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(m2, view2, in2);

    controller2.playGame();
    assertEquals("Invalid move. Play again. Invalid Co-ordinates",
            ap.toString().split("\n")[7]);
  }

  @Test
  public void testGameOverMessage() {
    Reader in = new StringReader("6 4 4 4 " +
            "3 4 5 4 " +
            "1 4 3 4 " +
            "4 6 4 4 " +
            "4 3 4 5 " +
            "4 1 4 3 " +
            "q");
    MarbleSolitaireModel m = new EnglishSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(m, view, in);

    controller.playGame();
    assertEquals("Game over!",
            ap.toString().split("\n")[57]);
    assertEquals("    O _ O",
            ap.toString().split("\n")[58]);
    assertEquals("    O _ O",
            ap.toString().split("\n")[59]);
    assertEquals("O O O O O O O",
            ap.toString().split("\n")[60]);
    assertEquals("_ _ O _ O _ O",
            ap.toString().split("\n")[61]);
    assertEquals("O O O O O O O",
            ap.toString().split("\n")[62]);
    assertEquals("    O _ O",
            ap.toString().split("\n")[63]);
    assertEquals("    O O O",
            ap.toString().split("\n")[64]);
    assertEquals("Score: 26",
            ap.toString().split("\n")[65]);
  }

  @Test
  public void testGameOverEuro() {
    Reader in = new StringReader("6 4 4 4 " + "3 4 5 4 " + "1 4 3 4 " + "4 6 4 4 " +
            "4 3 4 5 " + "4 1 4 3 " + "2 2 4 2 " + "2 6 4 6 " +
            "5 2 3 2 " + "5 6 3 6 " + "6 6 6 4 " + "5 4 5 6 " +
            "5 7 5 5 " + "6 3 6 5 " + "4 3 6 3 " + "6 2 6 4 " +
            "6 5 6 3 " + "4 5 6 5 " + "7 5 5 5 " + "7 3 5 3 " +
            "2 3 4 3 " + "2 5 4 5 " + "5 3 3 3 " + "5 5 3 5 " +
            "3 7 5 7 " + "3 5 3 7 " + "3 3 3 5 " + "3 1 3 3 " +
            "q");
    MarbleSolitaireModel m = new EuropeanSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(m, view, in);

    controller.playGame();

    assertEquals("Game over!",
            ap.toString().split("\n")[233]);
    assertEquals("    O _ O",
            ap.toString().split("\n")[234]);
    assertEquals("  _ _ _ _ _",
            ap.toString().split("\n")[235]);
    assertEquals("_ _ O _ O _ O",
            ap.toString().split("\n")[236]);
    assertEquals("_ _ _ _ _ _ _",
            ap.toString().split("\n")[237]);
    assertEquals("O _ _ _ _ _ O",
            ap.toString().split("\n")[238]);
    assertEquals("  _ _ _ _ _",
            ap.toString().split("\n")[239]);
    assertEquals("    _ O _",
            ap.toString().split("\n")[240]);
    assertEquals("Score: 8",
            ap.toString().split("\n")[241]);
  }

  @Test
  public void testGameOverTri() {
    Reader in = new StringReader("3 3 1 1 " +
            "3 1 3 3 " +
            "1 1 3 1 " +
            "5 4 3 2 " +
            "4 1 4 3 " +
            "3 2 5 4 " +
            "4 4 2 2 " +
            "q");
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(m, ap);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(m, view, in);

    controller.playGame();
    assertEquals("Game over!",
            ap.toString().split("\n")[49]);
    assertEquals("    _",
            ap.toString().split("\n")[50]);
    assertEquals("   _ O",
            ap.toString().split("\n")[51]);
    assertEquals("  O _ _",
            ap.toString().split("\n")[52]);
    assertEquals(" _ _ _ _",
            ap.toString().split("\n")[53]);
    assertEquals("O O O O O",
            ap.toString().split("\n")[54]);
    assertEquals("Score: 7",
            ap.toString().split("\n")[55]);
  }

  @Test
  public void testNoSuchElement() {
    Reader in = new StringReader("");
    MarbleSolitaireModel m = new EnglishSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(m, view, in);
    try {
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals("no such element", e.getMessage());
    }

    Reader in2 = new StringReader("");
    MarbleSolitaireModel m2 = new EuropeanSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(m2, ap2);

    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(m2, view2, in2);
    try {
      controller2.playGame();
    } catch (IllegalStateException e) {
      assertEquals("no such element", e.getMessage());
    }

    Reader in3 = new StringReader("");
    MarbleSolitaireModel m3 = new TriangleSolitaireModel();
    Appendable ap3 = new StringBuilder();
    MarbleSolitaireView view3 = new TriangleSolitaireTextView(m3, ap3);

    MarbleSolitaireController controller3 = new MarbleSolitaireControllerImpl(m3, view3, in3);
    try {
      controller3.playGame();
    } catch (IllegalStateException e) {
      assertEquals("no such element", e.getMessage());
    }
  }

  @Test
  public void testIOException() {
    Reader in = new InputStreamReader(System.in);
    MarbleSolitaireModel m = new EnglishSolitaireModel();
    Appendable ap = new MockAppendable();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, ap);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(m, view, in);

    try {
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals("IO Exception", e.getMessage());
    }

    Reader in2 = new InputStreamReader(System.in);
    MarbleSolitaireModel m2 = new EuropeanSolitaireModel();
    Appendable ap2 = new MockAppendable();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(m2, ap2);
    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(m2, view2, in2);

    try {
      controller2.playGame();
    } catch (IllegalStateException e) {
      assertEquals("IO Exception", e.getMessage());
    }

    Reader in3 = new InputStreamReader(System.in);
    MarbleSolitaireModel m3 = new TriangleSolitaireModel();
    Appendable ap3 = new MockAppendable();
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(m3, ap3);
    MarbleSolitaireController controller3 = new MarbleSolitaireControllerImpl(m3, view3, in3);

    try {
      controller3.playGame();
    } catch (IllegalStateException e) {
      assertEquals("IO Exception", e.getMessage());
    }
  }
}