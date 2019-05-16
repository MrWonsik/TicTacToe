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

        Random generator = new Random();
        Point cpuPoint = new Point(1,1);

        while(gameBoard.getGameBoardFields()[cpuPoint.getX()][cpuPoint.getY()].isFill()) {
            cpuPoint.setX(generator.nextInt(3));
            cpuPoint.setY(generator.nextInt(3));
            setCpuPoint(playerSign.getValue(), cpuPoint);
            setCpuPoint(cpuSign.getValue(), cpuPoint);
        }

        setSignInBoard(cpuPoint.getX(), cpuPoint.getY(), cpuSign);
    }
    
    public void setCpuPoint(int signValue, Point toReturn)
    {

        for(int i=0; i < GameBoard.SIZE_OF_BOARD ; i++)
        {
            if(gameBoard.getGameBoardFields()[i][1].getSign().getValue() == signValue
                    && gameBoard.getGameBoardFields()[i][0].getSign().getValue() == signValue
                    && !gameBoard.getGameBoardFields()[i][2].isFill())
            {
                toReturn.setX(i);
                toReturn.setY(2);
            }

            if(gameBoard.getGameBoardFields()[i][2].getSign().getValue() == signValue
                    && gameBoard.getGameBoardFields()[i][0].getSign().getValue() == signValue
                    && !gameBoard.getGameBoardFields()[i][1].isFill())
            {
                toReturn.setX(i);
                toReturn.setY(1);
            }

            if(gameBoard.getGameBoardFields()[i][2].getSign().getValue() == signValue
                    && gameBoard.getGameBoardFields()[i][1].getSign().getValue() == signValue
                    && !gameBoard.getGameBoardFields()[i][0].isFill())
            {
                toReturn.setX(1);
                toReturn.setY(0);
            }
        }

        for(int i=0; i < GameBoard.SIZE_OF_BOARD ; i++)
        {
            if(gameBoard.getGameBoardFields()[1][i].getSign().getValue() == playerSign.getValue()
                    && gameBoard.getGameBoardFields()[0][i].getSign().getValue() == playerSign.getValue()
                    && !gameBoard.getGameBoardFields()[2][i].isFill())
            {
                toReturn.setX(2);
                toReturn.setY(i);
            }

            if(gameBoard.getGameBoardFields()[2][i].getSign().getValue() == playerSign.getValue()
                    && gameBoard.getGameBoardFields()[0][i].getSign().getValue() == playerSign.getValue()
                    && !gameBoard.getGameBoardFields()[1][i].isFill())
            {
                toReturn.setX(1);
                toReturn.setY(i);
            }

            if(gameBoard.getGameBoardFields()[2][i].getSign().getValue() == playerSign.getValue()
                    && gameBoard.getGameBoardFields()[1][i].getSign().getValue() == playerSign.getValue()
                    && !gameBoard.getGameBoardFields()[0][i].isFill())
            {
                toReturn.setX(0);
                toReturn.setY(i);
            }
        }

        if(gameBoard.getGameBoardFields()[0][0].getSign().getValue() == signValue
                && gameBoard.getGameBoardFields()[1][1].getSign().getValue() == signValue
                && !gameBoard.getGameBoardFields()[2][2].isFill())
        {
            toReturn.setX(2);
            toReturn.setY(2);
        }

        if(gameBoard.getGameBoardFields()[0][0].getSign().getValue() == signValue
                && gameBoard.getGameBoardFields()[2][2].getSign().getValue() == signValue
                && !gameBoard.getGameBoardFields()[1][1].isFill())
        {
            toReturn.setX(1);
            toReturn.setY(1);
        }

        if(gameBoard.getGameBoardFields()[1][1].getSign().getValue() == signValue
                && gameBoard.getGameBoardFields()[2][2].getSign().getValue() == signValue
                && !gameBoard.getGameBoardFields()[0][0].isFill())
        {
            toReturn.setX(0);
            toReturn.setY(0);
        }


        if(gameBoard.getGameBoardFields()[2][0].getSign().getValue() == signValue
                && gameBoard.getGameBoardFields()[1][1].getSign().getValue() == signValue
                && !gameBoard.getGameBoardFields()[0][2].isFill())
        {
            toReturn.setX(0);
            toReturn.setY(2);
        }

        if(gameBoard.getGameBoardFields()[2][0].getSign().getValue() == signValue
                && gameBoard.getGameBoardFields()[0][2].getSign().getValue() == signValue
                && !gameBoard.getGameBoardFields()[1][1].isFill())
        {
            toReturn.setX(1);
            toReturn.setY(1);
        }

        if(gameBoard.getGameBoardFields()[0][2].getSign().getValue() == signValue
                && gameBoard.getGameBoardFields()[1][1].getSign().getValue() == signValue
                && !gameBoard.getGameBoardFields()[2][0].isFill())
        {
            toReturn.setX(2);
            toReturn.setY(0);
        }
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

    public void queue(int playerX, int playerY)
    {
        if(playerSign.getValue() == 1)
        {
            setSignInBoard(playerX, playerY, playerSign);
            cpuTurn();
            getGameBoard().showGameBoard();
            System.out.println();
        }
        else
        {
            cpuTurn();
            setSignInBoard(playerX, playerY, playerSign);
            getGameBoard().showGameBoard();
            System.out.println();
        }
    }
}
