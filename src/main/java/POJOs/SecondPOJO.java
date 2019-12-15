package POJOs;

public class SecondPOJO {
    private String name;
    private String teg;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTeg() {
        return teg;
    }
    public void setTeg(String teg) {
        this.teg = teg;
    }

    @Override
    public String toString() {
        switch (teg){
            case "university": return "Университет " + this.name;
            case "faculty": return " Факультет " + this.name;
            case "department": return "  Кафедра " + this.name;
            default: return this.name;
        }
    }
}
