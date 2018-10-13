import org.junit.Test;
import utils.ImageDownloader;

import java.io.IOException;

public class ImageDownloaderTest {

    @Test
    public void downloadImageTest() throws IOException {

        String basePath = "/home/gianfe/Documenti/java_workspace/meteo/images";
        String baseUrl = "http://openweathermap.org/img/w/01d.png";

        ImageDownloader.download(baseUrl,basePath+"//test.png");

    }
}
