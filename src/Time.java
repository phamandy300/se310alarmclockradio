public class Time {
    public int hours;
    public int minutes;
    public String period;

    public Time(int hours, int minutes, String period) {
        this.hours = hours;
        this.minutes = minutes;
        this.period = period.toUpperCase();
    }

    public void setTime(int setHour, int setMinute) {
        hours = setHour;
        minutes = setMinute;
    }
}
