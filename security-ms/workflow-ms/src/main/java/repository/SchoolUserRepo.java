package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reportms.models.SchoolUser;

public interface SchoolUserRepo extends JpaRepository<SchoolUser, Long> {


    SchoolUser findByUsername(String username);
}
