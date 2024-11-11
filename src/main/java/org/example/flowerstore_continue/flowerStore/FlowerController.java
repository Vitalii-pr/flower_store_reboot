package org.example.flowerstore_continue.flowerStore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flower")
public class FlowerController {

    @Autowired
    private final FlowerService flowerService;

    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping
    public List<Flower> getFlowers(){
        return flowerService.getAllFlowers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flower> getFlowerById(@PathVariable Long id) {
        return flowerService.getFlowerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Flower> createFlower(@RequestBody Flower flower) {
        Flower savedFlower = flowerService.saveFlower(flower);
        return new ResponseEntity<>(savedFlower, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlower(@PathVariable Long id) {
        flowerService.deleteFlower(id);
        return ResponseEntity.noContent().build();
    }
}
