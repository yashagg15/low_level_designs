package LibraryManagementSystem.AccountModel;

public class PersonAccount {

    private String personAccountId;
    private String firstName;
    private String emailAddress;
    private String userName;
    private String password;
    private LibraryCard libraryCard;

    public PersonAccount(String personAccountId, String firstName, String emailAddress, String userName, String password, LibraryCard libraryCard) {
        this.personAccountId = personAccountId;
        this.firstName = firstName;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.password = password;
        this.libraryCard = libraryCard;
    }

    public String getPersonAccountId() {
        return personAccountId;
    }

    public void setPersonAccountId(String personAccountId) {
        this.personAccountId = personAccountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }
}
