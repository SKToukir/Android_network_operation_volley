package com.best.hp_.udacitysunshine;

/**
 * Created by HP_$$) on 18-Dec-15.
 */
public class QuesBankClass {
    private int id;
    private String ques;
    private String clueA;
    private String clueB;
    private String clueC;
    private String clueD;
    private String ans;

    QuesBankClass(){

    }
//    QuesBankClass(int id,String ques, String clueA, String clueB, String clueC, String clueD,String ans){
//        this.id= id;
//        this.ques=ques;
//        this.clueA=clueA;
//        this.clueB=clueB;
//        this.clueC=clueC;
//        this.clueD=clueD;
//        this.ans=ans;
//    }
    QuesBankClass(String ques, String clueA, String clueB, String clueC, String clueD,String ans){
        this.ques=ques;
        this.clueA=clueA;
        this.clueB=clueB;
        this.clueC=clueC;
        this.clueD=clueD;
        this.ans=ans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getClueA() {
        return clueA;
    }

    public void setClueA(String clueA) {
        this.clueA = clueA;
    }

    public String getClueB() {
        return clueB;
    }

    public void setClueB(String clueB) {
        this.clueB = clueB;
    }

    public String getClueC() {
        return clueC;
    }

    public void setClueC(String clueC) {
        this.clueC = clueC;
    }

    public String getClueD() {
        return clueD;
    }

    public void setClueD(String clueD) {
        this.clueD = clueD;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
