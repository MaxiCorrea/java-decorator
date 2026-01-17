package application.usecase;

import application.port.CreditScorePort;

public class GetCreditScoreUseCase {

	private final CreditScorePort scorePort;
	
	public GetCreditScoreUseCase(
			final CreditScorePort scorePort) {
		this.scorePort = scorePort;
	}
	
	public int execute(
			final String dni) {
		return scorePort.getScore(dni);
	}
	
}
