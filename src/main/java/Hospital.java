import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital implements HealthcareCompositeTreeStuff {
    private String name;
    private List<Department> departments;

    @Override
    public void addPatient(Patient patient) {
        Department relevantDepartment = departments.stream().filter(department -> /*find the department that has the right specialty for the patient*/)).findFirst().orElseThrow(() -> new IllegalAccessError());
        relevantDepartment.addPatient(patient);
    }

    @Override
    public void removePatient(Patient patient) {

    }

    @Override
    public boolean containsPatient(Patient patient) {
        return false;
    }

    @Override
    public void treatPatient(Patient patient) {

    }
}
