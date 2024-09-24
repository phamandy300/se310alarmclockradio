public class Clock {
    public int hours;
    public int minutes;
    private int seconds;
    public String period;

    public Clock(int hours, int minutes, String period) {
        this.hours = hours;
        this.minutes = minutes;
        this.period = period.toUpperCase();
    }

    public void setTime(int setHour, int setMinute) {
        hours = setHour;
        minutes = setMinute;
    }

    public void tick() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            minutes++;
        }

        if (minutes >= 60) {
            minutes = 0;
            hours++;
        }

        if (hours >= 60) {
            hours = 0;
            if (period.equals("AM")) {
                period = "PM";
            } else {
                period = "AM";
            }
        }

    }

    public String display() {
        return period;
    }

}


