package model;

import com.fasterxml.jackson.databind.JsonNode;

    public class ResponseModel {
        private int ID;
        private String Tittle;
        private String Description;
        private int Price;
        private int DiscountPercentage;
        private int rating;
        private int stock;
        private String brand;
        private String Category;

        public ResponseModel(JsonNode ID, JsonNode tittle, JsonNode description, JsonNode price, JsonNode discountPercentage, JsonNode rating, JsonNode stock, JsonNode brand, JsonNode category) {
        }

        public int getID() {
            return this.ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getTittle() {
            return this.Tittle;
        }

        public void setTittle(String tittle) {
            this.Tittle = tittle;
        }

        public String getDescription() {
            return this.Description;
        }

        public void setDescription(String description) {
            this.Description = description;
        }

        public int getPrice() {
            return this.Price;
        }

        public void setPrice(int price) {
            this.Price = price;
        }

        public int getDiscountPercentage() {
            return this.DiscountPercentage;
        }

        public void setDiscountPercentage(int discountPercentage) {
            this.DiscountPercentage = discountPercentage;
        }

        public int getRating() {
            return this.rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public int getStock() {
            return this.stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public String getBrand() {
            return this.brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getCategory() {
            return this.Category;
        }

        public void setCategory(String category) {
            this.Category = category;
        }
    }


