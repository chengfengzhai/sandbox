package chengfeng.learn.admindemo.repo.ext;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import chengfeng.learn.admindemo.entity.User;

public class BaseJpaRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID> implements AdditonalCommonInterface<T,ID>{
	private static final Logger logger = LoggerFactory.getLogger(BaseJpaRepositoryImpl.class);
	
	private EntityManager em;
	
//	@Autowired
	public BaseJpaRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.em = em;
	}

	public BaseJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation,entityManager);
	}
	
	@Override
	public <S extends T> S save(S entity) {
		// TODO Auto-generated method stub
		System.out.print("entering overriden save() method in BaseJpaRepositoryImpl!");
		//JpaEntityInformationSupport.getEntityInformation(getDomainClass(), em);
		if( entity instanceof User) {
			System.out.println("cascade saving building!");
		}
		return super.save(entity);
	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return super.saveAndFlush(entity);
	}

	@Override
	public void aCommonMethodForAllRepositories() {
		logger.info(" enter addtional common methods for all repositories in BaseJpaRepositoryImpl ! ");;
	}

	@Override
	public T searchById(ID id) {
		/*
		if(super.existsById(id)) {
			return super.getById(id);
		}else{
			return null;
		}
		*/
		//These implementation should be more efficient
		Optional<T> result = super.findById(id);
		if (result.isPresent()){
			return result.get();
		}else {
			return null;
		}
	}

	@Override
	public <S extends T> S insert(S entity) {
		em.persist(entity);
		return entity;
		
	}

	@Override
	public <S extends T> S update(S entity) {
		return em.merge(entity);
	}

	@Override
	public <S extends T> S insertAndFlush(S entity) {
		S result = insert(entity);
		super.flush();
		return result;
	}

	@Override
	public <S extends T> S updateAndFlush(S entity) {
		S result = update(entity);
		super.flush();
		return result;
	}
	
	
}
