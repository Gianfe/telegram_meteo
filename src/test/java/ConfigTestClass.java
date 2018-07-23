import config.YamlConfig;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigTestClass {


    @Test
    public void testYamlConfiguration() throws IOException {

        Yaml yaml = new Yaml();

        try (InputStream in = Files.newInputStream(Paths.get("/home/gianfe/Documenti/java_workspace/meteo/src/main/resources/config.yaml"))) {
            YamlConfig config = yaml.loadAs(in, YamlConfig.class);
            System.out.println(config.toString());
        }
    }
}
