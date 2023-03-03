package com.project6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/{student}")
public class StudentController {
	
	@Autowired
	private WebClient.Builder webClient;
	
	@GetMapping("/{studentId}")
	public ResponseEntity<ResponseData> getStudentDetails(@PathVariable int studentId){
		
		ResponseData response=new ResponseData();
		
		Student s1=new Student();
		s1.setStudentId(1);
		s1.setStudentName("Avi");
		s1.setAddress("Bangalore");
		s1.setCollegeId(1);
		
		response.setStudent(s1);
		
		int collegeId=s1.getCollegeId();
		
//		RestTemplate restTemplate=new RestTemplate();
//		String endpoint="http://localhost:9012/college/{collegeId}";
//		
//		ResponseEntity<College> data= restTemplate.getForEntity(endpoint, College.class, collegeId);
//		if(data.getStatusCodeValue()==200) {
//			College c1=data.getBody();
//			response.setCollege(c1);
//		}
		
		//WEBCLIENT
		
		College c1=webClient.build()
				.get()
				.uri("http://localhost:9012/college/"+collegeId)
				.retrieve()
				.bodyToMono(College.class)
				.block();
		
		response.setCollege(c1);
		
		return new ResponseEntity<ResponseData>(response, HttpStatus.OK);
		
	}

}
