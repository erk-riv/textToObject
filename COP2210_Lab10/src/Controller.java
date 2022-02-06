import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public static Human findYoungestHumanWithoutCar(ArrayList<Human> humans) {
        int minAgeNoCar = humans.get(1).getAge();
        int location = 0;
        int setLocation = 0;
        for (Object humanSearch : humans) {
            if (((Human)humanSearch).getCar() == null) {
                if ((((Human) humanSearch).getAge()) < minAgeNoCar) {
                    minAgeNoCar = ((Human) humanSearch).getAge();
                    setLocation = location;
                }
            }
            location++;
        }
        return humans.get(setLocation);
    }

    public static Human findOldestHumanWithCar(ArrayList<Human> humans){
        int maxAgeWCar = humans.get(0).getAge();
        int location = 0;
        int setLocation = 0;
        for (Object humanSearch : humans) {
            if (((Human)humanSearch).getCar() != null) {
                if ((((Human) humanSearch).getAge()) > maxAgeWCar) {
                    maxAgeWCar = ((Human) humanSearch).getAge();
                    setLocation = location;
                }
            }
            location++;
        }
        return humans.get(setLocation);
    }

    public static Bowl bowlWithMostFruitWeight(ArrayList<Bowl> bowls){
        int bowlWithMostWeight = 0;
        int location = 0;
        int setLocation = 0;
        for (Object bowlSearch : bowls) {
            if (((Bowl)bowlSearch).getFruits() != null) {
                int weightAdder = 0;
                for (Object fruitSearch : ((Bowl)bowlSearch).getFruits()) {
                    weightAdder += ((Fruit)fruitSearch).getWeight();
                    if (weightAdder >  bowlWithMostWeight) {
                        bowlWithMostWeight += ((Fruit)fruitSearch).getWeight();
                        setLocation = location;
                }
                }
            }
            location++;
        }
        return bowls.get(setLocation);
    }

        public static void main(String[] args) throws Exception {

        yourInfoHeader();

        //--------------------------
        // Step 1
        //--------------------------
        System.out.println();

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Data.txt output");
        System.out.println("=========================================");

        try {

            //use this if you're on a mac
            String fileLocation = "./Data/data.txt";
            BufferedReader br = new BufferedReader(new FileReader("./data/data.txt"));
            String line;
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                System.out.println(strCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //--------------------------
        // Step 2
        //--------------------------
        ArrayList cars = new ArrayList<Car>();
        ArrayList humans = new ArrayList<Human>();
        ArrayList fruits = new ArrayList<Fruit>();
        ArrayList bowls = new ArrayList<Bowl>();

        //--------------------------
        // Step 3
        //--------------------------
        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/data.txt"));
            String line;
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                String[] tokens = strCurrentLine.split(",");

                if (tokens[0].equals("Car")) {
                    Car c = new Car(tokens[1], tokens[2], tokens[3]);
                    cars.add(c);
                } else if (tokens[0].equals("Human")) {
                    if (tokens.length <= 2) {
                        humans.add(new Human(tokens[1]));
                    } else {
                        Car c = new Car(tokens[4], tokens[5], tokens[6]);
                        humans.add(new Human(c, tokens[1]));
                    }
                } else if (tokens[0].equals("Fruit")) {
                    Fruit f = new Fruit(tokens[1], tokens[2]);
                    fruits.add(f);
                } else if (tokens[0].equals("Bowl")) {
                    if(tokens.length <= 3) {
                        bowls.add(new Bowl(null, tokens[1], tokens[2]));
                    } else {
                        ArrayList tempFruit = new ArrayList<Fruit>();
                        for (int i = 5; i < tokens.length; i += 3) {
                            Fruit bowlFruit = new Fruit(tokens[i], tokens[i+1]);
                            tempFruit.add(bowlFruit);

                        }
                        bowls.add(new Bowl(tempFruit, tokens[1], tokens[2]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println();
        System.out.println("=========================================");
        System.out.println("Car List");
        System.out.println("=========================================");

        for (Object carDisplay : cars) {
            ((Car)carDisplay).displayInfo();
        }


        System.out.println();
        System.out.println("=========================================");
        System.out.println("Human List");
        System.out.println("=========================================");

        for (Object humanDisplay : humans) {
            ((Human)humanDisplay).displayInfo();
        }


        System.out.println();
        System.out.println("=========================================");
        System.out.println("Fruit List");
        System.out.println("=========================================");

        for (Object fruitDisplay : fruits) {
            ((Fruit)fruitDisplay).displayInfo();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Bowl List");
        System.out.println("=========================================");

        for (Object bowlDisplay : bowls) {
            ((Bowl)bowlDisplay).displayInfo();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Youngest Human without Car");
        System.out.println("=========================================");

        findYoungestHumanWithoutCar(humans).displayInfo();
        System.out.println();

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Oldest Human with Car");
        System.out.println("=========================================");

        findOldestHumanWithCar(humans).displayInfo();
        System.out.println();

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Bowl with the most fruit by weight");
        System.out.println("=========================================");

        bowlWithMostFruitWeight(bowls).displayInfo();
        System.out.println();
    }




    public static void yourInfoHeader() {
        System.out.println("====================================================");
        System.out.println("PROGRAMMER:  \t " + "Erick Rivera");
        System.out.println("PANTHER ID:  \t " + "6311416");
        System.out.println();
        System.out.println("CLASS:  \t\t " + "COP2210");
        System.out.println("SECTION:  \t\t " + "U02");
        System.out.println("SEMESTER:  \t\t " + "Fall 2021");
        System.out.println("CLASSTIME:  \t " + "T & TH 5:00pm - 7:45pm");
        System.out.println();
        System.out.println("Assignment:  \t " + "Lab 10");
        System.out.println();
        System.out.println("CERTIFICATION:  \nI understand FIU's academic policies, and I certify");
        System.out.println("that this work is my own and that none of it is the");
        System.out.println("work of any other person.");
        System.out.println("====================================================");
        System.out.println();
    }
}

