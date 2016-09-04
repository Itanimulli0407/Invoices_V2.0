package easp.statements;

public enum EASPStatementEnum {

	GET_CUSTOMERS("SELECT * FROM kunden LEFT JOIN nummern ON kunden.id = nummern.kunde");
	// TODO: Insert more Statements here

	private final String statement;

	private EASPStatementEnum(String statement) {
		this.statement = statement;
	}

	public String getStatement() {
		return this.statement;
	}

}
