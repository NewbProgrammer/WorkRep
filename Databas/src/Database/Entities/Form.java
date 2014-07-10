package Database.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Form implements Serializable{
    private String name;
    private ArrayList<Group> groups;

    public Form() {
        name = "No Form";
        groups = new ArrayList<Group>(10);
    }

    public Form(String name) {
        this();
        this.name=name;
    }

    public Form(String name, Group group) {
        this();
        this.name=name;
        groups.add(group);
    }

    @Override
    public String toString() {
        return "Name - "+name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public void removeGroup() {
        groups.remove(groups.size()-1);
    }
}
