package com.sherpa.service.adoptions;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
class DogAdoptionController {


}

//DATA ORIENTED PROGRAMMING
//- records
//- sealed types
// - pattern matching
//- smart switch expressions

sealed interface  Loan permits SecuredLoan, UnSecuredLoan {}

final class SecuredLoan implements Loan{}
//OR
//tuples + name =record
record UnSecuredLoan() implements Loan {}

class  NonOpsLoan implements Loan{}




//look mon no more lombok !!

record  Dog (@Id int id, String name, String description, String owner){}
