package org.anton.hexlet.module3.alarm.alarm_states;

public interface State {
    public void clickMode();

    public void longClickMode();

    public void clickH();

    public void clickM();

    public void tick();

    public boolean isAlarmOn();

    public boolean isAlarmTime();

    public int getMinutes();

    public int getHours();

    public int getAlarmMinutes();

    public int getAlarmHours();

    public String getCurrentMode();
}

