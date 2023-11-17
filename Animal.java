public class Animal extends Entity {
    private String species;
    private String[] acceptableCropTypes;

    //constructor
    public Animal(String name, String species) {
        super(name);
        this.species = species;

        switch (species) {
            case "Cow": 
                this.acceptableCropTypes = new String[] {"Soy Bean", "Wheat", "Corn", "Oats"};
                break;
            case "Pig": 
                this.acceptableCropTypes = new String[] {"Onion", "Cabbage", "Soy Bean", "Corn", "Carrot", "Potato", "Oats"};
                break;
            case "Sheep":
                this.acceptableCropTypes = new String[] {"Corn", "Wheat", "Canola"};
                break;                
            case "Chicken":
                this.acceptableCropTypes = new String[] {"Corn", "Soy Bean", "Oats"};
                break;            
            case "Horse":
                this.acceptableCropTypes = new String[] {"Corn", "Wheat", "Carrot"};
                break;
            case "Llama":
                this.acceptableCropTypes = new String[] {"Wheat"};
                break;
            default: 
                break;    
        }
    }

    @Override
    public String getDescription() {
        return ("Animal id: " + this.getId() + "\n" +
                "Name: " + this.name + "\n" + 
                "Species: " + this.species);
    }
    
    public void feed(Crop crop, int amount) {
        String cropType = crop.getCropType();
        boolean canEat = false;

        for(int i = 0; i < acceptableCropTypes.length; i++) {
            if(cropType.equals(acceptableCropTypes[i])) {
                canEat = true;
                break;
            }
        }
        if(canEat) {
            if(crop.takeCrop(amount)) {
                System.out.println("The " + this.species + " happily eats the crops." + "\n");
            }
        }
        else {
            System.out.print(this.species + "s can only eat");
            for(int i = 0; i < this.acceptableCropTypes.length; i++) {
                if(i == this.acceptableCropTypes.length - 2) {
                    System.out.print(" " + this.acceptableCropTypes[i] + "and ");
                }
                else if(i == this.acceptableCropTypes.length - 1) {
                    System.out.print(" " + this.acceptableCropTypes[i] + "\n");
                }
                else {
                System.out.print(" " + this.acceptableCropTypes[i] + ", ");
                }
            }
        }
    }

    //getters setters
    public String getName() {
        return name;
    }
    public String[] getAcceptableCropTypes() {
        return acceptableCropTypes;
    }
    public String getSpecies() {
        return species;
    }
}