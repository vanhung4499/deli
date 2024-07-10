package com.union.deli.base.core.core.text;

import com.union.deli.base.core.utils.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 404 bug!
 *
 * @author vanhung4499
 * @date 7/10/2024
 */
public class CharsetKit {
    /**
     * ISO-8859-1
     */
    public static final String ISO_8859_1 = "ISO-8859-1";
    /**
     * UTF-8
     */
    public static final String UTF_8 = "UTF-8";

    /**
     * ISO-8859-1 Charset
     */
    public static final Charset CHARSET_ISO_8859_1 = Charset.forName(ISO_8859_1);
    /**
     * UTF-8 Charset
     */
    public static final Charset CHARSET_UTF_8 = Charset.forName(UTF_8);

    /**
     * Convert to Charset object
     *
     * @param charset character set, returns default charset if empty
     * @return Charset
     */
    public static Charset charset(String charset) {
        return StringUtils.isEmpty(charset) ? Charset.defaultCharset() : Charset.forName(charset);
    }

    /**
     * Convert the encoding of a string
     *
     * @param source      string
     * @param srcCharset  source charset, default is ISO-8859-1
     * @param destCharset target charset, default is UTF-8
     * @return converted string
     */
    public static String convert(String source, String srcCharset, String destCharset) {
        return convert(source, Charset.forName(srcCharset), Charset.forName(destCharset));
    }

    /**
     * Convert the encoding of a string
     *
     * @param source      string
     * @param srcCharset  source charset, default is ISO-8859-1
     * @param destCharset target charset, default is UTF-8
     * @return converted string
     */
    public static String convert(String source, Charset srcCharset, Charset destCharset) {
        if (null == srcCharset) {
            srcCharset = StandardCharsets.ISO_8859_1;
        }

        if (null == destCharset) {
            destCharset = StandardCharsets.UTF_8;
        }

        if (StringUtils.isEmpty(source) || srcCharset.equals(destCharset)) {
            return source;
        }
        return new String(source.getBytes(srcCharset), destCharset);
    }

    /**
     * @return system's default charset encoding
     */
    public static String systemCharset() {
        return Charset.defaultCharset().name();
    }
}
