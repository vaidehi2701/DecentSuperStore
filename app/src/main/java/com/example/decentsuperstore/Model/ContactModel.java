package com.example.decentsuperstore.Model;

public class ContactModel {
    private String BranchName;

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public ContactModel(String branchName) {
        BranchName = branchName;
    }
}



