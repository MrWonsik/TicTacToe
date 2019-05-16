package model;

public class GameBoardField {
    Sign sign;

    public GameBoardField() {
        sign = new Sign();
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }


    public Sign getSign() {
        return sign;
    }

    public boolean isFill()
    {
        if(sign.getValue() == 0){
            return false;
        }
        else
        {
            return true;
        }
    }
}
