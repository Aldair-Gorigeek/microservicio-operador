package com.tienda.operador.controller;

import com.tienda.operador.client.BuscadorClient;
import com.tienda.operador.dto.ItemDTO;
import com.tienda.operador.model.Operacion;
import com.tienda.operador.repository.OperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/operaciones")
public class OperacionController {

    @Autowired
    private OperacionRepository repository;

    @Autowired
    private BuscadorClient buscadorClient;

    @GetMapping
    public List<Operacion> getAllOperaciones() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Operacion getOperacionById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Operación no encontrada con ID: " + id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Operacion> getOperacionesByUsuario(@PathVariable Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public Operacion createOperacion(@RequestBody Operacion operacion) {
        ItemDTO item = buscadorClient.getItemById(operacion.getItemId());
        if (item == null) {
            throw new RuntimeException("El ítem no existe en el buscador");
        }
        operacion.setFecha(LocalDateTime.now());
        return repository.save(operacion);
    }
    
    @PostMapping("/lote")
    public List<Operacion> createOperaciones(@RequestBody List<Operacion> operaciones) {
        for (Operacion operacion : operaciones) {
            ItemDTO item = buscadorClient.getItemById(operacion.getItemId());
            if (item == null) {
                throw new RuntimeException("El ítem con ID " + operacion.getItemId() + " no existe en el buscador");
            }
            operacion.setFecha(LocalDateTime.now()); // ✅ Ahora esto ya no marcará error
        }
        return repository.saveAll(operaciones);
    }


}
