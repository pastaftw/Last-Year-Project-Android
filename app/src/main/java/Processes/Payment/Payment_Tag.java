package Processes.Payment;

//Common Modules
import androidx.annotation.Nullable;

import java.math.BigDecimal;
import Processes.Other.Types.Payment_Types;

public class Payment_Tag {
    @Nullable Integer _To_ID;
    BigDecimal _Payment_Amount;
    Payment_Types _Payment_Type;
    String _Payment_For;

    //Properties
    public Integer Get_To_ID() {return _To_ID;}
    public void Set_To_ID(@Nullable Integer value) {_To_ID = value;}
    public BigDecimal Get_Payment_Amount() {return _Payment_Amount;}
    public void Set_Payment_Amount(BigDecimal value) {_Payment_Amount = value;}
    public Payment_Types Get_Payment_Type() {return _Payment_Type;}
    public void Set_Payment_Type(Payment_Types value) {_Payment_Type = value;}
    public String Get_Payment_For() {return _Payment_For;}
    public void Set_Payment_For(String value) {_Payment_For = value;}
}
