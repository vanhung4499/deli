package com.union.deli.base.core.exception;

import com.union.deli.base.core.utils.MessageUtils;
import com.union.deli.base.core.utils.StringUtils;

/**
 * 404 bug!
 *
 * @author vanhung4499
 * @date 7/10/2024
 */
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Error message
     */
    private String message;

    /**
     * Detailed error message for internal debugging
     * <p>
     * Designed to be consistent with {@link CommonResult#getDetailMessage()}
     */
    private String detailMessage;

    /**
     * Empty constructor to avoid serialization issues
     */
    public GlobalException() {
    }

    public GlobalException(String message) {
        this.message = message;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    /**
     * Set the detailed error message.
     *
     * @param detailMessage detail message
     * @return this GlobalException instance
     */
    public GlobalException setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public GlobalException setMessage(String message) {
        this.message = message;
        return this;
    }
}
