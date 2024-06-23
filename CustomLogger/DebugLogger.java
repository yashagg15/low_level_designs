package CustomLogger;

public class DebugLogger extends Logger{

    private Logger nextLogger;
    private LogSink logSink;

    public DebugLogger(Logger nextLogger, LogSink logSink){
        super(logSink, nextLogger);
        this.nextLogger = nextLogger;
        this.logSink = logSink;
    }

    public void log(LogLevel logLevel, String message) {
        if(logLevel==LogLevel.DEBUG){
            this.logSink.write(message);
        }else{
            this.nextLogger.log(logLevel,message);
        }
        return;
    }
}
