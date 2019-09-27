package com.example.decentsuperstore.Model;

public class GroceryModel {

        private String Name;
        private String Weight;
        private String Price;
        private int ProductImage;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getWeight() {
            return Weight;
        }

        public void setWeight(String weight) {
            Weight = weight;
        }

        public String getPrice() {
            return Price;
        }

        public void setPrice(String price) {
            Price = price;
        }

        public int getProductImage() {
            return ProductImage;
        }

        public void setProductImage(int productImage) {
            ProductImage = productImage;
        }

        public GroceryModel(String name,String weight,String price, int productImage){

            this.Name = name;
            this.Weight = weight;
            this.Price = price;
            this.ProductImage = productImage;
        }


    }

