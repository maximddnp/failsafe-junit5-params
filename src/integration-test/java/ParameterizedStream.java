import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import pages.BasePage;
import pages.ResultPage;

import java.util.stream.Stream;

public class ParameterizedStream implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(Month.APRIL, ResultPage.class),
                Arguments.of(Month.JULY, BasePage.class)
        );
    }
}
