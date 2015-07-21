package com.tutorialspoint.designpattern.abstractfactory;

public class FactoryProducer {
   public static AbstractFactory getFactory(String choice){
      if(choice.equalsIgnoreCase("SHAPE")){
         return (AbstractFactory) new ShapeFactory();
      } else if(choice.equalsIgnoreCase("COLOR")){
         return (AbstractFactory) new ColorFactory();
      }
      return null;
   }
}