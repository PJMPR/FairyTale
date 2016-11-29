package dao.repositories;

import java.util.List;


import domain.model.Lend;



public interface ILendRepository extends IRepository<Lend>{

 public List<Lend> fromReader (int reader);
 public List<Lend> fromBook (int book);
}
