package org.example;


public class Calculator {
    private double operand1;
    private double operand2;
    private  String sign;

//    public char getSign() {
//        return sign;
//    }

    public void setSign(String sign) {
        this.sign = sign;
    }


    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public double Calculate(double operand1, double operand2, String sign){
        try{
            if (sign == "-"){
                return operand2 - operand1;
            }else if (sign == "+"){
                return operand1 + operand2;
            } else if(sign == "*"){
                return operand1 * operand2;
            } else if(sign == "/"){
                return  operand2 / operand1;
            }
        } catch (ArithmeticException e){
            System.out.println("Can't divide by zero");
        } catch (Exception e){
            System.out.println("Something went wrong");
        }

        return 0;
    }


}
