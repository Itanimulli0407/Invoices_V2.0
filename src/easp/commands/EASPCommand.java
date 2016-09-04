package easp.commands;

public class EASPCommand {

	private EASPCommandEnum type;
	private String[] arguments;

	public EASPCommand(EASPCommandEnum type){
		this.type = type;
	}
	
	public EASPCommand(EASPCommandEnum type, String ... arguments){
		this.type = type;
		this.arguments = arguments;
	}

	public EASPCommandEnum getType() {
		return type;
	}

	public String[] getArguments() {
		return arguments;
	}
	
}

