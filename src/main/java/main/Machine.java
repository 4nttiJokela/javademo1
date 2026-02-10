package main;

public class Machine {
    private String type;
    private String model;
    private Worker operator;

    public Machine (String type, String model, Worker operator) {
        this.type = type;
        this.model = model;
        this.operator = operator;
    }

    public String getMachineDetails() {
        return "Koneen tiedot: " + type + ", " + model + "\n" + "Työntekijän tiedot: " + operator.getWorkerName() + ", " +operator.getWorkerRole();
    }
}
