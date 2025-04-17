import java.util.*;

abstract class JobRole{
	public abstract String getWork();
	public abstract String getSkill();
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName();
	}
}

class SoftwareEngineer extends JobRole{
	public String getWork(){
		return "Develop applications";
	}
	public String getSkill(){
		return"Java";
	}
}

class DataScientist extends JobRole{
	public String getWork(){
		return "Analyze data";
	}
	public String getSkill(){
		return "Statistics";
	}
}

class ProductManager extends JobRole{
	public String getWork(){
		return "Define product strategy";
	}
	public String getSkill(){
		return "Project Management";
	}
}

class Resume<T extends JobRole>{
	private String candidateName;
	private T role;
	
	public Resume(String candidateName, T role){
		this.candidateName=candidateName;
		this.role=role;
	}
	public String getCandidateName(){
		return candidateName;
	}
	public T getRole(){
		return role;
	}
	
	@Override
	public String toString(){
		return "Resume of "+candidateName+" applying for "+role+"\nResponsibilities: "+role.getWork()+"\nSkills needed: "+role.getSkill();
	}
}

class ResumeScreening{
	public static<T extends JobRole> void screenResume(Resume<T> resume){
		System.out.println("Screening "+resume.getCandidateName()+" for "+resume.getRole());
		System.out.println("Responsibilites: "+resume.getRole().getWork());
		System.out.println("Skills needed: "+resume.getRole().getSkill());
		System.out.println("Resume processed");
		System.out.println();
	}
	
	public static void bulkScreen(List<? extends JobRole> roles){
		System.out.println("Screening Summary");
		for(JobRole role: roles){
			System.out.println("Role: "+role+", "+role.getWork());
			System.out.println();
		}
	}
}

public class AiResumeScreening{
	public static void main(String[] args){
		Resume<SoftwareEngineer> r1=new Resume<>("Alice", new SoftwareEngineer());
		Resume<DataScientist> r2=new Resume<>("Bob", new DataScientist());
		Resume<ProductManager> r3=new Resume<>("Charlie", new ProductManager());
		ResumeScreening.screenResume(r1);
		ResumeScreening.screenResume(r2);
		ResumeScreening.screenResume(r3);
		List<JobRole> allRoles=Arrays.asList(new SoftwareEngineer(), new DataScientist(), new ProductManager());
		
		ResumeScreening.bulkScreen(allRoles);
	}
}
