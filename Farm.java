import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Farm {

    CropManager CM;
    AnimalManager AM;

    public Farm() {
        this.CM = new CropManager();
        this.AM = new AnimalManager();
    }

    public void MainMenu() {
        Scanner MenuScanner = new Scanner(System.in);
        System.out.println("Welcome to your own farm, here you can manage your animals and crops!");
        boolean quit = false;
        while(!quit) {
            System.out.println("Main Menu" + "\n" +
                               "[1] Animal Manager" + "\n" +
                               "[2] Crop Manager" + "\n" +
                               "[3] Save Progress" + "\n" +
                               "[4] Load Save" + "\n" +
                               "[q] Exit Farm");
            String input = MenuScanner.nextLine();

            switch (input) {
                case "1": this.AM.AnimalMenu(this.CM.getCrops()); continue;
                case "2": this.CM.CropMenu(); continue;
                case "3": try {this.save();} catch(IOException e) {System.out.println("something went wrong");}; continue;
                case "4": try {load("SaveAnimals.csv", "SaveCrops.csv");} catch(IOException e) {System.out.println("Something went wrong");} continue;
                case "q": 
                    Scanner QuitScanner = new Scanner(System.in);
                    System.out.println("Are you sure you wish to quit the farm manager? ALL UNSAVED PROGRESS WILL BE LOST! [y/n]");
                    String QuitChoise = QuitScanner.nextLine();
                    if(QuitChoise.equals("y")) {
                        QuitScanner.close();
                        MenuScanner.close();
                        quit = true; 
                        break;
                    }
                    else {
                        continue;
                    }
                    
                default: System.out.println("Invalid choise"); break;
            }
            
        }
    }

    public void save() throws IOException {
        //animals
        ArrayList<Animal> saveAnimals = this.AM.getAnimals();
        
        FileWriter SaveAnimalsWriter = new FileWriter("SaveAnimals.csv");
        SaveAnimalsWriter.append("ID,Name,Species,AcceptableCropTypes" + "\n");
        
        for(Animal animal: saveAnimals) {
            SaveAnimalsWriter.append(String.valueOf(animal.getId()) + ",");
            SaveAnimalsWriter.append(animal.getName() + ",");
            SaveAnimalsWriter.append(animal.getSpecies() + ",");
            String AcceptableCropTypes = ("[" + String.join(":", animal.getAcceptableCropTypes()) + "]");
            SaveAnimalsWriter.append(AcceptableCropTypes + "\n");
        }
        SaveAnimalsWriter.close();

        //Crops
        FileWriter SaveCropsWriter = new FileWriter("SaveCrops.csv");
        SaveCropsWriter.append("ID,Type,Quantity" + "\n");
        Crop[] saveCrops = this.CM.getCrops();
        
        
        for(int i = 0; i < 10; i++) {
            SaveCropsWriter.append(String.valueOf(saveCrops[i].getId()) + ",");
            SaveCropsWriter.append(saveCrops[i].getCropType() + ",");
            SaveCropsWriter.append(String.valueOf(saveCrops[i].getQuantity())+ "\n");
        }
        SaveCropsWriter.close();

        System.out.println("Progress saved!" + "\n");
    }

    public void load(String SaveAnimalsPath, String SaveCropsPath) throws IOException {
        //Animals
        try(BufferedReader AnimalReader = new BufferedReader(new FileReader(SaveAnimalsPath))) {
            String[] AnimalHeader = AnimalReader.readLine().split(",");
            String AnimalLine;
            boolean flush = true;
            while((AnimalLine = AnimalReader.readLine()) != null) {
                String[] row = AnimalLine.split(",");
                int id = Integer.parseInt(row[0]);
                String name = row[1];
                String species = row[2];
                
                this.AM.loadAnimal(id, name, species, flush);
                flush = false;    
            }
        }
        catch(IOException e) {
            System.out.println("Something went wrong");
        }
        //Crops
        try(BufferedReader CropReader = new BufferedReader(new FileReader(SaveCropsPath))) {
            String[] CropHeader = CropReader.readLine().split(",");
            String[] CropLine;
            for(int i = 0; i < 10; i++) {
                CropLine = CropReader.readLine().split(",");
                int amount = Integer.parseInt(CropLine[2]);
                this.CM.loadCrop(i, amount);
            }

        }


        System.out.println("File Loaded!");
    }
}