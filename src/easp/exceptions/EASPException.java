package easp.exceptions;

public class EASPException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private EASPExceptionEnum type;
	private Exception oldException;
	private String[] parameters;

	public EASPException(EASPExceptionEnum type){
		this.type = type;
	}
	
	public EASPException(EASPExceptionEnum type, Exception oldException){
		this.type = type;
		this.oldException = oldException;
	}
	
	public EASPException(EASPExceptionEnum type, Exception oldException, String ... parameters){
		this.type = type;
		this.oldException = oldException;
		this.parameters = parameters;
	}

	public EASPExceptionEnum getType() {
		return type;
	}

	public Exception getOldException() {
		return oldException;
	}

	public String[] getParameters() {
		return parameters;
	}
	
}
