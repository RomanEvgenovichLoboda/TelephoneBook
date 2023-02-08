import Models.Abonent;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Abonent> list = new ArrayList<Abonent>();
        Scanner console = new Scanner(System.in);
        String menu="9";
        do {
            try{
                System.out.print("\n\t\t<-Menu->\n\t1 = Add Abonent\n\t2 = Show All\n\t3 = Remuve Abonent\n\t4 = Edit Abonent\n\t0 = Exit: ");
                menu=console.nextLine();
                switch (menu){
                    case "1":{
                        System.out.print("\nName: ");
                        String name = console.nextLine();
                        System.out.print("Number: ");
                        String number = console.nextLine();
                        System.out.print("Chuse Category:\n1 = Family\n2 = Work\n3 = Other: ");
                        String category = console.nextLine();
                        Abonent abonent = new Abonent(name,Integer.parseInt(number),category);
                        abonent.showInfo();
                        list.add(abonent);
                        break;
                    }
                    case "2":{
                        if(!list.isEmpty()){
                            for (Abonent ab:list) {
                                ab.showInfo();
                            }
                        }
                        else {
                            System.out.println("\n\tList is Empty !");
                        }
                        break;
                    }
                    case "3":{
                        if(!list.isEmpty()){
                            System.out.print("\nName of Abonent To Remuve: ");
                            String name = console.nextLine();
                            int count = 0;
                            for (Abonent ab: list) {

                                if(ab.getName().equals(name)){
                                    list.remove(ab);
                                    count++;
                                    break;
                                }
                            }
                            if(count==0){
                                System.out.println("\n\tNot Found !\n");
                            }
                        }
                        else {
                            System.out.println("\n\tList is Empty !");
                        }
                        break;
                    }
                    case "4":{
                        if(!list.isEmpty()){
                            System.out.print("\nName of Abonent To Edit: ");
                            String name = console.nextLine();
                            Abonent newAbon = null;
                            for (Abonent ab:list) {
                                if(ab.getName().equals(name)){
                                    newAbon =ab;
                                    newAbon.showInfo();
                                    System.out.print("\nEnter New Name:");
                                    newAbon.setName(console.nextLine());
                                    System.out.print("Enter New Number:");
                                    newAbon.setNumber(Integer.parseInt(console.nextLine()));
                                    System.out.print("Chuse Category:\n1 = Family\n2 = Work\n3 = Other: ");
                                    newAbon.setCategory(console.nextLine());
                                    newAbon.showInfo();
                                    break;
                                }

                            }
                            if(newAbon==null){
                                System.out.println("\n\tNot Found !\n");
                            }
                        }
                        else {
                            System.out.println("\n\tList is Empty !");
                        }
                        break;
                    }
                }

                // Runtime.getRuntime().exec("clear");
            }
            catch (Exception exception){
                System.out.println("\n\tExeption is :" + exception.getMessage());
            }
        }while (!menu.equals("0"));

    }
}