package org.anton.hexlet.module3.alarm.alarm_states;

import org.anton.hexlet.module3.alarm.AlarmClock;

public class ClockState implements State {

    private AlarmClock clock;

    private int hours;
    private int minutes;
    private int alarmMinutes;
    private int alarmHours;
    private boolean isAlarmOn;

    public ClockState(State state,int x) {
        hours = 12;
        minutes = 0;
        alarmMinutes = 0;
        alarmHours = 6;
        isAlarmOn = false;
        this.clock = (AlarmClock) state;
    }
    public ClockState(State state) {
        this.hours = state.getHours();
        this.minutes = state.getMinutes();
        this.alarmMinutes = state.getAlarmMinutes();
        this.alarmHours = state.getAlarmHours();
        this.isAlarmOn = state.isAlarmOn();
        this.clock = (AlarmClock) state;
    }

    //_____________________________________________________
    @Override
    public void clickMode() {
        clock.setState(new AlarmState(this.clock));
    }

    @Override
    public void longClickMode() {
        isAlarmOn = !isAlarmOn;
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
        return "clock";
    }
}
