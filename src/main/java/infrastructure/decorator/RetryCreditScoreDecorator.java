package infrastructure.decorator;

import domain.port.CreditScorePort;

public class RetryCreditScoreDecorator extends CreditScoreDecorator {

	private int maxRetries;

	protected RetryCreditScoreDecorator(
			final CreditScorePort delegate,
			final int maxRetries) {
		super(delegate);
		this.maxRetries = maxRetries;
	}

	@Override
	public int getScore(
			final String dni) {
		RuntimeException lastException = null;
		for(int retry = 0; retry < maxRetries ; ++retry) {
			try {
				return delegate.getScore(dni);
			} catch (RuntimeException ex) {
				lastException = ex;
			}
		}
		throw lastException;
	}

	
	
}
