package seed.python.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/** Tests for the {@link PythonScript} class. */
class PythonScriptTests {

    @Test
    void testPythonScriptRun() {
        IntStream.range(0, 10).parallel().forEach(i -> {
            PythonScript script = new PythonScript();
            script.importsAs("numpy", "np");
            script.write("print('hello, world')");
            script.write("a = np.linspace(0, 10, 100)");
            script.write(String.format("print(%s)", 5.0));
            String letter = String.valueOf((char) ('a' + i));
            script.write("print(" + letter + ")");
            int errorcode = assertDoesNotThrow(() -> script.exec());
            if (i == 0) {
                assertEquals(0, errorcode);
            } else {
                assertTrue(errorcode > 0);
            }
        });
    }
}
