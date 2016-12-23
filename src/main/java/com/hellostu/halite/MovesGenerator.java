package com.hellostu.halite;

import java.util.ArrayList;

/**
 * Created by stuartlynch on 23/12/2016.
 */
public class MovesGenerator {

    private MoveGenerator moveGenerator;
    private GameMapFetcher gameMapFetcher;

    ///////////////////////////////////////////////////////
    // Lifecycle
    ///////////////////////////////////////////////////////

    public MovesGenerator(GameMapFetcher gameMapFetcher, MoveGenerator moveGenerator) {
        this.gameMapFetcher = gameMapFetcher;
        this.moveGenerator = moveGenerator;
    }

    ///////////////////////////////////////////////////////
    // Public Methods
    ///////////////////////////////////////////////////////

    public ArrayList<Move> generateMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();

        GameMap gameMap = gameMapFetcher.fetchGameMap();
        moveGenerator.setGameMap(gameMap);

        for(int y = 0; y < gameMap.height; y++) {
            for(int x = 0; x < gameMap.width; x++) {
                Move move = moveGenerator.generateMove(new Location(x, y));
                if(move != null) {
                    moves.add(move);
                }
            }
        }
        return moves;
    }

}
