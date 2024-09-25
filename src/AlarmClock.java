public class AlarmClock extends Clock{
    protected Time alarmTime;
    Time snoozeTime;
    protected boolean alarmOn;
    protected boolean snoozeState;

    public AlarmClock(int hours, int minutes, String period, int alarmHR, int alarmMin, String alarmPeriod) {
        super(hours, minutes, period);
        alarmTime = new Time(alarmHR, alarmMin, alarmPeriod);
        snoozeTime = new Time(alarmTime.hours, alarmTime.minutes, alarmTime.period);
        this.alarmOn = true;
        this.snoozeState = false;
    }

    public void setAlarm(int setAlarmHR, int setAlarmMin, String setAlarmPeriod) {
        alarmTime.hours = setAlarmHR;
        alarmTime.minutes = setAlarmMin;
        alarmTime.period = setAlarmPeriod.toUpperCase();
    }

    boolean compareTimes(int hr1, int min1, String period1, int hr2, int min2, String period2) {
        return hr1 == hr2 && min1 == min2 && period1.equals(period2);
    }

    public void checkAlarm() {
        if (snoozeState && compareTimes(clockTime.hours, clockTime.minutes, clockTime.period, snoozeTime.hours, snoozeTime.minutes, snoozeTime.period)) {
            System.out.println("Buzz Buzz Buzz");
        } else if (alarmOn && compareTimes(clockTime.hours, clockTime.minutes, clockTime.period, alarmTime.hours, alarmTime.minutes, alarmTime.period)) {
            System.out.println("Buzz Buzz Buzz");
        }
    }

    public void snooze() {
        int snoozeMins = 9;
        snoozeState = true;
        if ((snoozeTime.minutes + snoozeMins) >= 60) {
            ++snoozeTime.hours;
            snoozeTime.minutes = (snoozeTime.minutes + snoozeMins) - 60;

            if (clockTime.hours == 12) {
                if (snoozeTime.period.equals("AM")) {
                    snoozeTime.period = "PM";
                } else {
                    snoozeTime.period = "AM";
                }
            }

            if (snoozeTime.hours >= 12) {
                snoozeTime.hours = 1;
            }
        } else {
            snoozeTime.minutes += snoozeMins;
        }

        System.out.println("Snooze was pressed");
    }

    public void alarmOff() {
        alarmOn = false;
        System.out.println("Alarm off");
    }

    public String displayAlarm() {
        String time;
        int minZero = 0;

        if (alarmTime.minutes < 10) {
            time = String.format("%d:%d%d %s", alarmTime.hours, minZero, alarmTime.minutes, alarmTime.period);
        } else {
            time = String.format("%d:%d %s", alarmTime.hours, alarmTime.minutes, alarmTime.period);
        }

        return time;
    }

//    public static void main(String[] args){
//        AlarmClock myClock = new AlarmClock(8, 0, "AM", 8, 5, "AM");
//        System.out.printf("Time: %s%n", myClock.displayTime());
//        System.out.printf("Alarm: %s%n", myClock.displayAlarm());
//
//        for (int i = 0; i < 5; i++) {
//            System.out.printf("Time: %s%n", myClock.displayTime());
//            for (int secs = 0; secs < 60; secs++) {
//                myClock.tick();
//                myClock.checkAlarm();
//            }
//        }
//
//        myClock.snooze();
//
//        for (int i = 0; i < 9; i++) {
//            System.out.printf("Time: %s%n", myClock.displayTime());
//            for (int secs = 0; secs < 60; secs++) {
//                myClock.tick();
//                myClock.checkAlarm();
//            }
//        }
//
//        myClock.alarmOff();
//
//    }
}
