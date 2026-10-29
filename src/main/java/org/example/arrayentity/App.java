package org.example.arrayentity;

import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.exception.InvalidPathException;
import org.example.arrayentity.exception.InvalidStringException;
import org.example.arrayentity.factory.ArrayFactory;
import org.example.arrayentity.factory.IntArrayFactory;
import org.example.arrayentity.parser.Parser;
import org.example.arrayentity.parser.impl.ParserImpl;
import org.example.arrayentity.reader.FileReader;
import org.example.arrayentity.reader.impl.FileReaderImpl;
import org.example.arrayentity.service.ArraySumService;
import org.example.arrayentity.service.AverageValueService;
import org.example.arrayentity.service.ExtremumService;
import org.example.arrayentity.service.SortArrayService;
import org.example.arrayentity.service.impl.ArraySumServiceImpl;
import org.example.arrayentity.service.impl.AverageValueServiceImpl;
import org.example.arrayentity.service.impl.ExtremumServiceImpl;
import org.example.arrayentity.service.impl.SortArrayServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        FileReader fileReader = new FileReaderImpl();
        ArraySumService arraySumService = new ArraySumServiceImpl();
        AverageValueService averageValueService = new AverageValueServiceImpl();
        ExtremumService extremumService = new ExtremumServiceImpl();
        SortArrayService sortArrayService = new SortArrayServiceImpl();
        List<String> data = null;
        try {
            data = fileReader.read(path, StandardCharsets.UTF_8);
        } catch (InvalidPathException | IOException e) {
            logger.warn("filepath {} is incorrect or empty!", path, e);
            return;
        }
        logger.info("read lines: {}", data.size());
        Parser parser = new ParserImpl();
        int parsedLines = 0;
        for (int i = 0; i < data.size(); i++) {
            try {
                IntArray array = arrayFactory.initializeArray(parser.parse(data.get(i)));
                System.out.println(array);
                System.out.println("array sum: " + arraySumService.calculateSum(array).getAsLong());
                System.out.println("array averageValue: " + averageValueService.calculateAverageValue(array).getAsDouble());
                System.out.println("array minValue: " + extremumService.findMinValue(array).getAsInt());
                System.out.println("array maxValue: " + extremumService.findMaxValue(array).getAsInt());
                sortArrayService.bubbleSort(array);
                System.out.println("array bubble sort: " + array);
                array = arrayFactory.initializeArray(parser.parse(data.get(i)));
                sortArrayService.selectionSort(array);
                System.out.println("array selection sort: " + array);
                System.out.println();
                System.out.println();
                parsedLines++;
            } catch (InvalidStringException e) {
                logger.warn("Skipping line {}: {}", i + 1, e.getMessage());
                continue;
            }
        }
        logger.info("parsed lines: {}", parsedLines);
    }
}
