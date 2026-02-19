/***********************************************************
 * Name: Ian Handy
 * Date:2/10/26
 * Description of lab work: Calendar creation for fictional calendar with test cases.
 ***********************************************************/


public class JankleBobit {
    private int month;
    private int day;
    private int year;
    static int evenMax = 14;
    static int oddMax = 45;
    static int numMonths = 17;
    static int leapMonth = 6;

    public JankleBobit() {
        month = 1;
        day = 1; 
        year =2006;

    }

    public JankleBobit (int m, int d, int y){
        month = m;
        day = d;
        year =y;
    }

    // -----------------------------------------------------------------------------
    // Check if a date is valid.
    // Preconditon: m, d and y are integers.
    // Postcondtion: If the combination of m, d and y represents a valid date,
    //       a true value is returned; otherwise, a false value is returned.
    // -----------------------------------------------------------------------------
    public static boolean isLegitimate(int m, int d, int y){

        if (m<=0|| d <= 0|| m > numMonths || d > oddMax)
            return false;
        else if ((y%2 == 0) && (m == leapMonth) && (d ==15)) {
            return true;
        } else if (m%2==0 && d > evenMax) {
            return false;
        } else if  (d > oddMax) {
            return false;
        } 

        return true;
    }

    // -----------------------------------------------------------------------------
    // Advance a given date by one day
    // Preconditon: givenDate is a valid date
    // Postcondtion: givenDate is a new valid date that is increased by one day
    // -----------------------------------------------------------------------------
    public static void advanceDate(JankleBobit givenDate) {
        givenDate.day+=1;
        if (isLegitimate(givenDate.month, givenDate.day, givenDate.year))
             {return;}
        else {
            givenDate.day = 1;
            givenDate.month += 1;
            if (isLegitimate(givenDate.month, givenDate.day, givenDate.year))
            {}
            else {
                givenDate.month = 1;
                givenDate.year +=1;
            }
        }
    }

    public void display(String s){
        System.out.println(s + month + "/" + day + "/" + year);
    }
}
