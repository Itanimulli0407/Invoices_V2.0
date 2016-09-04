package easp.statements;

public class EASPStatement {
	
	private EASPStatementEnum type;

	public EASPStatement(EASPStatementEnum type){
		this.type = type;
	}
	
	public EASPStatementEnum getType(){
		return this.type;
	}
	
}
