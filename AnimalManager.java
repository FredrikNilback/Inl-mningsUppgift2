import java.util.ArrayList;
import java.util.Scanner;

public class AnimalManager {
    private ArrayList<Animal> Animals;


    public AnimalManager() {
        Animals = new ArrayList<>();
    }

    public void AnimalMenu(Crop[] crops) {
        Scanner MenuScanner = new Scanner(System.in);
        boolean Continue = true;
        while(Continue) {
            System.out.println("What would you like to do?" + "\n" + 
                                "[1] View All Current Animals" + "\n" + 
                                "[2] Add Animal" + "\n" + 
                                "[3] Remove Animal" + "\n" +
                                "[4] Feed Animal" + "\n" + 
                                "[q] Return to Main Menu");
            
            String input = MenuScanner.nextLine();
            switch(input) {
                case "1": this.viewAnimals(); break;
                case "2": this.addAnimal(); break;
                case "3": this.removeAnimal(); break;
                case "4": this.feedAnimal(crops); break;
                case "q": Continue = false; break;
                default: System.out.println("Invalid choise"); continue;
            }
        }
    }


    private void viewAnimals() {
        if(Animals.isEmpty()) {
            System.out.println("You currently have no animals." + "\n");
        }
        else {
            for(int i = 0; i < Animals.size(); i++) {
                System.out.println(Animals.get(i).getDescription() + "\n" +
                                "============================================"+ "\n");
            }
        } 
    }

    private void addAnimal() {
        Scanner addAnimalScanner = new Scanner(System.in);
        String[] creatureCreator = new String[2];
        
        boolean Continue = true;
        while(Continue) {
            System.out.println("What Species?" + "\n" + 
                               "[1] Cow" + "\n" + 
                               "[2] Pig" + "\n" + 
                               "[3] Sheep" + "\n" +
                               "[4] Chicken" + "\n" +
                               "[5] Horse" + "\n" +
                               "[6] Llama" + "\n" +
                               "[q] Go back to Animal Manager");
            String species = addAnimalScanner.nextLine();
            switch (species) {
                case "1":
                    creatureCreator[1] = "Cow";    
                    break;
                case "2":
                    creatureCreator[1] = "Pig";
                    break;
                case "3":
                    creatureCreator[1] = "Sheep";
                    break;
                case "4":
                    creatureCreator[1] = "Chicken";
                    break;
                case "5":
                    creatureCreator[1] = "Horse";
                    break;
                case "6":
                    creatureCreator[1] = "Llama";
                    break;
                case "q":
                    Continue = false;
                    break;
                default:
                    System.out.println("Invalid choise");
                    continue;
            }

            if(Continue) {
                System.out.println("Please enter a name for you new " + creatureCreator[1]);
                Scanner nameScanner = new Scanner(System.in);
                String name = nameScanner.nextLine();
                Scanner acceptScanner = new Scanner(System.in);
                System.out.println("Are you happy with the name " + name + "? [y/n]");
                String choise = acceptScanner.nextLine();
                
                if(choise.equals("y")) {
                    Continue = false;
                    creatureCreator[0] = name;
                }
                else {
                    continue;
                }
            }
            else {
                break;
            }
        }
        Animals.add(new Animal(creatureCreator[0], creatureCreator[1]));
    }

    private void removeAnimal() {
        if(Animals.isEmpty()) {
            System.out.println("You have no animals to remove." + "\n");
        }
        else {
            System.out.println("Which animal do you wish to remove?");
            Scanner removeScanner = new Scanner(System.in);
            for(int i = 0; i < Animals.size(); i++) {
                System.out.print("\n"+ "[" + i + "]" + "\n" + Animals.get(i).getDescription() + "\n" +
                                "============================================"+ "\n");
            }
            System.out.println("[q] Return to Animal Manager");
            String choise = removeScanner.nextLine();
            if(!choise.equals("q")) {
                while(true) {
                    try {
                        int intChoise = Integer.parseInt(choise);
                        String removedAnimal = Animals.get(intChoise).getDescription();
                        Animals.remove(intChoise);
                        System.out.println(removedAnimal + "\n" + "was successfully removed" + "\n");
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid Choise" + "\n");
                        break;
                    }
                }
            }
        }
        
    }

    private void feedAnimal(Crop[] crops) {
        if(Animals.isEmpty()) {
            System.out.println("You have no animals to feed." + "\n");
        }
        else {
            System.out.println("Which animal do you wish to feed?");
            Scanner feedScanner = new Scanner(System.in);
            for(int i = 0; i < Animals.size(); i++) {
                System.out.print("\n"+ "[" + i + "]" + "\n" + Animals.get(i).getDescription() + "\n" +
                                "=========================================================="+ "\n");
            }
            System.out.println("[q] Return to Animal Manager");
            String choise = feedScanner.nextLine();
            if(!choise.equals("q")) {
                try {
                    int intChoise = Integer.parseInt(choise);
                } catch (Exception e) {
                    System.out.println("Invalid Choise" + "\n");
                }
                int intChoise = Integer.parseInt(choise);

                
                if(intChoise < Animals.size()) {
                    Scanner cropChoiseScanner = new Scanner(System.in);
                    System.out.println("Choose which crop to feed the " + Animals.get(intChoise).getSpecies());

                    for(int i = 0; i < crops.length; i++) {
                        System.out.println("[" + i + "] " + crops[i].getDescription());
                    }
                    String cropChoise = cropChoiseScanner.nextLine();
                    Scanner amountScanner = new Scanner(System.in);
                    switch (cropChoise) {
                        case "0": 
                            System.out.println("Select amount of " + crops[0].getCropType() + "es to feed the " + Animals.get(intChoise).getSpecies());
                            String amount0 = amountScanner.nextLine();
                            try {
                                int intAmount0 = Integer.parseInt(amount0);
                                Animals.get(intChoise).feed(crops[0], intAmount0);
                            } catch (Exception e) {
                                System.out.println("Invalid Choise" + "\n");
                            }
                            break;                        
                        case "1": 
                            System.out.println("Select amout of " + crops[1].getCropType() + " to feed the " + Animals.get(intChoise).getSpecies());
                            String amount1 = amountScanner.nextLine();
                            try {
                                int intAmount1 = Integer.parseInt(amount1);
                                Animals.get(intChoise).feed(crops[1], intAmount1);
                            } catch (Exception e) {
                                System.out.println("Invalid Choise" + "\n");
                            }
                            break;                    
                        case "2": 
                            System.out.println("Select amout of " + crops[2].getCropType() + "s to feed the " + Animals.get(intChoise).getSpecies());
                            String amount2 = amountScanner.nextLine();
                            try {
                                int intAmount2 = Integer.parseInt(amount2);
                                Animals.get(intChoise).feed(crops[2], intAmount2);
                            } catch (Exception e) {
                                System.out.println("Invalid Choise" + "\n");
                            }
                            break;                    
                        case "3": 
                            System.out.println("Select amout of " + crops[3].getCropType() + " to feed the " + Animals.get(intChoise).getSpecies());
                            String amount3 = amountScanner.nextLine();
                            try {
                                int intAmount3 = Integer.parseInt(amount3);
                                Animals.get(intChoise).feed(crops[3], intAmount3);
                            } catch (Exception e) {
                                System.out.println("Invalid Choise" + "\n");
                            }
                            break;                    
                        case "4": 
                            System.out.println("Select amout of " + crops[4].getCropType() + " to feed the " + Animals.get(intChoise).getSpecies());
                            String amount4 = amountScanner.nextLine();
                            try {
                                int intAmount4 = Integer.parseInt(amount4);
                                Animals.get(intChoise).feed(crops[4], intAmount4);
                            } catch (Exception e) {
                                System.out.println("Invalid Choise" + "\n");
                            }
                            break;                    
                        case "5": 
                            System.out.println("Select amout of " + crops[5].getCropType() + " to feed the " + Animals.get(intChoise).getSpecies());
                            String amount5 = amountScanner.nextLine();
                            try {
                                int intAmount5 = Integer.parseInt(amount5);
                                Animals.get(intChoise).feed(crops[5], intAmount5);
                            } catch (Exception e) {
                                System.out.println("Invalid Choise" + "\n");
                            }
                            break;                    
                        case "6": 
                            System.out.println("Select amout of " + crops[6].getCropType() + "s to feed the " + Animals.get(intChoise).getSpecies());
                            String amount6 = amountScanner.nextLine();
                            try {
                                int intAmount6 = Integer.parseInt(amount6);
                                Animals.get(intChoise).feed(crops[6], intAmount6);
                            } catch (Exception e) {
                                System.out.println("Invalid Choise" + "\n");
                            }
                            break;                    
                        case "7": 
                            System.out.println("Select amout of " + crops[7].getCropType() + "s to feed the " + Animals.get(intChoise).getSpecies());
                            String amount7 = amountScanner.nextLine();
                            try {
                                int intAmount7 = Integer.parseInt(amount7);
                                Animals.get(intChoise).feed(crops[7], intAmount7);
                            } catch (Exception e) {
                                System.out.println("Invalid Choise" + "\n");
                            }
                            break;                    
                        case "8": 
                            System.out.println("Select amout of " + crops[8].getCropType() + "es to feed the " + Animals.get(intChoise).getSpecies());
                            String amount8 = amountScanner.nextLine();
                            try {
                                int intAmount8 = Integer.parseInt(amount8);
                                Animals.get(intChoise).feed(crops[8], intAmount8);
                            } catch (Exception e) {
                                System.out.println("Invalid Choise" + "\n");
                            }
                            break;                    
                        case "9": 
                            System.out.println("Select amout of " + crops[9].getCropType() + "s to feed the " + Animals.get(intChoise).getSpecies());
                            String amount9 = amountScanner.nextLine();
                            try {
                                int intAmount9 = Integer.parseInt(amount9);
                                Animals.get(intChoise).feed(crops[9], intAmount9);
                            } catch (Exception e) {
                                System.out.println("Invalid Choise" + "\n");
                            }
                            break;                    
                        case "q": 
                            break;   
                        default:
                            break;                     
                    }
                }
                else {
                    System.out.println("Invalid Choise" + "\n");
                }
                
            }
        }
    }

    public void loadAnimal(int id, String name, String species, boolean flush) {
        if(flush && !Animals.isEmpty()) {
            int iterator = 0;
            while(Animals.size() > 0) {
            Animals.remove(iterator);
            iterator++;
            }
        }
        
        Animal loadedAnimal = new Animal(name, species);
        loadedAnimal.setId(id);
        Animals.add(loadedAnimal);
    }

    //getters setters
    public ArrayList<Animal> getAnimals() {
        return Animals;
    }
}