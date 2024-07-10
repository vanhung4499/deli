package com.union.deli.base.core.exception.base;

import com.union.deli.base.core.utils.MessageUtils;
import com.union.deli.base.core.utils.StringUtils;

/**
 * 404 bug!
 *
 * @author vanhung4499
 * @date 7/10/2024
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Module where the exception occurred
     */
    private String module;

    /**
     * Error code associated with the exception
     */
    private String code;

    /**
     * Arguments for the error code
     */
    private Object[] args;

    /**
     * Default error message
     */
    private String defaultMessage;

    public BaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String module, String code, Object[] args) {
        this(module, code, args, null);
    }

    public BaseException(String module, String defaultMessage) {
        this(module, null, null, defaultMessage);
    }

    public BaseException(String code, Object[] args) {
        this(null, code, args, null);
    }

    public BaseException(String defaultMessage) {
        this(null, null, null, defaultMessage);
    }

    @Override
    public String getMessage() {
        String message = null;
        if (!StringUtils.isEmpty(code)) {
            message = MessageUtils.message(code, args);
        }
        if (message == null) {
            message = defaultMessage;
        }
        return message;
    }

    public String getModule() {
        return module;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
