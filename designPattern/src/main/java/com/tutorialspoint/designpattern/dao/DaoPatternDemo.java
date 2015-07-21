package com.tutorialspoint.designpattern.dao;

public class DaoPatternDemo {
   public static void main(String[] args) {
      StudentDao studentDao = new StudentDaoImpl();

      
      //print all students
      System.out.println("List all --->");
      for (Student s : studentDao.getAllStudents()) {
         System.out.println("Student: [RollNo : " + s.getRollNo() + ", Name : " + s.getName() + " ]");
      }
      
    
      
      //update student
      System.out.println("UPDATE --->");
      Student student =studentDao.getAllStudents().get(0);
      System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
      student.setName("Michael");
      System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
      studentDao.updateStudent(student);
     
      //get the student
      System.out.println("GET --->");
      student = studentDao.getStudent(0);
      System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");		
      
      //delete the student
      System.out.println("DETELE --->");
      studentDao.deleteStudent(student);
      
      //print all students
      System.out.println("LIST ALL --->");      
      for (Student s : studentDao.getAllStudents()) {
         System.out.println("Student: [RollNo : " + s.getRollNo() + ", Name : " + s.getName() + " ]");
      }
      

   }
}