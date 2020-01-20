package movie.hd.moviehubhd.searchfile;

import java.util.Observable;

public class FilterManager  extends Observable {
    private String query;

    public void setQuery(String query) {
        this.query = query;
        setChanged();
        notifyObservers();
    }

    public String getQuery() {
        return query;
    }
}