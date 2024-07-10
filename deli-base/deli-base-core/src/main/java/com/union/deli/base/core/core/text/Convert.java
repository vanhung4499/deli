package com.union.deli.base.core.core.text;

import com.union.deli.base.core.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.NumberFormat;

/**
 * 404 bug!
 *
 * @author vanhung4499
 * @date 7/10/2024
 */
public class Convert {
    /**
     * Convert to string.<br>
     * If the given value is null or conversion fails, return the default value.<br>
     * Conversion failure does not throw an error.
     *
     * @param value        Value to convert
     * @param defaultValue Default value when conversion fails
     * @return Resulting string
     */
    public static String toStr(Object value, String defaultValue) {
        if (null == value) {
            return defaultValue;
        }
        if (value instanceof String) {
            return (String) value;
        }
        return value.toString();
    }

    /**
     * Convert to string.<br>
     * If the given value is null or conversion fails, return null.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to convert
     * @return Resulting string
     */
    public static String toStr(Object value) {
        return toStr(value, null);
    }

    /**
     * Convert to character.<br>
     * If the given value is null or conversion fails, return the default value.<br>
     * Conversion failure does not throw an error.
     *
     * @param value        Value to convert
     * @param defaultValue Default value when conversion fails
     * @return Resulting character
     */
    public static Character toChar(Object value, Character defaultValue) {
        if (null == value) {
            return defaultValue;
        }
        if (value instanceof Character) {
            return (Character) value;
        }

        final String valueStr = toStr(value, null);
        return StringUtils.isEmpty(valueStr) ? defaultValue : valueStr.charAt(0);
    }

    /**
     * Convert to character.<br>
     * If the given value is null or conversion fails, return null.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to convert
     * @return Resulting character
     */
    public static Character toChar(Object value) {
        return toChar(value, null);
    }

    /**
     * Convert to byte.<br>
     * If the given value is null or conversion fails, return the default value.<br>
     * Conversion failure does not throw an error.
     *
     * @param value        Value to convert
     * @param defaultValue Default value when conversion fails
     * @return Resulting byte
     */
    public static Byte toByte(Object value, Byte defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Byte) {
            return (Byte) value;
        }
        if (value instanceof Number) {
            return ((Number) value).byteValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }
        try {
            return Byte.parseByte(valueStr);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Convert to byte.<br>
     * If the given value is <code>null</code> or conversion fails, return the default value <code>null</code>.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @return Result
     */
    public static Byte toByte(Object value) {
        return toByte(value, null);
    }

    /**
     * Convert to Short.<br>
     * If the given value is <code>null</code> or conversion fails, return the default value.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @param defaultValue Default value when conversion fails
     * @return Result
     */
    public static Short toShort(Object value, Short defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Short) {
            return (Short) value;
        }
        if (value instanceof Number) {
            return ((Number) value).shortValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }
        try {
            return Short.parseShort(valueStr.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Convert to Short.<br>
     * If the given value is <code>null</code> or conversion fails, return the default value <code>null</code>.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @return Result
     */
    public static Short toShort(Object value) {
        return toShort(value, null);
    }

    /**
     * Convert to Number.<br>
     * If the given value is empty or conversion fails, return the default value.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @param defaultValue Default value when conversion fails
     * @return Result
     */
    public static Number toNumber(Object value, Number defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Number) {
            return (Number) value;
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }
        try {
            return NumberFormat.getInstance().parse(valueStr);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Convert to Number.<br>
     * If the given value is empty or conversion fails, return the default value <code>null</code>.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @return Result
     */
    public static Number toNumber(Object value) {
        return toNumber(value, null);
    }

    /**
     * Convert to int.<br>
     * If the given value is null or conversion fails, return the default value.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @param defaultValue Default value when conversion fails
     * @return Result
     */
    public static Integer toInt(Object value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(valueStr.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Convert to int.<br>
     * If the given value is <code>null</code> or conversion fails, return the default value <code>null</code>.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @return Result
     */
    public static Integer toInt(Object value) {
        return toInt(value, null);
    }

    /**
     * Convert to Integer array.<br>
     *
     * @param str Value to be converted
     * @return Result
     */
    public static Integer[] toIntArray(String str) {
        return toIntArray(",", str);
    }

    /**
     * Convert to Long array.<br>
     *
     * @param str Value to be converted
     * @return Result
     */
    public static Long[] toLongArray(String str) {
        return toLongArray(",", str);
    }

    /**
     * Convert to Integer array.<br>
     *
     * @param split Separator
     * @param str Value to be converted
     * @return Result
     */
    public static Integer[] toIntArray(String split, String str) {
        if (StringUtils.isEmpty(str)) {
            return new Integer[]{};
        }
        String[] arr = str.split(split);
        final Integer[] ints = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            final Integer v = toInt(arr[i], 0);
            ints[i] = v;
        }
        return ints;
    }

    /**
     * Convert to Long array.<br>
     *
     * @param split Separator
     * @param str Value to be converted
     * @return Result
     */
    public static Long[] toLongArray(String split, String str) {
        if (StringUtils.isEmpty(str)) {
            return new Long[]{};
        }
        String[] arr = str.split(split);
        final Long[] longs = new Long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            final Long v = toLong(arr[i], null);
            longs[i] = v;
        }
        return longs;
    }

    /**
     * Convert to String array.<br>
     *
     * @param str Value to be converted
     * @return Result
     */
    public static String[] toStrArray(String str) {
        return toStrArray(",", str);
    }

    /**
     * Convert to String array.<br>
     *
     * @param split Separator
     * @param str Value to be converted
     * @return Result
     */
    public static String[] toStrArray(String split, String str) {
        return str.split(split);
    }

    /**
     * Convert to long.<br>
     * If the given value is null or conversion fails, return the default value.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @param defaultValue Default value when conversion fails
     * @return Result
     */
    public static Long toLong(Object value, Long defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Long) {
            return (Long) value;
        }
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }
        try {
            // Support scientific notation
            return new BigDecimal(valueStr.trim()).longValue();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Convert to long.<br>
     * If the given value is <code>null</code> or conversion fails, return the default value <code>null</code>.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @return Result
     */
    public static Long toLong(Object value) {
        return toLong(value, null);
    }

    /**
     * Convert to double.<br>
     * If the given value is null or conversion fails, return the default value.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @param defaultValue Default value when conversion fails
     * @return Result
     */
    public static Double toDouble(Object value, Double defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Double) {
            return (Double) value;
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }
        try {
            // Support scientific notation
            return new BigDecimal(valueStr.trim()).doubleValue();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Convert to double.<br>
     * If the given value is null or conversion fails, return the default value <code>null</code>.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @return Result
     */
    public static Double toDouble(Object value) {
        return toDouble(value, null);
    }

    /**
     * Convert to Float.<br>
     * If the given value is null or conversion fails, return the default value.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @param defaultValue Default value when conversion fails
     * @return Result
     */
    public static Float toFloat(Object value, Float defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Float) {
            return (Float) value;
        }
        if (value instanceof Number) {
            return ((Number) value).floatValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(valueStr.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Convert to Float.<br>
     * If the given value is null or conversion fails, return the default value <code>null</code>.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @return Result
     */
    public static Float toFloat(Object value) {
        return toFloat(value, null);
    }

    /**
     * Convert to boolean.<br>
     * Supported string values are: true, false, yes, ok, no, 1, 0. If the given value is null or conversion fails, return the default value.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @param defaultValue Default value when conversion fails
     * @return Result
     */
    public static Boolean toBool(Object value, Boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }
        valueStr = valueStr.trim().toLowerCase();
        switch (valueStr) {
            case "true":
            case "yes":
            case "ok":
            case "1":
                return true;
            case "false":
            case "no":
            case "0":
                return false;
            default:
                return defaultValue;
        }
    }

    /**
     * Convert to boolean.<br>
     * If the given value is null or conversion fails, return the default value <code>null</code>.<br>
     * Conversion failure does not throw an error.
     *
     * @param value Value to be converted
     * @return Result
     */
    public static Boolean toBool(Object value) {
        return toBool(value, null);
    }

    /**
     * Convert to Enum object.<br>
     * If the given value is null or conversion fails, return the default value.<br>
     *
     * @param clazz Enum class
     * @param value Value
     * @param defaultValue Default value
     * @return Enum
     */
    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value, E defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (clazz.isAssignableFrom(value.getClass())) {
            @SuppressWarnings("unchecked")
            E myE = (E) value;
            return myE;
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }
        try {
            return Enum.valueOf(clazz, valueStr);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Convert to Enum object.<br>
     * If the given value is null or conversion fails, return the default value <code>null</code>.<br>
     *
     * @param clazz Enum class
     * @param value value
     * @return Enum
     */
    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value) {
        return toEnum(clazz, value, null);
    }

    /**
     * Convert to BigInteger.<br>
     * If the given value is null or conversion fails, return the default value.<br>
     * Conversion failures will not throw errors.
     *
     * @param value        value to be converted
     * @param defaultValue default value when conversion fails
     * @return result
     */
    public static BigInteger toBigInteger(Object value, BigInteger defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof BigInteger) {
            return (BigInteger) value;
        }
        if (value instanceof Long) {
            return BigInteger.valueOf((Long) value);
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }
        try {
            return new BigInteger(valueStr);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Convert to BigInteger.<br>
     * If the given value is null or conversion fails, return the default value <code>null</code>.<br>
     * Conversion failures will not throw errors.
     *
     * @param value value to be converted
     * @return result
     */
    public static BigInteger toBigInteger(Object value) {
        return toBigInteger(value, null);
    }

    /**
     * Convert to BigDecimal.<br>
     * If the given value is null or conversion fails, return the default value.<br>
     * Conversion failures will not throw errors.
     *
     * @param value        value to be converted
     * @param defaultValue default value when conversion fails
     * @return result
     */
    public static BigDecimal toBigDecimal(Object value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        }
        if (value instanceof Long) {
            return new BigDecimal((Long) value);
        }
        if (value instanceof Double) {
            return new BigDecimal((Double) value);
        }
        if (value instanceof Integer) {
            return new BigDecimal((Integer) value);
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }
        try {
            return new BigDecimal(valueStr);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Convert to BigDecimal.<br>
     * If the given value is null or conversion fails, return the default value.<br>
     * Conversion failures will not throw errors.
     *
     * @param value value to be converted
     * @return result
     */
    public static BigDecimal toBigDecimal(Object value) {
        return toBigDecimal(value, null);
    }

    /**
     * Convert an object to a UTF-8 encoded string.<br>
     * 1. Byte arrays and ByteBuffers will be converted to corresponding string arrays.<br>
     * 2. Object arrays will use Arrays.toString method.
     *
     * @param obj object
     * @return string
     */
    public static String utf8Str(Object obj) {
        return str(obj, CharsetKit.CHARSET_UTF_8);
    }

    /**
     * Convert an object to a string.<br>
     * 1. Byte arrays and ByteBuffers will be converted to corresponding string arrays.<br>
     * 2. Object arrays will use Arrays.toString method.
     *
     * @param obj         object
     * @param charsetName character set
     * @return string
     */
    public static String str(Object obj, String charsetName) {
        return str(obj, Charset.forName(charsetName));
    }

    /**
     * Convert an object to a string.<br>
     * 1. Byte arrays and ByteBuffers will be converted to corresponding string arrays.<br>
     * 2. Object arrays will use Arrays.toString method.
     *
     * @param obj     object
     * @param charset character set
     * @return string
     */
    public static String str(Object obj, Charset charset) {
        if (null == obj) {
            return null;
        }

        if (obj instanceof String) {
            return (String) obj;
        } else if (obj instanceof byte[]) {
            return str((byte[]) obj, charset);
        } else if (obj instanceof Byte[]) {
            byte[] bytes = ArrayUtils.toPrimitive((Byte[]) obj);
            return str(bytes, charset);
        } else if (obj instanceof ByteBuffer) {
            return str((ByteBuffer) obj, charset);
        }
        return obj.toString();
    }

    /**
     * Convert byte array to string.
     *
     * @param bytes   byte array
     * @param charset character set
     * @return string
     */
    public static String str(byte[] bytes, String charset) {
        return str(bytes, StringUtils.isEmpty(charset) ? Charset.defaultCharset() : Charset.forName(charset));
    }

    /**
     * Decode byte array.
     *
     * @param data    byte array
     * @param charset character set, if empty, the decoding result depends on the platform
     * @return decoded string
     */
    public static String str(byte[] data, Charset charset) {
        if (data == null) {
            return null;
        }

        if (null == charset) {
            return new String(data);
        }
        return new String(data, charset);
    }

    /**
     * Convert encoded byteBuffer data to string.
     *
     * @param data    data
     * @param charset character set, if empty, use the current system character set
     * @return string
     */
    public static String str(ByteBuffer data, String charset) {
        if (data == null) {
            return null;
        }

        return str(data, Charset.forName(charset));
    }

    /**
     * Convert encoded byteBuffer data to string.
     *
     * @param data    data
     * @param charset character set, if empty, use the current system character set
     * @return string
     */
    public static String str(ByteBuffer data, Charset charset) {
        if (null == charset) {
            charset = Charset.defaultCharset();
        }
        return charset.decode(data).toString();
    }

}
