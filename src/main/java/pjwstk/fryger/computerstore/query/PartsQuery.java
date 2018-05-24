package pjwstk.fryger.computerstore.query;

import pjwstk.fryger.computerstore.entity.ComputerPartCategory;
import pjwstk.fryger.computerstore.entity.Part;
import pjwstk.fryger.computerstore.entity.Part_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PartsQuery
{



    public static Query<Part> allParts()
    {


        return new Query<Part>() {
            @Override
            public CriteriaQuery<Part> toQuery(Root<Part> root, CriteriaQuery query, CriteriaBuilder cBuldier) {

                return query.select(root);


            }
        };
    }

    public static Query<Part> findByCategory(ComputerPartCategory category)
    {
        return new Query<Part>() {
            @Override
            public CriteriaQuery<Part> toQuery(Root<Part> root, CriteriaQuery query, CriteriaBuilder cBuldier) {

               // root = query.from(Part.class);


               return   query.where(cBuldier.equal(root.get(Part_.category),category));
            }
        };
    }

    public static Query<Part> findByName(String name)
    {
        return new Query<Part>() {
            @Override
            public CriteriaQuery<Part> toQuery(Root<Part> root, CriteriaQuery query, CriteriaBuilder cBuldier) {
                return query.where(cBuldier.equal(root.get(Part_.name),name));
            }
        };
    }

    public static Query<Part> fidndByPrice(int from, int to)
    {
        return new Query<Part>() {
            @Override
            public CriteriaQuery<Part> toQuery(Root<Part> root, CriteriaQuery query, CriteriaBuilder cBuldier) {


               return query.where(cBuldier.between(root.get(Part_.price), from,to)).orderBy(cBuldier.asc(root.get(Part_.price)));


            }
        };
    }



}