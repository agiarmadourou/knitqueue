package com.knitqueue.service;

import com.knitqueue.entity.AppUser;
import com.knitqueue.repository.AppUserRepository;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppUserServiceImplTest {

    @Test
    void findByIdReturnsExistingUser() {
        // Arrange: Prepare mock repository and test user
        AppUserRepository repo = mock(AppUserRepository.class);
        AppUserService service = new AppUserServiceImpl(repo);

        AppUser user = new AppUser(
                "jane@example.com","hash","Jane");
        when(repo.findById(1)).thenReturn(Optional.of(user));

        // Act: Call the real service method
        AppUser result = service.findById(1);

        // Assert: Verify that the correct user was returned
        assertSame(user,result);
        verify(repo).findById(1);

    }

    @Test
    void findByIdThrowsExceptionWhenUserNotFound() {
        // Arrange: Prepare mock repository for a missing user
        AppUserRepository repo = mock(AppUserRepository.class);
        AppUserService service = new AppUserServiceImpl(repo);

        when(repo.findById(1)).thenReturn(Optional.empty());

        // Act and Assert: Verify that the service throws an exception
        assertThrows(RuntimeException.class, () -> service.findById(1));
        verify(repo).findById(1);
    }
}
