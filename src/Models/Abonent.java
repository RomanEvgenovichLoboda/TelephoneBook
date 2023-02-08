package Models;

import java.util.Scanner;

public class Abonent {
    private String Name;
    private int Number;
    private Category Category;
    public Abonent(String name,int number,String cat){
        Name=name;
        Number=number;
        if(cat.equals("1")){
            Category=new Family();
        } else if (cat.equals("2")) {
            Category=new Work();
        }
        else{
            Category=new Others();
        }
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setCategory(String cat) {
        if(cat.equals("1")){
            Category=new Family();
        } else if (cat.equals("2")) {
            Category=new Work();
        }
        else{
            Category=new Others();
        }
    }

    public void showInfo(){
        System.out.println("\n\t Name -> "+ Name+"\n\t Telephone -> "+String.valueOf(Number)+"\n\t Category -> "+Category.Name);
    }
}
