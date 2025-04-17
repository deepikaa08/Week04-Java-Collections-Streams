import java.util.*;

abstract class CourseType{
	private String courseName;
	
	public CourseType(String courseName){
		this.courseName=courseName;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public abstract String getEvaluation();
	
	@Override 
	public String toString(){
		return courseName+" ("+getEvaluation()+") ";
	}
}

class ExamCourse extends CourseType{
	public ExamCourse(String courseName){
		super(courseName);
	}
	
	@Override
	public String getEvaluation(){
		return "Exam-based";
	}
}

class AssignmentCourse extends CourseType{
	public AssignmentCourse(String courseName){
		super(courseName);
	}
	
	@Override
	public String getEvaluation(){
		return "Assignment-Based";
	}
}

class ResearchCourse extends CourseType{
	public ResearchCourse(String courseName){
		super(courseName);
	}
	
	@Override
	public String getEvaluation(){
		return "Research-Based";
	}
}

class Course<T extends CourseType>{
	private T courseType;
	private String department;
	
	public Course(String department, T courseType){
		this.department=department;
		this.courseType=courseType;
	}
	
	public String getDepartment(){
		return department;
	}
	public T getCourseType(){
		return courseType;
	}
	
	@Override
	public String toString(){
		return "Department: "+department+", Course: "+courseType;
	}
}

class courseDetails{
	public static void displayCourses(List<? extends CourseType> courses){
		for(CourseType c: courses){
			System.out.println(c);
		}
	}
}

public class UniversityCourseSystem{
	public static void main(String[] args){
		ExamCourse math=new ExamCourse("Mathematics 101");
		AssignmentCourse javalab=new AssignmentCourse("Java Programming");
		ResearchCourse aiThesis=new ResearchCourse("Ai Research Thesis");
		
		Course<ExamCourse> c1=new Course<>("Science", math);
		Course<AssignmentCourse> c2=new Course<>("Computer Science", javalab);
		Course<ResearchCourse> c3=new Course<>("Engineering", aiThesis);
		
		List<CourseType> allCourses=new ArrayList<>();
		allCourses.add(math);
		allCourses.add(javalab);
		allCourses.add(aiThesis);
		System.out.println();
		System.out.println("All courses: ");
		courseDetails.displayCourses(allCourses);
		System.out.println();
		System.out.println("Course Details: ");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}





