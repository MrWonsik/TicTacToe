package model;

import java.util.Random;

public class Game {
    private GameBoard gameBoard;
    private Sign playerSign;
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

    public Sign getPlayerSign() {
        return playerSign;
    }

    public void cpuTurn(){

        int cpuPositionX = 1;
        int cpuPositionY = 1;
        while(gameBoard.getGameBoardFields()[cpuPositionX][cpuPositionY].isFill()){
            Random generator = new Random();
            cpuPositionX = generator.nextInt(3);
            cpuPositionY = generator.nextInt(3);
            //findBestPosition(cpuPositionX, cpuPositionY);
        }

        setSignInBoard(cpuPositionX, cpuPositionY, cpuSign);
    }

    private void findBestPosition(int positionX, int positionY)
    {
        Random generator = new Random();
        positionX = generator.nextInt(3);
        positionY = generator.nextInt(3);
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }


    public boolean isEnd(){
        if(gameBoard.isFill())
        {
            return true;
        }
        else {
            for(int x=0; x<GameBoard.SIZE_OF_BOARD; x++)
            {
                if(gameBoard.getGameBoardFields()[x][0].getSign().getValue() == gameBoard.getGameBoardFields()[x][1].getSign().getValue()
                && gameBoard.getGameBoardFields()[x][0].getSign().getValue() == gameBoard.getGameBoardFields()[x][2].getSign().getValue()
                && gameBoard.getGameBoardFields()[x][0].getSign().getValue() != 0
                )
                {
                    return true;
                }

                if(gameBoard.getGameBoardFields()[0][x].getSign().getValue() == gameBoard.getGameBoardFields()[1][x].getSign().getValue()
                && gameBoard.getGameBoardFields()[0][x].getSign().getValue() == gameBoard.getGameBoardFields()[2][x].getSign().getValue()
                && gameBoard.getGameBoardFields()[0][x].getSign().getValue() != 0
                )
                {
                    return true;
                }

                if(gameBoard.getGameBoardFields()[0][0].getSign().getValue() == gameBoard.getGameBoardFields()[1][1].getSign().getValue()
                && gameBoard.getGameBoardFields()[0][0].getSign().getValue() == gameBoard.getGameBoardFields()[2][2].getSign().getValue()
                && gameBoard.getGameBoardFields()[0][0].getSign().getValue() != 0)
                {
                    return true;
                }

                if(gameBoard.getGameBoardFields()[0][2].getSign().getValue() == gameBoard.getGameBoardFields()[1][1].getSign().getValue()
                && gameBoard.getGameBoardFields()[0][2].getSign().getValue() == gameBoard.getGameBoardFields()[2][0].getSign().getValue()
                && gameBoard.getGameBoardFields()[0][2].getSign().getValue() != 0)
                {
                    return true;
                }

            }

            return false;
        }
    }
}
