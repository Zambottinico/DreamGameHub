package app.tesis.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    @Modifying()
    @Query("update User u set u.firstname=:firstname, u.lastname=:lastname where u.id = :id")
    void updateUser(@Param(value = "id") Integer id,   @Param(value = "firstname") String firstname, @Param(value = "lastname") String lastname );

}
