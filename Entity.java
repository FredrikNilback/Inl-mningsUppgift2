public class Entity {

    protected String name;
    private int id;
    private static int nextId = 1;

    //constructor
    public Entity(String name) {
        this.id = nextId;
        nextId++;
        this.name = name;
    }

    public String getDescription() {
        return ("Creature id: " + this.id + "\n" + "Creature Name: " + this.name);
    }
    
    //getters, setters
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}