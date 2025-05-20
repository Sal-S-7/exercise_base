package org.example.exerciseDesignPattern.exercise01;

public class HouseInfo {

    private int floorNmbr;
    private boolean pool;
    private String roofingType;
    private String color;

    private HouseInfo(Builder builder){
        floorNmbr = builder.floorNmbr;
        pool = builder.pool;
        roofingType = builder.roofingType;
        color = builder.color;

    }

    public static class Builder {
        private int floorNmbr;
        private boolean pool;
        private String roofingType;
        private String color;

        public Builder floorNmbr(int floorNmbr) {
            this.floorNmbr = floorNmbr;
            return this;
        }
        public Builder pool(boolean pool) {
            this.pool = pool;
            return this;
        }
        public Builder roofingType(String roofingType) {
            this.roofingType = roofingType;
            return this;
        }
        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public HouseInfo build(){
            return new HouseInfo(this);
        }

    }

    @Override
    public String toString() {
        return "Information on the house : \n" + "\n- Number of floors : " + floorNmbr + "\n- Pool? " + pool + "\n- Roofing type : " + roofingType  + "\n- Color : " + color  ;
    }
}
