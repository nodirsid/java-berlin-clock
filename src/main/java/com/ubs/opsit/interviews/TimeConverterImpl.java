package com.ubs.opsit.interviews;

/**
 * Created by Nodirjon on 6/8/2017.
 */
public class TimeConverterImpl implements TimeConverter{

    @Override
    public String convertTime(String time) {
        Clock clock = new Clock(time);
        return clock.toString();
    }
}
