package utils.date

import java.text.SimpleDateFormat

class DateUtils {

    private static final Locale DEFAULT_LOCALE = new Locale("pt", "BR")

    public static String toString(Date fromDate, String format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, DEFAULT_LOCALE)
            simpleDateFormat.setTimeZone(TimeZone.getDefault())

            return simpleDateFormat.format(fromDate)
        } catch (Exception exception) {
            return null
        }
    }
}
