package in.purabtech.csvupload.repository;

import in.purabtech.csvupload.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
