/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_andela;

/**
 *
 * @author USER
 */
import java.sql.*;

    public class SQLiteJDBC
{
        public static void main(String[] args) {
   
        {

      connectDB();
      createDB();
      insertDB();
      selectDB();
      //updateDB();
      //deleteDB();
        }
        public static void connectDB()
  {
      
      Connection c = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Opened database successfully");
  }
  public static void createDB()
  {
      Connection c = null;
        Statement stmt = null;
        try {
        Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
          c.setAutoCommit(false);
          System.out.println("Opened database successfully");
 
          stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM web_blog;" );
          while ( rs.next() ) {
             int id = rs.getInt("id");
             String  name = rs.getString("name");
             String  message = rs.getString("message");
             String date_added = rs.getString("date_added");
             System.out.println( "ID : " + id );
             System.out.println( "Name : " + name );
             System.out.println( "Message : " + message );
             System.out.println( "Date Added : " + date_added );
             System.out.println();
          }
          rs.close();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Operation done successfully");  
  }
   
  public static void updateDB()
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
 
      stmt = c.createStatement();
      String sql = "UPDATE web_blog set message = 'This is updated by updateDB()' where ID=1;";
      stmt.executeUpdate(sql);
      c.commit();
 
      ResultSet rs = stmt.executeQuery( "SELECT * FROM web_blog;" );
      while ( rs.next() ) {
         int id = rs.getInt("id");
         String  name = rs.getString("name");
         String  message = rs.getString("message");
         String date_added = rs.getString("date_added");
         System.out.println( "ID : " + id );
         System.out.println( "Name : " + name );
         System.out.println( "Message : " + message );
         System.out.println( "Date Added : " + date_added );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
   
  public static void deleteDB()
  {
      Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
          c.setAutoCommit(false);
          System.out.println("Opened database successfully");
 
          stmt = c.createStatement();
          String sql = "DELETE from web_blog where ID=1;";
          stmt.executeUpdate(sql);
          c.commit();
 
          ResultSet rs = stmt.executeQuery( "SELECT * FROM web_blog;" );
          while ( rs.next() ) {
             int id = rs.getInt("id");
             String  name = rs.getString("name");
             String  message = rs.getString("message");
             String date_added = rs.getString("date_added");
             System.out.println( "ID : " + id );
             System.out.println( "Name : " + name );
             System.out.println( "Message : " + message );
             System.out.println( "Date Added : " + date_added );
             System.out.println();
          }
          rs.close();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Operation done successfully");
  }
    }
       
      
 
    
        
 

 
   
 
           