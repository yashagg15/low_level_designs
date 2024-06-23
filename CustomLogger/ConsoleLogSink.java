package CustomLogger;

public class ConsoleLogSink implements LogSink{

    public ConsoleLogSink(){

    }
    @Override
    public void write(String message) {

        System.out.println("Message published in console");
        System.out.println(message);
    }
}
