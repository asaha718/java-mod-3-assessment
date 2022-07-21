import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalWorld {
    public static void main(String[] args) {
        System.out.println("Welcome to Anug's Hospital World");
        System.out.println("What would you like the name of your Hospital to be? : ");

        try (Scanner scanner = new Scanner(System.in)) {
            //Create name of Hospital from user input
            String hospitalName = scanner.nextLine();
            HospitalService service = new HospitalService();

            while (hospitalName.isEmpty()) {
                System.out.println("Nothing was entered. Please try again");
                System.out.println("Enter the Name of the Hospital");

                hospitalName = scanner.nextLine();
            }

            Hospital newHospital = new Hospital(hospitalName);

            System.out.println("###Welcome to " + newHospital.getName() + " Hospital###");

            //get 3 Doctors with specialties
            while (newHospital.listOfDoctors.size() < 3) {
                service.addDocsToHospital(scanner);
            }

            //keep adding patients until user does not want to anymore
            Boolean addNewPatient = true;

            while (addNewPatient) {
                service.addPatientsToSystem(scanner);

                System.out.println("Do you want to add a new Patient? y/n");
                String addPatient = scanner.nextLine();

                if (addPatient.equals("n")) {
                    addNewPatient = false;
                }
            }

            //begin treating patients
            Boolean treatPatients = true;

            while (treatPatients) {
                service.treatPatient(scanner);

                System.out.println("Do you want keep treating a Patient? y/n");
                String keepTreating = scanner.nextLine();

                if (keepTreating.equals("y")) {
                    treatPatients = true;
                } else {
                    treatPatients = false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Patient> patientList = newHospital.listOfPatients;

        try {
            service.writeJson(patientList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thank you for using Anug's Hospital System");
    }

}

