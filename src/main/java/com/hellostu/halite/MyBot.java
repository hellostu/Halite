package com.hellostu.halite;

public class MyBot {
    public static void main(String[] args) throws java.io.IOException {
        InitPackage iPackage = Networking.getInit();
        Users users = new Users(iPackage.map, iPackage.myID);

        Networking.sendInit("MyJavaBot");
        MoveGenerator moveGenerator = new MoveGenerator(users);
        MovesGenerator movesGenerator = new MovesGenerator(new GameMapFetcher(), moveGenerator);

        while(true) {
            Networking.sendFrame(movesGenerator.generateMoves());
        }
    }
}
