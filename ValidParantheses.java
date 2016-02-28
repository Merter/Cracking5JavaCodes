
import java.util.*;


// CtCI5 9.6
public class ValidParantheses {

  private Set<String> paranthesisSet = new HashSet<String>();

  public Set<String> validParantheses(int n) {
    if (n < 0)
      return null;
    validParanthesis(n, n, "");
    return paranthesisSet;
  }

  private void validParanthesis(int left, int right, String str) {
    if (left==0 && right==0) {
      paranthesisSet.add(str);
      return;
    }
    if (left > 0) {
      validParanthesis(left-1, right, str+"(");
    }
    if (left < right) {
      validParanthesis(left, right-1, str+")");
    }
  }

}


// ()

// ()()
// (())

// ()()()
// (()())
// ()(())
// (())()
// ((()))

// ()()()()
// (()()())
// (()())()
// ()(()())
// ((()()))
// ()()(())
// ()(())()
// (()(()))

