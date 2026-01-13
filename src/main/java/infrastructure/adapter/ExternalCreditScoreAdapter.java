package infrastructure.adapter;

import domain.port.CreditScorePort;

public class ExternalCreditScoreAdapter implements CreditScorePort {

	@Override
	public int getScore(
			final String dni) {
		// HTTP call
		return 720;
	}

}
