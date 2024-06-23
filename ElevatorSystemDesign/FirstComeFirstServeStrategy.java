package ElevatorSystemDesign;

import java.util.LinkedList;
import java.util.Queue;

public class FirstComeFirstServeStrategy implements ElevatorControllerStrategy{

    public Queue<PendingRequest> queue = new LinkedList<>();

    public FirstComeFirstServeStrategy(Queue<PendingRequest> queue) {
        this.queue = queue;
    }

    @Override
    public void addPendingRequest(PendingRequest pendingRequest) {
        queue.add(pendingRequest);
    }

    @Override
    public void moveElevator(Elevator elevator) {

    }
}
