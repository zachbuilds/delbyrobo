package delbyrobo;
import battlecode.common.*;

public class Drone extends Unit {

    public Drone(RobotController r) {
        super(r);
    }

    public void takeTurn() throws GameActionException {
        super.takeTurn();


//		int turnCounter = rc.getRoundNum();
		
		if(rc.isCurrentlyHoldingUnit()==false) {
			RobotInfo[] robos = rc.senseNearbyRobots();
			for(RobotInfo robo:robos) {
				if(robo.getTeam()!=rc.getTeam()) {
					while(rc.isCurrentlyHoldingUnit()==false) {
						if(rc.canPickUpUnit(robo.getID())) {
							rc.pickUpUnit(robo.getID());
						}else {
							if(rc.canMove(rc.getLocation().directionTo(robo.getLocation()))) {
								rc.move(rc.getLocation().directionTo(robo.getLocation()));
							}
						}
					}
				}
			}
		}else {
			for(Direction dir:Util.directions) {
				if(rc.senseFlooding(rc.adjacentLocation(dir)) == true) {
					if(rc.isCurrentlyHoldingUnit()) {
						rc.canDropUnit(dir);
					}
				}
			}
		}

		nav.goTo(Util.randomDirection());
    }
}