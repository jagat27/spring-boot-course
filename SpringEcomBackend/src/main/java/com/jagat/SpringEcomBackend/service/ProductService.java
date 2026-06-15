package com.jagat.SpringEcomBackend.service;

import com.jagat.SpringEcomBackend.model.Product;
import com.jagat.SpringEcomBackend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired                      //without autowired we should create ProductRepo productRepo = new ProductRepo();
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

//    public Optional<Product> getProductById(int id) {
//        return productRepo.findById(id);
//    }
    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(new Product());
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {

        product.setImageName(image.getName());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        return productRepo.save(product);
    }

    public Product updateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getName());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        return productRepo.save(product);
    }

    public void deleteProduct(int id) {
         productRepo.deleteById(id);
    }


    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }
}
