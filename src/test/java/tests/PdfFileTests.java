package tests;

import com.codeborne.pdftest.PDF;
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
@Tag("pdf")
class PdfFileTests {

    @Test
    void successfulSearchForTextInPdfFile() throws IOException {
        String expectedFileText = "Here is your text2 in file.pdf! ";
        String actualFilePath = "src/test/resources/files/file.pdf";

        File actualFile = new File(actualFilePath);
        PDF pdf = new PDF(actualFile);

        assertThat(pdf, PDF.containsText(expectedFileText));
            }

}