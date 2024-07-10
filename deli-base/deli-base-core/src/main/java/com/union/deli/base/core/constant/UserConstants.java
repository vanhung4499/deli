package com.union.deli.base.core.constant;

/**
 * 404 bug!
 *
 * @author vanhung4499
 * @date 7/10/2024
 */
public class UserConstants {
    /**
     * Unique identifier for system users within the platform
     */
    public static final String SYS_USER = "SYS_USER";

    /**
     * Normal status
     */
    public static final String NORMAL = "0";

    /**
     * Exceptional status
     */
    public static final String EXCEPTION = "1";

    /**
     * User disable status
     */
    public static final String USER_DISABLE = "1";

    /**
     * Role disable status
     */
    public static final String ROLE_DISABLE = "1";

    /**
     * Normal department status
     */
    public static final String DEPT_NORMAL = "0";

    /**
     * Disabled department status
     */
    public static final String DEPT_DISABLE = "1";

    /**
     * Normal dictionary status
     */
    public static final String DICT_NORMAL = "0";

    /**
     * Whether it is a system default (yes)
     */
    public static final String YES = "Y";

    /**
     * Whether it is a menu external link (yes)
     */
    public static final String YES_FRAME = "0";

    /**
     * Whether it is a menu external link (no)
     */
    public static final String NO_FRAME = "1";

    /**
     * Menu type (directory)
     */
    public static final String TYPE_DIR = "M";

    /**
     * Menu type (menu)
     */
    public static final String TYPE_MENU = "C";

    /**
     * Menu type (button)
     */
    public static final String TYPE_BUTTON = "F";

    /**
     * Layout component identifier
     */
    public final static String LAYOUT = "Layout";

    /**
     * ParentView component identifier
     */
    public final static String PARENT_VIEW = "ParentView";

    /**
     * InnerLink component identifier
     */
    public final static String INNER_LINK = "InnerLink";

    /**
     * Validation return result code
     */
    public final static String UNIQUE = "0";
    public final static String NOT_UNIQUE = "1";

    /**
     * Username length limits
     */
    public static final int USERNAME_MIN_LENGTH = 2;
    public static final int USERNAME_MAX_LENGTH = 20;

    /**
     * Password length limits
     */
    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 20;
}
