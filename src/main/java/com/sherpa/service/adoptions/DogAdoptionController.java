package com.sherpa.service.adoptions;

import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@ResponseBody
class DogAdoptionController {

    private DogRepository dogRepository;

    public DogAdoptionController(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @PostMapping("/dogs/{dogId}/adoptions")
    void adopt(@RequestParam int dogId,
               @RequestBody Map<String, String> owner) {
        this.dogRepository.findById(dogId).ifPresent(dog -> {
            var newDog = this.dogRepository.save(new Dog(dog.id(), dog.name(), dog.description(), owner.get("name")));
        });

    }


}

interface DogRepository extends CrudRepository<Dog, Integer> {

}

record Dog(@Id int id, String name, String description, String owner) {
}
//DATA ORIENTED PROGRAMMING
//- records
//- sealed types
// - pattern matching
//- smart switch expressions
//
//sealed interface  Loan permits SecuredLoan, UnSecuredLoan {}
//
//final class SecuredLoan implements Loan{}
////OR
////tuples + name =record
//record UnSecuredLoan() implements Loan {}

//class  NonOpsLoan implements Loan{}


//look mon no more lombok !!


