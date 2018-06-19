package query;

import entity.Person;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

public class CommentQuery
{

    public static Query<Person> getAllPerson()
    {
        return new Query<Person>() {

            @Override
            public CriteriaQuery<Person> toQuery(Root<Person> root, CriteriaQuery query, CriteriaBuilder cBuldier) {

                return query.select(root);
            }
        };
    }

    public static Query<Person> getNumberOfPerson(int number)
    {
        return new Query<Person>() {

            @Override
            public CriteriaQuery<Person> toQuery(Root<Person> root, CriteriaQuery query, CriteriaBuilder cBuldier) {


                return query.select(cBuldier.count(query.from(Person.class)));
            }
        };
    }


}
