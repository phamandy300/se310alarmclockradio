public class Radio {
    public int radioStation;
    public int volume;
    public boolean on;

    public Radio(int radioStation, int volume, boolean on) {
        this.radioStation = radioStation;
        this.volume = volume;
        this.on = on;
    }

    public void setStation(int station) {
        radioStation = station;
    }

    public void setVolume(int setVol) {
        volume = setVol;
    }

    public void setState(boolean state) {
        on = state;
    }
}
