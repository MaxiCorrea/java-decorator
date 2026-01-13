package infrastructure.decorator;

import domain.port.CreditScorePort;

public abstract class CreditScoreDecorator implements CreditScorePort {

	protected final CreditScorePort delegate;
	
	protected CreditScoreDecorator(
			final CreditScorePort delegate) {
		this.delegate = delegate;
	}
	
}
