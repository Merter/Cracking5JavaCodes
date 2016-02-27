
import java.util.*;

public class MonochromeScreen {
  void drawHorizontalLine(byte[] screen, int width, int fromX, int toX, int atY) {
    if (toX > fromX) {
      int temp = fromX;
      fromX = toX;
      toX = temp;
    }
    // fromX is always smaller

    if (fromX >= width)
      return;
    if (toX >= width)
      toX = width-1;

    int height = screen.length / (width/8);
    if (atY<0 || atY>=height)
      return;

    int byteCountBegin = fromX / 8;
    int byteCountEnd = toX / 8;
    int offset = height * (width/8);

    for (int i=byteCountBegin+offset+1; i<byteCountEnd+offset; i++)
      screen[i] = (byte) ~0;  

    screen[byteCountBegin+offset] = (byte) (~0 >>> (fromX%8));
    screen[byteCountEnd+offset] = (byte) (~0 << (7 - toX%8));
  }




}
