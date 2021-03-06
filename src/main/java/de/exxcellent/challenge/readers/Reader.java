package de.exxcellent.challenge.readers;

import java.io.IOException;
import java.util.List;

/**
 * Reader Interface for reading different file origins.
 */
public interface Reader {
    List<String[]> read() throws IOException;
}
