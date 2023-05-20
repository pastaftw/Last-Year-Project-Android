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

    @Nullable Integer _To_ID;
    public Integer Get_To_ID() {return _To_ID;}
    public void Set_To_ID(@Nullable Integer value) {_To_ID = value;}

    //Constructor
    public Payment_Helper_Tag(Integer _Owner_ID, BigDecimal _Current_Debt, @Nullable Integer _To_ID) {
        this._Owner_ID = _Owner_ID;
        this._Current_Debt = _Current_Debt;
        this._To_ID = _To_ID;
    }
}
