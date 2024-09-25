public class AlarmClock extends Clock{
    public int alarmHR;
    public int alarmMin;
    public String alarmPeriod;
    protected boolean alarmOn;

    public AlarmClock(int hours, int minutes, String period, int alarmHR, int alarmMin, String alarmPeriod) {
        super(hours, minutes, period);
        this.alarmHR = alarmHR;
        this.alarmMin = alarmMin;
        this.alarmPeriod = alarmPeriod.toUpperCase();
        this.alarmOn = true;
    }

    public void setAlarm(int setAlarmHR, int setAlarmMin, String setAlarmPeriod) {
        alarmHR = setAlarmHR;
        alarmMin = setAlarmMin;
        alarmPeriod = setAlarmPeriod.toUpperCase();
    }

    private boolean compareTimes() {
        return hours == alarmHR && minutes == alarmMin && period.equals(alarmPeriod);
    }

    public void checkAlarm() {
        if (alarmOn && (compareTimes())) {
            System.out.println("Buzz Buzz Buzz");
        }
    }

    public void snooze() {
        int snoozeMins = 9;
        if ((alarmMin + snoozeMins) >= 60) {
            ++alarmHR;
            alarmMin = (alarmMin + snoozeMins) - 60;

            if (hours == 12) {
                if (alarmPeriod.equals("AM")) {
                    alarmPeriod = "PM";
                } else {
                    alarmPeriod = "AM";
                }
            }

            if (alarmHR >= 12) {
                alarmHR = 1;
            }
        } else {
            alarmMin = alarmMin + snoozeMins;
        }
    }

    public void alarmOff() {
        alarmOn = false;
    }

    public String displayAlarm() {
        String time;
        int minZero = 0;

        if (alarmMin < 10) {
            time = String.format("%d:%d%d %s", alarmHR, minZero, alarmMin, alarmPeriod);
        } else {
            time = String.format("%d:%d %s", alarmHR, alarmMin, alarmPeriod);
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
