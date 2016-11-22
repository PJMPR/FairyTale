package dao.repositories;

import java.util.List;

import domain.model.Book;
import domain.model.Lend;
import domain.model.Reader;



public interface ILendRepository extends IRepository<Lend>{

 public List<Lend> fromReader (Reader reader);
 public List<Lend> fromBook (Book book);
}
