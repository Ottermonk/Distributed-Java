package springxml.beans;

import springxml.beans.Order;
//
public class User {

        // Add new fields for email address and team name
        private String name;
        private String emailAddress;
        private String phone;

        public User() {
            // diagnostic message
            System.out.println("User: inside no-arg constructor");
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            // diagnostic message
            System.out.println("User: inside setter setName");
            this.name = name;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            // diagnostic message
            System.out.println("User: inside setter setEmailAddress");
            this.emailAddress = emailAddress;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            // diagnostic message
            System.out.println("User: inside setter setPhone");
            this.phone = phone;
        }

}
