package chengfeng.learn.admindemo.repo.ext;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AdditonalCommonInterface <T,ID>{
	void aCommonMethodForAllRepositories();
	T searchById(ID id);
	<S extends T> S insert(S entity);
	<S extends T> S update(S entity);
	<S extends T> S insertAndFlush(S entity);
	<S extends T> S updateAndFlush(S entity);
}
