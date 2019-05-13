package com.mycompany.dao;

import com.mycompany.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class UsersDaoJdbcImpl implements UsersDao
{
    private final String SQL_SELECT_ALL="SELECT * FROM fix_user";
    private final String SQL_SELECT_BY_ID="SELECT * FROM fix_user WHRE id = ?";
    
    private Connection conn;

    public UsersDaoJdbcImpl(DataSource dataSource) 
    {
        try
        {
            this.conn=dataSource.getConnection();
        }
        catch(SQLException e)
        {           throw new IllegalStateException(e);      }
    }
    
    
    @Override
    public List<User> findAllByFirstName(String firstname) { return null;    }

    @Override
    public Optional<User> find(Integer id)
    {
        try
        {
            PreparedStatement statm = conn.prepareStatement(SQL_SELECT_BY_ID);
            statm.setInt(1,id);
            ResultSet reslset=statm.executeQuery();
            if( reslset.next() )
            {
                String firstName=reslset.getString("first_name");
                String lastName=reslset.getString("last_name");
                return Optional.of( new User(id,firstName,lastName));
            }
            return Optional.empty();
        }
        catch( SQLException e)
        {           throw new IllegalStateException(e);       }
    }

    @Override
    public void save(User model) {      }

    @Override
    public void update(User model) {   }

    @Override
    public void delete(Integer model) {   }

    @Override
    public List<User> findAll() 
    {
       try
       {
           List<User> users = new ArrayList<>();
           Statement stt = conn.createStatement();
           ResultSet reslset=stt.executeQuery(SQL_SELECT_ALL);
           while( reslset.next() )
           {
               Integer id= reslset.getInt("id");
               String firstName=reslset.getString("first_name");
               String lastName=reslset.getString("last_name");
               
               User usr= new User(id,firstName,lastName);
               users.add(usr);
           }
           return users;
       }
       catch( SQLException e)
       {           throw new IllegalStateException(e);       }
    }
}
