package com.union.deli.base.core.constant;

/**
 * 404 bug!
 *
 * @author vanhung4499
 * @date 7/10/2024
 */
public class CacheConstants {
    /**
     * Redis key for login user tokens
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * Redis key for captcha codes
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * Cache key for system configuration parameters
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * Cache key for system dictionaries
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * Redis key for preventing duplicate submissions
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * Redis key for rate limiting
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * Redis key for login account password error count
     */
    public static final String PWD_ERR_CNT_KEY = "pwd_err_cnt:";

    /**
     * Maximum password retry count
     */
    public final static int PASSWORD_MAX_RETRY_COUNT = 5;

    /**
     * Password lock time, default 10 (minutes)
     */
    public final static int PASSWORD_LOCK_TIME = 10;

    /**
     * Cache key for login IP blacklist
     */
    public static final String SYS_LOGIN_BLACKIPLIST = SYS_CONFIG_KEY + "sys.login.blackIPList";
}
