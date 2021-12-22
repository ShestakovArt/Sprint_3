package ru.praktikum;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class Order {
    public final String firstName;
    public final String lastName;
    public final String address;
    public final String metroStation;
    public final String phone;
    public final int rentTime;
    public final String deliveryDate;
    public final String comment;
    public List<String> color;

    public Order(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, List<String> color){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    public static Order getRandom(List<String> getColor){
        Random random = new Random();
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        final String lastName = RandomStringUtils.randomAlphabetic(10);
        final String address = RandomStringUtils.randomAlphabetic(10);
        final String metroStation = RandomStringUtils.randomAlphabetic(10);
        final String phone = "+7 " + randomNum(1000) + randomNum(1000) + randomNum(100) + randomNum(100);
        final int rentTime = random.nextInt(30) + 1;
        final String deliveryDate = randomDate();
        final String comment = RandomStringUtils.randomAlphabetic(10);
        final List<String> color = getColor;
        return new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }

    private static String randomNum(int num) {
        Random random = new Random();
        int a = random.nextInt(num);
        if (a < 100){
            if (a < 10){
                if(num == 100){
                    return "0" + a;
                }
                else{
                    return "00" + a;
                }
            }
            else{
                if(num == 100){
                    return String.valueOf(a);
                }
                else{
                    return "0" + a;
                }
            }
        }
        else{
            return String.valueOf(a);
        }
    }

    private static String randomDate(){
        Random random = new Random();
        int a = random.nextInt(7) + 1;
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_YEAR, a);
        Date date = cal.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return format1.format(date);
    }
}
