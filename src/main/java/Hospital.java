import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital {
    private String name;
    public Hospital(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<Patient> listOfPatients = new ArrayList<>();
    public static List<Doctor> listOfDoctors = new ArrayList<>(3);

    public static void addDoctor(Doctor doc){
        listOfDoctors.add(doc);
    }

    public static void addPatient(Patient patient){
        listOfPatients.add(patient);
    }
}
