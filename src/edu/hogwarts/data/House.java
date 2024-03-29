package src.edu.hogwarts.data;

public class House implements HogwartsPerson {

    private final HouseOrigin name;
    private final String founder;
    private final String[] colors;

    private static final House gryffindor = new House(HouseOrigin.GRYFFINDOR, "Godric Gryffindor", "scarlet", "gold");
    private static final House hufflepuff = new House(HouseOrigin.HUFFLEPUFF, "Helga Hufflepuff", "yellow", "black");
    private static final House ravenclaw = new House(HouseOrigin.RAVENCLAW, "Rowena Ravenclaw", "blue", "silver");
    private static final House slytherin = new House(HouseOrigin.SLYTHERIN, "Salazar Slytherin", "green", "silver");

    public House(HouseOrigin name, String founder, String... colors) {
        this.name = name;
        this.founder = founder;
        this.colors = colors;
    }

    public static House getGryffindor() {
        return gryffindor;
    }

    public static House getSlytherin() {
        return slytherin;
    }

    public static House getRavenclaw() {
        return ravenclaw;
    }

    public static House getHufflepuff() {
        return hufflepuff;
    }

    public HouseOrigin getName() {
        return name;
    }

    public String toString() {
        StringBuilder colorString = new StringBuilder();
        if(colors.length > 0){
            for(String color : colors){
                colorString.append(color).append(", ");
            }
            colorString.replace(colorString.lastIndexOf(", "), colorString.length()-1, ".");
        }
        return "src.edu.hogwarts.data.House{\n" +
                " name: " + name + "\n" +
                " founder: " + founder + "\n" +
                " colors: " + colorString + "\n" +
                "}";
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public House getHouse() {
        return null;
    }

    @Override
    public String getEmployment() {
        return null;
    }
}



