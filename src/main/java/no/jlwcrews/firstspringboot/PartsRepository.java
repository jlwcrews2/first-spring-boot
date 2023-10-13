package no.jlwcrews.firstspringboot;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class PartsRepository {

    private final Logger log = LoggerFactory.getLogger(PartsRepository.class);

    @Getter
    private ArrayList<Part> parts = new ArrayList<>();

    public PartsRepository() {
        parts.add(new Part("gear"));
        parts.add(new Part("cog"));
    }


    public void addPart(Part part) {
        if (part.name().equals("fish")) throw new AddPartsException();
        parts.add(part);
    }

    public void deletePart(Part part) {
        try {
            parts.remove(part);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
