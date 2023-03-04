package Processes.Other;

public class Types {
    public enum Object_Buy_Types {
        Countable, //Default
        Kilogram,
        Gram,
    };

    public enum Item_Buyer_Types {
        Countable, //Default
        Persantage,
    };

    public enum Purpose_List_Types {
        None, //Default
        Ignore,
        Share,
    };

    public enum Payment_Types {
        Payee,
        Debtor,
    };
}