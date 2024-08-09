package utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class GetCsvData {
    private String csvPath;

    public GetCsvData(String e) {
        this.csvPath = e;
    }

    public ArrayList<String> getInputDataFromCsv() {
        ArrayList<String> d = new ArrayList<>();

        try (Reader reader = new FileReader(this.csvPath);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL.withDelimiter(',').withHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                d.add(csvRecord.get("UserName"));
                d.add(csvRecord.get("Password"));
                d.add(csvRecord.get("Categorie"));
                d.add(csvRecord.get("Article"));

                break;
            }
        } catch (IOException e) {
            System.out.println("Hubo un problema con el archivo de entrada .csv: " + e);
        }

        return d;
    }
}
