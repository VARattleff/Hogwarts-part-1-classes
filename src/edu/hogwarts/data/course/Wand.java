package src.edu.hogwarts.data.course;

public class Wand extends TeachingMaterial {

    private double lengthInInches;
    private String wood;
    private String core;

    public Wand(){}
    public Wand(double lengthInInches, String wood, String core) {
        this.lengthInInches = lengthInInches;
        this.wood = wood;
        this.core = core;
    }

    public Wand(String name, boolean onShoppingList, boolean required, boolean provided, String notes, double lengthInInches, String wood, String core) {
        super(name, onShoppingList, required, provided, notes);
        this.lengthInInches = lengthInInches;
        this.wood = wood;
        this.core = core;
    }

    public double getLengthInInches() {
        return lengthInInches;
    }

    public void setLengthInInches(double lengthInInches) {
        this.lengthInInches = lengthInInches;
    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String toString() {
        return "src.edu.hogwarts.data.course.Wand{" +
                "lengthInInches=" + lengthInInches +
                ", wood='" + wood + '\'' +
                ", core='" + core + '\'' +
                '}';
    }
}
