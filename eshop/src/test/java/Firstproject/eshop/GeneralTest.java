package Firstproject.eshop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTest 
{
public static void main(String arg[])
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("Firstproject.eshop");
	context.refresh();
}
}
