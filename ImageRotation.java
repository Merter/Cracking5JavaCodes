
import java.util.*;


// CtCI5 1.6
public class ImageRotation {

  public int[][] rotateImage(int[][] image, boolean isClockwise) {
    int imageSize = image.length;
    int[][] newImage = new int[imageSize][imageSize];
    for (int row=0; row<imageSize; row++) {
      for (int column=0; column<imageSize; column++) {
        if (isClockwise) {
          newImage[row][column] = image[imageSize-1-column][row];
        } else {
          newImage[row][column] = image[column][imageSize-1-row];
        }
      }
    }
    return newImage;
  }

  public void rotateImageInPlace(int[][] image, boolean isClockwise) {
    int imageSize = image.length;		
    for (int column=0; column<imageSize/2; column++) {
      for(int row=column; row<imageSize-1-column; row++) {
        int temp = image[row][column];
        for (int i=0; i<4; i++) {											
          int newRow = imageSize-1-column;
          int newColumn = row;
          if (!isClockwise) {
            newRow = column;					
            newColumn = imageSize-1-row;
          }
          image[row][column] = image[newRow][newColumn];
          row = newRow;
          column = newColumn;
        }
      }
    }
  }

}
