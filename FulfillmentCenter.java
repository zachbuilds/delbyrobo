package delbyrobo;
import battlecode.common.*;

public class FulfillmentCenter extends Building {
    public FulfillmentCenter(RobotController r) {
        super(r);
    }

    static int numDrones = 0;
    
    public void takeTurn() throws GameActionException {
        super.takeTurn();
        

        for (Direction dir : Util.directions) {
        	if(numDrones <= 4) {
	            if(tryBuild(RobotType.DELIVERY_DRONE, dir)) {
	                System.out.println("made a drone");
	                numDrones++;
	            }
            }
        }
    }
}
