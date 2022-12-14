package slf4j.helpers;

import slf4j.Logger;
import slf4j.Marker;

/**
 * A direct NOP (no operation) implementation of {@link Logger}.
 *
 */
public class NOPLogger extends NamedLoggerBase implements Logger {

    private static final long serialVersionUID = -517220405410904473L;

    /**
     * The unique instance of NOPLogger.
     */
    public static final NOPLogger NOP_LOGGER = new NOPLogger();

    /**
     * There is no point in creating multiple instances of NOPLogger. 
     * 
     * The present constructor should be "private" but we are leaving it as "protected" for compatibility.
     */
    protected NOPLogger() {
    }

    /**
     * Always returns the string value "NOP".
     */
    @Override
    public String getName() {
        return "NOP";
    }

    /**
     * Always returns false.
     * @return always false
     */
    @Override
    final public boolean isTraceEnabled() {
        return false;
    }

    /** A NOP implementation. */
    @Override
    final public void trace(String msg) {
        // NOP
    }

    /** A NOP implementation.  */
    @Override
    final public void trace(String format, Object arg) {
        // NOP
    }

    /** A NOP implementation.  */
    @Override
    public final void trace(String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation.  */
    @Override
    public final void trace(String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void trace(String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    final public boolean isDebugEnabled() {
        return false;
    }

    /** A NOP implementation. */
    final public void debug(String msg) {
        // NOP
    }

    /** A NOP implementation.  */
    final public void debug(String format, Object arg) {
        // NOP
    }

    /** A NOP implementation.  */
    final public void debug(String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation.  */
    final public void debug(String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    final public void debug(String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    final public boolean isInfoEnabled() {
        // NOP
        return false;
    }

    /** A NOP implementation. */
    final public void info(String msg) {
        // NOP
    }

    /** A NOP implementation. */
    final public void info(String format, Object arg1) {
        // NOP
    }

    /** A NOP implementation. */
    final public void info(String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation.  */
    final public void info(String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    final public void info(String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    final public boolean isWarnEnabled() {
        return false;
    }

    /** A NOP implementation. */
    final public void warn(String msg) {
        // NOP
    }

    /** A NOP implementation. */
    final public void warn(String format, Object arg1) {
        // NOP
    }

    /** A NOP implementation. */
    final public void warn(String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation.  */
    final public void warn(String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    final public void warn(String msg, Throwable t) {
        // NOP
    }

    /** A NOP implementation. */
    final public boolean isErrorEnabled() {
        return false;
    }

    /** A NOP implementation. */
    final public void error(String msg) {
        // NOP
    }

    /** A NOP implementation. */
    final public void error(String format, Object arg1) {
        // NOP
    }

    /** A NOP implementation. */
    final public void error(String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation.  */
    final public void error(String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    final public void error(String msg, Throwable t) {
        // NOP
    }

    // ============================================================
    // Added NOP methods since MarkerIgnoringBase is now deprecated
    // ============================================================
    /**
     * Always returns false.
     * @return always false
     */
    final public boolean isTraceEnabled(Marker marker) {
        // NOP
        return false;
    }

    /** A NOP implementation. */
    @Override
    final public void trace(Marker marker, String msg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void trace(Marker marker, String format, Object arg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void trace(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void trace(Marker marker, String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void trace(Marker marker, String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    final public boolean isDebugEnabled(Marker marker) {
        return false;
    }

    /** A NOP implementation. */
    @Override
    final public void debug(Marker marker, String msg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void debug(Marker marker, String format, Object arg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void debug(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    final public void debug(Marker marker, String format, Object... arguments) {
        // NOP
    }

    @Override
    final public void debug(Marker marker, String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    @Override
    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    /** A NOP implementation. */
    @Override
    final public void info(Marker marker, String msg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void info(Marker marker, String format, Object arg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void info(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void info(Marker marker, String format, Object... arguments) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void info(Marker marker, String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    @Override
    final public boolean isWarnEnabled(Marker marker) {
        return false;
    }

    /** A NOP implementation. */
    @Override
    final public void warn(Marker marker, String msg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void warn(Marker marker, String format, Object arg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void warn(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void warn(Marker marker, String format, Object... arguments) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void warn(Marker marker, String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    @Override
    final public boolean isErrorEnabled(Marker marker) {
        return false;
    }

    /** A NOP implementation. */
    @Override
    final public void error(Marker marker, String msg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void error(Marker marker, String format, Object arg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void error(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void error(Marker marker, String format, Object... arguments) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    final public void error(Marker marker, String msg, Throwable t) {
        // NOP
    }
    // ===================================================================
    // End of added NOP methods since MarkerIgnoringBase is now deprecated
    // ===================================================================

}
