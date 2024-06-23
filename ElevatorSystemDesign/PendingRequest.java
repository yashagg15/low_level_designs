package ElevatorSystemDesign;

public class PendingRequest {

    private int sourceFloor;
    private int destinationFloor;
    private Direction direction;
    private RequestLocation requestLocation;

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public RequestLocation getRequestLocation() {
        return requestLocation;
    }

    public void setRequestLocation(RequestLocation requestLocation) {
        this.requestLocation = requestLocation;
    }
}
