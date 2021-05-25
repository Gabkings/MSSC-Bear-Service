package com.gabkings.msscbearservice.web.controllers;


import com.gabkings.msscbearservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer/")
public class BeerController {

    @GetMapping("{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId) {
    // TODO implementation later
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createNewBeer(@RequestBody BeerDto beerDto){
        // TODO impl later
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateBeerDetails(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto){
        // TODO impl later
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    public ResponseEntity deleteBeerById(@PathVariable("beerId") UUID beerId){
        // TODO impl later
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
