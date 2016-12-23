package com.hellostu.halite;

import java.util.ArrayList;

/**
 * Created by stuartlynch on 23/12/2016.
 */
public class MovesGenerator {

    private MoveGenerator moveGenerator;
    private GameMap gameMap;

    ///////////////////////////////////////////////////////
    // Lifecycle
    ///////////////////////////////////////////////////////

    public MovesGenerator(GameMap gameMap, MoveGenerator moveGenerator) {
        this.gameMap = gameMap;
        this.moveGenerator = moveGenerator;
    }

    ///////////////////////////////////////////////////////
    // Public Methods
    ///////////////////////////////////////////////////////

    public ArrayList<Move> generateMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();

        gameMap = Networking.getFrame();

        for(int y = 0; y < gameMap.height; y++) {
            for(int x = 0; x < gameMap.width; x++) {
                Move move = moveGenerator.generateMove(new Location(x, y));
                if(move == null) continue;
                moves.add(move);
            }
        }
        return moves;
    }

}
