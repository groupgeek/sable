package com.xiaohe.bean;

public class MedicalrecordsWithBLOBs extends Medicalrecords {
    private String nowmedicalrecords;

    private String beforemedicalrecords;

    private String personalrecords;

    private String familyrecords;

    public String getNowmedicalrecords() {
        return nowmedicalrecords;
    }

    public void setNowmedicalrecords(String nowmedicalrecords) {
        this.nowmedicalrecords = nowmedicalrecords == null ? null : nowmedicalrecords.trim();
    }

    public String getBeforemedicalrecords() {
        return beforemedicalrecords;
    }

    public void setBeforemedicalrecords(String beforemedicalrecords) {
        this.beforemedicalrecords = beforemedicalrecords == null ? null : beforemedicalrecords.trim();
    }

    public String getPersonalrecords() {
        return personalrecords;
    }

    public void setPersonalrecords(String personalrecords) {
        this.personalrecords = personalrecords == null ? null : personalrecords.trim();
    }

    public String getFamilyrecords() {
        return familyrecords;
    }

    public void setFamilyrecords(String familyrecords) {
        this.familyrecords = familyrecords == null ? null : familyrecords.trim();
    }
}