
import java.util.*;


// CtCI5 1.1
public class AllCharsUnique {

  private static final int ALPHABET_SIZE = 256;	// Extended ASCII

  public boolean areAllCharsUniqueWithSet(String str) {
    Set<Character> charsInString = new HashSet<Character>();
    for (int i=0; i<str.length(); i++) {
      char currentChar = str.charAt(i);
      if (charsInString.contains(currentChar)) {
        return false;
      }
      charsInString.add(currentChar);
    }
    return true;
  }

  public boolean areAllCharsUniqueWithBitSet(String str) {
    if (str.length() > ALPHABET_SIZE) {
      return false;
    }
    BitSet charExists = new BitSet(ALPHABET_SIZE);
    for (int i=0; i<str.length(); i++) {
      char currentChar = str.charAt(i);
      if (charExists.get(currentChar)) {				
        return false;
      }
      charExists.set(currentChar);
    }
    return true;
  }	

  public boolean areAllCharsUniqueWithSorting(String str) {
    if (str.length() > ALPHABET_SIZE) {
      return false;
    }
    char[] content = str.toCharArray();
    Arrays.sort(content);
    for (int i=1; i<content.length; i++) {
      if (content[i] == content[i-1]) {
        return false;
      }
    }
    return true;
  }	

  public boolean areAllCharsUniqueBruteForce(String str) {
    for (int i=0; i<str.length(); i++) {
      for (int j=i+1; j<str.length(); j++) {
        if (str.charAt(i) == str.charAt(j)) {
          return false;
        }
      }
    }
    return true;
  }


  public boolean areAllCharsUnique(String str) {
    if (str.length() > ALPHABET_SIZE) {
      return false;
    }	
    boolean[] charExists = new boolean[ALPHABET_SIZE];
    for (int i=0; i<str.length(); i++) {
      char currentChar = str.charAt(i);
      if (charExists[currentChar]) {
        return false;
      }
      charExists[currentChar] = true;
    }
    return true;
  }

}
