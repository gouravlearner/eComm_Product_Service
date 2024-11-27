package dev.gourav.ecomm.productservice.services;

import dev.gourav.ecomm.productservice.Exceptions.ProductNotFoundException;
import dev.gourav.ecomm.productservice.Model.Product;
import dev.gourav.ecomm.productservice.dto.FakeStoreProductRequestDto;
import dev.gourav.ecomm.productservice.dto.FakeStoreProductResponseDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.function.EntityResponse;

import java.io.IOException;
import java.util.Objects;

@Service ("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    public RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductDetails(Long id) throws ProductNotFoundException {
        ResponseEntity<FakeStoreProductResponseDto> responseDto=

               restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                       FakeStoreProductResponseDto.class);
    if(responseDto.getBody()==null){
        throw new ProductNotFoundException("Product not found");
    }

        return Objects.requireNonNull(responseDto.getBody()).toProduct();
    }
    @Override
    public Product createProduct(String title, String description, Double price,
                                 String image, String category){

        FakeStoreProductRequestDto fakeStoreProductRequestDto = new FakeStoreProductRequestDto();
        fakeStoreProductRequestDto.setTitle(title);
        fakeStoreProductRequestDto.setDescription(description);
        fakeStoreProductRequestDto.setPrice(price);
        fakeStoreProductRequestDto.setImage(image);
        fakeStoreProductRequestDto.setCategory(category);

                ResponseEntity<FakeStoreProductResponseDto>  responseEntity =
                                restTemplate.postForEntity("https://fakestoreapi.com/products",
                                        fakeStoreProductRequestDto,
                                        FakeStoreProductResponseDto.class);

        return Objects.requireNonNull(responseEntity.getBody()).toProduct();

    }
}
