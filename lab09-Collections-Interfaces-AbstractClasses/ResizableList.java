/**
 * Created by haimengzhang on 7/6/17.
 */
public class ResizableList extends FixedSizeList implements SimpleList{

    public ResizableList(int capacity) {

       super();
    }

    public void add(int k) {

        if (size() == values.length) {

            resize();

        }
        super.add(k);

    }

    public void add(int i, int k) {
        if (i < 0) {
            throw new ListException("Can't have negative index");
        }

        if (i > size()) {

            throw new ListException("Can't have gaps");
        }

        if ( size() == values.length){

            resize();

        }
        super.add(i, k);
    }

    private void resize () {

        int [] resized = new int[values.length*2];

        if (size() == values.length) {

            for ( int j = 0; j < values.length; j++) {

                resized [j] = values [j];
            }
            values = resized;


        }
    }

}
