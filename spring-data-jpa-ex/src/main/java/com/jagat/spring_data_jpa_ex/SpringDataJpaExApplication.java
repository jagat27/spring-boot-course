package com.jagat.spring_data_jpa_ex;

import com.jagat.spring_data_jpa_ex.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaExApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringDataJpaExApplication.class, args);
		StudentRepo repo = context.getBean(StudentRepo.class);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setRollNo(101);
		s1.setName("pavan");
		s1.setMarks(78);

		s2.setRollNo(102);
		s2.setName("jagat");
		s2.setMarks(52);

		s3.setRollNo(103);
		s3.setName("likith");
		s3.setMarks(90);

//		repo.save(s2);
//		repo.save(s3);

		System.out.println(repo.findByName("jagat"));

	}

}
