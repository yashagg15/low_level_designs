package CustomLogger;

public class Logger {

    private LogSink logSink;

    private Logger nextLogger;

    Logger(LogSink logSink, Logger nextLogger) {
        this.logSink = logSink;  // BY DEFAULT IT IS A CONSOLE LOG SINK
        this.nextLogger = nextLogger;
    }


    public LogSink getLogSink() {
        return logSink;
    }

    public void setLogSink(LogSink logSink) {
        this.logSink = logSink;
        this.nextLogger = new InfoLogger(new DebugLogger(new ErrorLogger(null,logSink),logSink),logSink);
    }
    public void log(LogLevel logLevel, String message){
        if(nextLogger!=null){
            nextLogger.log(logLevel,message);
        }
    }

}
