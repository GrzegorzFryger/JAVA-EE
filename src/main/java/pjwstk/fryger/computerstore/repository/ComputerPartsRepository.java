package pjwstk.fryger.computerstore.repository;

import pjwstk.fryger.computerstore.entity.Comment;
import pjwstk.fryger.computerstore.entity.Part;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class ComputerPartsRepository
{

   @PersistenceContext
   EntityManager entityManager;




    public List<Part> getAll()
    {



        List<Part> a = new ArrayList<>();


       // System.out.println();

        return entityManager.createNamedQuery("Part.findAll",Part.class).getResultList();
    }

    public Part getById() {
        return null;
    }

    public Long addPart(Part part) {

        return null;
    }

    public void updatePart(Long id, Part part)
    {
    }

    public List<Comment> getAllComments()
    {
        return null;
    }

    public void addComment(Long id, Comment comment) {
    }

    public void deleteComment( Long id, Long idComment) {
    }
}
