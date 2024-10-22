public class builderEx1 {
    public static void main(String[] args) {
        // Using the builder to create a house
        House house = new House.Builder()
            .setFoundation("Concrete")
            .setStructure("Wood")
            .setRoof("Shingles")
            .setWindows(4)
            .setDoors(2)
            .build();

        // Output the built house
        System.out.println(house);
    }
}

class House{
    private String foundation;
    private String structure;
    private String roof;
    private int windows;
    private int doors;

    // Private constructor to prevent direct object creation
    private House() {}

    public String getFoundation(){return foundation;}
    public String getStructure(){return structure;}
    public String getRoof(){return roof;}
    public int getWindows(){return windows;}
    public int getDoors(){return doors;}

    @Override
    public String toString(){
        return "House with foundation : " + foundation +
                ", structure : " + structure + 
                ", roof : " + roof + 
                ", windows : " + windows + 
                ", doors : " + doors;
    }

    // Static nested Builder class
    public static class Builder{
        private String foundation;
        private String structure;
        private String roof;
        private int windows;
        private int doors;

        public Builder setFoundation(String foundation){
            this.foundation = foundation;
            return this;
        }

        public Builder setStructure(String structure){
            this.structure = structure;
            return this;
        }

        public Builder setRoof(String roof){
            this.roof = roof;
            return this;
        }

        public Builder setWindows(int windows){
            this.windows = windows;
            return this;
        }

        public Builder setDoors(int doors){
            this.doors = doors;
            return this;
        }

        public House build(){
            House house = new House();
            house.foundation = this.foundation;
            house.structure = this.structure;
            house.roof = this.roof;
            house.windows = this.windows;
            house.doors = this.doors;
            return house;
        }
    }
}
