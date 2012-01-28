package org.codefish.blog.mongo.repository;

import java.util.List;

import org.codefish.blog.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog, String> {
	public List<Blog> findByTitle(String title);
}