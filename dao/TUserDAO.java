package dao;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for TUser
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see dao.TUser
 * @author MyEclipse Persistence Tools
 */

public class TUserDAO implements ITUserDAO {
	// property constants
	public static final String PASSWORD = "password";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved TUser entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * TUserDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            TUser entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(TUser entity) {
		EntityManagerHelper.log("saving TUser instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent TUser entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * TUserDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            TUser entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(TUser entity) {
		EntityManagerHelper.log("deleting TUser instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(TUser.class,
					entity.getUsername());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved TUser entity and return it or a copy of it to
	 * the sender. A copy of the TUser entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = TUserDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            TUser entity to update
	 * @return TUser the persisted TUser entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public TUser update(TUser entity) {
		EntityManagerHelper.log("updating TUser instance", Level.INFO, null);
		try {
			TUser result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public TUser findById(String id) {
		EntityManagerHelper.log("finding TUser instance with id: " + id,
				Level.INFO, null);
		try {
			TUser instance = getEntityManager().find(TUser.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all TUser entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the TUser property to query
	 * @param value
	 *            the property value to match
	 * @return List<TUser> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<TUser> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding TUser instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from TUser model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<TUser> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/**
	 * Find all TUser entities.
	 * 
	 * @return List<TUser> all TUser entities
	 */
	@SuppressWarnings("unchecked")
	public List<TUser> findAll() {
		EntityManagerHelper
				.log("finding all TUser instances", Level.INFO, null);
		try {
			final String queryString = "select model from TUser model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}