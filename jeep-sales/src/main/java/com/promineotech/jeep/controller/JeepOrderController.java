   /**
 * 
 */
package com.promineotech.jeep.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author north
 *
 */
@Validated
@RequestMapping("/orders")
@OpenAPIDefinition(info = @Info(title = "Jeep Order Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Yo Local Server")})

public interface JeepOrderController {
  
  @Operation(
      summary ="Creating Order of Jeep",
      description = "Returning created jeep",
      responses = {
          @ApiResponse(responseCode = "201", description = "Created jeep is returned", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class))),
          @ApiResponse(responseCode = "400", description = "Invalid", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "Jeep component was not found", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "error", content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "orderRequest", required = true, description = "Order as JSON"),

      }
      )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Order createOrder(@Valid @RequestBody OrderRequest request);
  
}
