package Common;
import java.math.BigDecimal;
import Processes.Item.Item_Buyer;
import Processes.Item.Item_Model;
import Processes.Other.Types;
import Processes.Other.User;

public class TEST {
    public static Integer user_id_index_start = 0;

    public static User[] Users = {
            new User(user_id_index_start++, "Arda", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
            new User(user_id_index_start++, "Mustafa", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
            new User(user_id_index_start++, "Abdullah", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
            new User(user_id_index_start++, "Ayla", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
    };

    public static Item_Model[] Items = {                                                                                                                                                     //TEST PARAMS
            new Item_Model(
                    new Item_Buyer[]{
                            new Item_Buyer(Users[0], new BigDecimal(5)),
                            new Item_Buyer(Users[2], new BigDecimal(35)),
                    },
                    Types.Item_Buyer_Share_Types.Total,
                    "Patates Cipsi",
                    Types.Item_Buy_Types.Countable,
                    BigDecimal.valueOf(1),
                    BigDecimal.valueOf(40),
                    BigDecimal.valueOf(0),
                    "DATE_PLACE_HOLDER"
            ),
    };
}
