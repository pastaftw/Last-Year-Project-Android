package Processes.Calculate;

//Common Modules
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculate_Control {
    // [/]
    public static BigDecimal Divide (BigDecimal val_1, BigDecimal val_2) {
        BigDecimal result = val_1.divide(val_2, 2, RoundingMode.DOWN);
        //Calculate_Control.Calculate_Lost(val_1, result, val_2);
        return result;
    }
    public static BigDecimal Divide (BigDecimal val_1, Integer val_2) {
        BigDecimal result = val_1.divide(BigDecimal.valueOf(val_2), 2, RoundingMode.DOWN);
        //Calculate_Control.Calculate_Lost(val_1, result, val_2);
        return result;
    }

    // [*]
    public static BigDecimal Multiply(BigDecimal val_1, BigDecimal val_2) {return val_1.multiply(val_2);}
    public static BigDecimal Multiply(BigDecimal val_1, Integer val_2) {return val_1.multiply(BigDecimal.valueOf(val_2));}

    // [+]
    public static BigDecimal Add(BigDecimal val_1, BigDecimal val_2) {return val_1.add(val_2);}
    public static BigDecimal Add(BigDecimal val_1, Integer val_2) {return val_1.add(BigDecimal.valueOf(val_2));}

    // [-]
    public static BigDecimal Substract(BigDecimal val_1, BigDecimal val_2) {return val_1.subtract(val_2);}
    public static BigDecimal Substract(BigDecimal val_1, Integer val_2) {return val_1.subtract(BigDecimal.valueOf(val_2));}

    // [<->]
    public static BigDecimal Convert_To_Kg(BigDecimal val_1) {return Calculate_Control.Divide(val_1, 1000);}
    public static BigDecimal Convert_To_Kg(Integer val_1) {return Calculate_Control.Divide(BigDecimal.valueOf(val_1), 1000);}
}
