package rana.census.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StateCensusAnalyserTest {
    StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();

    public static List<String[]> records;
    public StateCensusAnalyserTest() throws IOException, CsvException {
        try(
                BufferedReader bufferedReader=new BufferedReader(new FileReader("IndiaStateCensusData.csv"));
                CSVReader csvReader=new CSVReader(bufferedReader);
                ){
             records= csvReader.readAll();
        }
    }

    @Test
    public void iterator() throws IOException, CsvException {
        assertEquals(records.size(), stateCensusAnalyser.stateCensusAnalyser_data());
    }
}