package com.union.deli.base.core.constant;

/**
 * 404 bug!
 *
 * @author vanhung4499
 * @date 7/10/2024
 */
public class HttpStatus {
    /**
     * Operation succeeded
     */
    public static final int SUCCESS = 200;

    /**
     * Object created successfully
     */
    public static final int CREATED = 201;

    /**
     * The request has been accepted
     */
    public static final int ACCEPTED = 202;

    /**
     * The operation was successful but no content is returned
     */
    public static final int NO_CONTENT = 204;

    /**
     * The resource has been moved permanently
     */
    public static final int MOVED_PERM = 301;

    /**
     * Redirect
     */
    public static final int SEE_OTHER = 303;

    /**
     * The resource has not been modified
     */
    public static final int NOT_MODIFIED = 304;

    /**
     * Error in the parameter list (missing or mismatched format)
     */
    public static final int BAD_REQUEST = 400;

    /**
     * Unauthorized access
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * Access forbidden, authorization expired
     */
    public static final int FORBIDDEN = 403;

    /**
     * Resource or service not found
     */
    public static final int NOT_FOUND = 404;

    /**
     * Disallowed HTTP method
     */
    public static final int BAD_METHOD = 405;

    /**
     * Resource conflict or resource locked
     */
    public static final int CONFLICT = 409;

    /**
     * Unsupported data or media type
     */
    public static final int UNSUPPORTED_TYPE = 415;

    /**
     * Internal server error
     */
    public static final int ERROR = 500;

    /**
     * Interface not implemented
     */
    public static final int NOT_IMPLEMENTED = 501;

    /**
     * System warning message
     */
    public static final int WARN = 601;
}

