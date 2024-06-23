package CustomLogger;

public class DatabaseLogSink implements LogSink {

    private String connectionDetails;

    public DatabaseLogSink(String connectionDetails){
        this.connectionDetails = connectionDetails;
    }

    @Override
    public void write(String message) {
        System.out.println("Message published in database log sink");
        System.out.println(message);
    }
}
