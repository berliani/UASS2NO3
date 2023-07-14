package network;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.ResponseModel;
    public class FirstConnect {
        private static final String API_URL = "https://dummyjson.com/products";
        private static final String X_CONS_ID = "1234567";
        private static final String USER_KEY = "faY738sH";

        public FirstConnect() {
        }

        public static void main(String[] args) {
            String jsonData = fetchData();
            if (jsonData != null) {
                List<ResponseModel> responseModels = parseJson(jsonData);
                selectionSort(responseModels);
                System.out.println("Data Yang Diurutkan Berdasarkan Rating :");
                Iterator var3 = responseModels.iterator();

                while(var3.hasNext()) {
                    ResponseModel responseModel = (ResponseModel)var3.next();
                    System.out.println(responseModel.getRating());
                }
            } else {
                System.out.println("Gagal mengambil data JSON.");
            }

        }

        private static String fetchData() {
            try {
                URL url = new URL("https://dummyjson.com/products");
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setRequestProperty("X-Cons-ID", "1234567");
                connection.setRequestProperty("user_key", "faY738sH");
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    Scanner scanner = new Scanner(connection.getInputStream());
                    StringBuilder response = new StringBuilder();

                    while(scanner.hasNextLine()) {
                        response.append(scanner.nextLine());
                    }

                    scanner.close();
                    return response.toString();
                }

                System.out.println("Gagal mengambil data. Kode respons: " + responseCode);
                connection.disconnect();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

            return null;
        }

        private static List<ResponseModel> parseJson(String jsonData) {
            List<ResponseModel> products = new ArrayList();
            ObjectMapper mapper = new ObjectMapper();

            try {
                JsonNode rootNode = mapper.readTree(jsonData);
                JsonNode productsNode = rootNode.get("products");
                if (productsNode.isArray()) {
                    Iterator var5 = productsNode.iterator();

                    while(var5.hasNext()) {
                        JsonNode node = (JsonNode)var5.next();
                        JsonNode ID = node.get("ID");
                        JsonNode tittle = node.get("Tittle");
                        JsonNode description = node.get("Description");
                        JsonNode price = node.get("Price");
                        JsonNode discountPercentage = node.get("Discount Percentage");
                        JsonNode Rating = node.get("Rating");
                        JsonNode stock = node.get("Stock");
                        JsonNode brand = node.get("Brand");
                        JsonNode kategory = node.get("Kategory");
                        products.add(new ResponseModel(ID, tittle, description, price, discountPercentage, Rating, stock, brand, kategory));
                    }
                }
            } catch (IOException var16) {
                var16.printStackTrace();
            }

            return products;
        }

        private static void selectionSort(List<ResponseModel> products) {
            int n = products.size();

            for(int i = 0; i < n - 1; ++i) {
                int minIndex = i;

                for(int j = i + 1; j < n; ++j) {
                    if (((ResponseModel)products.get(j)).getRating() < ((ResponseModel)products.get(minIndex)).getRating()) {
                        minIndex = j;
                    }
                }

                ResponseModel temp = (ResponseModel)products.get(minIndex);
                products.set(minIndex, (ResponseModel)products.get(i));
                products.set(i, temp);
            }

        }
    }


