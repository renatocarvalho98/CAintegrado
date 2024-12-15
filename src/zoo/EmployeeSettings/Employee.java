/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package zoo.EmployeeSettings;

public class Employee {

        private String name;
        private int age;
        private String workLocation; // "Lion Enclosure", "Bird Aviary"
        private int ID_employee;
        private String phoneNumber;
        private String email;
        private String department; // "Veterinary", "Maintenance"
        private String shift; // Morning, Evening, Night
        private double salary;
        private boolean isActive;
        private String employmentDate;

        private static int currentID = 1; // Auto-increment ID

        // Constructor
        public Employee(String name, int age, String workLocation, String phoneNumber, String email,
                        String department, String shift, double salary, String employmentDate) {
            this.name = name;
            this.age = age;
            this.workLocation = workLocation;
            this.ID_employee = currentID++;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.department = department;
            this.shift = shift;
            this.salary = salary;
            this.isActive = true; // Default to active
            this.employmentDate = employmentDate;
        }

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public String getWorkLocation() { return workLocation; }
        public void setWorkLocation(String workLocation) { this.workLocation = workLocation; }

        public int getID_employee() { return ID_employee; }

        public String getPhoneNumber() { return phoneNumber; }
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }

        public String getShift() { return shift; }
        public void setShift(String shift) { this.shift = shift; }

        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }

        public boolean isActive() { return isActive; }
        public void setActive(boolean isActive) { this.isActive = isActive; }

        public String getEmploymentDate() { return employmentDate; }
        public void setEmploymentDate(String employmentDate) { this.employmentDate = employmentDate; }
    }