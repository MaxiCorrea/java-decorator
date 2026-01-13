package infrastructure.decorator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import domain.port.CreditScorePort;

class CachedCreditScoreDecoratorTest {

	@Test
	void shouldCallDelegateOnlyOnce() {
		CreditScorePort port = mock(CreditScorePort.class);
		Mockito.when(port.getScore("123")).thenReturn(700);
		CreditScorePort cache = new CachedCreditScoreDecorator(port);
		cache.getScore("123");
		cache.getScore("123");
		verify(port, times(1)).getScore("123");
	}

}
