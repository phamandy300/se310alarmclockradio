public class AlarmClockRadio extends AlarmClock{
    private final Radio myRadio;

    public AlarmClockRadio(int hours, int minutes, String period, int alarmHR, int alarmMin, String alarmPeriod) {
        super(hours, minutes, period, alarmHR, alarmMin, alarmPeriod);
        myRadio = new Radio(0, 0, false);
    }

    public void setStation(int station) {
        myRadio.setStation(station);
    }

    public void setVolume(int setVol) {
        myRadio.setVolume(setVol);
    }

    public void setState(boolean state) {
        myRadio.setState(state);
    }

    public String displayStation() {
        return myRadio.displayStation();
    }
}
