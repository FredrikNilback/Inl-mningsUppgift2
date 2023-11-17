public class Crop extends Entity {
    private String cropType;
    protected int quantity;

    //constructor
    public Crop(String cropType) {
        super("Why would I name a crop?");
        this.cropType = cropType;
        this.quantity = 0;
    }


    public void addCrop(int change) {
        this.quantity += change;
    }
    public boolean takeCrop(int change) { 
        if(change > this.quantity) {
            System.out.println("Insufficient amount of crops." + "\n");
            return false;
        }
        else {
            System.out.println(change + " " + this.cropType + " removed");
            this.addCrop(-change);
            return true;
        }
    }

    @Override
    public String getDescription() {
        int spacing = 8 - this.cropType.length();
        String SpacingString = " ";
        for(int i = 0; i < spacing; i++) {
            SpacingString = (SpacingString + " ");
        }
        return ("Type: " + this.cropType + SpacingString + "Quantity: " + this.quantity);
    }

    
    //getters setters
    public String getCropType() {
        return cropType;
    }
    public int getQuantity() {
        return quantity;
    }
}