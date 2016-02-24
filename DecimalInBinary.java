
import java.util.*;

public class DecimalInBinary {

  private static final String ERROR_MESSAGE = "ERROR";

  public String binayRepresenatationByPower(double value) {
    StringBuilder sb = new StringBuilder();
    sb.append("0.");
    for (int i=1; i<=Integer.SIZE; i++) {
      double divisor = Math.pow(0.5, i);
      int comp = new Double(divisor).compareTo(new Double(value));
      if (comp == 0) {
        sb.append(1);
        return sb.toString();
      }
      if (comp < 0) sb.append("0");
      else {
        sb.append("1");
        value -= divisor;
      }
    }
    return ERROR_MESSAGE;
  }  

  public String binaryRepresentationByMultiplication(double value) {
    StringBuilder sb = new StringBuilder();
    sb.append("0.");
    for (int i=1; i<=Integer.SIZE; i++) {
      value *= 2;
      int comp = new Double(1).compareTo(new Double(value));
      if (comp == 0) {
        sb.append(1);
        return sb.toString();
      }
      if (comp < 0) sb.append("0");
      else {
        sb.append("1");
        value--;
      }
    }
    return ERROR_MESSAGE;  	
  }

}
