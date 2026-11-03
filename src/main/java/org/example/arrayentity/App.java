package org.example.arrayentity;

import org.example.arrayentity.arraystatistics.ArrayStatistics;
import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.exception.InvalidPathException;
import org.example.arrayentity.exception.InvalidStringException;
import org.example.arrayentity.factory.ArrayFactory;
import org.example.arrayentity.factory.IntArrayFactory;
import org.example.arrayentity.parser.ArrayParser;
import org.example.arrayentity.parser.impl.ArrayParserImpl;
import org.example.arrayentity.reader.ArrayFileReader;
import org.example.arrayentity.reader.impl.ArrayFileReaderImpl;
import org.example.arrayentity.repository.ArrayRepository;
import org.example.arrayentity.service.ArraySumService;
import org.example.arrayentity.service.AverageValueService;
import org.example.arrayentity.service.ExtremumService;
import org.example.arrayentity.service.SortArrayService;
import org.example.arrayentity.service.impl.ArraySumServiceImpl;
import org.example.arrayentity.service.impl.AverageValueServiceImpl;
import org.example.arrayentity.service.impl.ExtremumServiceImpl;
import org.example.arrayentity.service.impl.SortArrayServiceImpl;
import org.example.arrayentity.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final String path = "data/data.txt";

    public static void main(String[] args) {
        ArrayFactory arrayFactory = new IntArrayFactory();
        ArrayFileReader arrayFileReader = new ArrayFileReaderImpl();
        ArraySumService arraySumService = new ArraySumServiceImpl();
        AverageValueService averageValueService = new AverageValueServiceImpl();
        ExtremumService extremumService = new ExtremumServiceImpl();
        SortArrayService sortArrayService = new SortArrayServiceImpl();
        Warehouse warehouse = Warehouse.getReference();
        ArrayRepository arrayRepository = ArrayRepository.getReference();
        List<String> data = null;
        try {
            data = arrayFileReader.read(path);
        } catch (InvalidPathException | IOException e) {
            logger.warn("filepath {} is incorrect or empty!", path, e);
            return;
        }
        logger.info("read lines: {}", data.size());
        ArrayParser arrayParser = new ArrayParserImpl();
        int parsedLines = 0;
        for (int i = 0; i < data.size(); i++) {
            try {
                IntArray array = arrayFactory.createArray(arrayParser.parse(data.get(i)));
                System.out.println(array);
                warehouse.addArrayStatistics(array.getId(), new ArrayStatistics(averageValueService.calculateAverageValue(array), arraySumService.calculateSum(array), extremumService.findMinValue(array), extremumService.findMaxValue(array)));
                System.out.println("array sum: " + );
                System.out.println("array averageValue: " +);
                System.out.println("array minValue: " +);
                System.out.println("array maxValue: " +);
                sortArrayService.bubbleSort(array);
                System.out.println("array bubble sort: " + array);
                array = arrayFactory.createArray(arrayParser.parse(data.get(i)));
                sortArrayService.selectionSort(array);
                System.out.println("array selection sort: " + array);
                System.out.println();
                System.out.println();
                parsedLines++;
            } catch (InvalidStringException e) {
                logger.warn("Skipping line {}: {}", i + 1, e.getMessage());
                continue;
            }
            arra
        }
        logger.info("parsed lines: {}", parsedLines);
    }
}
