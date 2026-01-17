package infrastructure.adapter;

import application.port.CreditScorePort;

public class ExternalCreditScoreAdapter implements CreditScorePort {

	@Override
	public int getScore(
			final String dni) {
		// HTTP call
		return 720;
	}

}
