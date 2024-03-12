package harshkumar.fakestoresstproject.Controllers;

import harshkumar.fakestoresstproject.models.Cart;
import harshkumar.fakestoresstproject.models.Category;
import harshkumar.fakestoresstproject.models.Product;
import harshkumar.fakestoresstproject.services.FakeStoreProductService;
import harshkumar.fakestoresstproject.services.ProductService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){

        this.productService=productService;
    }
    @GetMapping("/hello")
        public String sayHello(){
            return "helloWorld";
    }

    @GetMapping("/products")
    public Product[] getAllProducts() {
        return productService.getAllProducts();
    }


    @PostMapping ("/products")
    public Product createProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/carts")
    public Cart[] getAllCarts(){
        return productService.getAllCarts();
    }
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }
    @GetMapping("/carts/{id}")
    public Cart getSingleCart(@PathVariable("id")Long id){
        return productService.getSingleCart(id);
    }

}
