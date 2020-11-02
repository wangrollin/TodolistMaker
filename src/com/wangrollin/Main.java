package com.wangrollin;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        generateTodolistOfYear(2021);
    }

    private static void generateTodolistOfYear(int year) {
        String filePath = "out/" + year + ".md";
        try (OutputStream output = new FileOutputStream(filePath)) {
            System.out.println("# " + year + " todolist");
            output.write(("# " + year + " todolist\n\n").getBytes());
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, 0, 1);
            while (calendar.get(Calendar.YEAR) == year) {
                SimpleDateFormat format = new SimpleDateFormat("### yyyy.MM.dd 周u");
                String curDate = format.format(calendar.getTime());
                System.out.println(curDate);
                output.write((curDate+"\n\n").getBytes());
                calendar.add(Calendar.DATE, 1);
            }
        } catch (Exception e) {
            System.out.println("exit -1");
            return;
        }


    }
}
