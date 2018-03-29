/**
 * Created by monsg on 6/22/2017.
 */
public class TriangleDrawer2 {
    public static void main (String[] args) {

        for (int row = 0, SIZE = 10; row < SIZE + 1; ++row) {
            for (int col = 0; col < row; col++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

}
