package Behavioural_patterns.template_method;

public class pract1 {
    public static void main(String[] args) {
        System.out.println("CSV Processing:");
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process();

        System.out.println("\nJSON Processing:");
        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.process();
    }
}

abstract class DataProcessor{
    public void process(){
        readData();
        processData();
        saveData();
    }

    public void readData(){
        System.out.println("Read data from file");
    }

    abstract void processData();

    public void saveData(){
        System.out.println("Save data to file");
    }
}

class CSVDataProcessor extends DataProcessor{
    @Override
    void processData(){
        System.out.println("Processing CSV data");
    }
}

class JSONDataProcessor extends DataProcessor{
    @Override
    void processData(){
        System.out.println("Processing JSON data");
    }
}   

