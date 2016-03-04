
import java.util.*;


// CtCI5 1.5
public class StringCompression {

  private class CharCount {
    private char key;
    private int consecutiveCount;

    public CharCount(char key, int count) {
      this.key = key;
      this.consecutiveCount = count;
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(key);
      sb.append(consecutiveCount);
      return sb.toString();
    }
  }

  public String compress(String str) {
    ArrayList<CharCount> compressedList = new ArrayList<CharCount>();
    char curr = str.charAt(0);
    int count = 1;
    for (int i=1; i<str.length(); i++) {
      if (str.charAt(i) == curr) {
        count++;
      } else {
        compressedList.add(new CharCount(curr, count));
        curr = str.charAt(i);
        count = 1;
      }
    }
    compressedList.add(new CharCount(curr, count));
    String compressedString = generateCompressedString(compressedList);
    if (compressedString.length() < str.length()) {
      return compressedString;
    }
    return str;
  }

  private String generateCompressedString(ArrayList<CharCount> compressedList) {
    StringBuilder sb = new StringBuilder();
    for (CharCount cc : compressedList) {
      sb.append(cc.toString());
    }
    return sb.toString();
  }
}
