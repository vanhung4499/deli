package com.union.deli.base.core.utils;

import com.union.deli.base.core.constant.Constants;
import com.union.deli.base.core.core.text.StrFormatter;
import org.springframework.util.AntPathMatcher;

import java.math.BigDecimal;
import java.util.*;

import static java.util.Objects.isNull;

/**
 * 404 bug!
 *
 * @author vanhung4499
 * @date 7/10/2024
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * Empty string
     */
    private static final String NULLSTR = "";

    /**
     * Underscore character
     */
    private static final char SEPARATOR = '_';

    /**
     * Get the non-null value of a parameter
     *
     * @param value        The value to be evaluated
     * @param defaultValue Default value to return if value is null
     * @return value if not null, otherwise defaultValue
     */
    public static <T> T nvl(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    /**
     * * Check if a Collection is empty, including List, Set, Queue
     *
     * @param coll Collection to check
     * @return true if empty, false if not empty
     */
    public static boolean isEmpty(Collection<?> coll) {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * * Check if a Collection is not empty, including List, Set, Queue
     *
     * @param coll Collection to check
     * @return true if not empty, false if empty
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * * Check if an array of objects is empty
     *
     * @param objects Array of objects to check
     * @return true if empty, false if not empty
     */
    public static boolean isEmpty(Object[] objects) {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * * Check if an array of objects is not empty
     *
     * @param objects Array of objects to check
     * @return true if not empty, false if empty
     */
    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

    /**
     * * Check if a Map is empty
     *
     * @param map Map to check
     * @return true if empty, false if not empty
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return isNull(map) || map.isEmpty();
    }

    /**
     * * Check if a Map is not empty
     *
     * @param map Map to check
     * @return true if not empty, false if empty
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * Check if a string is empty.
     *
     * @param str String
     * @return true if empty, false if not empty
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || NULLSTR.equals(str.trim());
    }

    /**
     * Check if a string is not empty.
     *
     * @param str String
     * @return true if not empty, false if empty
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * Check if an object is null.
     *
     * @param object Object
     * @return true if null, false if not null
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * Check if an object is not null.
     *
     * @param object Object
     * @return true if not null, false if null
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    /**
     * Check if an object is an array (Java primitive type array).
     *
     * @param object Object
     * @return true if array, false if not array
     */
    public static boolean isArray(Object object) {
        return isNotNull(object) && object.getClass().isArray();
    }

    /**
     * Trim whitespace from a string.
     */
    public static String trim(String str) {
        return (str == null ? "" : str.trim());
    }

    /**
     * Substring a string.
     *
     * @param str   String
     * @param start Start index
     * @return Resulting substring
     */
    public static String substring(final String str, int start) {
        if (str == null) {
            return NULLSTR;
        }

        if (start < 0) {
            start = str.length() + start;
        }

        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return NULLSTR;
        }

        return str.substring(start);
    }

    /**
     * Substring a string.
     *
     * @param str   String
     * @param start Start index
     * @param end   End index
     * @return Resulting substring
     */
    public static String substring(final String str, int start, int end) {
        if (str == null) {
            return NULLSTR;
        }

        if (end < 0) {
            end = str.length() + end;
        }
        if (start < 0) {
            start = str.length() + start;
        }

        if (end > str.length()) {
            end = str.length();
        }

        if (start > end) {
            return NULLSTR;
        }

        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * Format text, {} represents placeholders.<br>
     * This method simply replaces placeholders {} sequentially with parameters.<br>
     * To output {} literally, escape it with \\ (double backslash). To output \\ before {}, use quadruple backslashes \\\\\\\\.<br>
     * Example:<br>
     * Normal usage: format("this is {} for {}", "a", "b") -> this is a for b<br>
     * Escaping {}: format("this is \\{} for {}", "a", "b") -> this is \{} for a<br>
     * Escaping \\: format("this is \\\\{} for {}", "a", "b") -> this is \a for b<br>
     *
     * @param template Text template with placeholders represented by {}
     * @param params   Parameter values
     * @return Formatted text
     */
    public static String format(String template, Object... params) {
        if (isEmpty(params) || isEmpty(template)) {
            return template;
        }
        return StrFormatter.format(template, params);
    }

    /**
     * Check if a string starts with http:// or https://
     *
     * @param link Link to check
     * @return true if starts with http:// or https://, false otherwise
     */
    public static boolean ishttp(String link) {
        return StringUtils.startsWithAny(link, Constants.HTTP, Constants.HTTPS);
    }

    /**
     * Convert a string to a set
     *
     * @param str String to convert
     * @param sep Separator
     * @return Set collection
     */
    public static final Set<String> str2Set(String str, String sep) {
        return new HashSet<String>(str2List(str, sep, true, false));
    }

    /**
     * Convert a string to a list.
     *
     * @param str         String to convert
     * @param sep         Separator
     * @param filterBlank Whether to filter purely blank strings
     * @param trim        Whether to trim leading and trailing whitespace
     * @return List collection
     */
    public static final List<String> str2List(String str, String sep, boolean filterBlank, boolean trim) {
        List<String> list = new ArrayList<String>();
        if (StringUtils.isEmpty(str)) {
            return list;
        }

        // Filter blank strings
        if (filterBlank && StringUtils.isBlank(str)) {
            return list;
        }
        String[] split = str.split(sep);
        for (String string : split) {
            if (filterBlank && StringUtils.isBlank(string)) {
                continue;
            }
            if (trim) {
                string = string.trim();
            }
            list.add(string);
        }

        return list;
    }

    /**
     * Check if a given collection contains any elements from the given array.
     *
     * @param collection Given collection
     * @param array      Given array
     * @return true if contains any element, false otherwise
     */
    public static boolean containsAny(Collection<String> collection, String... array) {
        if (isEmpty(collection) || isEmpty(array)) {
            return false;
        } else {
            for (String str : array) {
                if (collection.contains(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Check if a specified string contains any of the strings from a specified string array, ignoring case.
     *
     * @param cs                  Specified string
     * @param searchCharSequences String array to check against
     * @return true if contains any string, false otherwise
     */
    public static boolean containsAnyIgnoreCase(CharSequence cs, CharSequence... searchCharSequences) {
        if (isEmpty(cs) || isEmpty(searchCharSequences)) {
            return false;
        }
        for (CharSequence testStr : searchCharSequences) {
            if (containsIgnoreCase(cs, testStr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Convert camel case to underscore case.
     */
    public static String toUnderScoreCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // Whether the previous character is uppercase
        boolean preCharIsUpperCase = true;
        // Whether the current character is uppercase
        boolean curreCharIsUpperCase = true;
        // Whether the next character is uppercase
        boolean nexteCharIsUpperCase = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i > 0) {
                preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
            } else {
                preCharIsUpperCase = false;
            }

            curreCharIsUpperCase = Character.isUpperCase(c);

            if (i < (str.length() - 1)) {
                nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }

            if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase) {
                sb.append(SEPARATOR);
            } else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase) {
                sb.append(SEPARATOR);
            }
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * Check if a string contains any of the specified strings (case insensitive).
     *
     * @param str  String to check
     * @param strs Array of strings to check against
     * @return true if contains any of the strings, false otherwise
     */
    public static boolean inStringIgnoreCase(String str, String... strs) {
        if (str != null && strs != null) {
            for (String s : strs) {
                if (str.equalsIgnoreCase(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Convert a string in underscore uppercase naming convention to camel case. Returns an empty string if the input string is null or empty.
     * Example: HELLO_WORLD -> HelloWorld
     *
     * @param name String in underscore uppercase naming convention
     * @return String in camel case
     */
    public static String convertToCamelCase(String name) {
        StringBuilder result = new StringBuilder();
        // Quick check
        if (name == null || name.isEmpty()) {
            // No need to convert
            return "";
        } else if (!name.contains("_")) {
            // If there are no underscores, simply capitalize the first letter
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        // Split the original string using underscores
        String[] camels = name.split("_");
        for (String camel : camels) {
            // Skip leading, trailing, or consecutive underscores in the original string
            if (camel.isEmpty()) {
                continue;
            }
            // Capitalize the first letter
            result.append(camel.substring(0, 1).toUpperCase());
            // Lowercase the rest of the letters
            result.append(camel.substring(1).toLowerCase());
        }
        return result.toString();
    }

    /**
     * Convert a string from underscore naming convention to camel case.
     * Example: user_name -> userName
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Check if a specified string matches any string in a specified list of strings.
     *
     * @param str  Specified string
     * @param strs List of strings to check against
     * @return true if there is a match, false otherwise
     */
    public static boolean matches(String str, List<String> strs) {
        if (isEmpty(str) || isEmpty(strs)) {
            return false;
        }
        for (String pattern : strs) {
            if (isMatch(pattern, str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determine if a URL matches the specified pattern:
     * ? represents a single character;
     * * represents any string within a single path level, cannot cross levels;
     * ** represents any number of path levels.
     *
     * @param pattern Matching pattern
     * @param url     URL to match against
     * @return true if the URL matches the pattern, false otherwise
     */
    public static boolean isMatch(String pattern, String url) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(pattern, url);
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }

    /**
     * Left pad a number with zeros to reach the specified length. If the number converted to a string is longer than size, only the last size characters are kept.
     *
     * @param num  Number object
     * @param size Specified length of the resulting string
     * @return String representation of the number with specified length
     */
    public static final String padl(final Number num, final int size) {
        return padl(num.toString(), size, '0');
    }

    /**
     * Left pad a string. If the original string length is greater than size, only the last size characters are kept.
     *
     * @param s    Original string
     * @param size Specified length of the resulting string
     * @param c    Character used for padding
     * @return String of specified length, left-padded or truncated from the original string
     */
    public static final String padl(final String s, final int size, final char c) {
        final StringBuilder sb = new StringBuilder(size);
        if (s != null) {
            final int len = s.length();
            if (s.length() <= size) {
                for (int i = size - len; i > 0; i--) {
                    sb.append(c);
                }
                sb.append(s);
            } else {
                return s.substring(len - size, len);
            }
        } else {
            for (int i = size; i > 0; i--) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Clean up a number string by removing trailing zeros after the decimal point.
     *
     * @param old Original string
     * @return Cleaned up string representation of the number
     */
    public static String getCleanNumber(String old) {
        try {
            return (new BigDecimal(old)).stripTrailingZeros().toPlainString();
        } catch (Exception e) {
            return old;
        }
    }

    /**
     * Check if a string is not empty and contains non-whitespace characters.
     *
     * @param str String to check
     * @return true if the string is not empty and contains non-whitespace characters, false otherwise
     */
    public static boolean hasText(String str) {
        return (str != null && !str.isEmpty() && containsText(str));
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}
