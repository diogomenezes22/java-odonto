package ondoto.framework.dao;


public class CreateDaoException extends RuntimeException {

	/**
	 * 
	 */
	public CreateDaoException() {
		super();
	}

	/**
	 * @param reason
	 * @param cause
	 */
	public CreateDaoException(String reason, Throwable cause) {
		super(reason, cause);
	}

	/**
	 * @param reason
	 */
	public CreateDaoException(String reason) {
		super(reason);
	}

	/**
	 * @param cause
	 */
	public CreateDaoException(Throwable cause) {
		super(cause);
	}

	
}
