package Processes.Other;

public class User {
    //Variables
    Integer _ID = 0;
    String _Name;
    String _Surname;
    String _Username;

    //Properties
    public Integer ID() {return _ID;}
    public void ID(Integer value) {_ID = value;}
    public String Name() {return _Name;}
    public void Name(String value) {_Name = value;}
    public String Surname() {return _Surname;}
    public void Surname(String value) {_Surname = value;}
    public String Username() {return _Username;}
    public void Username(String value) {_Username = value;}

    //Constructor
    public User(Integer id, String name, String surname, String username) {
        _ID = id;
        _Name = name;
        _Surname = surname;
        _Username = username;
    }
}