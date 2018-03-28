package org.imsglobal.basiclti.consumersecret.api;

/**
 * RuntimeException indicating that some unexpected and unrecoverable error has occurred in the consumer secret service.
 * 
 * @author Roland Groen (roland@edia.nl)
 *
 */
public class UnexpectedConsumerServiceException extends RuntimeException {

	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8332692966206669521L;

	public UnexpectedConsumerServiceException() {
	    super();
    }

	public UnexpectedConsumerServiceException(String message, Throwable cause) {
	    super(message, cause);
    }

	public UnexpectedConsumerServiceException(String message) {
	    super(message);
    }

	public UnexpectedConsumerServiceException(Throwable cause) {
	    super(cause);
    }

}
