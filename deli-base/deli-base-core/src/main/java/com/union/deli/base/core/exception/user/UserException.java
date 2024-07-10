package com.union.deli.base.core.exception.user;

import com.union.deli.base.core.exception.base.BaseException;

/**
 * 404 bug!
 *
 * @author vanhung4499
 * @date 7/10/2024
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
