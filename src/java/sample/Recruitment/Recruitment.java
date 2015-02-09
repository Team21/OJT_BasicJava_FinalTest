/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.Recruitment;

/**
 *
 * @author thienlh
 */
public class Recruitment {
    private String recruitmentCode;
    private String position;
    private String recruitmentPackage;
    private int participant;

    public Recruitment() {
    }

    public Recruitment(String recruitmentCode, String position, String recruitmentPackage, int participant) {
        this.recruitmentCode = recruitmentCode;
        this.position = position;
        this.recruitmentPackage = recruitmentPackage;
        this.participant = participant;
    }

    public String getRecruitmentCode() {
        return recruitmentCode;
    }

    public void setRecruitmentCode(String recruitmentCode) {
        this.recruitmentCode = recruitmentCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRecruitmentPackage() {
        return recruitmentPackage;
    }

    public void setRecruitmentPackage(String recruitmentPackage) {
        this.recruitmentPackage = recruitmentPackage;
    }

    public int getParticipant() {
        return participant;
    }

    public void setParticipant(int participant) {
        this.participant = participant;
    }

    @Override
    public String toString() {
        return recruitmentCode + ", " + position + ", " + recruitmentPackage + ", " + participant;
    }
}
