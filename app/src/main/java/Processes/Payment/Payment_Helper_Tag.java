package Processes.Payment;
import androidx.annotation.Nullable;

import java.math.BigDecimal;

public class Payment_Helper_Tag {
    Integer _Owner_ID;
    public Integer Get_Owner_ID() {return _Owner_ID;}
    public void Set_Owner_ID(Integer value) {_Owner_ID = value;}

    BigDecimal _Current_Debt;
    public BigDecimal Get_Current_Debt() {return _Current_Debt;}
    public void Set_Current_Debt(BigDecimal value) {_Current_Debt = value;}

    //Constructor
    public Payment_Helper_Tag(Integer _Owner_ID, BigDecimal _Current_Debt) {
        this._Owner_ID = _Owner_ID;
        this._Current_Debt = _Current_Debt;
    }
}
