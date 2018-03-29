public class FrenchRevolutionaryDate extends Date {

    @Override
    public Date nextDate(){
        int mymonth = month();
        int mydayOfMonth = dayOfMonth();
        int myyear = year();

        if (dayOfYear() >= 365 ) {
            myyear += 1;
            mymonth = 1;
            mydayOfMonth = 1;
        }

        else if (dayOfMonth() == 30 && mymonth <=12) {
            mymonth += 1;
            mydayOfMonth = 1;

        }else {
            mydayOfMonth += 1;
        }


        return new FrenchRevolutionaryDate(myyear, mymonth, mydayOfMonth);
    }

    /** In a nonleap year for the French Revolutionary Calendar, the first
     *  twelve months have 30 days and month 13 has five days.
     */
    public FrenchRevolutionaryDate(int year, int month, int dayOfMonth) {

        super(year, month, dayOfMonth);
    }

    @Override
    public int dayOfYear() {
        return (month() - 1) * 30 + dayOfMonth();
    }

}
