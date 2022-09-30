package com.kivous.g2cbottomsheet;

public class VerticalObject {
//    private int pacImage;
    private String pacName;
    private String pacDescription;
    private String pacCost;

    public VerticalObject(int pacImage, String pacName, String pacDescription, String pacCost) {
//        this.pacImage = pacImage;
        this.pacName = pacName;
        this.pacDescription = pacDescription;
        this.pacCost = pacCost;
    }

//    public int getPacImage() {
//        return pacImage;
//    }

    public void setPacImage(int pacImage) {
//        this.pacImage = pacImage;
    }

    public String getPacName() {
        return pacName;
    }

    public void setPacName(String pacName) {
        this.pacName = pacName;
    }

    public String getPacDescription() {
        return pacDescription;
    }

    public void setPacDescription(String pacDescription) {
        this.pacDescription = pacDescription;
    }

    public String getPacCost() {
        return pacCost;
    }

    public void setPacCost(String pacCost) {
        this.pacCost = pacCost;
    }
}
