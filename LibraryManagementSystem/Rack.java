package LibraryManagementSystem;

public class Rack {

    private int rackId;
    private String location;

    public Rack(int rackId, String location) {
        this.rackId = rackId;
        this.location = location;
    }

    public int getRackId() {
        return rackId;
    }

    public void setRackId(int rackId) {
        this.rackId = rackId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
