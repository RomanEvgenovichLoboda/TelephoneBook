import Models.Abonent;

import java.util.*;

import static java.lang.Runtime.getRuntime;

public class Main {

    public static void main(String[] args) {menu();}
    public static ArrayList<Abonent> list = new ArrayList<Abonent>();
    public static Scanner console = new Scanner(System.in);
    public static void menu(){
        String menu;
        while (true) {
            try{
                System.out.print("\n\t\t\t<-Menu->\n\t\t1 = Add Abonent\n\t\t2 = Show All\n\t\t3 = Remuve Abonent\n\t\t4 = Edit Abonent\n\t\t0 = Exit: ");
                menu=console.nextLine();
                switch (menu){
                    case "1":{
                        addAbonent();
                        break;
                    }
                    case "2":{
                        showTelBook();
                        break;
                    }
                    case "3":{
                        remuveAbonent();
                        break;
                    }
                    case "4":{
                        editAbonent();
                        break;
                    }
                    case "0":{return;}

                    default:{
                        System.out.println("\n\tInvalid Input !");
                    }
                }
//                final String ANSI_CLS = "\u001b[2J";
//                final String ANSI_HOME = "\u001b[H";
//                System.out.print(ANSI_CLS + ANSI_HOME);
//                System.out.flush();
                //System.out.print("\033[H\033[J");
                //Runtime.getRuntime().exec("cls");
                //System.out.print(String.format("\033[H\033[2J"));
                //System.out.print(ESC+"[1;1H");  System.out.flush();
                //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                //System.out.println("\f");
//                Runtime runtime = getRuntime();
//                Process process = runtime.exec("clc");
//                String ANSI_CLEAR_SEQ = "\u001b[2J";
//                System.out.println(ANSI_CLEAR_SEQ);
                //Runtime.getRuntime().exec("cmd /C start cls");
                //System.console().clear();
            }
            catch (Exception exception){
                System.out.println("\n\tExeption is :" + exception.getMessage());
            }
        }
    }
    public static void addAbonent(){
        System.out.print("\nName: ");
        String name = console.nextLine();
        System.out.print("Number: ");
        String number = console.nextLine();
        System.out.print("Chuse Category:\n1 = Family\n2 = Work\n3 = Other: ");
        String category = console.nextLine();
        if(!isHasAlready(name,Integer.parseInt(number))){
            Abonent abonent = new Abonent(name,Integer.parseInt(number),category);
            list.add(abonent);
            System.out.println("\n\tAbonent Added !");
            abonent.showInfo();
        }
    }
    public static void showTelBook(){
        if(!list.isEmpty()){
            System.out.println("\n\t<-My Telephone Book->");
            for (Abonent ab:list) {
                ab.showInfo();
            }
        }
        else {
            System.out.println("\n\tList is Empty !");
        }
    }
    public static void remuveAbonent(){
        if(!list.isEmpty()){
            System.out.print("\nName of Abonent To Remuve: ");
            String name = console.nextLine();
            boolean isRemuve = false;
            for (Abonent ab: list) {

                if(ab.getName().equals(name)){
                    list.remove(ab);
                    System.out.println("\n\tNot Found !");
                    System.out.println("\n\t\tAbonent Remuved !");
                    isRemuve=true;
                    break;
                }
            }
            if(!isRemuve){
                System.out.println("\n\tNot Found !");
            }
        }
        else {
            System.out.println("\n\tList is Empty !");
        }
    }
    public static void editAbonent(){
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
                    System.out.println("\n\t\tEdition Is Ok !");
                    newAbon.showInfo();
                    break;
                }
            }
            if(newAbon==null){
                System.out.println("\n\tNot Found !");
            }
        }
        else {
            System.out.println("\n\tList is Empty !");
        }
    }
    public static boolean isHasAlready(String name,int number){
        boolean isHas=false;
        if(!list.isEmpty()){
            for (Abonent ab:list) {
                if(ab.getName().equals(name)){
                    System.out.println("\n\tThis Name Has already !");
                    ab.showInfo();
                    isHas = true;
                    break;
                }
                else if (ab.getNumber()==number){
                    System.out.println("\n\tThis Number Has already !");
                    ab.showInfo();
                    isHas = true;
                    break;
                }
            }
        }
       return isHas;
    }
}