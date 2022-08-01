import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests {@code TriangleSolitaireTextView}.
 */
public class TriangleViewTest {

  @Test
  public void testValidInitialization() {
    MarbleSolitaireModel t = new TriangleSolitaireModel();
    MarbleSolitaireView v = new TriangleSolitaireTextView(t);
    assertEquals(
            "    _\n"
                    + "   O O\n"
                    + "  O O O\n"
                    + " O O O O\n"
                    + "O O O O O", v.toString());

    MarbleSolitaireModel t2 = new TriangleSolitaireModel(6);
    Appendable ap = new StringBuilder("hello");
    MarbleSolitaireView v2 = new TriangleSolitaireTextView(t2, ap);
    assertEquals(
            "     _\n"
                    + "    O O\n"
                    + "   O O O\n"
                    + "  O O O O\n"
                    + " O O O O O\n"
                    + "O O O O O O", v2.toString());
    assertEquals("hello", ap.toString());
  }

  @Test
  public void testInvalidInitialization() {
    try {
      new TriangleSolitaireTextView(null);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException ex) {
      assertEquals(ex.getMessage(), "board is null");
    }

    MarbleSolitaireModel t = new TriangleSolitaireModel();
    Appendable ap = System.out;

    try {
      new MarbleSolitaireTextView(null, ap);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException ex) {
      assertEquals("board is null", ex.getMessage());
    }

    try {
      new MarbleSolitaireTextView(t, null);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException ex) {
      assertEquals("appendable is null", ex.getMessage());
    }

  }

  @Test
  public void testToString() {
    MarbleSolitaireModel t = new TriangleSolitaireModel();
    MarbleSolitaireView v = new TriangleSolitaireTextView(t);
    assertEquals(
            "    _\n"
                    + "   O O\n"
                    + "  O O O\n"
                    + " O O O O\n"
                    + "O O O O O", v.toString());
    t.move(2, 0, 0, 0);
    assertEquals(
            "    O\n"
                    + "   _ O\n"
                    + "  _ O O\n"
                    + " O O O O\n"
                    + "O O O O O", v.toString());

    MarbleSolitaireModel t1 = new TriangleSolitaireModel(6);
    MarbleSolitaireView v1 = new TriangleSolitaireTextView(t1);
    assertEquals(
            "     _\n"
                    + "    O O\n"
                    + "   O O O\n"
                    + "  O O O O\n"
                    + " O O O O O\n"
                    + "O O O O O O", v1.toString());
    t1.move(2, 2, 0, 0);
    assertEquals(
            "     O\n"
                    + "    O _\n"
                    + "   O O _\n"
                    + "  O O O O\n"
                    + " O O O O O\n"
                    + "O O O O O O", v1.toString());

    MarbleSolitaireModel t2 = new TriangleSolitaireModel(1, 1);
    MarbleSolitaireView v2 = new TriangleSolitaireTextView(t2);
    assertEquals(
            "    O\n"
                    + "   O _\n"
                    + "  O O O\n"
                    + " O O O O\n"
                    + "O O O O O", v2.toString());
    t2.move(3, 3, 1, 1);
    assertEquals(
            "    O\n"
                    + "   O O\n"
                    + "  O O _\n"
                    + " O O O _\n"
                    + "O O O O O", v2.toString());

    MarbleSolitaireModel t3 = new TriangleSolitaireModel(6, 2, 2);
    MarbleSolitaireView v3 = new TriangleSolitaireTextView(t3);
    assertEquals(
            "     O\n"
                    + "    O O\n"
                    + "   O O _\n"
                    + "  O O O O\n"
                    + " O O O O O\n"
                    + "O O O O O O", v3.toString());
    t3.move(2, 0, 2, 2);
    assertEquals(
            "     O\n"
                    + "    O O\n"
                    + "   _ _ O\n"
                    + "  O O O O\n"
                    + " O O O O O\n"
                    + "O O O O O O", v3.toString());
  }

  @Test
  public void testRenderBoard() throws IOException {
    MarbleSolitaireModel t = new TriangleSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView v = new TriangleSolitaireTextView(t, ap);
    v.renderBoard();
    assertEquals(
            "    _\n"
                    + "   O O\n"
                    + "  O O O\n"
                    + " O O O O\n"
                    + "O O O O O", ap.toString());
    MarbleSolitaireModel t1 = new TriangleSolitaireModel();
    Appendable ap1 = new StringBuilder();
    MarbleSolitaireView v1 = new TriangleSolitaireTextView(t1, ap1);
    t1.move(2, 0, 0, 0);
    v1.renderBoard();
    assertEquals(
            "    O\n"
                    + "   _ O\n"
                    + "  _ O O\n"
                    + " O O O O\n"
                    + "O O O O O", ap1.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    MarbleSolitaireModel t = new TriangleSolitaireModel();
    Appendable ap = new StringBuilder();
    MarbleSolitaireView v = new TriangleSolitaireTextView(t, ap);
    v.renderMessage("Hello");
    assertEquals(ap.toString(), "Hello");
    v.renderMessage("Hello");
    assertEquals(ap.toString(), "HelloHello");
  }

  @Test
  public void testIOExceptions() {
    MarbleSolitaireModel t = new TriangleSolitaireModel();
    Appendable ap = new MockAppendable();
    MarbleSolitaireView v = new TriangleSolitaireTextView(t, ap);

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
