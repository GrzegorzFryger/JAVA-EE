package pjwstk.fryger.computerstore.entity;

import pjwstk.fryger.computerstore.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "PART")
@NamedQuery(name = "Part.findAll", query = "select p from Part p")
public class Part
{
   // public static final String FIND_ALL = "Part.findAll";
    @Id
    private Long id;
    private String name;
    private int price;
    private String description;

    public Part() {
    }


    // private ComputerPartCategory category;
  //  private List<Comment> comments = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  //  public ComputerPartCategory getCategory() {
     //   return category;
    //}

    //public void setCategory(ComputerPartCategory category) {
      //  this.category = category;
    //}

   // public List<Comment> getComments() {
     //   return comments;
    //}

    //public void setComments(List<Comment> comments) {
      //  this.comments = comments;
    //}

    @Override
    public String toString() {
        return "Part{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category=" + //category +
                ", comments=" +// comments +
                '}';
    }
}
