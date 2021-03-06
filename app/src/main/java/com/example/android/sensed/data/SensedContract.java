package com.example.android.sensed.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Essential Strings and URI constants for the database also utility methods
 * @author Laurie Dugdale
 */

public class SensedContract {


    // The authority
    public static final String AUTHORITY = "com.example.android.sensed";

    // The base content URI
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    // The path for the "entry" directory
    public static final String PATH_ENTRIES = "entry";

    /**
     * CLASS
     * inner class for handling the Entry table constants and methods.
     */
    public static final class SensedEntry implements BaseColumns {

        // TaskEntry content URI = base content URI + path
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_ENTRIES).build();

        // Table name
        public static final String TABLE_NAME = "entry";

        // Column names
        public static final String COLUMN_ENTRY_DATE_TIME = "date";
        public static final String COLUMN_ENTRY_HAPPINESS= "happiness";
        public static final String COLUMN_ENTRY_LONGITUDE = "longitude";
        public static final String COLUMN_ENTRY_LATITUDE = "latitude";

        /**
         * Builds a URI that adds the weather date to the end of the forecast content URI path.
         * This is used to query details about a single weather entry by date. This is what we
         * use for the detail view query. We assume a normalized date is passed to this method.
         *
         * @param id Normalized date in milliseconds
         * @return Uri to query details about a single weather entry
         */
        public static Uri buildEntryUriWithId(long id) {
            return CONTENT_URI.buildUpon()
                    .appendPath(Long.toString(id))
                    .build();
        }

        public static Uri buildEntryUriWithDate(String date) {
            return CONTENT_URI.buildUpon()
                    .appendPath(date)
                    .build();
        }


        public static String getSqlSelectBetweenDates(String fromDate, String toDate) {
            return "date BETWEEN '" + fromDate + "' AND '" + toDate + "'";

        }


    }
}
