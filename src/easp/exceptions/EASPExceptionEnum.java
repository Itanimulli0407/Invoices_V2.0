package easp.exceptions;

public enum EASPExceptionEnum {

	E001 ("Database Server Error"),
	E002 ("Null Pointer Error"),
	E003 ("SQL Error"),
	E004 ("IO Exception");
	
	private String type;
	
	private EASPExceptionEnum (String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
}
