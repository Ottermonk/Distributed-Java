package springxml.beans;

public class Order {
    private User user;

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        System.out.println("Order: inside setter setUser");
        this.user = user;
    }
}
