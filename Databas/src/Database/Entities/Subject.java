package Database.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Subject implements Serializable {
	private String name;
	private Major major;
	private ArrayList<Teacher> teachers;

    public Subject() {
        name = "No Subject";
        major = new Major();
        teachers = new ArrayList<Teacher>(10);
    }

    public Subject(String name) {
        this();
        this.name = name;
    }

    public Subject(String name, Major major) {
        this(name);
		this.major=major;
        major.addSubject(this);
	}

    public Subject(String name, Major major, Teacher teacher) {
        this(name, major);
       	teachers.add(teacher);
       	teacher.addSubject(this);
    }

	@Override
	public String toString() {
		return "SubjectName - "+name;
	}

	public void setName(String name) {
		this.name=name;
	}
	
	public void setMajor(Major major) {
		this.major=major;
	}
	
	public String getName() {
		return name;
	}
	
	public Major getMajor() {
		return major;
	}
	
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
       //teacher.addSubject(this);
	}
}
