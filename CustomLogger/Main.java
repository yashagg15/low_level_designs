package CustomLogger;


public class Main {

    public static void main(String[] args) {


        LogSink logSink = new ConsoleLogSink();
        Logger logger = new Logger(logSink,new InfoLogger(new DebugLogger
                (new ErrorLogger(null,logSink),logSink),logSink));
        logger.log(LogLevel.INFO,"This is Yash");
        logger.log(LogLevel.ERROR, "Some exception occurred while fetching the users list");
        logger.log(LogLevel.DEBUG, "Hey Yash, This is the debug mode");


        logSink = new FileLogSink("abc.txt");
        logger = new Logger(logSink,new InfoLogger(new DebugLogger
                (new ErrorLogger(null,logSink),logSink),logSink));
        logger.log(LogLevel.INFO,"This is Yash");
        logger.log(LogLevel.ERROR, "Some exception occurred while fetching the users list");
        logger.log(LogLevel.DEBUG, "Hey Yash, This is the debug mode");

        logSink = new DatabaseLogSink("conn:url:https:://abc.txt/logs");
        logger = new Logger(logSink,new InfoLogger(new DebugLogger
                (new ErrorLogger(null,logSink),logSink),logSink));
        logger.log(LogLevel.INFO,"This is Yash");
        logger.log(LogLevel.ERROR, "Some exception occurred while fetching the users list");
        logger.log(LogLevel.DEBUG, "Hey Yash, This is the debug mode");

    }
}
