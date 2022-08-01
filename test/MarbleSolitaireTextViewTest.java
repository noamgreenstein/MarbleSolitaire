import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * tests {@code MarbleSolitaireTextView} with English and European boards.
 */
public class MarbleSolitaireTextViewTest {

  @Test
  public void testToString() {
    MarbleSolitaireModel e = new EnglishSolitaireModel();
    e.move(3, 1, 3, 3);
    MarbleSolitaireTextView v = new MarbleSolitaireTextView(e);
    assertEquals(v.toString(),
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O");

    EnglishSolitaireModel e1 = new EnglishSolitaireModel(4, 4);
    MarbleSolitaireTextView v1 = new MarbleSolitaireTextView(e1);
    assertEquals(v1.toString(),
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ O O\n" +
                    "    O O O\n" +
                    "    O O O");


    EnglishSolitaireModel e2 = new EnglishSolitaireModel(7, 6, 1);
    e2.move(6, 3, 6, 1);
    MarbleSolitaireTextView v2 = new MarbleSolitaireTextView(e2);
    assertEquals(v2.toString(),
            "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "O O _ _ O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O");

    EnglishSolitaireModel e3 = new EnglishSolitaireModel(5);
    e3.move(6, 4, 6, 6);
    MarbleSolitaireTextView v3 = new MarbleSolitaireTextView(e3);
    assertEquals(v3.toString(), "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O _ _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O");

    EnglishSolitaireModel e4 = new EnglishSolitaireModel();
    MarbleSolitaireTextView v4 = new MarbleSolitaireTextView(e4);
    assertEquals(v4.toString(),
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O");

    MarbleSolitaireModel eu = new EuropeanSolitaireModel();
    MarbleSolitaireTextView euv = new MarbleSolitaireTextView(eu);
    assertEquals(euv.toString(),
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O");
    eu.move(1, 3, 3, 3);
    assertEquals(euv.toString(),
            "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O");

    MarbleSolitaireModel eu2 = new EuropeanSolitaireModel(1, 1);
    MarbleSolitaireTextView euv2 = new MarbleSolitaireTextView(eu2);
    assertEquals(euv2.toString(),
            "    O O O\n" +
                    "  _ O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O");
    eu2.move(1, 3, 1, 1);
    assertEquals(euv2.toString(),
            "    O O O\n" +
                    "  O _ _ O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O");

    MarbleSolitaireModel eu3 = new EuropeanSolitaireModel(5);
    MarbleSolitaireTextView euv3 = new MarbleSolitaireTextView(eu3);
    assertEquals(euv3.toString(),
            "        O O O O O\n" +
                    "      O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "  O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "      O O O O O O O\n" +
                    "        O O O O O");
    eu3.move(6, 4, 6, 6);
    assertEquals(euv3.toString(),
            "        O O O O O\n" +
                    "      O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "  O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O _ _ O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "      O O O O O O O\n" +
                    "        O O O O O");
    MarbleSolitaireModel eu4 = new EuropeanSolitaireModel(7, 14, 14);
    MarbleSolitaireTextView euv4 = new MarbleSolitaireTextView(eu4);
    assertEquals(euv4.toString(),
            "            O O O O O O O\n" +
                    "          O O O O O O O O O\n" +
                    "        O O O O O O O O O O O\n" +
                    "      O O O O O O O O O O O O O\n" +
                    "    O O O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O O O O O O O\n" +
                    "    O O O O O O O O O O O O _ O O\n" +
                    "      O O O O O O O O O O O O O\n" +
                    "        O O O O O O O O O O O\n" +
                    "          O O O O O O O O O\n" +
                    "            O O O O O O O");
    eu4.move(14, 12, 14, 14);
    assertEquals(euv4.toString(),
            "            O O O O O O O\n" +
                    "          O O O O O O O O O\n" +
                    "        O O O O O O O O O O O\n" +
                    "      O O O O O O O O O O O O O\n" +
                    "    O O O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O O O O O O O\n" +
                    "    O O O O O O O O O O _ _ O O O\n" +
                    "      O O O O O O O O O O O O O\n" +
                    "        O O O O O O O O O O O\n" +
                    "          O O O O O O O O O\n" +
                    "            O O O O O O O");
  }

  @Test
  public void testRenderBoard() throws IOException {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireTextView v = new MarbleSolitaireTextView(e, ap);
    v.renderBoard();
    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", ap.toString());

    EnglishSolitaireModel e2 = new EnglishSolitaireModel();
    Appendable ap2 = new StringBuilder();
    MarbleSolitaireTextView v2 = new MarbleSolitaireTextView(e2, ap2);
    e2.move(3, 1, 3, 3);
    v2.renderBoard();
    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", ap2.toString());

    MarbleSolitaireModel e3 = new EuropeanSolitaireModel();
    Appendable ap3 = new StringBuilder();
    MarbleSolitaireTextView v3 = new MarbleSolitaireTextView(e3, ap3);
    v3.renderBoard();
    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", ap3.toString());

    MarbleSolitaireModel e4 = new EuropeanSolitaireModel();
    Appendable ap4 = new StringBuilder();
    MarbleSolitaireTextView v4 = new MarbleSolitaireTextView(e4, ap4);
    e4.move(3, 1, 3, 3);
    v4.renderBoard();
    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", ap4.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireTextView v = new MarbleSolitaireTextView(e, ap);
    v.renderMessage("Hello");
    assertEquals(ap.toString(), "Hello");
    v.renderMessage("Hello");
    assertEquals(ap.toString(), "HelloHello");
  }

  @Test
  public void testValidInitialization() {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    MarbleSolitaireTextView v = new MarbleSolitaireTextView(e);
    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", v.toString());

    EnglishSolitaireModel e2 = new EnglishSolitaireModel();
    Appendable ap = new StringBuilder("hello");
    MarbleSolitaireTextView v2 = new MarbleSolitaireTextView(e2, ap);
    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", v2.toString());
    assertEquals("hello", ap.toString());

    MarbleSolitaireModel e3 = new EuropeanSolitaireModel();
    Appendable ap2 = new StringBuilder("hello1");
    MarbleSolitaireTextView v3 = new MarbleSolitaireTextView(e3, ap2);
    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", v3.toString());
    assertEquals("hello1", ap2.toString());
  }

  @Test
  public void testInvalidInitialization() {

    try {
      new MarbleSolitaireTextView(null);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException ex) {
      assertEquals(ex.getMessage(), "board is null");
    }

    EnglishSolitaireModel e = new EnglishSolitaireModel();
    Appendable ap = System.out;
    MarbleSolitaireModel e2 = new EuropeanSolitaireModel();

    try {
      new MarbleSolitaireTextView(null, ap);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException ex) {
      assertEquals("board is null", ex.getMessage());
    }

    try {
      new MarbleSolitaireTextView(e, null);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException ex) {
      assertEquals("appendable is null", ex.getMessage());
    }

    try {
      new MarbleSolitaireTextView(e2, null);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException ex) {
      assertEquals("appendable is null", ex.getMessage());
    }
  }

  @Test
  public void testRenderIOExceptions() {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    Appendable ap = new MockAppendable();
    MarbleSolitaireTextView v = new MarbleSolitaireTextView(e, ap);

    try {
      v.renderMessage("hello");
    } catch (IOException io) {
      assertEquals("IO Exception", io.getMessage());
    }

    try {
      v.renderBoard();
    } catch (IOException io) {
      assertEquals("IO Exception", io.getMessage());
    }
  }
}