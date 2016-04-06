package com.wira.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Tutorial from MKYong here :
 * http://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
 */
public class MainAppProcessCsvPgsql {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        String csvFile = args[2];
        BufferedReader br = null;
        String line = "";
        String delimiter = ",";

        try{
            br = new BufferedReader(new FileReader(csvFile));
            while((line=br.readLine()) != null){
                String[] csvColumn = line.split(delimiter);
                //Ambil column keberapa untuk X dan Y, atau kolom apapun yang dibutuhkan
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(br != null){
                try{
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
