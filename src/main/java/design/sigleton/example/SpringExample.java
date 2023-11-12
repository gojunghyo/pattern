package design.sigleton.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringExample {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        String myBean = (String) applicationContext.getBean("myBean");
        String myBean1 = (String) applicationContext.getBean("myBean");

        System.out.println(myBean == myBean1);
    }
}
