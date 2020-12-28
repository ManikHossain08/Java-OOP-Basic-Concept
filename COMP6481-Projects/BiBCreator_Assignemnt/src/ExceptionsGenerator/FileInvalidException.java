package ExceptionsGenerator;

/**
 * @author manikhossain
 *
 */
public class FileInvalidException extends Exception {
	private static final long serialVersionUID = 1L;

	public FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
	}

	/**
	 * @param userMsg
	 */
	public FileInvalidException(String userMsg) {
		super(userMsg);
	}

	public String getMessage() {
		return super.getMessage();
	}

}
