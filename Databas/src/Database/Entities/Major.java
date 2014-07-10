package Database.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Major implements Serializable {
	private String name;
    private ArrayList<Group> groups;
    private ArrayList<Subject> subjects;

	public Major() {
        name = "No Major";
        groups = new ArrayList<Group>(10);
        subjects = new ArrayList<Subject>(10);
    }

    public Major(String name) {
        this();
		this.name=name;
	}
	
	@Override 
	public String toString() {
		return "MajorName - "+name;
	}

    public void addGroup(Group group) {
        groups.add(group);
        group.setMajor(this);
    }

    public void removeGroup() {
        groups.remove(groups.size()-1);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setMajor(this);
    }

    public void removeSubject() {
        subjects.remove(subjects.size()-1);
    }
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
}