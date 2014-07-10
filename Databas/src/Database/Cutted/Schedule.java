package Database.Cutted;

import Database.Entities.Group;
import Database.TeachSubj;

public class Schedule {
	private TeachSubj teachSubj;
	private Group group;
	private String day;
	int pairNumber;

    public Schedule() {}

    public Schedule(TeachSubj teachSubj, Group group, String day, int pairNumber) {
		this.teachSubj=teachSubj;
		this.group=group;
		this.day=day;
		this.pairNumber=pairNumber;
	}
	
	@Override
	public String toString() {
		return "Schedule info\n"+teachSubj.toString()+"\n"+group.toString()+"\nDay - "+day+" PairNumber - "+pairNumber;
	}
}
