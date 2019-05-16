package model;

public class Circle extends Sign {
    private String imgPath;
    private int value;

    public Circle()
    {
        imgPath = "Circle.jpg";
        value = 1;
    }

    public String getImgPath() {
        return imgPath;
    }

    public int getValue() {
        return value;
    }
}
