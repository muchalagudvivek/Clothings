package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Payload.ApiResponse;
import Payload.ProductDto;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductControllers {

    @Autowired
    private ProductService productService;
    
    @PostMapping(value = "/add" )
    public ResponseEntity<ProductDto> CreateProduct(@RequestParam MultiValueMap<String, String> formData, @RequestParam("img") MultipartFile file) throws IOException {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(formData.getFirst("productname"));
        productDto.setDescription(formData.getFirst("description"));
        productDto.setWeight(Float.valueOf(formData.getFirst("weight")));
        productDto.setPrice(Float.valueOf(formData.getFirst("price")));
        productDto.setImg(file.getBytes());

        ProductDto save = this.productService.CreateProduct(productDto);

        return new ResponseEntity<ProductDto>(save,HttpStatusCode.valueOf(200));
    }

    
    @GetMapping("/{productid}")
    public ResponseEntity<ProductDto> GetById(@PathVariable Integer productid){
        ProductDto product = this.productService.ReadProduct(productid);

        return new ResponseEntity<>(product,HttpStatusCode.valueOf(200));
    }


    
    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAll(){
        List<ProductDto> products = this.productService.ReadAllProduct();

        return new ResponseEntity<>(products,HttpStatusCode.valueOf(200));
    }


    
    @DeleteMapping(value = "/del/{ProductId}",produces = "application/json")
    public ResponseEntity<ApiResponse> Delete(@PathVariable Integer ProductId){
        this.productService.DeleteProduct(ProductId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Product deleted"),HttpStatusCode.valueOf(200));
    }



    
    @PutMapping("/{ProductId}")
    public ResponseEntity<ProductDto> UpdateProduct(@RequestParam MultiValueMap<String, String> formData, @RequestParam("img") MultipartFile file,@PathVariable Integer ProductId) throws IOException {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(formData.getFirst("productname"));
        productDto.setDescription(formData.getFirst("description"));
        productDto.setWeight(Float.valueOf(formData.getFirst("weight")));
        productDto.setPrice(Float.valueOf(formData.getFirst("price")));
        productDto.setImg(file.getBytes());

        ProductDto save = this.productService.UpdateProduct(productDto,ProductId);

        return new ResponseEntity<ProductDto>(save,HttpStatusCode.valueOf(200));
    }



}
