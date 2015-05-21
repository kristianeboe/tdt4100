package exam2010;

/**
 * Created by Kristian on 21/05/15.
 */

//Hensikten med innkapsling er å få kontroll med hva slags informasjon man kan få ut av et objekt og passe på at man kun
//kan endre verdier via visse metoder og på den måten garantere objektets gyldighet

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        checkDay(day);
        checkMonth(month);
        checkYear(year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void changeDayForward(){
        day++;
        if (day> 31){
            day = 1;
            month++;
            if (month > 12){
                month = 1;
            }
        }
    }

    public void changeDayBackwards(){
        day--;
        if (day<0){
            day = 31;
            month--;
            if (month < 0){
                month = 12;
            }
        }
    }

    private void checkDay(int day){
        if (day <0 || day >31){
            throw new IllegalArgumentException("Day must be between 1 and 31, but was "+day);
        } else if (month == 2 && day >28){
            throw new IllegalArgumentException("February only has 28 days");
        }
    }

    private void checkMonth(int month){
        if (month <0 ||month>12){
            throw new IllegalArgumentException("Month must be between 1 and 12, but was"+month);
        }
    }

    private void checkYear(int year){
        if(year<1900 ||year <9999) {
            throw new IllegalArgumentException("Year must be between 1900 and 9999 because those are the valid years for this date class. You put year to be " + year);
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        checkDay(day);
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        checkMonth(month);
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        checkYear(year);
        this.year = year;
    }
}
