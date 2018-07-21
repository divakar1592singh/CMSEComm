package cmsecomm.ecommerce.app.com.cmsecomm.Model;


public class NavDrawerItem {
    private boolean showNotify;
    private int navIconList;
    private String title;


    public NavDrawerItem() {

    }

    public NavDrawerItem(boolean showNotify, int navIconList, String title) {
        this.showNotify = showNotify;
        this.navIconList = navIconList;
        this.title = title;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public int getNavIconList() {
        return navIconList;
    }

    public void setNavIconList(int navIconList) {
        this.navIconList = navIconList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}