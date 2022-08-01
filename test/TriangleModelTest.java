import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests {@code TriangleSolitaireModel}.
 */
public class TriangleModelTest {
  MarbleSolitaireModel t;

  @Before
  public void init() {
    t = new TriangleSolitaireModel();
  }

  @Test
  public void testValidInitialization() {
    assertEquals(5, t.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(0, 0));
    t.move(2, 0, 0, 0);
    MarbleSolitaireModel t2 = new TriangleSolitaireModel(4, 4);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t2.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t2.getSlotAt(4, 4));
    t2.move(4, 2, 4, 4);
    MarbleSolitaireModel t3 = new TriangleSolitaireModel(6);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t3.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t3.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t3.getSlotAt(0, 0));
    t3.move(2, 0, 0, 0);
    MarbleSolitaireModel t4 = new TriangleSolitaireModel(7, 6, 5);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t4.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t4.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t4.getSlotAt(6, 5));
    t4.move(6, 3, 6, 5);
  }

  @Test
  public void testInvalidInitialization() {
    try {
      new TriangleSolitaireModel(0);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("invalid dimension", e.getMessage());
    }

    try {
      new TriangleSolitaireModel(1, 2);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty co-ordinates: (1,2)", e.getMessage());
    }

    try {
      new TriangleSolitaireModel(5, 2);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty co-ordinates: (5,2)", e.getMessage());
    }

    try {
      new TriangleSolitaireModel(1, -2);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty co-ordinates: (1,-2)", e.getMessage());
    }

    try {
      new TriangleSolitaireModel(-1, 1, 1);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("invalid dimension", e.getMessage());
    }

    try {
      new TriangleSolitaireModel(6, 1, 2);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty co-ordinates: (1,2)", e.getMessage());
    }

    try {
      new TriangleSolitaireModel(6, 6, 2);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty co-ordinates: (6,2)", e.getMessage());
    }

    try {
      new TriangleSolitaireModel(7, -1, 1);
      fail("should have thrown an exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty co-ordinates: (-1,1)", e.getMessage());
    }
  }

  @Test
  public void testMakeMarbles() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (i == 0 && j == 0) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(i, j));
        } else if (i >= j) {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(i, j));
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t.getSlotAt(i, j));
        }
      }
    }
  }

  @Test
  public void testMove() {
    //up right
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(2, 0));
    t.move(2, 0, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(2, 0));

    //left
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(2, 2));
    t.move(2, 2, 2, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(2, 2));

    //up left
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(4, 4));
    t.move(4, 4, 2, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(4, 4));

    //down right
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(1, 1));
    t.move(1, 1, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(1, 1));

    //right
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(4, 2));
    t.move(4, 2, 4, 4);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(4, 2));

    t.move(3, 0, 1, 0);

    //down left
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(0, 0));
    t.move(0, 0, 2, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(0, 0));
  }

  @Test
  public void testInvalidMoves() {
    try {
      t.move(1, 1, 0, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move", e.getMessage());
    }

    try {
      t.move(3, 3, 0, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move", e.getMessage());
    }

    try {
      t.move(-1, 1, 0, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Co-ordinates", e.getMessage());
    }

    try {
      t.move(2, 1, 2, 3);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Co-ordinates", e.getMessage());
    }

    try {
      t.move(2, 0, 2, 2);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Co-ordinates", e.getMessage());
    }
  }

  @Test
  public void testIsGameOver() {
    assertFalse(t.isGameOver());
    t.move(2, 2, 0, 0);
    t.move(2, 0, 2, 2);
    t.move(0, 0, 2, 0);
    t.move(4, 3, 2, 1);
    t.move(3, 0, 3, 2);
    t.move(2, 1, 4, 3);
    t.move(3, 3, 1, 1);
    assertTrue(t.isGameOver());
  }

  @Test
  public void testGetBoardSize() {
    MarbleSolitaireModel t1 = new TriangleSolitaireModel(6);
    assertEquals(5, t.getBoardSize());
    assertEquals(6, t1.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t.getSlotAt(0, 4));
  }

  @Test
  public void testGetScore() {
    assertEquals(14, t.getScore());
    t.move(2, 0, 0, 0);
    assertEquals(13, t.getScore());
    t.move(2, 2, 2, 0);
    assertEquals(12, t.getScore());

    MarbleSolitaireModel t1 = new TriangleSolitaireModel(6);
    assertEquals(20, t1.getScore());
    t1.move(2, 0, 0, 0);
    assertEquals(19, t1.getScore());
    t1.move(2, 2, 2, 0);
    assertEquals(18, t1.getScore());
  }

}
