import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.BasePage;
import pages.FormResultBasePage;
import pages.ResultPage;

import java.util.stream.Stream;

public class BaseTest {

    @ParameterizedTest(name = "test - {0}, {1}")
    @ArgumentsSource(ParameterizedStream.class)
    void testExample(
            Month month,
            Class<FormResultBasePage> pageClass
    ) {
        if (pageClass.getName().contains("BasePage")) {
            assert false;
        }
    }

    @ParameterizedTest(name = "test2 - {0}, {1}")
    @MethodSource("testStream")
    void testExample2(
            Month month,
            Class<FormResultBasePage> pageClass
    ) {
        if (month == Month.APRIL) {
            assert false;
        }
    }

    private static Stream<Arguments> testStream() {
        return Stream.of(
                Arguments.of(Month.APRIL, ResultPage.class),
                Arguments.of(Month.JULY, BasePage.class)
        );
    }
}
