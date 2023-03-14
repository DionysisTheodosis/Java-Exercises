package exercise01;
//KLASH GIA NA KRATAEI THN SHMERINH MERA KAI NA ELEGXEI AN MIA DOTHISA MERA EINAI H SHMERINH
public class ToDay {
    private int day;
    private int month;
    private int year;
    
    //CONSTRUCTOR XWRIS ORISMATA GIA NA MPOREI NA DHMIOURGHTHEI NEO ANTIKEIMENO XWRIS EISAGWGH PARAMETRWN
    public ToDay() {
    }
    //CONSTRUCTOR ME 3 ORISMATA GIA THN ARXIKOPOIHSH TWN METAVLITWN
    public ToDay(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    //METHODOS GIA THN EPISTROFH THS MERAS
    public int getDay() {
        return day;
    }
    //METHODOS GIA THN EISAGWGH THS MERAS
    public void setDay(int day) {
        this.day = day;
    }
    //METHODOS GIA THN EPISTROFH TOU MHNA
    public int getMonth() {
        return month;
    }
    //METHODOS GIA THN EISAGWGH TOU MHNA
    public void setMonth(int month) {
        this.month = month;
    }
    //METHODOS GIA THN EPISTROFH TOU XRONOU
    public int getYear() {
        return year;
    }
    //METHODOS GIA THN EISAGWGH TOU XRONOU
    public void setYear(int year) {
        this.year = year;
    }
    //METHODOS GIA NA EXETAZEI AN MIA DOTHEISA MERA EINAI H SHMERINH
    public boolean isToDay(ToDay date) {
        return day == date.getDay() && month == date.getMonth() && year == date.getYear();
    }
}