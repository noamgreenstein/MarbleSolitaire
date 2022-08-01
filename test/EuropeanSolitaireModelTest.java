import org.junit.Before;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests {@code EuropeanSolitaireModel}.
 */
public class EuropeanSolitaireModelTest {
  MarbleSolitaireModel e;

  @Before
  public void init() {
    e = new EuropeanSolitaireModel();
  }

  @org.junit.Test
  public void testMakeMarbles() {
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (i < 2 && j < 2 || i > 4 && j < 2 || i < 2 && j > 4 || i > 4 && j > 4) {
          if (i == 1 && j == 1 || i == 1 && j == 5 || i == 5 && j == 1 || i == 5 && j == 5) {
            assertEquals(e.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Marble);
          } else {
            assertEquals(e.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Invalid);
          }
        } else if (i == 3 && j == 3) {
          assertEquals(e.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Empty);
        } else {
          assertEquals(e.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Marble);
        }
      }
    }
  }

  @org.junit.Test
  public void move() {
    assertEquals(e.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    e.move(1, 3, 3, 3);
    assertEquals(e.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(e.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(e.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Empty);
    e.move(2, 1, 2, 3);
    assertEquals(e.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(e.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(e.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Empty);
    e.move(3, 3, 1, 3);
    assertEquals(e.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(e.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(e.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(2, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Empty);
    e.move(2, 5, 2, 3);
    assertEquals(e.getSlotAt(2, 5), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(e.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(e.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    try {
      e.move(2, 3, -1, 4);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Co-ordinates invalid");
    }
    try {
      e.move(2, 0, 2, 2);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "cannot jump here");
    }
    try {
      e.move(3, 0, 4, 0);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Co-ordinates invalid");
    }
    try {
      e.move(3, 0, 3, 2);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Co-ordinates invalid");
    }
    try {
      e.move(2, 2, 2, 4);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Co-ordinates invalid");
    }
    try {
      e.move(-1, 4, 3, 3);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Co-ordinates invalid");
    }
    try {
      e.move(3, 0, 3, 3);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Co-ordinates invalid");
    }
    try {
      e.move(4, 4, 3, 3);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Co-ordinates invalid");
    }
  }

  @org.junit.Test
  public void isGameOver() {
    assertFalse(e.isGameOver());
    e.move(5, 3, 3, 3);
    e.move(2, 3, 4, 3);
    e.move(0, 3, 2, 3);
    e.move(3, 5, 3, 3);
    e.move(3, 2, 3, 4);
    e.move(3, 0, 3, 2);
    e.move(1, 1, 3, 1);
    e.move(1, 5, 3, 5);
    e.move(4, 1, 2, 1);
    e.move(4, 5, 2, 5);
    e.move(5, 5, 5, 3);
    e.move(4, 3, 4, 5);
    e.move(4, 6, 4, 4);
    e.move(5, 2, 5, 4);
    e.move(3, 2, 5, 2);
    e.move(5, 1, 5, 3);
    e.move(5, 4, 5, 2);
    e.move(3, 4, 5, 4);
    e.move(6, 4, 4, 4);
    e.move(6, 2, 4, 2);
    e.move(1, 2, 3, 2);
    e.move(1, 4, 3, 4);
    e.move(4, 2, 2, 2);
    e.move(4, 4, 2, 4);
    e.move(2, 6, 4, 6);
    e.move(2, 4, 2, 6);
    e.move(2, 2, 2, 4);
    e.move(2, 0, 2, 2);
    assertTrue(e.isGameOver());
  }

  @org.junit.Test
  public void getBoardSize() {
    MarbleSolitaireModel e1 = new EuropeanSolitaireModel(5);
    assertEquals(e.getBoardSize(), 7);
    assertEquals(e1.getBoardSize(), 13);
  }

  @org.junit.Test
  public void getSlotAt() {
    assertEquals(e.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(e.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(e.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(e.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(e.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Marble);
    try {
      e.getSlotAt(7, 7);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid empty cell position (7,7)");
    }
    try {
      e.getSlotAt(-2, 1);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid empty cell position (-2,1)");
    }

  }

  @org.junit.Test
  public void getScore() {
    assertEquals(e.getScore(), 36);
    e.move(1, 3, 3, 3);
    assertEquals(e.getScore(), 35);
    e.move(2, 1, 2, 3);
    assertEquals(e.getScore(), 34);
  }

  @org.junit.Test
  public void testValidInitialization() {
    assertEquals(e.getBoardSize(), 7);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e.getSlotAt(3, 3));
    e.move(3, 1, 3, 3);
    MarbleSolitaireModel e1 = new EuropeanSolitaireModel(5);
    assertEquals(e1.getBoardSize(), 13);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e1.getSlotAt(6, 6));
    e1.move(6, 4, 6, 6);
    MarbleSolitaireModel e2 = new EuropeanSolitaireModel(1, 1);
    assertEquals(e2.getBoardSize(), 7);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e2.getSlotAt(1, 1));
    e2.move(1, 3, 1, 1);
    MarbleSolitaireModel e3 = new EuropeanSolitaireModel(7, 12, 12);
    assertEquals(e3.getBoardSize(), 19);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e3.getSlotAt(12, 12));
    e3.move(12, 10, 12, 12);
  }

  @org.junit.Test
  public void testInvalidInitialization() {
    try {
      new EuropeanSolitaireModel(-1, 2);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid empty cell position (-1,2)");
    }
    try {
      new EuropeanSolitaireModel(7, 7);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid empty cell position (7,7)");
    }
    try {
      new EuropeanSolitaireModel(4);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Thickness is not a positive odd number");
    }
    try {
      new EuropeanSolitaireModel(5, -1, 2);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid empty cell position (-1,2)");
    }
    try {
      new EuropeanSolitaireModel(3, 7, 7);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid empty cell position (7,7)");
    }
    try {
      new EuropeanSolitaireModel(4, 3, 3);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Thickness is not a positive odd number");
    }
  }

}
