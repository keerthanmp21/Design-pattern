import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        Employee emp1 = new Developer("kmp1", 100, "junior developer");
        Employee emp2 = new Developer("kmp2", 101, "senior developer");

        Manager engManager = new Manager("kmp4", 300, "Engineering Manager");
        
        engManager.addEmployee(emp1);
        engManager.addEmployee(emp2);

        Employee emp3 = new Designer("kmp3", 200, "senior designer");
        
        Manager desManager = new Manager("kmp5", 302, "Designer Manager");
        desManager.addEmployee(emp3);

        Manager genManager = new Manager("kmp6", 303, "General Manager");
        genManager.addEmployee(engManager);
        genManager.addEmployee(desManager);

        genManager.showEmployeeDetails();
    }
}

interface Employee{
    void showEmployeeDetails();
}

class Developer implements Employee{
    private String name;
    private long empId;
    private String position;

    public Developer(String name, long empId, String position){
        this.name = name;
        this.empId = empId;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails(){
        System.out.println(empId + " " + name + " " + position);
    }
}

class Designer implements Employee{
    private String name;
    private long empId;
    private String position;

    public Designer(String name, long empId, String position){
        this.name = name;
        this.empId = empId;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails(){
        System.out.println(empId + " " + name + " " + position);
    }
}

class Manager implements Employee{
    private String name;
    private long empId;
    private String position;
    private List<Employee> subordinates;

    public Manager(String name, long empId, String position){
        this.name = name;
        this.empId = empId;
        this.position = position;
        subordinates = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        subordinates.add(employee);
    }

    public void removeEmployee(Employee employee){
        subordinates.remove(employee);
    }

    @Override
    public void showEmployeeDetails(){
        System.out.println(empId + " " + name + " " + position);
        for(Employee emp : subordinates){
            emp.showEmployeeDetails();
        }
    }
}