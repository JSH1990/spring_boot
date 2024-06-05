package studio.thinkground.testproject.data.repository;

import org.springframework.data.repository.CrudRepository;
import studio.thinkground.testproject.data.dto.ShortUrlResponseDto;


public interface ShortUrlRedisRepository extends CrudRepository<ShortUrlResponseDto, String> {

}
