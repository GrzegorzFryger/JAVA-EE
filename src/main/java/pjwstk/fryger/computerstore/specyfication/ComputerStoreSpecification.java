package pjwstk.fryger.computerstore.specyfication;

import pjwstk.fryger.computerstore.entity.Part;
import pjwstk.fryger.computerstore.entity.Part_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ComputerStoreSpecification
{
    public static Specification<Part> allParts(String name)
    {
        return new Specification<Part>() {
            @Override
            public Predicate toPredicate(Root<Part> root, CriteriaQuery query, CriteriaBuilder cb) {

                return cb.equal(root.get(Part_.name),name);

            }
        };
    }
}
