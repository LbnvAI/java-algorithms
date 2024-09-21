package org.anton.hexlet.module3.alarm;

import org.anton.hexlet.module3.alarm.alarm_states.ClockState;
import org.anton.hexlet.module3.alarm.alarm_states.State;

public class AlarmClock implements State {

    private State state;

    public AlarmClock() {
        this.state = new ClockState(this,1);
    }

    public void setState(State state) {
        this.state = state;
    }

    //_____________________________________________________
    @Override
    public void clickMode() {
        state.clickMode();
    }

    @Override
    public void longClickMode() {
        state.longClickMode();
    }

    @Override
    public void clickH() {
        state.clickH();
    }

    @Override
    public void clickM() {
        state.clickM();
    }

    @Override
    public void tick() {
        state.tick();
    }

    //_____________________________________________________
    @Override
    public boolean isAlarmOn() {
        return state.isAlarmOn();
    }

    @Override
    public boolean isAlarmTime() {
        return state.isAlarmTime();
    }

    @Override
    public int getMinutes() {
        return state.getMinutes();
    }

    @Override
    public int getHours() {
        return state.getHours();
    }

    @Override
    public int getAlarmMinutes() {
        return state.getAlarmMinutes();
    }

    @Override
    public int getAlarmHours() {
        return state.getAlarmHours();
    }

    @Override
    public String getCurrentMode() {
        return state.getCurrentMode();
    }
}
