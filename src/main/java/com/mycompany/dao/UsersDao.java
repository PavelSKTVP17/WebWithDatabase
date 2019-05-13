package com.mycompany.dao;

import com.mycompany.models.User;
import java.util.List;
import java.util.Optional;


public interface UsersDao extends CrudDao<User>
{
    List<User> findAllByFirstName( String firstname);   
}
