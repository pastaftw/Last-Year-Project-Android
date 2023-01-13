package App_Basis.Payment;

//Common Modules
import java.math.BigDecimal;

//Custom Modules
import App_Basis.Types.Payment_Types;

public class Payment_Tag {
    Integer _To_ID;
    BigDecimal _Payment_Amount;
    Payment_Types _Payment_Type;
    String _Payment_For;

    //Properties
    public Integer To_ID() {return _To_ID;}
    public void To_ID(Integer value) {_To_ID = value;}
    public BigDecimal Payment_Amount() {return _Payment_Amount;}
    public void Payment_Amount(BigDecimal value) {_Payment_Amount = value;}
    public Payment_Types Payment_Type() {return _Payment_Type;}
    public void Payment_Type(Payment_Types value) {_Payment_Type = value;}
    public String Payment_For() {return _Payment_For;}
    public void Payment_For(String value) {_Payment_For = value;}
}
