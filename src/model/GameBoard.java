package model;

public class GameBoard {
    final static int SIZE_OF_BOARD = 3;
    GameBoardField[][] gameBoardFields;

    GameBoard() {
        gameBoardFields = new GameBoardField[SIZE_OF_BOARD][SIZE_OF_BOARD];
        for (int x = 0; x < SIZE_OF_BOARD; x++){
            for(int y=0; y < SIZE_OF_BOARD; y++){
                gameBoardFields[x][y] = new GameBoardField();
            }
        }
    }

    public GameBoardField[][] getGameBoardFields() {
        return gameBoardFields;
    }

    public void showGameBoard(){
        for (int x = 0; x < SIZE_OF_BOARD; x++){
            for(int y=0; y < SIZE_OF_BOARD; y++){
                    System.out.print(gameBoardFields[x][y].getSign().getValue() + " ");
            }
            System.out.println();
        }
    }

    public boolean isFill(){
        for (int x = 0; x < SIZE_OF_BOARD; x++){
            for(int y=0; y < SIZE_OF_BOARD; y++){
                if(gameBoardFields[x][y].getSign().getValue() == 0)
                {
                    return false;
                }
            }
        }

        return true;
    }
}
