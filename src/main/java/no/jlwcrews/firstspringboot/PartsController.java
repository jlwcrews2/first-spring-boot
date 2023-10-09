package no.jlwcrews.firstspringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
@Slf4j
public class PartsController {

    @Autowired
    private PartsService partsService;

    @Value("${jason.happyWord}")
    private String happyWord;

    @GetMapping()
    public ResponseEntity<List<Part>> getParts() {
        System.out.println(happyWord);
        return ResponseEntity.ok(partsService.getParts());

    }

    @PostMapping()
    public void addPart(@RequestBody Part part) {
        partsService.addPart(part);
    }

    @DeleteMapping()
    public void deletePart(@PathVariable String name) {

    }
}
