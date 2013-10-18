package hibernateAccesObject;

import hibernateMappingClass.Author;
import hibernateUtil.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.criterion.Expression;

public class AuthorHAO {
	public void addAuthors(Author author) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(author);
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

	public void updateAuthor(Author author) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(author);
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

	public Author getAuthorById(int id) throws SQLException {
		Session session = null;
		Author author = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			author = (Author) session.load(Author.class, id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return author;
	}

	public List<Author> getAllAuthors() throws SQLException {
		Session session = null;
		List<Author> authors = new ArrayList<Author>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			authors = session.createCriteria(Author.class).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return authors;
	}

	public void deleteAuthor(Author author) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(author);
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
	
	public Author getAuthorByName(String name) {
		Session session = null;
		String[] str=name.split("_");
		List<Author> authors = new ArrayList<Author>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			authors = session.createCriteria(Author.class).add(Expression.like("firstName", str[0])).add(Expression.like("lastName", str[1])).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		if (!authors.isEmpty())
			return authors.get(0);
		else
			return null;
	}
}
