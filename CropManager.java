import java.util.Scanner;

public class CropManager {
    private Crop[] CropMenu;

    public CropManager() {
        CropMenu = new Crop[] {new Crop("Potato"), new Crop("Corn"), new Crop("Carrot"),
                               new Crop("Wheat"), new Crop("Canola"), new Crop("Oats"),
                               new Crop("Onion"), new Crop("Cabbage"), new Crop("Tomato"), 
                               new Crop("Soy Bean")};
    }

    public void CropMenu() {
        Scanner MenuScanner = new Scanner(System.in);
        boolean Continue = true;
        while(Continue) {
            System.out.println("What would you like to do?" + "\n" + 
                                "[1] View All Current Crops" + "\n" + 
                                "[2] Add Crops" + "\n" + 
                                "[3] Remove Crops" + "\n" + 
                                "[q] Return to Main Menu");
                               
            String input = MenuScanner.nextLine();
            switch(input) {
                case "1": this.viewCrops(); break;
                case "2": this.addCrop(); break;
                case "3": this.removeCrop(); break;
                case "q": Continue = false; break;
                default: System.out.println("Invalid choise"); continue;
            }
        }
    }

    private void viewCrops() {
        
        System.out.println("Currently available crops:");
        for(int i = 0; i < CropMenu.length; i++) {
            System.out.println(CropMenu[i].getDescription());
        }
        System.out.println();     
    }

    private void addCrop() {
        Scanner AddScanner = new Scanner(System.in);
        
        boolean Continue = true;
        while(Continue) {
            System.out.println("Choose which type of crop to add");
            for(int i = 0; i < CropMenu.length; i++) {
                System.out.println("[" + i + "] " + CropMenu[i].getDescription());
            }
            System.out.println("[q] Go back to Crop Manager");

            String input = AddScanner.nextLine();
            Scanner AddAmountScanner = new Scanner(System.in);
            switch(input) {
                case "0":
                    System.out.println("How many " + CropMenu[0].getCropType() + "es do you wish to add?");
                    
                    String Amount0 = AddAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount0);
                        if(IntAmount < 0) {
                            System.out.println("Use function takeCrop() to remove crops");
                            break;
                        }
                        CropMenu[0].addCrop(IntAmount);
                        Continue = false;
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "1": 
                    System.out.println("How much " + CropMenu[1].getCropType() + " do you wish to add?");
                    String Amount1 = AddAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount1);
                        if(IntAmount < 0) {
                            System.out.println("Use function takeCrop() to remove crops");
                            break;
                        }
                        CropMenu[1].addCrop(IntAmount);
                        Continue = false;
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "2": 
                    System.out.println("How many " + CropMenu[2].getCropType() + "s do you wish to add?");
                    String Amount2 = AddAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount2);
                        if(IntAmount < 0) {
                            System.out.println("Use function takeCrop() to remove crops");
                            break;
                        }
                        CropMenu[2].addCrop(IntAmount);
                        Continue = false;
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "3": 
                    System.out.println("How much " + CropMenu[3].getCropType() + " do you wish to add?");
                    String Amount3 = AddAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount3);
                        if(IntAmount < 0) {
                            System.out.println("Use function takeCrop() to remove crops");
                            break;
                        }
                        CropMenu[3].addCrop(IntAmount);
                        Continue = false;
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "4": 
                    System.out.println("How much " + CropMenu[4].getCropType() + " do you wish to add?");
                    String Amount4 = AddAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount4);
                        if(IntAmount < 0) {
                            System.out.println("Use function takeCrop() to remove crops");
                            break;
                        }
                        CropMenu[4].addCrop(IntAmount);
                        Continue = false;
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "5": 
                    System.out.println("How much " + CropMenu[5].getCropType() + " do you wish to add?");
                    String Amount5 = AddAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount5);
                        if(IntAmount < 0) {
                            System.out.println("Use function takeCrop() to remove crops");
                            break;
                        }
                        CropMenu[5].addCrop(IntAmount);
                        Continue = false;
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "6": 
                    System.out.println("How many " + CropMenu[6].getCropType() + "s do you wish to add?");
                    String Amount6 = AddAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount6);
                        if(IntAmount < 0) {
                            System.out.println("Use function takeCrop() to remove crops");
                            break;
                        }
                        CropMenu[6].addCrop(IntAmount);
                        Continue = false;
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "7": 
                    System.out.println("How many " + CropMenu[7].getCropType() + "s do you wish to add?");
                    String Amount7 = AddAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount7);
                        if(IntAmount < 0) {
                            System.out.println("Use function takeCrop() to remove crops");
                            break;
                        }
                        CropMenu[7].addCrop(IntAmount);
                        Continue = false;
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "8": 
                    System.out.println("How many " + CropMenu[8].getCropType() + "es do you wish to add?");
                    String Amount8 = AddAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount8);
                        if(IntAmount < 0) {
                            System.out.println("Use function takeCrop() to remove crops");
                            break;
                        }
                        CropMenu[8].addCrop(IntAmount);
                        Continue = false;
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "9": 
                    System.out.println("How many " + CropMenu[9].getCropType() + "s do you wish to add?");
                    String Amount9 = AddAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount9);
                        if(IntAmount < 0) {
                            System.out.println("Use function takeCrop() to remove crops");
                            break;
                        }
                        CropMenu[9].addCrop(IntAmount);
                        Continue = false;
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "q": 
                    Continue = false; 
                    break;
                default: 
                    System.out.println("Invalid Choise"); 
                    System.out.println("Choose whice type of crop to add");
                    break;

            }
        }
        
    }

    private void removeCrop() {
        Scanner RemoveScanner = new Scanner(System.in);
        boolean Continue = true;
        while(Continue) {
            System.out.println("Chose which type of crop to remove");
            for(int i = 0; i < CropMenu.length; i++) {
                System.out.println("[" + i + "] " + CropMenu[i].getDescription());
            }
            System.out.println("[q] Go back to Crop Manager");

            String input = RemoveScanner.nextLine();
            Scanner RemoveAmountScanner = new Scanner(System.in);
            switch(input) {
                case "0":
                    System.out.println("How many " + CropMenu[0].getCropType() + "es do you wish to remove?");
                    String Amount0 = RemoveAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount0);
                        CropMenu[0].takeCrop(IntAmount);
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "1": 
                    System.out.println("How much " + CropMenu[1].getCropType() + " do you wish to remove?");
                    String Amount1 = RemoveAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount1);
                        CropMenu[1].takeCrop(IntAmount);
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "2": 
                    System.out.println("How many " + CropMenu[2].getCropType() + "s do you wish to remove?");
                    String Amount2 = RemoveAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount2);
                        CropMenu[2].takeCrop(IntAmount);
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "3": 
                    System.out.println("How much " + CropMenu[3].getCropType() + " do you wish to remove?");
                    String Amount3 = RemoveAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount3);
                        CropMenu[3].takeCrop(IntAmount);
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "4": 
                    System.out.println("How much " + CropMenu[4].getCropType() + " do you wish to remove?");
                    String Amount4 = RemoveAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount4);
                        CropMenu[4].takeCrop(IntAmount);
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "5": 
                    System.out.println("How much " + CropMenu[5].getCropType() + " do you wish to remove?");
                    String Amount5 = RemoveAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount5);
                        CropMenu[5].takeCrop(IntAmount);
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "6": 
                    System.out.println("How many " + CropMenu[6].getCropType() + "s do you wish to remove?");
                    String Amount6 = RemoveAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount6);
                        CropMenu[6].takeCrop(IntAmount);
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "7": 
                    System.out.println("How many " + CropMenu[7].getCropType() + "s do you wish to remove?");
                    String Amount7 = RemoveAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount7);
                        CropMenu[7].takeCrop(IntAmount);
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "8": 
                    System.out.println("How many " + CropMenu[8].getCropType() + "s do you wish to remove?");
                    String Amount8 = RemoveAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount8);
                        CropMenu[8].takeCrop(IntAmount);
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "9": 
                    System.out.println("How many " + CropMenu[9].getCropType() + "s do you wish to remove?");
                    String Amount9 = RemoveAmountScanner.nextLine();
                    try {
                        int IntAmount = Integer.parseInt(Amount9);
                        CropMenu[9].takeCrop(IntAmount);
                    } catch (Exception e) {
                        System.out.println("Must be an integer");
                    }
                    break;
                case "q": 
                    Continue = false; 
                    break;
                default: 
                    System.out.println("Invalid Choise"); 
                    System.out.println("Choose whice type of crop to add");
                    break;
            }
        }


    }

    public void loadCrop(int TypeEnum, int Quantity) {
        switch (TypeEnum) {
            case 0: CropMenu[0].addCrop(-CropMenu[0].quantity); CropMenu[0].addCrop(Quantity); break;
            case 1: CropMenu[1].addCrop(-CropMenu[1].quantity); CropMenu[1].addCrop(Quantity); break;
            case 2: CropMenu[2].addCrop(-CropMenu[2].quantity); CropMenu[2].addCrop(Quantity); break;
            case 3: CropMenu[3].addCrop(-CropMenu[3].quantity); CropMenu[3].addCrop(Quantity); break;
            case 4: CropMenu[4].addCrop(-CropMenu[4].quantity); CropMenu[4].addCrop(Quantity); break;
            case 5: CropMenu[5].addCrop(-CropMenu[5].quantity); CropMenu[5].addCrop(Quantity); break;
            case 6: CropMenu[6].addCrop(-CropMenu[6].quantity); CropMenu[6].addCrop(Quantity); break;
            case 7: CropMenu[7].addCrop(-CropMenu[7].quantity); CropMenu[7].addCrop(Quantity); break;
            case 8: CropMenu[8].addCrop(-CropMenu[8].quantity); CropMenu[8].addCrop(Quantity); break;
            case 9: CropMenu[9].addCrop(-CropMenu[9].quantity); CropMenu[9].addCrop(Quantity); break;

        }
    }
    //getters setters
    public Crop[] getCrops() {
        return CropMenu;
    }
}