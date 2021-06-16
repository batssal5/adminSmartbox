package com.vdcompany.adminSmartbox.utils;

public class PropertyAccessException extends Exception {
    private static final long serialVersionUID = -6563173185249858025L;

    public PropertyAccessException(String message, Exception cause) {
        super(message, cause);
    }

    public PropertyAccessException(String message) {
        super(message);
    }
}
