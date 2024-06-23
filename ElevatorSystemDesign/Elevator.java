package ElevatorSystemDesign;

public class Elevator {

    private Integer elevatorId;
    private Direction direction;
    private int currentFloor;
    private String door; // can create a whole object to control this
    private String display; // can create a whole object to control this
    private ElevatorState elevatorState;
    private static int MAX_WEIGHT_CAPACITY;
    private int currentElevatorWeight;
    private ElevatorControllerStrategy elevatorControllerStrategy;



}
