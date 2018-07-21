package cmsecomm.ecommerce.app.com.cmsecomm.VerticalTwoItemView;

/**
 * Created by Divakar on 5/31/2017.
 */

public class VerticalTwoItemListModel {

    public VerticalTwoItemListModel(int thumbnail, String title, String subTitle ) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.subTitle = subTitle;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    private int thumbnail;
    private String title;
    private String subTitle;

}

/*
public class VerticalTwoItemListModel {
    public VerticalTwoItemListModel(String name, int numOfSongs, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    private String name;
    private int numOfSongs;
    private int thumbnail;
}
*/
