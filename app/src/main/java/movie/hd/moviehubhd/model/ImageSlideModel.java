package movie.hd.moviehubhd.model;

public class ImageSlideModel {

    int image;
    String MovieCatagory;

    public ImageSlideModel(int image, String movieCatagory) {
        this.image = image;
        MovieCatagory = movieCatagory;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMovieCatagory() {
        return MovieCatagory;
    }

    public void setMovieCatagory(String movieCatagory) {
        MovieCatagory = movieCatagory;
    }
}