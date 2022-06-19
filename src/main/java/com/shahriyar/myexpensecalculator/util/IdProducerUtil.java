package com.shahriyar.myexpensecalculator.util;

import java.time.LocalDateTime;

public class IdProducerUtil {

    private static final String MONTH_STRING = "MONTH";
    private static final String YEAR_STRING = "YEAR";
    private static LocalDateTime localDateTimeObj;

    public static Long produceId(LocalDateTime localDateTime, String type) {
        localDateTimeObj = localDateTime;
        return type.equals(MONTH_STRING) ? produceIdForMonth() :
                type.equals(YEAR_STRING) ? produceIdForYear() : produceIdForDay();
    }

    private static Long produceIdForYear() {
        return Long.parseLong(String.format("%d",localDateTimeObj.getYear()));
    }

    private static Long produceIdForMonth() {
        return Long.parseLong(String.format("%d%d",localDateTimeObj.getYear(), localDateTimeObj.getMonthValue()));
    }

    private static Long produceIdForDay() {
        return Long.parseLong(String.format(
                "%d%d%d",localDateTimeObj.getYear(), localDateTimeObj.getMonthValue(), localDateTimeObj.getDayOfMonth()));
    }

}
