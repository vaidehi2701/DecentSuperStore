package com.example.decentsuperstore.Model;

    public class HistoryModel {


        private String OrderDate;
        private String OrderStatus;
        private String OrderNumber;
        private String OrderPrice;

        public HistoryModel(String orderDate, String orderStatus, String orderNumber, String orderPrice) {
            OrderDate = orderDate;
            OrderStatus = orderStatus;
            OrderNumber = orderNumber;
            OrderPrice = orderPrice;
        }

        public String getOrderDate() {
            return OrderDate;
        }

        public void setOrderDate(String orderDate) {
            OrderDate = orderDate;
        }

        public String getOrderStatus() {
            return OrderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            OrderStatus = orderStatus;
        }

        public String getOrderNumber() {
            return OrderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            OrderNumber = orderNumber;
        }

        public String getOrderPrice() {
            return OrderPrice;
        }

        public void setOrderPrice(String orderPrice) {
            OrderPrice = orderPrice;
        }
    }



