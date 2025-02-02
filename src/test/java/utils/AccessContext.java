package utils;

import java.util.List;

public class AccessContext {
    private static AccessContext instance;
    public String userName;
    public String password;
    public List<String> categories;
    private String articleName;
    private String articlePrice;
    public String articleDescription;

    private AccessContext() {}

    public static synchronized AccessContext getInstance() {
        if (instance == null) {
            instance = new AccessContext();
        }
        return instance;
    }

    public void setUsername (String username) {
        this.userName = username;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setCategories (List<String> categories) {
        this.categories = categories;
    }

    public List<String> getCategories() {
        return this.categories;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleName() {
        return this.articleName;
    }

    public void setArticlePrice(String articlePrice) {
        this.articlePrice = articlePrice;
    }

    public String getArticlePrice() {
        return this.articlePrice;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public String getArticleDescription() {
        return this.articleDescription;
    }
}