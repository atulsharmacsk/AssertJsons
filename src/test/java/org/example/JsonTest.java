package org.example;

import lombok.SneakyThrows;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class JsonTest {

    private String readJson(String fileName) throws Exception {
        return new String(Files.readAllBytes
                (Paths.get(Objects.requireNonNull
                                (getClass().getClassLoader().getResource(fileName))
                        .toURI())), StandardCharsets.UTF_8);
    }

    @SneakyThrows
    @Test
    public void demoTest1() {
        String expected = readJson("expected.json");
        String actual = readJson("actual.json");
        JSONAssert.assertEquals(expected, actual, JSONCompareMode.STRICT);
    }

    @SneakyThrows
    @Test
    public void demoTest2() {
        String expected = readJson("expected.json");
        String actual = readJson("actual.json");
        JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
    }
}