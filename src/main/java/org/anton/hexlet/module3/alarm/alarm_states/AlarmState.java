package org.anton.hexlet.module3.alarm.alarm_states;


import org.anton.hexlet.module3.alarm.AlarmClock;

public class AlarmState implements State {

    private AlarmClock clock;
    private int hours;
    private int minutes;
    private int alarmMinutes;
    private int alarmHours;
    private boolean isAlarmOn;

    public AlarmState(State state) {
        this.hours = state.getHours();
        this.minutes = state.getMinutes();
        this.alarmMinutes = state.getAlarmMinutes();
        this.alarmHours = state.getAlarmHours();
        this.isAlarmOn = state.isAlarmOn();
        clock = (AlarmClock) state;
    }

    //_____________________________________________________
    @Override
    public void clickMode() {
        clock.setState(new ClockState(this.clock));
    }

    @Override
    public void longClickMode() {
        isAlarmOn = !isAlarmOn;
    }

    @Override
    public void clickH() {
        alarmHours++;
        if (alarmHours == 24) alarmHours = 0;
    }

    @Override
    public void clickM() {
        alarmMinutes++;
        if (alarmMinutes == 60) alarmMinutes = 0;
    }

    @Override
    public void tick() {
        minutes++;
        if (minutes == 60) {
            minutes = 0;
            hours++;
            if (hours == 24) hours = 0;
        }
        if (isAlarmOn && minutes == alarmMinutes && hours == alarmHours)
            clock.setState(new BellState(this.clock));
    }

    //_____________________________________________________
    @Override
    public boolean isAlarmOn() {
        return isAlarmOn;
    }

    @Override
    public boolean isAlarmTime() {
        return alarmHours == hours && alarmMinutes == minutes;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public int getAlarmMinutes() {
        return alarmMinutes;
    }

    @Override
    public int getAlarmHours() {
        return alarmHours;
    }

    @Override
    public String getCurrentMode() {
        return "alarm";
    }
}
