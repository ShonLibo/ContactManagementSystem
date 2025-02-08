package contactmanager.app;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
        void testMainMethodRunsWithoutException() {
            try {
                String[] args = {};
                Main.main(args);
            } catch (Exception e) {
                fail("Main method threw an exception: " + e.getMessage());
            }
        }
}
