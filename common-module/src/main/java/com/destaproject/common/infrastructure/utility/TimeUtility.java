package com.destaproject.common.infrastructure.utility;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeUtility {
    public static Timestamp getTimestampByLocalDateTime() {
        return Timestamp.valueOf(LocalDateTime.now(ZoneId.systemDefault()));
    }

    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now(ZoneId.systemDefault());
    }

    public static ZonedDateTime getZoneDateTime() {
        return LocalDateTime.now().atZone(ZoneId.systemDefault());
    }
}