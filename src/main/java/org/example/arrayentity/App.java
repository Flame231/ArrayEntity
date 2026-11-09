package org.example.arrayentity;

import org.example.arrayentity.arraystatistics.ArrayStatistics;
import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.exception.InvalidPathException;
import org.example.arrayentity.exception.InvalidStringException;
import org.example.arrayentity.factory.ArrayFactory;
import org.example.arrayentity.factory.IntArrayFactory;
import org.example.arrayentity.observer.Observer;
import org.example.arrayentity.observer.impl.ObserverImpl;
import org.example.arrayentity.parser.ArrayParser;
import org.example.arrayentity.parser.impl.ArrayParserImpl;
import org.example.arrayentity.reader.ArrayFileReader;
import org.example.arrayentity.reader.impl.ArrayFileReaderImpl;
import org.example.arrayentity.repository.impl.ArrayRepositoryImpl;
import org.example.arrayentity.service.ArraySumService;
import org.example.arrayentity.service.AverageValueService;
import org.example.arrayentity.service.ExtremumService;
import org.example.arrayentity.service.SortArrayService;
import org.example.arrayentity.service.impl.ArraySumServiceImpl;
import org.example.arrayentity.service.impl.AverageValueServiceImpl;
import org.example.arrayentity.service.impl.ExtremumServiceImpl;
import org.example.arrayentity.service.impl.SortArrayServiceImpl;
import org.example.arrayentity.specification.ArraySpecification;
import org.example.arrayentity.specification.impl.ArrayIdSpecificationImpl;
import org.example.arrayentity.specification.impl.ArraySumSpecificationImpl;
import org.example.arrayentity.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

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
        ArrayRepositoryImpl arrayRepositoryImpl = ArrayRepositoryImpl.getReference();
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
                OptionalDouble averageValue = averageValueService.calculateAverageValue(array);
                OptionalLong sum = arraySumService.calculateSum(array);
                OptionalInt minValue = extremumService.findMinValue(array);
                OptionalInt maxValue = extremumService.findMaxValue(array);
                ArrayStatistics arrayStatistics = new ArrayStatistics(array.getId(), averageValue, sum, minValue, maxValue);
                Observer observer = new ObserverImpl();
                array.addObserver(observer);
                warehouse.addArrayStatistics(arrayStatistics);
                System.out.println("array averageValue: " + averageValue);
                System.out.println("array sum: " + sum);
                System.out.println("array minValue: " + minValue);
                System.out.println("array maxValue: " + maxValue);
                sortArrayService.bubbleSort(array);
                System.out.println("array bubble sort: " + array);
                sortArrayService.selectionSort(array);
                System.out.println("array selection sort: " + array);
                System.out.println();
                System.out.println();
                parsedLines++;
                arrayRepositoryImpl.addArray(array);
            } catch (InvalidStringException e) {
                logger.warn("Skipping line {}: {}", i + 1, e.getMessage());
                continue;
            }
        }
        List<IntArray> intArrays = arrayRepositoryImpl.findBySpecification(new ArraySumSpecificationImpl(6, Long::equals));
        for (IntArray intArray : intArrays) {
            System.out.println(intArray);
        }
        logger.info("parsed lines: {}", parsedLines);
    }
}
