package homeWork9;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.*;

public class Tests {

    /**
     * 1.
     * – Запаковать в zip архив несколько разных файлов - pdf, xlsx, csv
     * – Положить его в ресурсы
     * – Реализовать чтение и проверку содержимого каждого файла из архива
     * 2.
     * – Реализовать разбор json  файла библиотекой Jackson
     * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core/2.13.1
     * – Придумать реальный объект и описать его в виде  json
     * – В идеале json должен содержать массив
     */

    InputStream getFileFromZIP(FileExtension fileExtension) throws Exception {
        ZipFile zipFile = new ZipFile("C:\\Junk\\Projects\\QAguru\\src\\test\\resources\\Desktop.zip");

        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        InputStream inputStream = null;

        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
             inputStream = zipFile.getInputStream(entry);

            if (entry.getName().contains(fileExtension.toString().toLowerCase())) {
                return inputStream;
            }
        }
        return inputStream;
    }

    enum FileExtension {
        PDF, XLS, CSV
    }

    @Test
    void debugPDF() throws Exception {
        PDF pdf = new PDF(getFileFromZIP(FileExtension.PDF));
        assertThat(pdf.text).contains("REMEMBER THESE SHORTCUTS");
    }

    @Test
    void debugXLS() throws Exception {
        XLS xls = new XLS(getFileFromZIP(FileExtension.XLS));
        String actualValue = String.valueOf(xls
                .excel
                .getSheetAt(0)
                .getRow(6)
                .getCell(2)
                .getNumericCellValue());

        assertThat(actualValue).isEqualTo("1613.0");
    }

    @Test
    void debugCSV() throws Exception {
        InputStream inputStream = getFileFromZIP(FileExtension.CSV);
        CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream, UTF_8));
        List<String[]> csv = csvReader.readAll();
        assertThat(csv).contains(
                new String[]{"name", "age", "job"},
                new String[]{"Sergei", "30", "tester"}
        );
    }

    @Test
    void readPdfFromZip() throws IOException {
        ZipFile zipFile = new ZipFile("C:\\Junk\\Projects\\QAguru\\src\\test\\resources\\Desktop.zip");

        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);

            if (entry.getName().contains(".pdf")) {
                PDF pdf = new PDF(stream);
                assertThat(pdf.text).contains("REMEMBER THESE SHORTCUTS");
            }
        }
    }

    @Test
    void XLS() throws Exception {
        ZipFile zipFile = new ZipFile("C:\\Junk\\Projects\\QAguru\\src\\test\\resources\\Desktop.zip");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);

            if (entry.getName().contains(".xlsx")) {
                XLS xls = new XLS(stream);
                String actualValue = String.valueOf(xls
                        .excel
                        .getSheetAt(0)
                        .getRow(6)
                        .getCell(2)
                        .getNumericCellValue());

                assertThat(actualValue).isEqualTo("1613.0");
            }
        }
    }

    @Test
    void CSV() throws Exception {
        ZipFile zipFile = new ZipFile("C:\\Junk\\Projects\\QAguru\\src\\test\\resources\\Desktop.zip");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);

            if (entry.getName().contains(".csv")) {
                CSVReader csvReader = new CSVReader(new InputStreamReader(stream, UTF_8));
                List<String[]> csv = csvReader.readAll();
                assertThat(csv).contains(
                        new String[]{"name", "age", "job"},
                        new String[]{"Sergei", "30", "tester"}
                );
            }
        }
    }
}