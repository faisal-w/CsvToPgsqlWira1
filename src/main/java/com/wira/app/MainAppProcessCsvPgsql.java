package com.wira.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Lenovo on 06/04/2016.
 */
public class MainAppProcessCsvPgsql {

    public static void main(String[] args) {
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
