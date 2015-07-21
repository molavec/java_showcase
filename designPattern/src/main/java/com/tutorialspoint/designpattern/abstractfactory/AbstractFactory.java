package com.tutorialspoint.designpattern.abstractfactory;

import com.tutorialspoint.designpattern.factory.Shape;

public abstract class AbstractFactory {
   abstract Color getColor(String color);
   abstract Shape getShape(String shape) ;
}