package infrastructure.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import application.port.CreditScorePort;

class RetryCreditScoreDecoratorTest {

	@Test
	void shouldRetryUntilSuccess() {
		CreditScorePort port = mock(CreditScorePort.class);
		Mockito.when(port.getScore("123")).thenThrow(RuntimeException.class).thenReturn(700);
		RetryCreditScoreDecorator retry = new RetryCreditScoreDecorator(port, 2);
		int expectedResult = 700;
		assertEquals(expectedResult, retry.getScore("123"));
		verify(port, times(2)).getScore("123");
	}

}
