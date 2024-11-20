import java.util.ArrayList;

public class Main1 {
    public static void Main1(String[] args) {
        // 第 3 部分 - 使用类和对象
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. Smith", "General Practitioner", "Family Medicine");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Johnson", "General Practitioner", "Pediatrics");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Brown", "General Practitioner", "Internal Medicine");

        OtherHealthProfessional ohp1 = new OtherHealthProfessional(4, "Nurse Jane", "Registered Nurse", "Emergency Care");
        OtherHealthProfessional ohp2 = new OtherHealthProfessional(5, "Therapist Mike", "Licensed Therapist", "Counseling");

        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        ohp1.printDetails();
        ohp2.printDetails();

        System.out.println("------------------------------");

        // 第 5 部分 - 预约的收集
        ArrayList<Appointment> appointments = new ArrayList<>();

        createAppointment(appointments, "John Doe", "1234567890", "08:00", gp1);
        createAppointment(appointments, "Jane Doe", "0987654321", "10:00", gp2);
        createAppointment(appointments, "Bob Smith", "5555555555", "14:30", ohp1);
        createAppointment(appointments, "Alice Johnson", "9999999999", "16:00", ohp2);

        printExistingAppointments(appointments);

        cancelBooking(appointments, "0987654321");

        printExistingAppointments(appointments);
    }

    public static void createAppointment(ArrayList<Appointment> appointments, String patientName, String patientPhone, String preferredTime, HealthProfessional healthProfessional) {
        Appointment appointment = new Appointment(patientName, patientPhone, preferredTime, healthProfessional);
        appointments.add(appointment);
        System.out.println("Appointment created successfully for " + patientName + " with " + healthProfessional.getClass().getSimpleName() + " at " + preferredTime);
    }

    public static void printExistingAppointments(ArrayList<Appointment> appointments) {
        System.out.println("Existing Appointments:");
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printDetails();
                System.out.println("------------------------------");
            }
        }
    }

    public static void cancelBooking(ArrayList<Appointment> appointments, String patientPhone) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getPatientPhone().equals(patientPhone)) {
                appointments.remove(i);
                System.out.println("Appointment for " + patientPhone + " has been cancelled.");
                return;
            }
        }
        System.out.println("No appointment found for the provided phone number: " + patientPhone);
    }
}