import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class PointUtils {

	/**
	 * Returns the point with the largest Y value. If there are multiple such
	 * points, just chooses one arbitrarily.
	 */
	public static Point highestPoint(List<Point> points) {
		// TODO use the iterator to complete this method!
		Iterator<Point> pointIterator = points.iterator();
		Point maxPoint = null;
		if (pointIterator.hasNext()) {
			int maxY;
			Point temp = null;
			maxPoint = pointIterator.next();
			maxY = maxPoint.y;
			while (pointIterator.hasNext()) {
				temp = pointIterator.next();
				if (temp.y > maxY) {
					maxPoint = temp;
					maxY = temp.y;
				}
			}
		}
		return maxPoint;
	}

	/**
	 * Returns a new point that is the centroid of all the given points. A
	 * centroid has an X value that is the average of all the given points' X
	 * values, and a Y value that is the average of all the given points' Y
	 * values.
	 */
	public static Point centroid(List<Point> points) {
		Iterator<Point> pointIterator = points.iterator();
		// TODO use the iterator to complete this method!
<<<<<<< HEAD

		Point temp = null;
		if (pointIterator.hasNext()) {
			temp = pointIterator.next();
			int totalX = 0;
			int totalY = 0;
			int aveX = 0;
			int aveY = 0;
			int count = 1;
			while (pointIterator.hasNext()) {
				temp = pointIterator.next();
				totalX += temp.x;
				totalY += temp.y;
				count += 1;
			}
			return new Point(totalX / (count), totalY / (count));
		}else { return null;}
=======
		if (pointIterator.hasNext()) {
			Point temp = pointIterator.next();
			int x = temp.x;
			int y = temp.y;
			int count = 1;
			while (pointIterator.hasNext()) {
				temp = pointIterator.next();
				x += temp.x;
				y += temp.y;
				count++;
			}
			return new Point (x/count, y/count);
		}
		return null;
>>>>>>> c47c2ba7dd7e238c053a89ba3808fca113ad4adc
	}

	public static void main(String[] args) {
		List<Point> points = new LinkedList<>();
		points.add(new Point(1, 1));
		points.add(new Point(1, 3));
		points.add(new Point(3, 1));
		points.add(new Point(3, 3));

		/* Should be java.awt.Point[x=3,y=3] or java.awt.Point[x=1,y=3] */
		System.out.println(highestPoint(points));

		// Should be java.awt.Point[x=2,y=2]
		System.out.println(centroid(points));

		points = new LinkedList<>();
		points.add(new Point(1, 1));
		points.add(new Point(1, -1));
		points.add(new Point(-1, 1));
		points.add(new Point(-1, -1));

		/* Should be java.awt.Point[x=1,y=1] or java.awt.Point[x=-1,y=1] */
		System.out.println(highestPoint(points));

		// Should be java.awt.Point[x=0,y=0]
		System.out.println(centroid(points));
	}
}
