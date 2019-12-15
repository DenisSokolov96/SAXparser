package POJOs;

public class FirstPOJO {

    private int val;
    private String name;

    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "   Группа "+ this.name +" " + this.val + " студент.";
    }

}
