package slf4j.helpers;

import slf4j.ILoggerFactory;
import slf4j.Logger;

/**
 * NOPLoggerFactory is a trivial implementation of {@link
 * ILoggerFactory} which always returns the unique instance of
 * NOPLogger.
 * 
 */
public class NOPLoggerFactory implements ILoggerFactory {

    public NOPLoggerFactory() {
        // nothing to do
    }

    public Logger getLogger(String name) {
        return NOPLogger.NOP_LOGGER;
    }

}
