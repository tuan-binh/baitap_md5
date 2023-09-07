package ra.demo_spring_boot.service;

public interface IGenericMapper<T, K, V> {
	T toEntity(K k);
	
	K toRequest(T t);
	
	V toResponse(T t);
}
