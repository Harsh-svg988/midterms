package harshkumar.fakestoresstproject.services;

import harshkumar.fakestoresstproject.models.Cart;
import harshkumar.fakestoresstproject.models.Product;

public interface ProductService {
    Product []getAllProducts();
    Product getSingleProduct(Long id);
    Product addProduct(Product product);
    Cart[] getAllCarts();
//    Cart getSingleCart(Long id);
    Cart getSingleCart(Long id);
    Product updateProduct(Long id);
    Product deleteProduct(Long id);
}
