package POJOs;

public class SecondPOJO {
    private int id;
    private String mark;
    private String model;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return "OtherEmployee:: ID="+this.id +" Mark=" + this.mark + " Model=" + this.model;
    }
}
