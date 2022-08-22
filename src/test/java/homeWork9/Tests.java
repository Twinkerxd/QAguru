package homeWork9;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

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

    @Test
    public void checkPdfFromZip() throws Exception {
        ClassLoader classLoader = Tests.class.getClassLoader(); // помогает работать с файлами из ресурсов
        InputStream inputStream = classLoader.getResourceAsStream("Desktop.zip"); // передаём архив из ресурсов
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);

        ZipEntry entry;

        while ((entry = zipInputStream.getNextEntry()) != null) {
            System.out.println(entry.getName());

        }
    }

    @Test
    public void second() throws IOException {
        ZipFile zipFile = new ZipFile("C:\\Junk\\Projects\\QAguru\\src\\test\\resources\\Desktop.zip");

        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);

            if (entry.getName().contains(".pdf")) {
                PDF pdf = new PDF(stream);
                assertThat(pdf.text.contains("REMEMBER THESE SHORTCUTS"));
            } else if (entry.getName().contains(".xlsx")) {
                XLS xls = new XLS(stream);
                double actualValue = xls.excel.getSheetAt(0).getRow(6).getCell(2).getNumericCellValue();
//                assertThat(actualValue, 1613.1);
                Typetester t = new Typetester();
                t.printType(actualValue);
                System.out.println();
            } else if (entry.getName().contains(".csv")) {

            }
        }
    }

    class Typetester {
        void printType(byte x) {
            System.out.println(x + " is an byte");
        }
        void printType(int x) {
            System.out.println(x + " is an int");
        }
        void printType(float x) {
            System.out.println(x + " is an float");
        }
        void printType(double x) {
            System.out.println(x + " is an double");
        }
        void printType(char x) {
            System.out.println(x + " is an char");
        }
    }
}