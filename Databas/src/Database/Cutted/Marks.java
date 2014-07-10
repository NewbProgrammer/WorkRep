package Database.Cutted;

import Database.Entities.Group;
import Database.Entities.Student;
import Database.TeachSubj;

import java.util.Date;

public class Marks {
	private MarkType markType;
	private TeachSubj teachSubj;
	private Student student;
	private Date date;
	private Group group;

    public Marks() {}

    public Marks(MarkType markType, TeachSubj teachSubj, Student student, Date date, Group group) {
		this.markType=markType;
		this.teachSubj=teachSubj;
		this.student=student;

		this.date=date;
		this.group=group;
	}
	
	@Override
	public String toString() {
		return "Marks info:\nMarkType - "+markType+"\n"+teachSubj.toString()+"\n"+student.toString()+"\n"
				+group.toString()+"\nDate - "+date;
	}
	
	
}