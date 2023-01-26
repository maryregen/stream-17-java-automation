package files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFilesTest {
    static ClassLoader cl = SelenideFilesTest.class.getClassLoader();
    static HashMap<String, byte[]> ZipFiles = new HashMap<>();

    @BeforeAll
    static void selenideParseFilesFromZIP() throws Exception {
        InputStream stream = cl.getResourceAsStream("example.zip");
        ZipInputStream zis = new ZipInputStream(stream);

        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            String name = entry.getName();
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            for (int c = zis.read(); c != -1; c = zis.read()) {
                out.write(c);
            }
            out.flush();
            zis.closeEntry();
            out.close();
            ZipFiles.put(name, out.toByteArray());
        }
    }

    @Test
    void parsePDFFile() throws Exception {
        try (
                InputStream stream = new ByteArrayInputStream(ZipFiles.get(new String("example.pdf")));
        )
        {
            PDF content = new PDF(stream);
            assertThat(content.text).contains("Пример pdf");
        }
    }
//
    @Test
    void parseXLSFile() throws Exception {
        //System.out.println(Arrays.toString(ZipFiles.get(new String("example.xlsx"))));
        try (
                InputStream s = new ByteArrayInputStream(ZipFiles.get(new String("example.xlsx")));
        )
        {
            XLS content = new XLS(s);
            assertThat(content.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).contains("Пример xlsx");
        }
    }
//
    @Test
    void parseCSVFile () throws Exception {
        try (
                //InputStream resourceAsStream = cl.getResourceAsStream("example.csv");
                InputStream stream = new ByteArrayInputStream(ZipFiles.get(new String("example.csv")));
                CSVReader reader = new CSVReader(new InputStreamReader(stream));
                )
        {
            List<String[]> content = reader.readAll();
            assertThat(content.get(0)[0]).contains("Example of csv");
        }
    }
}

