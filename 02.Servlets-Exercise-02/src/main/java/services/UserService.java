package services;

import dao.UserMapperImpl;
import model.User;
import services.interfaces.Repository;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class UserService implements Repository<User> {

    private UserMapperImpl mapper;

    public UserService(Connection con) {

        this.mapper = new UserMapperImpl(con);
    }


    @Override
    public User getById(Long id) {

       return (User) this.mapper.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return this.mapper.getAll();

    }

    @Override
    public void add(User item) {

        this.mapper.persistAdd(item);
    }

    @Override
    public void update(User item) {

        this.mapper.persistUpdate(item);

    }

    @Override
    public void remove(User item) {

        this.mapper.deleteOne(item.getId());

    }

    public Map<String,Long> searchByEmail(String email){

       return this.mapper.searchByEmail(email);
    }
}
