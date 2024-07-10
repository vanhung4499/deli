package com.union.deli.base.core.constant;

import io.jsonwebtoken.Claims;

/**
 * 404 bug!
 *
 * @author vanhung4499
 * @date 7/10/2024
 */
public class Constants {

    /**
     * UTF-8 character set
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK character set
     */
    public static final String GBK = "GBK";

    /**
     * Main domain prefix
     */
    public static final String WWW = "www.";

    /**
     * HTTP request prefix
     */
    public static final String HTTP = "http://";

    /**
     * HTTPS request prefix
     */
    public static final String HTTPS = "https://";

    /**
     * Common success identifier
     */
    public static final String SUCCESS = "0";

    /**
     * Common failure identifier
     */
    public static final String FAIL = "1";

    /**
     * Login success message
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * Logout message
     */
    public static final String LOGOUT = "Logout";

    /**
     * Register message
     */
    public static final String REGISTER = "Register";

    /**
     * Login failure message
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * Captcha expiration time (minutes)
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * Token
     */
    public static final String TOKEN = "token";

    /**
     * Token prefix
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * Login user key
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * User ID
     */
    public static final String JWT_USERID = "userid";

    /**
     * User name
     */
    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * User avatar
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * Creation time
     */
    public static final String JWT_CREATED = "created";

    /**
     * User authorities
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * Resource mapping path prefix
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * RMI (Remote Method Invocation) lookup
     */
    public static final String LOOKUP_RMI = "rmi:";

    /**
     * LDAP (Lightweight Directory Access Protocol) lookup
     */
    public static final String LOOKUP_LDAP = "ldap:";

    /**
     * LDAPS (LDAP over SSL) lookup
     */
    public static final String LOOKUP_LDAPS = "ldaps:";

    /**
     * Scheduled task whitelist configuration (only allowed package names, add others as needed)
     */
    public static final String[] JOB_WHITELIST_STR = { "com.union.deli" };

    /**
     * Scheduled task prohibited characters
     */
    public static final String[] JOB_ERROR_STR = { "java.net.URL", "javax.naming.InitialContext", "org.yaml.snakeyaml",
            "org.springframework", "org.apache", "com.union.deli.common.utils.file", "com.union.deli.common.config" };

    /**
     * Automatic JSON object recognition whitelist configuration (only allowed package names for safer parsing)
     */
    public static final String[] JSON_WHITELIST_STR = { "org.springframework", "com.deli" };

    /**
     * Login success status
     */
    public static final String LOGIN_SUCCESS_STATUS = "0";

    /**
     * Login failure status
     */
    public static final String LOGIN_FAIL_STATUS = "1";

    /**
     * Demo account username
     */
    public static final String DEMO_ACCOUNT = "union";
}
