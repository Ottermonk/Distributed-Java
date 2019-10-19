package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.User;
import springxml.beans.Order;

public class SpringApp {
    public static void main(String[] args) {
        // load the Spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from Spring container
        User theUser = context.getBean("myUser", User.class);
        Order theOrder = context.getBean("myOrder", Order.class);

        // call methods on the bean
        System.out.println(theOrder.getUser());

        // call getters for literal values
        System.out.println(theUser.getName());
        System.out.println(theUser.getEmailAddress());
        System.out.println(theUser.getPhone());

        // close the context
        context.close();
    }
}
