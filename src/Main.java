public class Main {
    public static void main(String[] args){
        AlarmClockRadio myClock = new AlarmClockRadio(8, 0, "AM", 8, 5, "AM");
        myClock.setStation(1060);
        myClock.setVolume(50);

        System.out.printf("Time: %s%n", myClock.displayTime());
        System.out.printf("Alarm: %s%n", myClock.displayAlarm());
        System.out.printf("Radio Station: %s%n", myClock.displayStation());

        for (int i = 0; i < 5; i++) {
            for (int secs = 0; secs < 60; secs++) {
                myClock.tick();
            }
            System.out.printf("Time: %s%n", myClock.displayTime());
            myClock.checkAlarm();
        }

        myClock.snooze();

        for (int i = 0; i < 9; i++) {
            for (int secs = 0; secs < 60; secs++) {
                myClock.tick();
            }
            System.out.printf("Time: %s%n", myClock.displayTime());
            myClock.checkAlarm();
        }

        myClock.alarmOff();

    }
}
