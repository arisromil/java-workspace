package object;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Prefer `try-resources` to `try-finally`
// A resource must implement the AutoCloseable interface

public class TryResources {

    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader( new FileReader(path))){
            return br.readLine();
        }
    }

}
