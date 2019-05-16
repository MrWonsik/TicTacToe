package model;

import java.util.Random;

public class Game {
    private GameBoard gameBoard;
    private Sign playerSign;

    public Sign getCpuSign() {
        return cpuSign;
    }

    private Sign cpuSign;

    public Game(){
        gameBoard = new GameBoard();
        playerSign = new Circle();
        cpuSign = new Cross();
    }

    public void setSignInBoard(int positionX, int positionY, Sign sign){
        if(gameBoard.getGameBoardFields()[positionX][positionY].getSign().getValue() == 0 ) {
            gameBoard.getGameBoardFields()[positionX][positionY].setSign(sign);
        }
    }

    public void cpuTurn(){
        Random generator = new Random();
        int cpuPositionX;
        int cpuPositionY;
        do {
            cpuPositionX = generator.nextInt(3);
            cpuPositionY = generator.nextInt(3);
        } while(gameBoard.getGameBoardFields()[cpuPositionX][cpuPositionY].isFill());

        setSignInBoard(cpuPositionX, cpuPositionY, cpuSign);

    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Sign getPlayerSign() {
        return playerSign;
    }

    public boolean isEnd(){
        if(gameBoard.isFill())
        {
            return true;
        }

        return false;
    }
}
