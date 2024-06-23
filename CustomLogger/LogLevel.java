package CustomLogger;

// Different log levels
public enum LogLevel {

    INFO(1),
    DEBUG(2),
    WARN(3),
    ERROR(4);
    private  int level;
     LogLevel(int level){
        this.level = level;
    }
}
