
package com.mycompany.dao;


import com.mycompany.models.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class UsersDaoJdbcTemplateImpl implements UsersDao
{
    JdbcTemplate templ;
    private final String SQL_SELECT_ALL="SELECT * FROM fix_user";
    Map<Integer,User> usersMap = new HashMap<>();
    private final String SQL_SELECT_USER="SELECT * FROM fix_user WHERE id=?";
    private final String SQL_SELECT_ALL_BY_FIRST_NAME="SELECT * FROM fix_user WHERE first_name=?";

    public UsersDaoJdbcTemplateImpl(DataSource dataSource) 
    {
        templ=new JdbcTemplate(dataSource);
    }
    private RawMapper<User> userRowMapper = (ResultSet relst,int i) ->
        {
            Integer id = relst.getInt("id");
        }
    
    @Override
    public List<User> findAllByFirstName(String firstname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<User> find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(User model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
