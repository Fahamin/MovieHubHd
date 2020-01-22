package movie.hd.moviehubhd.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import movie.hd.moviehubhd.model.FavModel;


@Database(entities={FavModel.class},version = 1)
public abstract class FavDatabase extends RoomDatabase {

    public abstract FavoriteDao favoriteDao();


}
