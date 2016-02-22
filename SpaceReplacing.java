
import java.util.*;


// CtCI5 1.4
public class SpaceReplacing {

  private static final String REPLACER = "%20";

  public String replaceSpacesiInCharArrayWithReplacer(char[] content, int realSize) {
    int spaceCount = findSpaceCount(content, realSize);
    int i = realSize+spaceCount;
    content[i] = '\0';		
    int j = realSize-1;
    while (i > j) {
      if (content[j] != ' ') {
        content[i--] = content[j--];
      } else {
        for (int r=REPLACER.length()-1; r>=0; r--) {
          content[--i] = REPLACER.charAt(r);
        }
        j--;
      }
    }
    return new String(content);
  }

  private int findSpaceCount(char[] content, int realSize) {
    int spaceCount = 0;
    for (int i=0; i<realSize; i++) {
      if (content[i] == ' ') {
        spaceCount++;
      }
    }
    return spaceCount;
  }

  public String replaceSpacesInStringWithReplacer(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<str.length(); i++) {
      char chr = str.charAt(i);
      if (chr == ' ') {
        sb.append("%20");
      } else {
        sb.append(chr);
      }
    }
    return sb.toString();
  }
}
