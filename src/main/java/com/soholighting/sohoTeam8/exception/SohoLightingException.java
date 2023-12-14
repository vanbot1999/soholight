package com.soholighting.sohoTeam8.exception;

/**
 * @author EnochRibin 23089855
 */
public class SohoLightingException extends Exception {
    public SohoLightingException() {
    }

    public SohoLightingException(String message) {
        super(message);
    }

    public SohoLightingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SohoLightingException(Throwable cause) {
        super(cause);
    }

    public SohoLightingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
