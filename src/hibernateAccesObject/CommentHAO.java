package hibernateAccesObject;

import hibernateMappingClass.Comment;
import hibernateUtil.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

public class CommentHAO {
	public void addComment(Comment comment) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(comment);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void updateComment(Comment comment) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(comment);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Comment getCommentById(int id) throws SQLException {
		Session session = null;
		Comment comment = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			comment = (Comment) session.load(Comment.class, id);
			Hibernate.initialize(comment.getValue());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return comment;
	}

	public List<Comment> getAllComments() throws SQLException {
		Session session = null;
		List<Comment> comments = new ArrayList<Comment>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			comments = session.createCriteria(Comment.class).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return comments;
	}
	
	public List<Comment> getCommentsByBookId(int idBook) throws SQLException {
		Session session = null;
		List<Comment> comments = new ArrayList<Comment>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			comments = session.createQuery("from Comment where idBook=" + String.valueOf(idBook)).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return comments;
	}

	public void deleteComment(Comment comment) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(comment);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
}
