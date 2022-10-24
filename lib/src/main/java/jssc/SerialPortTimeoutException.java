package jssc;


public class SerialPortTimeoutException extends Exception {
    final private static long serialVersionUID = 1L;

    /** Serial port object **/
    private SerialPort port;
    /** Method name **/
    private String methodName;
    /** Timeout value **/
    private int timeoutValue;

    /** Port name **/
    @Deprecated
    private String portName;

    /**
     * Constructs a new <code>SerialPortTimeoutException</code>
     *
     * @param port Port which the exception occurred on
     * @param methodName Method name which the exception occurred on
     * @param timeoutValue Timeout value which the exception occurred on
     */
    public SerialPortTimeoutException(SerialPort port, String methodName, int timeoutValue) {
        super("Port name - " + port.getPortName() + "; Method name - " + methodName + "; Serial port operation timeout (" + timeoutValue + " ms).");
        this.port = port;
        this.methodName = methodName;
        this.timeoutValue = timeoutValue;
    }

    /**
     * Constructs a new <code>SerialPortTimeoutException</code>
     * Deprecated: Use <code>SerialPortTimeoutException(SerialPort, String, int)</code> instead.
     *
     * @param portName Port name which the exception occurred on
     * @param methodName Method name which the exception occurred on
     * @param timeoutValue Timeout value which the exception occurred on
     *
     * @see #SerialPortTimeoutException(SerialPort, String, int)
     */
    @Deprecated
    public SerialPortTimeoutException(String portName, String methodName, int timeoutValue) {
        super("Port name - " + portName + "; Method name - " + methodName + "; Serial port operation timeout (" + timeoutValue + " ms).");
        this.portName = portName;
        this.methodName = methodName;
        this.timeoutValue = timeoutValue;
    }

    /**
     * Getting port name during operation with which the exception was called
     * Deprecated: Use <code>getPort().getName()</code> instead.
     *
     * @return Port name
     */
    @Deprecated
    public String getPortName() {
        return port != null ? port.getPortName() : portName;
    }

    /**
     * Gets the <code>SerialPort</code> which threw the exception
     *
     * @return <code>SerialPort</code> object
     */
    @SuppressWarnings("unused")
    public SerialPort getPort() {
        return port;
    }

    /**
     * Gets the method name during execution of which the exception was called
     *
     * @return Calling method name
     */
    @SuppressWarnings("unused")
    public String getMethodName() {
        return methodName;
    }

    /**
     * Gets timeout value of which the exception was called
     *
     * @return Calling method name
     */
    @SuppressWarnings("unused")
    public int getTimeoutValue() {
        return timeoutValue;
    }
}
