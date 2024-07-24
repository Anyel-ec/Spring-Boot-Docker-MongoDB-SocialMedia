package top.anyel.rrss.shared.utils.logger;

public interface ICustomLogger {
    void logInfo(String message);
    void logInfo(String message, Exception e);
    void logDebug(String message);
    void logDebug(String message, Exception e);
    void logWarn(String message);
    void logWarn(String message, Exception e);
    void logError(String message, Exception e);
    void logError(String message);

}
