package jssc;


public interface SerialPortEventListener {
    /**
     * Called when an event fires
     *
     * @param serialPortEvent <code>SerialPortEvent</code> object containing port, event type and event data
     */
    void serialEvent(SerialPortEvent serialPortEvent);
}
