
import java.util.*;


// CtCI5 3.4
public class TowersOfHanoi {

  private int diskCount;
  private static final int ROD_COUNT = 3;

  public TowersOfHanoi(int diskCount) {
    this.diskCount = diskCount;
  }

  public void run() {
    move(0, diskCount-1, 0, ROD_COUNT-1);
  }

  private void move(int beginDisk, int endDisk, int fromRod, int toRod) {
    if (beginDisk == endDisk) {
      if (fromRod < toRod) {
        for (int i=fromRod; i<toRod; i++) {
          System.out.println("Moving rod " + beginDisk + " from " + i + " to " + (i+1));
        }
      } else {
        for (int i=fromRod; i>=toRod; i--) {
          System.out.println("Moving rod " + beginDisk + " from " + i + " to " + (i-1));
        }
      }			
      return;
    }
    move(beginDisk, endDisk-1, fromRod, toRod);
    move(endDisk, endDisk, fromRod, fromRod+1);
    move(beginDisk, endDisk-1, toRod, fromRod);
    move(endDisk, endDisk, fromRod+1, toRod);
    move(beginDisk, endDisk-1, fromRod, toRod);
  }

}
