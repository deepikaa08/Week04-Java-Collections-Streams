import java.util.*;
class Patient implements Comparable<Patient>{
    String name;
    int severity;

    public Patient(String name, int severity){
        this.name=name;
        this.severity=severity;
    }

    @Override
    public int compareTo(Patient other){
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString(){
        return this.name;
    }
}
public class HospitalTriage {
    public static void main(String[] args) {
        PriorityQueue<Patient> triage=new PriorityQueue<>();
        triage.add(new Patient("John", 3));
        triage.add(new Patient("Alice", 5));
        triage.add(new Patient("Bob", 2));

        System.out.println("Priority order:");
        while(!triage.isEmpty()){
            Patient p=triage.poll();
            System.out.print(p.name+",");
        }
    }
}
