package com.example.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

class MovieTableConnector extends SQL_GetSet
{
    private Connection conn;
    /**
     * Creates Movie Table Connector with given connection.
     * Connection should be linked to server prior to creating this object.
     * @param conn Valid connection
     */
    public MovieTableConnector(Connection conn) {super(conn);this.conn = conn;}

    public boolean createNewMovie(String title,String ageRating,int yearRelease,String producer,String director,String cast,
                                  int IMDBRating,int RTRating,String trailerURL,String posterURL,String category,
                                  String synopsis,int durationMin)
    {
        if(!(verifyString(title)&&verifyString(producer)&&verifyString(director)&&verifyString(cast)&&
                verifyString(trailerURL) && verifyString(posterURL) && verifyString(synopsis)))
        {
            return false;
        }

        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO [Movie Titles] VALUES ('"+title+"','"+ageRating+"',"+yearRelease+",'"+producer+"','"
                    +cast+"','"+director+"',"+IMDBRating+","+RTRating+",'"+trailerURL+"','"+category+
                    "','"+synopsis+"',"+durationMin+",'"+posterURL+"')";
            stmt.executeUpdate(SQL);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    // get titles of movies in specific category
    String [] getTitlesInCategory(String category)
    {
        Object [] temp = getMany(category,"Movie Titles","Category","Title");
        return Arrays.copyOf(temp,temp.length,String[].class);
    }

    String [] getTitlesOnDay(String date)
    {
        Object [] temp = getMany(date,"Showtimes","Show Date","Movie Title");
        Integer [] temp2 = Arrays.copyOf(temp,temp.length,Integer[].class);
        int [] ids = Arrays.stream(temp2).mapToInt(Integer::intValue).toArray();
        String [] toRet = new String [ids.length];

        for (int i = 0; i < ids.length; i++)
        {
            toRet[i] = get(ids[i],"Movie Titles","Movie ID","Movie Title");
        }
        return toRet;
    }

    String [] getAllTitles()
    {
        Object [] temp = getAll("Movie Titles","Title");
        return Arrays.copyOf(temp,temp.length,String[].class);
    }

    // ageRating
    String getAgeRating(String title){return get(title,"Movie Titles","Title","Age Rating");}
    boolean changeAgeRating(String title,String ageRate)
    {
        if(verifyString(ageRate))return false;
        return update(title,"Movie Titles","Title","Age Rating",ageRate);
    }

    // yearRelease
    int getYearRelease(String title){return get(title,"Movie Titles","Title","Year Released");}
    boolean changeYearRelease(String title,int yearRelease)
    {
        return update(title,"Movie Titles","Title","Year Released",yearRelease);
    }

    // producer
    String getProducer(String title){return get(title,"Movie Titles","Title","Producer");}
    boolean changeProducer(String title,String producer)
    {
        if(verifyString(producer))return false;
        return update(title,"Movie Titles","Title","Producer",producer);
    }

    // cast
    String getCast(String title){return get(title,"Movie Titles","Title","Cast");}
    boolean changeCast(String title,String cast)
    {
        if(verifyString(cast))return false;
        return update(title,"Movie Titles","Title","Cast",cast);
    }

    // director
    String getDirector(String title){return get(title,"Movie Titles","Title","Director");}
    boolean changeDirector(String title,String director)
    {
        if(verifyString(director))return false;
        return update(title,"Movie Titles","Title","Director",director);
    }

    // IMDBRating
    int getIMDBRating(String title){return get(title,"Movie Titles","Title","IMDB Rating");}
    boolean changeIMDBRating(String title,int IMDBRating)
    {
        return update(title,"Movie Titles","Title","IMDB Rating",IMDBRating);
    }

    // RTRating
    int getRTRating(String title){return get(title,"Movie Titles","Title","Rotten Tomatoes");}
    boolean changeRTRating(String title,int RTRating)
    {
        return update(title,"Movie Titles","Title","Rotten Tomatoes",RTRating);
    }

    // trailerURL
    String getTrailerURL(String title){return get(title,"Movie Titles","Title","Trailer URL");}
    boolean changeTrailerURL(String title,String trailerURL)
    {
        if(verifyString(trailerURL))return false;
        return update(title,"Movie Titles","Title","Trailer URL",trailerURL);
    }

    // posterURL
    String getPosterURL(String title){return get(title,"Movie Titles","Title","PosterURL");}
    boolean changePosterURL(String title,String posterURL)
    {
        if(verifyString(posterURL))return false;
        return update(title,"Movie Titles","Title","PosterURL",posterURL);
    }

    // categoryID
    String getCategory(String title){return get(title,"Movie Titles","Title","Category");}
    boolean changeCategory(String title,String category)
    {
        return update(title,"Movie Titles","Title","Category ID",category);
    }

    // synopsis
    String getSynopsis(String title){return get(title,"Movie Titles","Title","Synopsis");}
    boolean changeSynopsis(String title,String synopsis)
    {
        return update(title,"Movie Titles","Title","Synopsis",synopsis);
    }

    // durationMin
    int getDuration(String title){return get(title,"Movie Titles","Title","Duration");}
    boolean changeDuration(String title,int duration)
    {
        return update(title,"Movie Titles","Title","Duration",duration);
    }
}
