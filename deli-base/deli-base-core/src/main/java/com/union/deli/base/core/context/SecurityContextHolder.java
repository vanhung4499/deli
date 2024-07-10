package com.union.deli.base.core.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.union.deli.base.core.constant.SecurityConstants;
import com.union.deli.base.core.core.text.Convert;
import com.union.deli.base.core.utils.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Retrieves user ID, username, token, and other information from the current thread-local variables.
 * Note: This information must be passed in through the request headers at the gateway, and values must be set in the HeaderInterceptor interceptor.
 * Otherwise, this class will not be able to retrieve the information.
 *
 *  @author vanhung4499
 *  @date 7/10/2024
 */
public class SecurityContextHolder {
    private static final TransmittableThreadLocal<Map<String, Object>> THREAD_LOCAL = new TransmittableThreadLocal<>();

    /**
     * Sets a key-value pair in the thread-local map.
     *
     * @param key   The key to set.
     * @param value The value associated with the key. If null, it is set to an empty string.
     */
    public static void set(String key, Object value) {
        Map<String, Object> map = getLocalMap();
        map.put(key, value == null ? StringUtils.EMPTY : value);
    }

    /**
     * Retrieves the value associated with the specified key from the thread-local map.
     *
     * @param key The key whose associated value is to be retrieved.
     * @return The value associated with the specified key, or an empty string if the key does not exist.
     */
    public static String get(String key) {
        Map<String, Object> map = getLocalMap();
        return Convert.toStr(map.getOrDefault(key, StringUtils.EMPTY));
    }

    /**
     * Retrieves the value associated with the specified key from the thread-local map and converts it to the specified type.
     *
     * @param <T>   The type of the value to be retrieved.
     * @param key   The key whose associated value is to be retrieved.
     * @param clazz The class of the type to which the value should be converted.
     * @return The value associated with the specified key, converted to the specified type, or null if the key does not exist.
     */
    public static <T> T get(String key, Class<T> clazz) {
        Map<String, Object> map = getLocalMap();
        return StringUtils.cast(map.getOrDefault(key, null));
    }

    /**
     * Retrieves the thread-local map. If it does not exist, creates a new ConcurrentHashMap and sets it.
     *
     * @return The thread-local map containing the key-value pairs.
     */
    public static Map<String, Object> getLocalMap() {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new ConcurrentHashMap<>();
            THREAD_LOCAL.set(map);
        }
        return map;
    }

    /**
     * Sets the thread-local map to the specified map.
     *
     * @param threadLocalMap The map to be set as the thread-local map.
     */
    public static void setLocalMap(Map<String, Object> threadLocalMap) {
        THREAD_LOCAL.set(threadLocalMap);
    }

    /**
     * Retrieves the user ID from the thread-local map.
     *
     * @return The user ID retrieved from the thread-local map.
     */
    public static Long getUserId() {
        return Convert.toLong(get(SecurityConstants.DETAILS_USER_ID), 0L);
    }

    /**
     * Sets the user ID in the thread-local map.
     *
     * @param account The user ID to be set.
     */
    public static void setUserId(String account) {
        set(SecurityConstants.DETAILS_USER_ID, account);
    }

    /**
     * Retrieves the username from the thread-local map.
     *
     * @return The username retrieved from the thread-local map.
     */
    public static String getUserName() {
        return get(SecurityConstants.DETAILS_USERNAME);
    }

    /**
     * Sets the username in the thread-local map.
     *
     * @param username The username to be set.
     */
    public static void setUserName(String username) {
        set(SecurityConstants.DETAILS_USERNAME, username);
    }

    /**
     * Retrieves the user key from the thread-local map.
     *
     * @return The user key retrieved from the thread-local map.
     */
    public static String getUserKey() {
        return get(SecurityConstants.USER_KEY);
    }

    /**
     * Sets the user key in the thread-local map.
     *
     * @param userKey The user key to be set.
     */
    public static void setUserKey(String userKey) {
        set(SecurityConstants.USER_KEY, userKey);
    }

    /**
     * Retrieves the permissions from the thread-local map.
     *
     * @return The permissions retrieved from the thread-local map.
     */
    public static String getPermission() {
        return get(SecurityConstants.ROLE_PERMISSION);
    }

    /**
     * Sets the permissions in the thread-local map.
     *
     * @param permissions The permissions to be set.
     */
    public static void setPermission(String permissions) {
        set(SecurityConstants.ROLE_PERMISSION, permissions);
    }

    /**
     * Removes all entries from the thread-local map.
     */
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
