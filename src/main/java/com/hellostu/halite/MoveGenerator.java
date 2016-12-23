package com.hellostu.halite;

/**
 * Created by stuartlynch on 21/12/2016.
 */
public class MoveGenerator {

    private GameMap gameMap;
    private int     thisOwnerId;

    ///////////////////////////////////////////////////////
    // Lifecycle
    ///////////////////////////////////////////////////////

    public MoveGenerator(GameMap gameMap, int thisOwnerId) {
        this.gameMap = gameMap;
        this.thisOwnerId = thisOwnerId;
    }

    ///////////////////////////////////////////////////////
    // Public Methods
    ///////////////////////////////////////////////////////

    public Move generateMove(Location location) {
        if(this.gameMap.getSite(location).owner != this.thisOwnerId) return null;

        Direction dir = Direction.randomDirection();
        return new Move(location, dir);
    }

}
