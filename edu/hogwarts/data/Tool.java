package edu.hogwarts.data;

public class Tool extends TeachingMaterial{

    private String name;

    private String description;

    public Tool(){}
    public Tool(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Tool(String name, boolean onShoppingList, boolean required, boolean provided, String notes, String name1, String description) {
        super(name, onShoppingList, required, provided, notes);
        this.name = name1;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "edu.hogwarts.data.Tool{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
