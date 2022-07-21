import java.util.List;

public class Department implements  HealthcareCompositeTreeStuff {
    private String specialty;
    private List<Doctor> doctors;

    @Override
    public void addPatient(Patient patient) {

    }

    @Override
    public void removePatient(Patient patient) {
        doctors.stream().filter(doctor -> doctor.containsPatient(patient)).forEach(doctor -> doctors.remove(patient));
    }

    @Override
    public boolean containsPatient(Patient patient) {
        return false;
    }

    @Override
    public void treatPatient(Patient patient) {

    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
