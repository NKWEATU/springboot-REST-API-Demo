package net.javaguides.springboot_rest_api.controller;

import net.javaguides.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")//this is the base URL
public class StudentController {

    // http://localhost:8080/student
        @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                123,
                "Kennedy",
                "Nkweatu"
        );
       // return new ResponseEntity<>(student, HttpStatus.OK);
        //return ResponseEntity.ok(student);
            return ResponseEntity.ok()
                    .header("custom-header", "Kennedy")
                    .body(student);
    }

    // http://localhost:8080/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
         List<Student>  students = new ArrayList<>();
        students.add(new Student (1,"John", "Peter"));
        students.add(new Student (2,"maxwell", "Paul"));
        students.add(new Student (3,"kennedy", "philip"));
        students.add(new Student (4,"Jacinta", "Adama"));
        students.add(new Student (5,"Esther", "Nkweatu"));
        return ResponseEntity.ok(students);
        }

        //Spring REST API with path variable
    //{id} - URI template variable
    // http://localhost:8080/students/1

    @GetMapping("{id}/{first-name}/{last-name}")//multiple variable request with different path variables
    public ResponseEntity<Student>studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name")String firstName,
                                       @PathVariable("last-name")String lastName
    
   //@PathVariable annotation is used to bind the value of url template
   //variable into method argument
    ){
           Student student = new Student(studentId, firstName, lastName);
           return ResponseEntity.ok(student);
    }
    //spring boot REST API with request param
    // http://localhost:8080/students/query?id=5&firstName=Esther&lastName=Nkweatu
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
            Student student = new Student(id, firstName, lastName);
            return ResponseEntity.ok(student);

            //@RequestParam annotation is used to extract the value of parameters in url
        }

        //spring boot REST API that handles HTTP POST Request creating new resource
    //@postMapping and @RequestBody
    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
            System.out.println(student.getId());
            System.out.println(student.getFirstName());
            System.out.println(student.getLastName());
            return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring boot REST API that handle HTTP put request - this is for updating existing resource
    
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
            System.out.println(student.getFirstName());
            System.out.println(student.getLastName());
            return ResponseEntity.ok(student);
    }

    //Spring boot REST API that handles HTTP Request - deleting the existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
            System.out.println(studentId);
            return ResponseEntity.ok("Student deleted successfully!");
    }
}
