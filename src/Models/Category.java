package Models;

public abstract class Category {
    protected String Name;
    public Category(String name){
        Name=name;
    }
    public String getName() {
        return Name;
    }
}
