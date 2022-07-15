public class Patient {
    private String name;
    private String ailment;
    private int healthIndex;
    public Patient(String name, String ailment, int healthIndex) {
        this.name = name;
        this.ailment = ailment;
        this.healthIndex = healthIndex;
    }

    public String getAilment() {
        return ailment;
    }

    public int getHealthIndex() {
        return healthIndex;
    }

    public void setHealthIndex(int healthIndex) {
        this.healthIndex = healthIndex;
    }

    public String getName() {
        return name;
    }

    public void getTreatment(int val){
        setHealthIndex(getHealthIndex() + val);
    }

}

