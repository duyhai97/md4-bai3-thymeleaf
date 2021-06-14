package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{

    private static final Map<Integer, Product> productList ;
    
    static {
        productList = new HashMap<>();
        productList.put(1,new Product(1,"Quần",100,5));
        productList.put(2,new Product(2,"Áo",100,5));
        productList.put(3,new Product(3,"Giày",100,5));
        productList.put(4,new Product(4,"Dép",100,5));
        productList.put(5,new Product(5,"Balo",100,5));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void create(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id,product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }
}
