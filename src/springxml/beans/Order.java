package springxml.beans;

public class Order {
    private User user;

    public String getUser() {
        return user.getUser();
    }


    public void setUser(User user) {
        System.out.println("User: inside setter setUser");
        this.user = user;
    }
}
