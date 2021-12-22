package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.apache.http.HttpStatus.*;


public class ListOfOrdersTest {
    public OrderResponse orderResponse;

    @Before
    public void setup(){
        orderResponse = new OrderResponse();
    }

    @Test
    @DisplayName("Checking the order list")
    @Description("Проверка списка заказов")
    public void CheckingOrderList(){
        ValidatableResponse listOrder = orderResponse.GetListOrders();
        listOrder.statusCode(SC_OK);
        Assert.assertNotNull("Список заказов пуст", listOrder);
        // проверка списка заказов по ключу total, всего заказов
        LinkedHashMap pageInfo = listOrder.extract().path("pageInfo");
        Assert.assertTrue("Список заказов пуст", (int) pageInfo.get("total") > 0);
        // проверка списка заказов по orders, количество заказов в теле ответа запроса
        ArrayList ordersFromPage = listOrder.extract().path("orders");
        Assert.assertTrue("Список заказов пуст", ordersFromPage.size() > 0);
    }
}
