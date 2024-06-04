package studio.thinkground.testproject.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.thinkground.testproject.data.entity.Listener;

public interface ListenerRepository extends JpaRepository<Listener, Long> {

}
