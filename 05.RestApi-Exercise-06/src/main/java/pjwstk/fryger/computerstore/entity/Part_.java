package pjwstk.fryger.computerstore.entity;


import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.List;

@StaticMetamodel(Part.class)
public class Part_
{
    public static volatile SingularAttribute<Part, Long> id;
    public static volatile SingularAttribute<Part, String> name;
    public static volatile SingularAttribute<Part, Integer> price;
    public static volatile SingularAttribute<Part, String> description;
    public static volatile SingularAttribute<Part, ComputerPartCategory> category;
    public static volatile ListAttribute<Comment,List> comments;

}
