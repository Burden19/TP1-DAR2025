package res;

import java.io.Serializable;

public class Operation implements Serializable {

    private double operand1;
    private String operator;
    private double operand2;
    private double resultat;
    private String errorMessage;

    public Operation(double operand1, String operator, double operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
        this.errorMessage = null;
    }
    public String validate() {
        if (operator == null || operator.trim().isEmpty()) {
            return "L'opérateur ne peut pas être vide";
        }

        if (!operator.matches("[+\\-*/]")) {
            return "Opérateur non valide. Utilisez +, -, *, ou /";
        }

        if (Double.isNaN(operand1) || Double.isNaN(operand2)) {
            return "Les opérandes doivent être des nombres valides";
        }

        return null;
    }

    // Getters and Setters
    public double getOperand1() {
        return operand1;
    }
    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public double getOperand2() {
        return operand2;
    }
    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }
    public double getResultat() {
        return resultat;
    }
    public void setResultat(double resultat) {
        this.resultat = resultat;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
