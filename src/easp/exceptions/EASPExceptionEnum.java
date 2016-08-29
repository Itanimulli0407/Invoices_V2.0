package easp.exceptions;

public enum EASPExceptionEnum {

	E001 ("Database Server Error");
	
	private String type;
	
	private EASPExceptionEnum (String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
}
