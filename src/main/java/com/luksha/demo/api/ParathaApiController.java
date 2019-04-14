package com.luksha.demo.api;

import com.luksha.demo.data.ParathaRepo;
import com.luksha.demo.domain.Paratha;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/paratha", produces = "application/json")
@CrossOrigin(origins = "*")
public class ParathaApiController {

    private ParathaRepo parathaRepo;

    public ParathaApiController(ParathaRepo parathaRepo) {
        this.parathaRepo = parathaRepo;
    }

    @GetMapping(produces = "application/json")
    public Iterable<Paratha> allParathas() {
        return parathaRepo.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void postParatha(@RequestBody Paratha paratha) {
        parathaRepo.save(paratha);
    }

    @DeleteMapping("/{parathaId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteParatha(@PathVariable("parathaId") Long parathaId) {
        try {
            parathaRepo.deleteById(parathaId);
        } catch (EmptyResultDataAccessException e) {

        }
    }
}
