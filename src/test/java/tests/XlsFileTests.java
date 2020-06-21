package tests;

import com.codeborne.xlstest.XLS;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertThat;


@Epic("QA.GURU automation course")
@Story("File tests")
@Tag("file")
@Tag("xls")
class XlsFileTests {

    @Test
    void successfulSearchForTextInXlsFile() throws IOException {
        String expectedFileText = "Here is your text2 in file.xlsx! ";
        String actualFilePath = "src/test/resources/files/file.xlsx";

        File actualFile = new File(actualFilePath);
        XLS xls = new XLS(actualFile);

        assertThat(xls, XLS.containsText(expectedFileText));
    }

}