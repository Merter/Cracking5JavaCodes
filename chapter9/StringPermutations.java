
import java.util.*;


// CtCI5 9.5
public class StringPermutations {

  public Set<String> generatePermutations(String string) {
    return generatePermutationsStartingFrom(string.toCharArray(), 0);
  }

  private Set<String> generatePermutationsStartingFrom(char[] content, int index) {
    if (index == content.length) {
      return Collections.emptySet();
    }
    Set<String> smallerSet = generatePermutationsStartingFrom(content, index+1);
    Set<String> biggerSet = new HashSet<String>();
    for (String smallerString : smallerSet) {
      for (int j=0; j<=smallerString.length(); j++) {
        StringBuilder sb = new StringBuilder();
        sb.append(smallerString.substring(0, j));
        sb.append(content[index]);
        if (j<smallerString.length()) {
          sb.append(smallerString.substring(j));
        }
        biggerSet.add(sb.toString());
      }
    }
    return biggerSet;
  }

}

// c

// bc
// cb

// abc
// acb
// bac
// bca
// cab
// cba

// aa
