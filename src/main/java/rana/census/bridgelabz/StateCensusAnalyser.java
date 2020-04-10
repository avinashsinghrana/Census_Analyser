package rana.census.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StateCensusAnalyser {

    public int stateCensusAnalyser_data() throws IOException, CsvException {
        int count=1;
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader("IndiaStateCensusData.csv"));
                CSVReader csvReader = new CSVReader(bufferedReader);
        ){
            CsvToBean<CSVdata> csvToBean = new CsvToBeanBuilder<CSVdata>(bufferedReader)
                    .withType(CSVdata.class)
                    .build();

            Iterator<CSVdata> csvdataIterator = csvToBean.iterator();

            while (csvdataIterator.hasNext()){
                CSVdata csvdata = csvdataIterator.next();
                System.out.println("State :: " + csvdata.getState());
                System.out.println("State :: " + csvdata.getPopulation());
                System.out.println("State :: " + csvdata.getAreaInSqKm());
                System.out.println("State :: " + csvdata.getDensityPerSqKm());
                System.out.println("*****************************************");
                count++;
            }
        }
        return count;
    }
}
