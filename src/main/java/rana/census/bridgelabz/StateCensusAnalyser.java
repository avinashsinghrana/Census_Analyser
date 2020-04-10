package rana.census.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class StateCensusAnalyser {

    public StateCensusAnalyser() throws IOException, CsvException {
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader("IndiaStateCensusData.csv"));
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
            }
        }
    }
}
