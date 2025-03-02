package com.tienda.operador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.tienda.operador.client") // Asegura que Feign escanee el paquete correcto
public class MicroservicioOperadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioOperadorApplication.class, args);
    }
}
