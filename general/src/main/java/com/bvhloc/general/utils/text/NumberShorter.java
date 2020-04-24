package com.bvhloc.general.utils.text;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberShorter {

    public static String format(double number) {
        return format(number, 2);
    }

    public static String format(double number, int decimalChar) {

        if (Math.abs(number) >= 1000000000) {
            number /= 1000000000;
            number = round(number, decimalChar);
            return number + "B";
        }
        if (Math.abs(number) >= 1000000) {
            number /= 1000000;
            number = round(number, decimalChar);
            return number + "M";
        }
        if (Math.abs(number) >= 1000) {
            number /= 1000;
            number = round(number, decimalChar);
            return number + "K";
        }
        number = round(number, decimalChar);
        return number + "";
    }

    private static double round(double number, int decimalChar) {

        long decimal = 10;
        decimal = (long) Math.pow(decimal, decimalChar);

        return Math.ceil(number * decimal) / decimal;
    }

    public static class YouTradeFormat {

        /**
         * Short number
         * <p>
         * ●	57,000.00 -> 57K (Thousand)
         * ●	100,000,000.00 -> 100M (Million)
         * ●	99,000,000,000.00 -> 99B (Billion)
         * </p>
         *
         * @param number
         * @return
         */
        public static String shortNumberFormat(double number) {
            if (Math.abs(number) >= 1000000000) {
                number /= 1000000000;
                return String.format("%sB", numberWithDecimalFormat(number));
            }
            if (Math.abs(number) >= 1000000) {
                number /= 1000000;
                return String.format("%sM", numberWithDecimalFormat(number));
            }
            if (Math.abs(number) >= 1000) {
                number /= 1000;
                return String.format("%sK", numberWithDecimalFormat(number));
            }
            return numberWithDecimalFormat(number);
        }


        /**
         * Percent number
         *
         * <p>
         * ●	Use dot (.) for decimal delimiter.
         * ●	Use comma (,) for thousand delimiter (if it's over 1000).
         * ●	Always have fixed 2 decimals.
         * ●	Always end with percent sign.
         * ●	There is no space (or &nbsp;) between number and percent sign
         * ●	Right align.
         * ●	Ex : 1.00%, 1.23%, 1,234.00%
         * </p>
         *
         * @param number
         * @return
         */
        public static String percentFormat(double number) {
            // End with percent sign
            return String.format("%s%%", numberWithDecimalFormat(number));
        }

        /**
         * Number with decimal format
         *
         * <p>
         * ●	Use comma (,) for thousand delimeter.
         * ●	Use dot (.) for decimal delimiter.
         * ●	Ex : 123,456.789
         * ●	Right align.
         * </p>
         *
         * @param number
         * @return
         */
        public static String numberWithDecimalFormat(double number) {
            return String.format("%s", decimalFormal(2).format(number));
        }

        /**
         * Number without decimal format
         *
         * @param number
         * @return
         */
        public static String numberFormat(double number) {
            return String.format("%s", decimalFormal(0).format(number));
        }

        private static NumberFormat decimalFormal(int numOfDecimal) {
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());

            DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();

            // Use dot (.) for decimal delimiter.
            formatSymbols.setDecimalSeparator('.');
            // Use comma (,) for thousand delimiter (if it's over 1000).
            formatSymbols.setGroupingSeparator(',');
            // Apply symbol format
            ((DecimalFormat) numberFormat).setDecimalFormatSymbols(formatSymbols);
            numberFormat.setGroupingUsed(true);

            // Always have fixed 2 decimals.
            numberFormat.setMinimumFractionDigits(numOfDecimal);
            numberFormat.setMaximumFractionDigits(numOfDecimal);

            return numberFormat;
        }
    }
}
