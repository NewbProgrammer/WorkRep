package Database;
import java.util.*;

public class MyDate extends GregorianCalendar{

	MyDate(int year, int month, int day){
		super(year,month,day);
	}

	@Override
	public String toString(){
		return DATE+" "+MONTH+" "+YEAR+"\n"+DAY_OF_WEEK+"\n"+get(Calendar.DATE);
	}
}
