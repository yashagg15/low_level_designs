package CustomLogger;

import java.io.File;

public class FileLogSink implements LogSink{

    private String filename;

    public FileLogSink(String filename){
        this.filename = filename;
    }

    @Override
    public void write(String message) {
        System.out.println("Message published in file log sink");
        System.out.println(message);
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
