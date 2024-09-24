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
        ++seconds;
        if (seconds >= 60) {
            seconds = 0;
            ++minutes;
        }

        if (minutes >= 60) {
            minutes = 0;
            ++hours;
        }

        if (hours == 12) {
            if (period.equals("AM")) {
                period = "PM";
            } else {
                period = "AM";
            }
        }

        if (hours > 12) {
            hours = 1;
        }

    }

    public String display() {
        String time;
        int minZero = 0;

        if (minutes == 0) {
            time = String.format("%d:%d%d %s", hours, minutes, minZero, period);
        } else {
            time = String.format("%d:%d %s", hours, minutes, period);
        }

        return time;
    }

    public static void main(String[] args){
        Clock test = new Clock(11, 59, "pm");
        System.out.println(test.display());
        for (int secs = 0; secs < 60; secs++) {
            test.tick();
        }
        System.out.println(test.display());



    }
}