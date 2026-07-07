package mx.edu.tecdesoftware.market_backend_2026_3A.web.controller;


import mx.edu.tecdesoftware.market_backend_2026_3A.domain.Product;
import mx.edu.tecdesoftware.market_backend_2026_3A.domain.repository.ProductRepository;
import mx.edu.tecdesoftware.market_backend_2026_3A.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);

        }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id")int productId){
        return productService.getProduct((productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("categoryId")int categoryId) {
        return productService.getByCategory((productId)
                        .map(ResponseEntity::ok))
                        .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id")int productoId){
        if (productService.delete(productoId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
