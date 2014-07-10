package Database.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
	private String name;
	private Form form;
	private Major major;
    private ArrayList<Student> students;

	public Group() {
        name = "No Name";
        form = new Form();
        major = new Major();
        students = new ArrayList<Student>(10);
    }

    public Group(String name) {
        this();
        this.name = name;
    }

    public Group(String name, Form form) {
        this(name);
        this.form=form;
        form.addGroup(this);
    }

	public Group(String name, Form form, Major major) {
		this(name, form);
        this.major=major;
        major.addGroup(this);
	}

    public void addStudent(Student student) {
        students.add(student);
        student.setGroup(this);
    }

    public void removeStudent() {
        students.remove(students.size()-1);
    }
	
	@Override 
	public String toString() {
		return "Name - "+name+" Form - "+form.getName()+" Major - "+major.getName();
	}

	public void setName(String name) {
		this.name=name;
	}
	
	public void setForm(Form form) {
		this.form=form;
	}
	
	public void setMajor(Major major) {
		this.major=major;
	}
	
	public String getName() {
		return name;
	}
	
	public Form getForm() {
		return form;
	}
	
	public Major getMajor() {
		return major;
	}
}
