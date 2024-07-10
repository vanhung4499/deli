package com.union.deli.base.core.utils;

import com.union.deli.base.core.utils.spring.SpringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 404 bug!
 *
 * @author vanhung4499
 * @date 7/10/2024
 */
public class MessageUtils {

    /**
     * Get message based on message code and arguments, delegate to Spring MessageSource.
     *
     * @param code Message code
     * @param args Arguments
     * @return Internationalized message value
     */
    public static String message(String code, Object... args) {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}

