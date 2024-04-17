package ru.gb.HWwith_an_asterisk.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.HWwith_an_asterisk.config.DBconf;
import ru.gb.HWwith_an_asterisk.model.User;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;
    private final DBconf dBconf;

    public UserRepository(JdbcTemplate jdbc, DBconf dBconf) {
        this.jdbc = jdbc;
        this.dBconf = dBconf;
    }

    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(dBconf.getFindAll(), userRowMapper);
    }

    public User save(User user) {
        jdbc.update(dBconf.getSave(), user.getFirstName(), user.getLastName());
        return  user;
    }

    public void deleteById(int id){
    jdbc.update(dBconf.getDeleteById(),id);
    }

    public void updateById(int id, String firstName, String lastName){
        jdbc.update(dBconf.getUpdateById(), firstName, lastName, id);
    }
}