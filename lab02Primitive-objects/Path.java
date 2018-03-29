/** A class that represents a path via pursuit curves.
 *  @author You!
 */
public class Path {

    /** What to do, what to do... */

    Point currPoint, nextPoint;

    public Path(double x, double y) {
    	nextPoint = new Point(x, y);
    	currPoint = new Point(x, y);
    }

    public double getCurrX() {
    	return this.currPoint.getX();
    }

    public double getCurrY() {
    	return this.currPoint.getY();	
    }

    public double getNextX() {
    	return this.nextPoint.getX();
    }

    public double getNextY() {
    	return this.nextPoint.getY();
    }

    public Point getCurrentPoint(Point point) {
    	return this.currPoint;
    }

    public void setCurrentPoint(Point point) {
    	this.currPoint = point;
    }

    public void iterate(double dx, double dy) {
    	this.setCurrentPoint(this.nextPoint);
    	this.nextPoint = new Point(this.getCurrX() + dx, this.getCurrY() +dy);
    }

}
