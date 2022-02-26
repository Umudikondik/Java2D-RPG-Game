package Game;
import java.sql.*;

public class Highscores          //Postgresql for LocalHost
{

    private static Connection connect = null;   // Establish connection.
    private static Statement statement = null;   // Create and execute sql queries.
    private static ResultSet resultSet = null;   // Use returned values of our query.

    final private static String host = "jdbc:postgresql://localhost:5432/Java Game";     // host name
    final private static String user = "postgres";                 // user name
    final private static String password = "15022001Umut";       // password

    private double point;
    private double[] highscores = new double[5];
    private String[] nicknames = new String[5];



    public static void writeResultSet(ResultSet resultSet) throws SQLException     // Thanks to that we are possible to print query results.
    {
        ResultSetMetaData rsmd = resultSet.getMetaData();   // resultSet = Hold sql query results.
        int columnsNumber = rsmd.getColumnCount();          // resultSet number of columns.
        while(resultSet.next())
        {
            for(int i = 1; i <= columnsNumber; i++)
            {
                System.out.print(resultSet.getString(i) + "      ");
            }
            System.out.println();
        }
    }

    public Highscores(double point,String nickname) throws SQLException {
        try
        {
            connect = DriverManager.getConnection(host,user,password);       // connect to the database with the input of host, user and password.
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        statement = connect.createStatement();
        int score = 0;
        String nickname2 = "";

        // The high scores and nicknames are assigned to the arrays.

        for(int i = 1; i <= highscores.length; i++)
        {
            resultSet = statement.executeQuery("Select highscores.point from highscores where highscores.rank = '"+i+"' order by point desc");

            while(resultSet.next())   // We need it to read next rows.
            {
                score = resultSet.getInt(1);    // We get the first column's variable because result of the query has just one column.
            }
            highscores[i-1] = score;
            resultSet = statement.executeQuery("Select highscores.nickname from highscores where highscores.rank = '"+i+"'order by point desc" );
            while(resultSet.next())   // We need it to read next rows.
            {
                nickname2 = resultSet.getString(1);    // We get the first column's variable because result of the query has just one column.
            }
            nicknames[i-1] = nickname2;
        }

        // The minimum value is changed according to the player's score which is in the constructor. (If player's point is bigger than the minimum point in the array.)
        double min = highscores[0];
        int position = 0;
        double temp;
        String temp2;
        for(int i = 1 ; i < highscores.length; i++)           // Establish the minimum value in the array and set it to the double min.
        {
            if (highscores[i] < min)
            {
                min = highscores[i];
                position = i;
            }
        }
        if (min < point)          // If player's point is bigger than the minimum value, change it.
        {
            highscores[position] = point;
            nicknames[position] = nickname;
        }

        for (int i = 0; i < highscores.length; i++) {           // Sorting arrays (descending)
            for (int j = i+1; j < highscores.length; j++) {
                if(highscores[i] < highscores[j]) {
                    temp = highscores[i];
                    highscores[i] = highscores[j];
                    highscores[j] = temp;
                    ////////////////////
                    temp2= nicknames[i];
                    nicknames[i] = nicknames[j];
                    nicknames[j] = temp2;
                }
            }
        }

        // Update the sql database with our new high scores and nicknames.
        for(int i = 0; i < 5; i++)
        {
            statement.executeUpdate("Update public.highscores set point= '" + highscores[i] + "' , nickname = '" + nicknames[i] + "' where public.highscores.rank= '" + (i+1) + "'");   //Son puanı güncelleme
        }
        resultSet = statement.executeQuery("Select * from public.highscores order by rank asc;");
        writeResultSet(resultSet);
    }
    public double getHighscores(int i) {        // Buraya girilen integer indexindeki higscores[i] return oluyor.
        return highscores[i];
    }
    public String getNicknames(int i) {
        return nicknames[i];
    }
}

