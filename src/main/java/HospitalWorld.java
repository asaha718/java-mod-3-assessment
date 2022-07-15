import java.util.ArrayList;
import java.util.Scanner;

public class HospitalWorld {
    public static void main(String[] args) {
        System.out.println("Welcome to Anug's Hospital World");
        System.out.println("What would you like the name of your Hospital to be? : ");

        try (Scanner scanner = new Scanner(System.in)) {
            //Create name of Hospital from user input
            String hospitalName = scanner.nextLine();

            while (hospitalName.isEmpty()) {
                System.out.println("Nothing was entered. Please try again");
                System.out.println("Enter the Name of the Hospital");

                hospitalName = scanner.nextLine();
            }

            Hospital newHospital = new Hospital(hospitalName);

            System.out.println("###Welcome to " + newHospital.getName() + " Hospital###");

            //get 3 Doctors with specialties
            while (Hospital.listOfDoctors.size() < 3) {
                addDocsToHospital(scanner);
            }

            Boolean addNewPatient = true;

            while (addNewPatient) {
                addPatientsToSystem(scanner);

                System.out.println("Do you want to add a new Patient? y/n");
                String addPatient = scanner.nextLine();

                if (addPatient.equals("n")) {
                    addNewPatient = false;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Thank you for using Anug's Hospital System");
    }

    public static void addDocsToHospital(Scanner scanner) {

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
        while(listOfAilments.size() < 2){
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

    public static void addPatientsToSystem(Scanner scanner) {
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

}

