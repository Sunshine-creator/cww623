package dao;

import java.util.List;

/**
 * Interface for TUserDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ITUserDAO {
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
	 * ITUserDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            TUser entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(TUser entity);

	/**
	 * Delete a persistent TUser entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ITUserDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            TUser entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(TUser entity);

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
	 * entity = ITUserDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            TUser entity to update
	 * @return TUser the persisted TUser entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public TUser update(TUser entity);

	public TUser findById(String id);

	/**
	 * Find all TUser entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the TUser property to query
	 * @param value
	 *            the property value to match
	 * @return List<TUser> found by query
	 */
	public List<TUser> findByProperty(String propertyName, Object value);

	public List<TUser> findByPassword(Object password);

	/**
	 * Find all TUser entities.
	 * 
	 * @return List<TUser> all TUser entities
	 */
	public List<TUser> findAll();
}