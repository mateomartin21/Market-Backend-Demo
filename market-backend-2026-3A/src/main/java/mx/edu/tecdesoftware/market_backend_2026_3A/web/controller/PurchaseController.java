package mx.edu.tecdesoftware.market_backend_2026_3A.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edu.tecdesoftware.market_backend_2026_3A.domain.Purchase;
import mx.edu.tecdesoftware.market_backend_2026_3A.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@Tag(name = "Purchase", description = "Manage purchases in the store")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    @Operation(summary = "Get all purchases", description ="Return a list of all registered purchases")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of purchases")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    @Operation(summary = "Get purchases by client ID", description ="Return a list of purchases made by a specific client")
    @ApiResponse(responseCode = "200", description = "Purchases found for the client")
    @ApiResponse(responseCode = "404", description = "No purchases found for this client")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Purchase>> getByClient(
            @Parameter(description = "ID of the client to retrieve purchases for", example ="1", required = true)
            @PathVariable("id") String clientId) {
        return purchaseService.getByClient(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new purchase", description ="Register a new purchase along with its items and return the created record",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, content = @Content(examples = @ExampleObject(name= "Example purchase", value = """
            {
                "clientId" : 4546221,
                "date" : "2026-07-16T10:30:00",
                "paymentMethod" : "C",
                "comment" : "Dejar el paquete en la recepción",
                "status" : "P",
                "items": [
                    {
                        "productId": 4,
                        "quantity": 2,
                        "total": 41.00,
                        "status": true
                    }
                ]
            }"""))))
    @ApiResponse(responseCode = "201", description = "Purchase created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid purchase data")
    @ApiResponse(responseCode= "409", description = "Purchase conflict")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}