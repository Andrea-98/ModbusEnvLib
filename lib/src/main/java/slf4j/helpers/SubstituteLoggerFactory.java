package slf4j.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import slf4j.ILoggerFactory;
import slf4j.Logger;
import slf4j.event.SubstituteLoggingEvent;

/**
 * SubstituteLoggerFactory manages instances of {@link SubstituteLogger}.
 *
 */
public class SubstituteLoggerFactory implements ILoggerFactory {

    volatile boolean postInitialization = false;

    final Map<String, SubstituteLogger> loggers = new ConcurrentHashMap<>();

    final LinkedBlockingQueue<SubstituteLoggingEvent> eventQueue = new LinkedBlockingQueue<>();

    synchronized public Logger getLogger(String name) {
        SubstituteLogger logger = loggers.get(name);
        if (logger == null) {
            logger = new SubstituteLogger(name, eventQueue, postInitialization);
            loggers.put(name, logger);
        }
        return logger;
    }

    public List<String> getLoggerNames() {
        return new ArrayList<>(loggers.keySet());
    }

    public List<SubstituteLogger> getLoggers() {
        return new ArrayList<>(loggers.values());
    }

    public LinkedBlockingQueue<SubstituteLoggingEvent> getEventQueue() {
        return eventQueue;
    }

    public void postInitialization() {
        postInitialization = true;
    }

    public void clear() {
        loggers.clear();
        eventQueue.clear();
    }
}
