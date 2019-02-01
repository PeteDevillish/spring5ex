package pete.springframework.spring5ex.Repositories;

import org.springframework.data.repository.CrudRepository;
import pete.springframework.spring5ex.Model.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
