package smr.shop.product.stock.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import smr.shop.product.stock.service.dto.request.CreateProductStockRequest;
import smr.shop.product.stock.service.dto.request.UpdateProductStockRequest;
import smr.shop.product.stock.service.dto.response.GetProductStockResponse;
import smr.shop.product.stock.service.service.ProductStockService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/1.0/product-stock")
public class ProductStockController {
    private final ProductStockService productStockService;

    public ProductStockController(ProductStockService productStockService) {
        this.productStockService = productStockService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductStockRequest create(@RequestBody CreateProductStockRequest request) {
        return productStockService.create(request);
    }

    @PostMapping("/crate-all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<CreateProductStockRequest> createAll(@RequestBody List<CreateProductStockRequest> productStockRequests) {
        return productStockService.createAll(productStockRequests);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetProductStockResponse getById(@PathVariable UUID id) {
        return productStockService.getById(id);
    }

    @GetMapping("/get-by-product-id/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public GetProductStockResponse getByProductId(@PathVariable Long productId) {
        return productStockService.getByProductId(productId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable UUID id) {
        productStockService.deleteById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateById(@PathVariable UUID id,
                           @RequestBody UpdateProductStockRequest request) {
        productStockService.updateById(id, request);
    }
}