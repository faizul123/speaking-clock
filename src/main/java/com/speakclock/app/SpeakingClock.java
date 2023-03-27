package com.speakclock.app;


import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class SpeakingClock {
    private String[] words = {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven","twelve", "thirdeen", "fourteen", "fiveteen", "seventeen", "eighteen", "nineteen", "twenty",
            "thirdy", "fourty", "fivety"
    };

    private String wordClockPrefix = "It's ";
    private String midDay = "It's Midday";
    private String midNight = "It's midnight";

    public String run() {
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour(), minutes = localTime.getMinute();
        String dayPeriod = (hour > 21 && hour < 23) || (hour == LocalTime.MIDNIGHT.getHour() || (hour > 1 && hour < 5)) ? midNight : midDay;
        hour = hour == 0 ? 12 : hour;
        String hourToWord = hour >= 13 ? words[hour-13] : words[hour- 1];
        String minutesToWord = minutes < 20 ? words[minutes - 1] : getMinutesToWord(minutes);
        return wordClockPrefix + hourToWord + " " + minutesToWord + " " + dayPeriod;
    }

    private String getMinutesToWord(int minutes) {
        int _1DigitValue = minutes % 10;
        int _10DigitValue = minutes / 10;

        String convertedWord = "";
        if(_10DigitValue == 2) convertedWord += words[18];
        if(_10DigitValue == 3) convertedWord += words[19];
        if(_10DigitValue == 4) convertedWord += words[20];
        if(_10DigitValue == 5) convertedWord += words[21];
        convertedWord += " " +words[_1DigitValue-1];
        return convertedWord;
    }
}
