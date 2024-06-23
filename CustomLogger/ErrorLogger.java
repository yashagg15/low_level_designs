package CustomLogger;

public class ErrorLogger extends Logger{

    private Logger nextLogger;
    private LogSink logSink;

    public ErrorLogger(Logger nextLogger, LogSink logSink){
        super(logSink, nextLogger);
        this.nextLogger = nextLogger;
        this.logSink = logSink;
    }

    public void log(LogLevel logLevel, String message) {
        if(logLevel==LogLevel.ERROR){
            this.logSink.write(message);
        }else{
            System.out.println("No log level found");
        }
        return;
    }
}
