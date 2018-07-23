import utils.ImageDownloader;

import java.io.IOException;

public class ImageDownloaderTest {

    public static void main(String[] args) throws IOException {

        String basePath = "D:\\Profiles\\gmeloni\\Documents\\Sorgenti\\Varie\\meteo\\images";
        String baseUrl = "http://openweathermap.org/img/w/01d.png";

        ImageDownloader.download(baseUrl,basePath+"\\test.png");

    }
}
