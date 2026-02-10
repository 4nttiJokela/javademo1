package main;

public class Worker {
    private String name;
    private String role;

    public Worker (String name, String role) {
    this.name = name;
    this.role = role;
    }

    public String getWorkerName() {
        return name;
    }

    public String getWorkerRole() {
        return role;
    }
}
