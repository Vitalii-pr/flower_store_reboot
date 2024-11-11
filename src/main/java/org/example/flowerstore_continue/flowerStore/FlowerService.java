package org.example.flowerstore_continue.flowerStore;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService {

    public List<Flower> getAllFlowers(){
        return List.of(new Flower(), new Flower());
    }
}
