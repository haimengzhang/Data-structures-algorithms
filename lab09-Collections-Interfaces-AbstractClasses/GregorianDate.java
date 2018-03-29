public class GregorianDate extends Date {

    @Override
    public Date nextDate() {
        int month = month();
        int dayOfMonth = dayOfMonth();
        int year = year();
        int dayOfYear = dayOfYear();

        if (dayOfYear == 365) {
            year += 1;
            month = 1;
            dayOfMonth = 1;

        } else if (dayOfMonth() == monthLengths[month()-1] && month <12) {
            month += 1;
            dayOfMonth = 1;

        } else {
            dayOfMonth += 1;
        }

        return new GregorianDate(year, month, dayOfMonth);
    }


    public static int[] monthLengths = {31, 28, 31, 30, 31, 30, 31,
        31, 30, 31, 30, 31};// each month contains different num of days

    public GregorianDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    @Override
    public int dayOfYear() {
        int rtnValue = 0;
        for (int m = 0; m < month() - 1; m++) {
            rtnValue += monthLengths[m];
        }
        return rtnValue + dayOfMonth();
    }

}
