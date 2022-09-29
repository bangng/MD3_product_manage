package rikkei.academy.productservlet.service;

import rikkei.academy.productservlet.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService{
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"product1",5,"fake","China"));
        productList.add(new Product(2,"product2",6,"super fake","China1"));
        productList.add(new Product(3,"product3",7,"fake super","China2"));
        productList.add(new Product(4,"product4",8,"fake fake","China3"));
        productList.add(new Product(5,"product5",9,"fa ke","China4"));

    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);

    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){

                return productList.get(i);

            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                productList.remove(i);
                break;
            }
        }

    }

    @Override
    public Product searchByName(String name) {
        for (Product pro: productList) {
            if (pro.getProName().equalsIgnoreCase(name)){
                return pro;
            }
        }
        return null;
    }
}
