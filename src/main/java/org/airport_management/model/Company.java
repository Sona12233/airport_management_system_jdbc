package org.airport_management.model;

public class Company {

    private int companyId;

    private String companyName;

    private String foundingDate;

    public Company() {
    }



    public Company(String companyName, String foundingDate){
        this.companyName = companyName;
        this.foundingDate = foundingDate;
    }

    public Company(int companyId, String companyName, String foundingDate) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.foundingDate = foundingDate;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(String foundingDate) {
        this.foundingDate = foundingDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", foundingDate='" + foundingDate + '\'' +
                '}';
    }
}
