package ElevatorSystemDesign;

public interface ElevatorControllerStrategy {

    void addPendingRequest(PendingRequest pendingRequest);
    void moveElevator(Elevator elevator);
}
