package com.BackEnd.v1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class TestClass {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        cal.add(Calendar.DATE, -5);
        
        System.out.println(sdf.format(cal.getTime()));
	}
}
