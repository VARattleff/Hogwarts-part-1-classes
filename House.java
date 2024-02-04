public class House {

    private String name;
    private String founder;
    private String[] colors;
    public String getName() {
        return name;
    }

    public House(){}
    public House (String name, String founder, String[]colors) {
        this.name = name;
        this.founder = founder;
        this.colors = colors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public String toString() {
        StringBuilder colorsString = new StringBuilder();
        if (colors != null && colors.length > 0) {
            for (String color : colors) {
                colorsString.append(color).append(", ");
            }
            colorsString.replace(colorsString.lastIndexOf(", "), colorsString.length(), "");
        } else {
            colorsString.append("None");
        }

        return "House{\n" +
                "Name: " + name + "\n" +
                "Founder: " + founder + "\n" +
                "Colors: " + colorsString + "\n" +
                "}";
    }

}
