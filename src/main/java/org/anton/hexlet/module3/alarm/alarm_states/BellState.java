package org.anton.hexlet.module3.alarm.alarm_states;

import org.anton.hexlet.module3.alarm.AlarmClock;

public class BellState implements State {

    private AlarmClock clock;
    private int hours;
    private int minutes;
    private int alarmMinutes;
    private int alarmHours;
    private boolean isAlarmOn;

    public BellState(State state){

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
        this.isAlarmOn = !this.isAlarmOn;
    }

    @Override
    public void clickH() {
        hours++;
        if (hours == 24) hours = 0;
    }

    @Override
    public void clickM() {
        minutes++;
        if (minutes == 60) minutes = 0;
    }

    @Override
    public void tick() {
        minutes++;
        if (minutes == 60) {
            minutes = 0;
            hours++;
            if (hours == 24) hours = 0;
        }
        clock.setState(new ClockState(this.clock));
    }

    //_____________________________________________________
    @Override
    public boolean isAlarmOn() {
        return true;
    }

    @Override
    public boolean isAlarmTime() {
        return true;
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
        return "bell";
    }
}
