package com.tutorialspoint.designpattern.prototype;

public class Circle extends Shape {

	   public Circle(){
	     type = "circle";
	   }

	   @Override
	   public void draw() {
	      System.out.println("Inside Circle::draw() method.");
	   }
	   
	}