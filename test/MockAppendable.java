import java.io.IOException;

/**
 * Creates a mock appendable object with the sole purpose of throwing IO Exceptions.
 */
public class MockAppendable implements Appendable {
  /**
   * appends a sequence of characters to the object.
   *
   * @param csq The character sequence to append.  If {@code csq} is
   *            {@code null}, then the four characters {@code "null"} are
   *            appended to this Appendable.
   * @return null
   * @throws IOException always
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("IO Exception");
  }

  /**
   * appends a sequence of characters to the object at a particular range.
   *
   * @param csq   The character sequence from which a subsequence will be
   *              appended.  If {@code csq} is {@code null}, then characters
   *              will be appended as if {@code csq} contained the four
   *              characters {@code "null"}.
   * @param start The index of the first character in the subsequence
   * @param end   The index of the character following the last character in the
   *              subsequence
   * @return null
   * @throws IOException always
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("IO Exception");
  }

  /**
   * appends a single character to the object.
   *
   * @param c The character to append
   * @return null
   * @throws IOException always
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("IO Exception");
  }
}
