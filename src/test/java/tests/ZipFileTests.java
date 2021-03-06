package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.FileUtils;
import utils.ZipUtils;

import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


@Epic("QA.GURU automation course")
@Story("Zip file tests")
@Tag("zip")
@Tag("file")
class ZipFileTests {

    @Test
    void successfulSearchForTextInZip() {
        String source = "src/test/resources/files/files.zip";
        String destination = "src/test/resources/files/unzip";

        String expectedFileText = "Here is your text3 in file3.txt!";

        new ZipUtils().unzip(source, destination);
        sleep(1000); // todo waitUtilFileExists();

        String actualFileText = new FileUtils().readStringFromFile("src/test/resources/files/unzip/file3.txt");
        System.out.println("Actual text from file: \n" + actualFileText);

        assertThat(actualFileText, containsString(expectedFileText));
    }

    @Test
    void successfulSearchForTextInZipWithPassword() {
        String source = "src/test/resources/files/files_with_password.zip";
        String destination = "src/test/resources/files/unzip_with_password";
        String password = "qa.guru";

        String expectedFileText = "Here is your text3 in file2.txt!";

        new ZipUtils().unzip(source, destination, password);
        sleep(1000); // todo waitUtilFileExists();

        String actualFileText = new FileUtils().readStringFromFile("src/test/resources/files/unzip_with_password/file2.txt");
        System.out.println("Actual text from file: \n" + actualFileText);

        assertThat(actualFileText, containsString(expectedFileText));
    }
}