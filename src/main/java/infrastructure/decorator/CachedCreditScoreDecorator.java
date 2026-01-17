package infrastructure.decorator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import application.port.CreditScorePort;

public class CachedCreditScoreDecorator extends CreditScoreDecorator {

	private final Map<String, Integer> cache = new ConcurrentHashMap<>();
	
	protected CachedCreditScoreDecorator(CreditScorePort delegate) {
		super(delegate);
	}

	@Override
	public int getScore(
			final String dni) {
		return cache.computeIfAbsent(dni, delegate::getScore);
	}

}
