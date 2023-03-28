package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Serializable>{

}
