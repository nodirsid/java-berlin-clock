package com.ubs.opsit.interviews;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Nodirjon on 6/8/2017.
 */
public class Clock {
    //set all lights to off by default
    private char[] blinkingLight={'O'};
    private char[] hoursFirstRow={'O','O','O','O'};
    private char[] hoursSecondRow={'O','O','O','O'};
    private char[] minutesFirstRow={'O','O','O','O','O','O','O','O','O','O','O'};
    private char[] minutesSecondRow={'O','O','O','O'};

    //constructor
    public Clock(String input){
        //convert the input to 24-hour clock format
        LocalTime time=LocalTime.parse(input, DateTimeFormatter.ofPattern("HH:mm:ss"));

        //if the input is 24:00:00, then set the clock as such, instead of 00:00:00
        if (input.equals("24:00:00")) {
            setTime(24, 00, 00);
        } else {
            setTime(time.getHour(), time.getMinute(), time.getSecond());
        }
    }

    private void setTime(int hrs, int mins, int secs) {
        if (secs % 2 == 0) {
            blinkingLight[0] = 'Y';
        }
        int fullFiveHours = hrs / 5;
        for (int i = 0; i < fullFiveHours; i++) {
            hoursFirstRow[i] = 'R';
        }
        int fullHours = hrs % 5;
        for (int i = 0; i < fullHours; i++) {
            hoursSecondRow[i] = 'R';
        }
        int fullFiveMinutes = mins / 5;
        for (int i = 0; i < fullFiveMinutes; i++) {
            if (i % 3 > 1) {
                minutesFirstRow[i] = 'R';
            } else {
                minutesFirstRow[i] = 'Y';
            }
        }
        int fullMinutes = mins % 5;
        for (int i = 0; i < fullMinutes; i++) {
            minutesSecondRow[i] = 'Y';
        }
    }

    @Override
    public String toString() {
        String output="";
        output+=String.valueOf(blinkingLight);
        output+=System.getProperty("line.separator");
        output+=String.valueOf(hoursFirstRow);
        output+=System.getProperty("line.separator");
        output+=String.valueOf(hoursSecondRow);
        output+=System.getProperty("line.separator");
        output+=String.valueOf(minutesFirstRow);
        output+=System.getProperty("line.separator");
        output+=String.valueOf(minutesSecondRow);
        return output;
    }
}