package com.trues.util;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.util.CSVUtil;
import com.googlecode.jcsv.writer.CSVColumnJoiner;

import java.util.regex.Pattern;

/**
 * User: son.nguyen
 * Date: 11/3/2014
 * Time: 8:28 PM
 */
public class TrueCSVColumnJoinerImpl implements CSVColumnJoiner {

    @Override
    public String joinColumns(String[] data, CSVStrategy strategy) {
        final String delimiter = String.valueOf(strategy.getDelimiter());
        final String quote = String.valueOf(strategy.getQuoteCharacter());
        final String doubleQuote = quote + quote;

        // check each column for delimiter or quote characters
        // and escape them if neccessary
        for (int i = 0; i < data.length; i++) {
            if (data[i].contains(delimiter) || data[i].contains(quote)) {
                if (data[i].contains(quote)) {
                    data[i] = data[i].replaceAll(Pattern.quote(quote), doubleQuote);
                }
            }
            data[i] = quote + data[i] + quote;
        }

        return CSVUtil.implode(data, delimiter);
    }
}
