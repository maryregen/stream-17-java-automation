package files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFilesTest {
    static ClassLoader cl = SelenideFilesTest.class.getClassLoader();

    @BeforeAll
    static void selenideParseFilesFromZIP() throws IOException {

        //File zipFile = new File("src/test/resources/example.zip");
        try (
                InputStream stream = cl.getResourceAsStream("example.zip");
                ZipInputStream zis = new ZipInputStream(stream)
        ) {
            ZipEntry entry;
            String name;
            while ((entry = zis.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream("src/test/resources/" + name);
                System.out.println(name);
                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fout.write(c);
                }
                fout.flush();
                zis.closeEntry();
                fout.close();
            }
        }
    }

    @Test
    void parsePDFFile() throws IOException {
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("example.pdf")
        )
        {
            PDF content = new PDF(resourceAsStream);
            assertThat(content.text).contains("Пример pdf");
        }
    }

    @Test
    void parseXLSFile() throws IOException {
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("example.xlsx");
                )
        {
            XLS content = new XLS(resourceAsStream);
            assertThat(content.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()).contains("Пример xlsx");
        }
    }

    @Test
    void parseCSVFile () throws IOException {
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("example.csv");
                CSVReader reader = new CSVReader(new InputStreamReader(resourceAsStream));
                )
        {
            List<String[]> content = reader.readAll();
            assertThat(content.get(0)[0]).contains("Example of csv");
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

}

