package harshkumar.fakestoresstproject.services;

import harshkumar.fakestoresstproject.dtos.FakeStoreCartDto;
import harshkumar.fakestoresstproject.dtos.FakeStoreProductDto;
import harshkumar.fakestoresstproject.models.Cart;
import harshkumar.fakestoresstproject.models.Category;
import harshkumar.fakestoresstproject.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class FakeStoreProductService implements ProductService{
//    rest template allows us to send API reqests to URL
    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public Product[] getAllProducts() {
        ResponseEntity<Product[]> response =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products",
                        Product[].class);
        Product[] allProducts = response.getBody();
        return allProducts;
    }
    @Override
   public Product getSingleProduct(Long id) {
        FakeStoreProductDto  fakeStoreProductDto = restTemplate.getForObject(
               "https://fakestoreapi.com/products/1"+id,
                FakeStoreProductDto.class
        );
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(new Category(fakeStoreProductDto.getCategory()));
        return product;
   }
   @Override
   public Cart getSingleCart(Long id){
       FakeStoreCartDto fakeStoreCartDto = restTemplate.getForObject(
               "https://fakestoreapi.com/carts/5"+id,
               FakeStoreCartDto.class
       );
       Cart cart =new Cart();
       cart.setId(fakeStoreCartDto.getId());
       cart.setUserId(fakeStoreCartDto.getUserId());
       cart.setDate(fakeStoreCartDto.getDate());
       cart.setProducts(fakeStoreCartDto.getProduct());
       return cart;
   }

    @Override
    public Product addProduct(Product product) {
        FakeStoreProductDto newProduct = new FakeStoreProductDto();
        newProduct.setId(product.getId());
        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setCategory(product.getCategory().getName());
        newProduct.setImage(product.getImageUrl());
        restTemplate.postForObject(
                "https://fakestoreapi.com/products/",
                newProduct,
                FakeStoreProductDto.class
        );
        return product;
    }


//    @Override
//    public Cart[] getallCarts() {
//        return new Cart[0];
//    }

    @Override
    public Cart[] getAllCarts() {
        ResponseEntity<Cart[]> response =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/carts",
                        Cart[].class);
        Cart[] allCarts = response.getBody();
        return allCarts;
    }
    @Override
    public Product updateProduct(Long id) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }

}
