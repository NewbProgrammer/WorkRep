package Database.Cutted;
/**
 * 
 * @author Alex
 *	This class might be useless.
 *	Think about deleting it in future.
 */
public class MarkType {

	private String name;

	MarkType(String name){
		this.name=name;
	}
	
	@Override
	public String toString(){
		return "MarkType info:\n"+name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
}
