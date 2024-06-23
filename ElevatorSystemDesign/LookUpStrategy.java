package ElevatorSystemDesign;

import java.util.PriorityQueue;

public class LookUpStrategy implements  ElevatorControllerStrategy{

    PriorityQueue<PendingRequest> upQueue;
    PriorityQueue<PendingRequest> downQueue;

    public LookUpStrategy() {
        this.upQueue = new PriorityQueue<PendingRequest>((first, second)->{
            return first.getDestinationFloor()-second.getDestinationFloor();
        });
        this.downQueue = new PriorityQueue<PendingRequest>((first, second)->{
            return second.getDestinationFloor()-first.getDestinationFloor();
        });;
    }

    @Override
    public void addPendingRequest(PendingRequest pendingRequest) {
        Direction direction = pendingRequest.getDirection();
        if(direction == Direction.UP){
            upQueue.add(pendingRequest);
        }else if(direction ==  Direction.DOWN){
            downQueue.add(pendingRequest);
        }
    }

    @Override
    public void moveElevator(Elevator elevator) {

    }
}
