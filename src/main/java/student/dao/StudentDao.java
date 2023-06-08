package student.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import antlr.collections.List;
import student.dto.Student;

public class StudentDao {
public void signStudent(Student student) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
}
public Student loginStudent(String email) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	Query query=entityManager.createQuery("select a from Student a where a.email=?1");
	query.setParameter(1, email);
	Student student=(Student) query.getSingleResult();
    return student;
}

public java.util.List<Student> getStudents(){
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	Query query=entityManager.createQuery("select a from Student a");
	java.util.List<Student> list=query.getResultList();
	return list;	
}
public Student updateStudent(int id, String name) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	Student student=entityManager.find(Student.class, id);
	EntityTransaction entityTransaction=entityManager.getTransaction();
    if(student!=null) {
    	entityTransaction.begin();
    	student.setName(name);
    	entityManager.merge(student);
    	entityTransaction.commit();
    	return student;
    }
	return null;
	
}
public Student getStudentById(int id) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	Student student=entityManager.find(Student.class, id);
	if(student!=null) {
		return student;
	}
	return null;
}
public Student deleteStudentById(int id) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	Student student=entityManager.find(Student.class, id);
	if(student!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		return student;
	}
	return null;
}
}
