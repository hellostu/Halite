package com.hellostu.halite;

/**
 * Created by stuartlynch on 21/12/2016.
 */
public class MoveGenerator {

    private GameMap gameMap;
    private GameMapProperties gameMapProperties;
    private Users   users;

    ///////////////////////////////////////////////////////
    // Lifecycle
    ///////////////////////////////////////////////////////

    public MoveGenerator(Users users) {
        this.users = users;
    }

    ///////////////////////////////////////////////////////
    // Public Methods
    ///////////////////////////////////////////////////////

    public Move generateMove(Location location) {
        Site site = gameMap.getSite(location);
        if(users.isOwnSite(site) == false) return null;

        Direction directionToMove = Direction.STILL;
        int adjacentSitesOwned = 0;

        for(int i=0; i<4; i++) {
            Direction potentialDirection = Direction.CARDINALS[i];
            Location adjacentLocation = gameMap.getLocation(location, potentialDirection);
            Site adjacentSite = gameMap.getSite(adjacentLocation);

            //Already owns site?
            if(users.isOwnSite(adjacentSite)) {
                adjacentSitesOwned++;
                continue;
            }

            if(gameMapProperties.numberOfNeighbourEnemies(adjacentLocation) > 1) {
                directionToMove = potentialDirection;
                break;
            }

            //Is adjacent site too strong?
            if (site.strength <= adjacentSite.strength && users.isOwnSite(adjacentSite) == false) continue;

            directionToMove = potentialDirection;
        }

        if(adjacentSitesOwned == 4 && site.strength > Math.min(100, site.production * site.production)) {
            directionToMove = this.gameMapProperties.getDirection(location, gameMapProperties.nearestEnemy(location));
        }

        return new Move(location, directionToMove);
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
        this.gameMapProperties = new GameMapProperties(gameMap, users);
    }


}
