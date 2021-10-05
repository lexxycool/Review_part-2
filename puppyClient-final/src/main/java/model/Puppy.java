package model;

public class Puppy {

    private int id;
    private String name;

    private int weight;
    private String gender;
    private boolean paperTrained;

    @Override
    public String toString() {
        return "Puppy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", paperTrained=" + paperTrained +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isPaperTrained() {
        return paperTrained;
    }

    public void setPaperTrained(boolean paperTrained) {
        this.paperTrained = paperTrained;
    }

}
