package utils;

import java.util.Random;

public class DateGenerator {
    private int day;
    private int month;
    private int year;

    private Random rand = new Random();
    private static int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int centuryDays[] = {5, 3, 2, 0};
    private static int doomsdays[] = {3, 28, 7, 4, 9, 6, 11, 8, 5, 10, 7, 12};

    public DateGenerator() {
        while (!validDate(day, month, year)) {
            setYear();
            setMonth();
            setDay();
        }
    }

    private static boolean leapYear(int year) {
        return ((year % 400) != 0) && ((year % 4) == 0);
    }

    private static boolean validDate(int day, int month, int year) {
        if (year < 1583)
            return false;
        if (month < 1 || month > 12)
            return false;
        if (day < 1)
            return false;
        if (month == 2) {
            if (leapYear(year)) {
                if (day > 29)
                    return false;
            } else {
                if (day > 28)
                    return false;
            }
        } else {
            if (day > monthDays[month - 1])
                return false;
        }
        return true;
    }

    public int getDayOfWeek() {
        if (!validDate(day, month, year))
            return -1;

        int centuryDay = centuryDays[((year / 100) - 14) % 4];
        boolean isLeapYear = leapYear(year);

        year = year % 100;
        int anchorDay = year / 12 + (year % 12) + (year % 12) / 4;

        int doomsday = doomsdays[month - 1];
        if (isLeapYear && month < 3)
            doomsday++;

        return (centuryDay + anchorDay + day - doomsday + 35) % 7;
    }

    public String getWeekday(int dayOfWeek) {
        switch (dayOfWeek) {
            case 0: return  "Sunday";
            case 1: return  "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            default: return "Error";
        }
    }

    private void setDay() {
        this.day = rand.nextInt(31) + 1;
    }

    private void setMonth() {
        this.month = rand.nextInt(12) + 1;
    }

    private void setYear() {
        this.year = rand.nextInt(2100 + 1 - 1900) + 1900;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}