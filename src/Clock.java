public class Clock {
    protected final Time clockTime;
    private int seconds;

    public Clock(int hours, int minutes, String period) {
        clockTime = new Time(hours, minutes, period);
        seconds = 0;
    }

    public void tick() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            clockTime.minutes++;
        }

        if (clockTime.minutes >= 60) {
            clockTime.minutes = 0;
            clockTime.hours++;
        }

        if (clockTime.hours == 12) {
            if (clockTime.period.equals("AM")) {
                clockTime.period = "PM";
            } else {
                clockTime.period = "AM";
            }
        }

        if (clockTime.hours > 12) {
            clockTime.hours = 1;
        }

    }

    public String displayTime() {
        String time;
        int minZero = 0;

        if (clockTime.minutes < 10) {
            time = String.format("%d:%d%d %s", clockTime.hours, minZero, clockTime.minutes, clockTime.period);
        } else {
            time = String.format("%d:%d %s", clockTime.hours, clockTime.minutes, clockTime.period);
        }

        return time;
    }

//    public static void main(String[] args){
//        Clock test = new Clock(11, 59, "pm");
//        System.out.println(test.displayTime());
//        for (int secs = 0; secs < 60; secs++) {
//            test.tick();
//        }
//        System.out.println(test.displayTime());
//    }
}