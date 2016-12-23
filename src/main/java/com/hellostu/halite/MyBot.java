package com.hellostu.halite;

public class MyBot {
    public static void main(String[] args) throws java.io.IOException {
        InitPackage iPackage = Networking.getInit();
        int myID = iPackage.myID;
        GameMap gameMap = iPackage.map;

        Networking.sendInit("MyJavaBot");
        MoveGenerator moveGenerator = new MoveGenerator(gameMap, myID);
        MovesGenerator movesGenerator = new MovesGenerator(gameMap, moveGenerator);

        while(true) {
            Networking.sendFrame(movesGenerator.generateMoves());
        }
    }
}
