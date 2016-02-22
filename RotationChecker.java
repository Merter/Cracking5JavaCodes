
import java.util.*;


// CtCI5 1.8
public class RotationChecker {

  public boolean isRotation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    StringBuilder doubleS1 = new StringBuilder();
    doubleS1.append(s1);
    doubleS1.append(s1);
    return isSubstring(doubleS1.toString(), s2);
  }

  private boolean isSubstring(String main, String part) {
    return main.indexOf(part) != -1;
  }

}
