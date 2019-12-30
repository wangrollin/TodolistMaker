package com.wangrollin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        generateTodolistOfYear(2020);
    }

    private static void generateTodolistOfYear(int year) {
        String filePath = "out/" + year + ".md";
        try (OutputStream output = new FileOutputStream(filePath)) {
            System.out.println("# " + year + " todolist");
            output.write(("# " + year + " todolist\n").getBytes());
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, 0, 1);
            while (calendar.get(Calendar.YEAR) == year) {
                SimpleDateFormat format = new SimpleDateFormat("### yyyy.MM.dd 周u");
                String curDate = format.format(calendar.getTime());
                System.out.println(curDate);
                output.write((curDate+"\n").getBytes());
                calendar.add(Calendar.DATE, 1);
            }
        } catch (Exception e) {
            System.out.println("exit -1");
            return;
        }


    }
}
