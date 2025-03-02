package com.tienda.operador.client;

import com.tienda.operador.dto.ItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-buscador")
public interface BuscadorClient {

    @GetMapping("/items/{id}")
    ItemDTO getItemById(@PathVariable Long id);
}
