public class Dog extends Animal {
    private String name;
    private String color;

    public Dog(String species, int age, String name, String color) {
        super(species, age);
        this.name = name;
        this.color = color;
    }
}
