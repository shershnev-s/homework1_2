package by.tut.shershnev_s.service.impl;

import by.tut.shershnev_s.service.util.CreateFileUtil;
import by.tut.shershnev_s.service.util.RandomUtil;
import by.tut.shershnev_s.service.util.WriteDataToFileUtil;
import by.tut.shershnev_s.service.FirstHomeWorkService;
import by.tut.shershnev_s.service.model.Car;
import by.tut.shershnev_s.service.model.CarModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by user on 28.11.2019.
 */
public class FirstHomeWorkServiceImpl implements FirstHomeWorkService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void runFirstTask() {
        float x = RandomUtil.getRandomNumber();
        float y = RandomUtil.getRandomNumber();
        float z = RandomUtil.getRandomNumber();
        compareNumbers(x, y, z);
        averageSum(x, y, z);
    }

    @Override
    public void runSecondTask() {
        int arrayLength = 10;
        int[] numberArray = new int[arrayLength];
        numberArray = fillArrayByRandomNumbers(numberArray);
        printArray(numberArray);
        int minValue = findMinValue(numberArray);
        int maxValue = findMaxValue(numberArray);
        numberArray = replaceMaxToMin(numberArray, minValue, maxValue);
        printArray(numberArray);
    }

    @Override
    public void runThirdTask() {
        int numbersOfCars = 10;
        Map<Car, Integer> carsStart = generateCarObjects(numbersOfCars);
        int randomEngineCapacity = RandomUtil.getRandomNumberInRange(1, 3);
        Map<Car, Integer> cars = groupObjects(carsStart);
        String pathForResult = "D:\\JavaLearning\\homework1_2\\hw1_2\\src\\main\\resources\\result.txt";
        File file = new File(pathForResult);
        CreateFileUtil.createFile(file);
        String stringForWriting = getString(cars, randomEngineCapacity);
        WriteDataToFileUtil.writeDataToFileUtil(file, stringForWriting);
    }

    private String getString(Map<Car, Integer> map, int randomEngineCapacity) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Car, Integer> element : map.entrySet()) {
            if (element.getKey().getEngineCapacity() == randomEngineCapacity) {
                stringBuilder.append(element.getKey().getName() + ":" + element.getKey().getCarModel() + ":" + element.getKey().getEngineCapacity());
            }
        }
        return stringBuilder.toString();
    }

    private Map<Car, Integer> groupObjects(Map<Car, Integer> map) {
        Map<Car, Integer> result = new LinkedHashMap<>();
        Stream<Map.Entry<Car, Integer>> stream = map.entrySet().stream();
        stream.sorted(Comparator.comparing(Map.Entry::getValue)).forEach(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }

    private CarModel generateCarModel() {
        CarModel[] carModel = CarModel.values();
        int randomCarModel = RandomUtil.getRandomNumberInRange(0, 2);
        return carModel[randomCarModel];
    }

    private Map<Car, Integer> generateCarObjects(int numberOfObjects) {
        Map<Car, Integer> cars = new HashMap<>();
        String carName = "name";
        for (int i = 0; i < numberOfObjects; i++) {
            int randomEngineCapacity = RandomUtil.getRandomNumberInRange(1, 3);
            Car car = new Car(generateCarModel(), randomEngineCapacity, carName + i);
            cars.put(car, car.getEngineCapacity());
        }
        return cars;
    }

    private void compareNumbers(float x, float y, float z) {
        logger.debug(x + " " + y + " " + z);
        if (x > z) {
            logger.debug("x + y = " + x + y);
        } else {
            logger.debug("z = " + z);
        }
    }

    private void averageSum(float x, float y, float z) {
        float numbersQuantity = 3;
        float result = (x + y + z) / numbersQuantity;
        logger.info("average sum = " + result);
    }

    private int[] fillArrayByRandomNumbers(int[] array) {
        int minRandomNumber = -300;
        int maxRandomNumber = 300;
        for (int i = 0; i < array.length; i++) {
            array[i] = RandomUtil.getRandomNumberInRange(minRandomNumber, maxRandomNumber);
        }
        return array;
    }

    private int findMinValue(int[] array) {
        int minValue = array[0];
        for (int element : array) {
            if (minValue > element) {
                minValue = element;
            }
        }
        logger.info("minValue value = " + minValue);
        return minValue;
    }

    private int findMaxValue(int[] array) {
        int maxValue = array[0];
        for (int element : array) {
            if (maxValue < element) {
                maxValue = element;
            }
        }
        logger.info("maxValue value = " + maxValue);
        return maxValue;
    }

    private int[] replaceMaxToMin(int[] array, int minValue, int maxValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == maxValue) {
                array[i] = minValue * maxValue;
            }
        }
        return array;
    }

    private void printArray(int[] array) {
        for (int element : array) {
            logger.error(element + " ");
        }
    }
}
