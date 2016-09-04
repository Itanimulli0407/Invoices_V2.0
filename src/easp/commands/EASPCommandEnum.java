package easp.commands;

public enum EASPCommandEnum {

	DEAULT (""),
	EXIT ("exit"),
	CREATE_CUSTOMER ("create_customer"),
	CREATE_INVOICE ("create_invoice");
	
	private final String type;
	
	private EASPCommandEnum(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
}
