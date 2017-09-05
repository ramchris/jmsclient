package com.ram.huxley.fitch.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtil {
    public static long getTime(int seconds) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime subtractSecondsFromCurrentTime = currentTime.minusSeconds(seconds);
        if (seconds == 0) return currentTime.atZone(ZoneId.systemDefault()).toEpochSecond();
        else return subtractSecondsFromCurrentTime.atZone(ZoneId.systemDefault()).toEpochSecond();
    }
}
