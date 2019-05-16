package model;

public class Cross extends Sign {
    private String imgPath;
    private int value;

    public Cross()
    {
        this.imgPath = "Cross.jpg";
        this.value = 2;
    }


    public int getValue() {
        return value;
    }
}
