package main;

import java.util.ArrayList;

class Safe {
    private String pinCode;
    private ArrayList<String> safeFolder;

    public Safe (String pinCode) {
        this.pinCode = pinCode;
        this.safeFolder = new ArrayList<>();
    }

    public void changePin (String code) {
        this.pinCode = code;
    }

    public void addToFolder (String item) {
        safeFolder.add(item);
    }
    public ArrayList<String> listFolder(String pin) {
        if (pinCode.equals(pin)) {
            return safeFolder;
        }
        return null;
    }
}