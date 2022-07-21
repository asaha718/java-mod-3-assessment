import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalService {

    public void addDocsToHospital(Scanner scanner) {

        System.out.println("Lets add a Doctor with a specialty to your Hospital");
        System.out.println("&&& What is the Doctor's name : &&&");
        String docName = scanner.nextLine();

        while (docName.isEmpty()) {
            System.out.println("Nothing was entered. Please try again");
            System.out.println("-Enter the Name of the Doctor-");
            docName = scanner.nextLine();
        }

        System.out.println("What is the Doctor's Specialty (ex. Dermatology, Pediatrics, Radiology...) : ");
        String specialty = scanner.nextLine();

        while (specialty.isEmpty()) {
            System.out.println("Nothing was entered. Please try again");
            System.out.println("-Enter specialty-");
            specialty = scanner.nextLine();
        }

        ArrayList<String> listOfAilments = new ArrayList<>();
        System.out.println("Add 2 ailments can this doctor treat? (one at a time)");
        while (listOfAilments.size() < 2) {
            System.out.println("Example ailments: cold , headache, backpain, cancer, covid, etc.");
            System.out.println("Add treatable ailment? (type one and press enter)");
            String ailment = scanner.nextLine();
            while (ailment.isEmpty()) {
                System.out.println("Nothing was entered. Please try again");
                System.out.println("-Enter specialty-");
                ailment = scanner.nextLine();
            }
            listOfAilments.add(ailment);
        }

        Doctor newDoc = new Doctor(docName, specialty, listOfAilments);

        Hospital.addDoctor(newDoc);
        System.out.println(newDoc.name + " has been added to the Hospital!");

    }

    public void addPatientsToSystem(Scanner scanner) {
        System.out.println("***Lets add a Patient to your Hospital***");
        System.out.println("What is the Patient's name : ");
        String patientName = scanner.nextLine();
        while (patientName.isEmpty()) {
            System.out.println("Nothing was entered. Please try again");
            System.out.println("Enter Patient's name : ");
            patientName = scanner.nextLine();
        }

        System.out.println("What is the Patient's ailment : ");
        String patientAilment = scanner.nextLine();
        while (patientAilment.isEmpty()) {
            System.out.println("Nothing was entered. Please try again");
            System.out.println("Enter ailment : ");
            patientAilment = scanner.nextLine();
        }

        System.out.println("What is the Patient's health index (1-99) : ");
        int patientHealth = Integer.parseInt(scanner.nextLine());
        while (patientHealth > 100 || patientHealth < 0) {
            System.out.println("Not a valid health index");
            System.out.println("Enter health index : ");
            patientName = scanner.nextLine();
        }

        Patient enteringPatient = new Patient(patientName, patientAilment, patientHealth);

        Hospital.addPatient(enteringPatient);

    }

    public void treatPatient(Scanner scanner) {
        // pick a patient to treat
        System.out.println("Pick a patient to treat");
        for (int i = 0; i < Hospital.listOfPatients.size(); i++) {
            Patient patient = Hospital.listOfPatients.get(i);
            System.out.println("Type " + i + " to treat " + patient.getName() + " with " + patient.getAilment());
        }

        int patientIndex = Integer.parseInt(scanner.nextLine());

        Patient treatedPatient = Hospital.listOfPatients.get(patientIndex);

        System.out.println("Who should " + treatedPatient.getName() + " with " + treatedPatient.getAilment() + " see?");

        // pick a doctor to treat patient
        for (int i = 0; i < Hospital.listOfPatients.size(); i++) {
            Doctor doc = Hospital.listOfDoctors.get(i);
            System.out.println("Type " + i + " to treat " + doc.name + " with specialty in " + doc.specialty);
        }
        // if doc can treat ailment add to health index else do not
        int docIndex = Integer.parseInt(scanner.nextLine());
        Doctor treatingDoc = Hospital.listOfDoctors.get(patientIndex);

        if(treatingDoc.ailments.contains(treatedPatient.getAilment())){
            treatedPatient.setHealthIndex(10);
            System.out.println(treatedPatient.getName() + "saw the correct doctor");
            System.out.println(treatedPatient.getName() + " health index is now " + treatedPatient.getHealthIndex());
        } else {
            treatedPatient.setHealthIndex(5);
            System.out.println(treatedPatient.getName() + "did not see the optimal doctor");
            System.out.println(treatedPatient.getName() + " health index is now " + treatedPatient.getHealthIndex());
        }

        // if health index is >99 remove patient

        if(treatedPatient.getHealthIndex() > 99) {
            System.out.println("Patient is in full health");
            System.out.println(treatedPatient.getName() + " has been discharged");
            Hospital.listOfPatients.remove(patientIndex);
        }

    }

    public void writeJson(List<Patient> patients) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(patients);
        System.out.println(json);
        //Write JSON to file.
        try {
            FileReader.writeToFile("myPatients.json", json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
