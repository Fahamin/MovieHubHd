package movie.hd.moviehubhd.model;

import java.util.List;

public class DataHomeModel {
    List<MovieModel> list;
    String movieName;
    String movieCatagoryName;

    public DataHomeModel(List<MovieModel> list,  String movieCatagoryName) {
        this.list = list;
        this.movieCatagoryName = movieCatagoryName;
    }

    public List<MovieModel> getList() {
        return list;
    }

    public void setList(List<MovieModel> list) {
        this.list = list;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieCatagoryName() {
        return movieCatagoryName;
    }

    public void setMovieCatagoryName(String movieCatagoryName) {
        this.movieCatagoryName = movieCatagoryName;
    }
}
