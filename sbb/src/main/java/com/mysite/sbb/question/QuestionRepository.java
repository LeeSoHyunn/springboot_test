package com.mysite.sbb.question;

import java.util.List;

<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
>>>>>>> 5e0656f51b5d2eb08ca95919ed471ed34413c38a
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question findBySubject(String subject);

	Question findBySubjectAndContent(String subject, String content);

	List<Question> findBySubjectLike(String subject);
<<<<<<< HEAD
	
	Page<Question> findAll(Pageable pageable);
=======
>>>>>>> 5e0656f51b5d2eb08ca95919ed471ed34413c38a
}
