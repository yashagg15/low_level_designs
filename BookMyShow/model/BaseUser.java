package BookMyShow.model;

import BookMyShow.service.SearchService;

public class BaseUser {
    private Integer userId;
    private String firstName;
    private String lastName;
    private AccountDetails accountDetails;
    public SearchService searchService;

    public BaseUser(Integer userId, String firstName, String lastName, AccountDetails accountDetails,
                    SearchService searchService) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountDetails = accountDetails;
        this.searchService = searchService;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }
    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
