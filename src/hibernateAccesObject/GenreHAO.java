package hibernateAccesObject;

import hibernateMappingClass.Genre;
import hibernateMappingClass.User;
import hibernateUtil.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.criterion.Expression;

public class GenreHAO {
	public void addGenre(Genre genre) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(genre);
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

	public void updateGenre(Genre genre) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(genre);
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

	public Genre getGenreById(int id) throws SQLException {
		Session session = null;
		Genre genre = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			genre = (Genre) session.createQuery("from Genre where id=" + id).list().get(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return genre;
	}

	public List<Genre> getAllGenres() throws SQLException {
		Session session = null;
		List<Genre> genres = new ArrayList<Genre>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			genres = session.createCriteria(Genre.class).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return genres;
	}

	public void deleteGenre(Genre genre) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(genre);
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
	
	public Genre getGenreByName(String name) {
		Session session = null;
		List<Genre> genres = new ArrayList<Genre>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			genres = session.createCriteria(Genre.class).add(Expression.like("value", name)).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		if (!genres.isEmpty())
			return genres.get(0);
		else
			return null;
	}
}
