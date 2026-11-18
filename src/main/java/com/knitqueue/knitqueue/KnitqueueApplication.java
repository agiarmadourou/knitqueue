package com.knitqueue.knitqueue;

import com.knitqueue.knitqueue.entity.AppUser;
import com.knitqueue.knitqueue.entity.Project;
import com.knitqueue.knitqueue.entity.ShoppingItem;
import com.knitqueue.knitqueue.repository.AppUserRepository;
import com.knitqueue.knitqueue.repository.ProjectRepository;
import com.knitqueue.knitqueue.repository.ShoppingItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class KnitqueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnitqueueApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AppUserRepository appUserRepository,
			ProjectRepository projectRepository,
			ShoppingItemRepository shoppingItemRepository) {
		return runner -> {
//			// Create new user
//			AppUser appUser1 = new AppUser(
//					"Jane@knitqueue.com","hashash","Jane");
//			appUserRepository.save(appUser1);
//
//			// Add new project for the user
//            Project  project1 = new Project(appUser1,"Raglan sweater with cables",
//					null,null,null,"IDEA"
//			);
//			projectRepository.save(project1);
//
//			// Add new shopping item for the project
//			ShoppingItem shoppingItem1 = new ShoppingItem(project1,appUser1,
//					"8 balls of Drops Lima",null,false);
//			shoppingItemRepository.save(shoppingItem1);
//
//			// find all
//			List<AppUser> users=appUserRepository.findAll();
//			System.out.println(users);
//
//			// update
//			int id=appUser1.getUserId();
//			AppUser theUser = appUserRepository.findById(id).orElse(null);
//			if (theUser !=null) {
//				theUser.setFirstName("Mary");
//				appUserRepository.save(theUser);
//			}
//
//			// find by Id
//			AppUser theAppUser =appUserRepository.findById(id).orElse(null);
//			System.out.println(theAppUser);
//
//			// delete by Id
//			projectRepository.deleteById(project1.getProjectId());
//			appUserRepository.deleteById(id);
		};
	}

}
