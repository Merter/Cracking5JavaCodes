
import java.util.*;


// CtCI5 1.3
public class PermutationChecking {

  private static final int ALPHABET_SIZE = 256;	// Extended ASCII

  public boolean isPermutationWithSorting(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    char[] chars1 = s1.toCharArray();
    char[] chars2 = s2.toCharArray();
    Arrays.sort(chars1);
    Arrays.sort(chars2);
    for (int i=0; i<s1.length(); i++) {
      if (chars1[i] != chars2[i]) {
        return false;
      }
    }
    return true;
  }

  public boolean isPermutationWithModularSorting(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    return sorted(s1).equals(sorted(s2));
  }

  private String sorted(String str) {
    char[] content = str.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }	

  public boolean isPermutationWithCounting(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    int[] charCounts = new int[ALPHABET_SIZE];	
    for (int i=0; i<s1.length(); i++) {
      charCounts[s1.charAt(i)]++;
    }
    for (int i=0; i<s2.length(); i++) {
      if (charCounts[s2.charAt(i)] == 0) {
        return false;
      }
      charCounts[s2.charAt(i)]--;
    }
    return true;
  }

}
