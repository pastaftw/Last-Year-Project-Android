package Processes.Other;

public class Types {
    public enum Item_Buy_Types {
        Countable, //Default
        Kilogram,
        Gram,
    };

    public enum Item_Buyer_Share_Types {
        Total, //Default
        //Amount,
        //Persantage,
    };

    public enum Item_Calculate_Types {
        None, //Default
        Ignore,
        Share,
    };

    //???///
    public enum Payment_Types {
        Payee,
        Debtor,
    };
}