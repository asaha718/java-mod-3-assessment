import java.util.ArrayList;
import java.util.List;

public class Doctor implements  HealthcareCompositeTreeStuff {
    private String name;
    private List<Patient> patients;


    @Override
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    @Override
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    @Override
    public boolean containsPatient(Patient patient) {
        return false;
    }

    @Override
    public void treatPatient(Patient patient) {

    }
}
