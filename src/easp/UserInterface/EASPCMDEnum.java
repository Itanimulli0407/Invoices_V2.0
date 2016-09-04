package easp.UserInterface;

public enum EASPCMDEnum {

	GUIFLAG ("-g:");
	
	private final String identifier;
	
	private EASPCMDEnum (String value){
		this.identifier = value;
	}
	
	public String getIdentifier(){
		return this.identifier;
	}
	
}
