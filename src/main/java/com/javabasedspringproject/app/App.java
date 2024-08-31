package com.javabasedspringproject.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        
        /*
         * Singleton Scope Beans
         * For every getBean() invocation it refers to same object
         * Objects created when we load container
         */
        HelloWorld helloWorld1 = applicationContext.getBean(HelloWorld.class);
        helloWorld1.show();
        System.out.println("hashCode: "+ helloWorld1.hashCode());
        
        HelloWorld helloWorld2 = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld2.show();
        System.out.println("hashCode: "+ helloWorld2.hashCode());
        
        /*
         * Prototype Scope Beans
         * For every getBean() invocation it create new objects
         * Objects got created with the explicit getBean() invocation.
         */
        System.out.println();
        JavaWorld javaWorld1 = applicationContext.getBean("javaWorld",JavaWorld.class);
        javaWorld1.show();
        System.out.println("hashCode: "+ javaWorld1.hashCode());
        
        JavaWorld javaWorld2 = applicationContext.getBean(JavaWorld.class);
        javaWorld2.show();
        System.out.println("hashCode: "+ javaWorld2.hashCode());
        
        /*
         * Setter Injection
         * Which mandatory require the setters methods for all the variables in the class
         */
        System.out.println();
        Student student = applicationContext.getBean("student",Student.class);
        System.out.println(student.getId());
        student.getJavaWorld().show();
        student.getHelloWorld().show();
        
        /*
         * Constructor Injection| Following Order
         * Which mandatory require the setters methods for all the variables, allargs constructor, noargs constructor in the class
         */
        System.out.println();
        Student student1 = applicationContext.getBean("student1",Student.class);
        System.out.println(student1.getId());
        student1.getJavaWorld().show();
        student1.getHelloWorld().show();
        
        /*
         * Using autowire| byName
         * @Qualifier
         */
        System.out.println();
        System.out.println("Using autowire| byType");
        Wheeler wheeler = (Wheeler) applicationContext.getBean("wheeler");
        System.out.println(wheeler.getId());
        wheeler.getVehicle().show();
        
        /*
         * Using autowire| byType
         * @Primary
         */
        System.out.println();
        System.out.println("Using autowire| byName");
        Stud stud = applicationContext.getBean(Stud.class);
        System.out.println(stud.getId());
        stud.getComputer().show();
        
        /*
         * Lazy-init
         */
        System.out.println();
        System.out.println("Lazy-init");
        System.out.println("Application context loaded");

        // by default all beans are created when ApplicationContext is created.
        Holiday holiday = applicationContext.getBean(Holiday.class);
        
        // it will not created by default when we call ApplicationContext is created
        // created when we actually use it
        Workday workday = applicationContext.getBean(Workday.class);
        
        /*
         * Using @Component
         */
        System.out.println();
        Test test = applicationContext.getBean(Test.class);
        
        /*
         * When use both @Primary and @Qualifier, then @Qualifier has the highest priority
         */
        
    }
}
