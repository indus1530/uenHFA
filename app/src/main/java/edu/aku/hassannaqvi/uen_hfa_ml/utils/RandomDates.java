package edu.aku.hassannaqvi.uen_hfa_ml.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class RandomDates {

    public static void main(String[] args) {

        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1900, 2010);

        /*int year = randBetween( Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date().getTime())) -1,
                Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date().getTime())));*/

        gc.set(Calendar.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

        System.out.println(gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH));

    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

}
