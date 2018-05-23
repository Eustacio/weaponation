import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Wallison Freitas
 */
public interface EntityRepository<T> extends JpaRepository<T, Long> {}
