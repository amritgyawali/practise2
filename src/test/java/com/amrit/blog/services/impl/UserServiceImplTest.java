package com.amrit.blog.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amrit.blog.entities.Post;
import com.amrit.blog.entities.Role;
import com.amrit.blog.entities.User;
import com.amrit.blog.exceptions.ResourceNotFoundException;
import com.amrit.blog.payloads.RoleDto;
import com.amrit.blog.payloads.UserDto;
import com.amrit.blog.repositories.RoleRepo;
import com.amrit.blog.repositories.UserRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private RoleRepo roleRepo;

    @MockBean
    private UserRepo userRepo;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#createUser(UserDto)}
     */
    @Test
    void CreateUser_Test() {
        // Arrange
        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<User>>any())).thenReturn(user);

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Optional<Role> ofResult = Optional.of(role);
        when(roleRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(userRepo.save(Mockito.<User>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.createUser(userDto));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(roleRepo).findById(eq(502));
        verify(userRepo).save(isA(User.class));
        verify(passwordEncoder).encode(isA(CharSequence.class));
    }

    /**
     * Method under test: {@link UserServiceImpl#createUser(UserDto)}
     */
//    @Test
//    void CreateUser_Test2() {
//        // Arrange
//        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
//        User user = mock(User.class);
//        when(user.getPassword()).thenReturn("iloveyou");
//        doNothing().when(user).setAbout(Mockito.<String>any());
//        doNothing().when(user).setEmail(Mockito.<String>any());
//        doNothing().when(user).setId(anyInt());
//        doNothing().when(user).setName(Mockito.<String>any());
//        doNothing().when(user).setPassword(Mockito.<String>any());
//        doNothing().when(user).setPosts(Mockito.<List<Post>>any());
//        doNothing().when(user).setRoles(Mockito.<Set<Role>>any());
//        user.setAbout("About");
//        user.setEmail("jane.doe@example.org");
//        user.setId(1);
//        user.setName("Name");
//        user.setPassword("iloveyou");
//        user.setPosts(new ArrayList<>());
//        user.setRoles(new HashSet<>());
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Map");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<User>>any())).thenReturn(user);
//        Optional<Role> emptyResult = Optional.empty();
//        when(roleRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
//
//        UserDto userDto = new UserDto();
//        userDto.setAbout("About");
//        userDto.setEmail("jane.doe@example.org");
//        userDto.setId(1);
//        userDto.setName("Name");
//        userDto.setPassword("iloveyou");
//        userDto.setRoles(new HashSet<>());
//
//        // Act and Assert
//        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.createUser(userDto));
//        verify(user).getPassword();
//        verify(user).setAbout(eq("About"));
//        verify(user).setEmail(eq("jane.doe@example.org"));
//        verify(user).setId(eq(1));
//        verify(user).setName(eq("Name"));
//        verify(user, atLeast(1)).setPassword(Mockito.<String>any());
//        verify(user).setPosts(isA(List.class));
//        verify(user).setRoles(isA(Set.class));
//        verify(modelMapper, atLeast(1)).map(isA(Object.class), isA(Class.class));
//        verify(roleRepo).findById(eq(502));
//        verify(passwordEncoder).encode(isA(CharSequence.class));
//    }

    /**
     * Method under test: {@link UserServiceImpl#updateUser(UserDto, Integer)}
     */
    @Test
    void UpdateUser_Test() {
        // Arrange
        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any())).thenReturn(userDto);

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user);

        User user2 = new User();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());
        when(userRepo.save(Mockito.<User>any())).thenReturn(user2);
        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        UserDto userDto2 = new UserDto();
        userDto2.setAbout("About");
        userDto2.setEmail("jane.doe@example.org");
        userDto2.setId(1);
        userDto2.setName("Name");
        userDto2.setPassword("iloveyou");
        userDto2.setRoles(new HashSet<>());

        // Act
        UserDto actualUpdateUserResult = userServiceImpl.updateUser(userDto2, 1);

        // Assert
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(userRepo).findById(eq(1));
        verify(userRepo).save(isA(User.class));
        verify(passwordEncoder).encode(isA(CharSequence.class));
        assertSame(userDto, actualUpdateUserResult);
    }

    /**
     * Method under test: {@link UserServiceImpl#updateUser(UserDto, Integer)}
     */
//    @Test
//    void UpdateUser_Test2() {
//        // Arrange
//        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
//
//        UserDto userDto = new UserDto();
//        userDto.setAbout("About");
//        userDto.setEmail("jane.doe@example.org");
//        userDto.setId(1);
//        userDto.setName("Name");
//        userDto.setPassword("iloveyou");
//        userDto.setRoles(new HashSet<>());
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Map");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any())).thenReturn(userDto);
//
//        User user = new User();
//        user.setAbout("About");
//        user.setEmail("jane.doe@example.org");
//        user.setId(1);
//        user.setName("Name");
//        user.setPassword("iloveyou");
//        user.setPosts(new ArrayList<>());
//        user.setRoles(new HashSet<>());
//        Optional<User> ofResult = Optional.of(user);
//        when(userRepo.save(Mockito.<User>any()))
//                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));
//        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);
//
//        UserDto userDto2 = new UserDto();
//        userDto2.setAbout("About");
//        userDto2.setEmail("jane.doe@example.org");
//        userDto2.setId(1);
//        userDto2.setName("Name");
//        userDto2.setPassword("iloveyou");
//        userDto2.setRoles(new HashSet<>());
//
//        // Act and Assert
//        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.updateUser(userDto2, 1));
//        verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
//        verify(userRepo).findById(eq(1));
//        verify(userRepo).save(isA(User.class));
//        verify(passwordEncoder).encode(isA(CharSequence.class));
//    }

    /**
     * Method under test: {@link UserServiceImpl#updateUser(UserDto, Integer)}
     */
//    @Test
//    void UpdateUser_Test3() {
//        // Arrange
//        UserDto userDto = new UserDto();
//        userDto.setAbout("About");
//        userDto.setEmail("jane.doe@example.org");
//        userDto.setId(1);
//        userDto.setName("Name");
//        userDto.setPassword("iloveyou");
//        userDto.setRoles(new HashSet<>());
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Map");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any())).thenReturn(userDto);
//        Optional<User> emptyResult = Optional.empty();
//        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
//
//        UserDto userDto2 = new UserDto();
//        userDto2.setAbout("About");
//        userDto2.setEmail("jane.doe@example.org");
//        userDto2.setId(1);
//        userDto2.setName("Name");
//        userDto2.setPassword("iloveyou");
//        userDto2.setRoles(new HashSet<>());
//
//        // Act and Assert
//        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.updateUser(userDto2, 1));
//        verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
//        verify(userRepo).findById(eq(1));
//    }

    /**
     * Method under test: {@link UserServiceImpl#updateUser(UserDto, Integer)}
     */
//    @Test
//    void UpdateUser_Test4() {
//        // Arrange
//        UserDto userDto = new UserDto();
//        userDto.setAbout("About");
//        userDto.setEmail("jane.doe@example.org");
//        userDto.setId(1);
//        userDto.setName("Name");
//        userDto.setPassword("iloveyou");
//        userDto.setRoles(new HashSet<>());
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Map");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any())).thenReturn(userDto);
//
//        User user = new User();
//        user.setAbout("About");
//        user.setEmail("jane.doe@example.org");
//        user.setId(1);
//        user.setName("Name");
//        user.setPassword("iloveyou");
//        user.setPosts(new ArrayList<>());
//        user.setRoles(new HashSet<>());
//        Optional<User> ofResult = Optional.of(user);
//        when(userRepo.save(Mockito.<User>any()))
//                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));
//        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);
//        UserDto userDto2 = mock(UserDto.class);
//        when(userDto2.getAbout()).thenReturn("About");
//        when(userDto2.getEmail()).thenReturn("jane.doe@example.org");
//        when(userDto2.getName()).thenReturn("Name");
//        when(userDto2.getPassword()).thenReturn("");
//        doNothing().when(userDto2).setAbout(Mockito.<String>any());
//        doNothing().when(userDto2).setEmail(Mockito.<String>any());
//        doNothing().when(userDto2).setId(anyInt());
//        doNothing().when(userDto2).setName(Mockito.<String>any());
//        doNothing().when(userDto2).setPassword(Mockito.<String>any());
//        doNothing().when(userDto2).setRoles(Mockito.<Set<RoleDto>>any());
//        userDto2.setAbout("About");
//        userDto2.setEmail("jane.doe@example.org");
//        userDto2.setId(1);
//        userDto2.setName("Name");
//        userDto2.setPassword("iloveyou");
//        userDto2.setRoles(new HashSet<>());
//
//        // Act and Assert
//        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.updateUser(userDto2, 1));
//        verify(userDto2).getAbout();
//        verify(userDto2).getEmail();
//        verify(userDto2).getName();
//        verify(userDto2, atLeast(1)).getPassword();
//        verify(userDto2).setAbout(eq("About"));
//        verify(userDto2).setEmail(eq("jane.doe@example.org"));
//        verify(userDto2).setId(eq(1));
//        verify(userDto2).setName(eq("Name"));
//        verify(userDto2).setPassword(eq("iloveyou"));
//        verify(userDto2).setRoles(isA(Set.class));
//        verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
//        verify(userRepo).findById(eq(1));
//        verify(userRepo).save(isA(User.class));
//    }

    /**
     * Method under test: {@link UserServiceImpl#getUserById(Integer)}
     */
    @Test
    void GetUserById_Test() {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any())).thenReturn(userDto);

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        UserDto actualUserById = userServiceImpl.getUserById(1);

        // Assert
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(userRepo).findById(eq(1));
        assertSame(userDto, actualUserById);
    }

    /**
     * Method under test: {@link UserServiceImpl#getUserById(Integer)}
     */
    @Test
    void GetUserById_Test2() {
        // Arrange
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.getUserById(1));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(userRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link UserServiceImpl#getUserById(Integer)}
     */
//    @Test
//    void GetUserById_Test3() {
//        // Arrange
//        UserDto userDto = new UserDto();
//        userDto.setAbout("About");
//        userDto.setEmail("jane.doe@example.org");
//        userDto.setId(1);
//        userDto.setName("Name");
//        userDto.setPassword("iloveyou");
//        userDto.setRoles(new HashSet<>());
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Map");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any())).thenReturn(userDto);
//        Optional<User> emptyResult = Optional.empty();
//        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
//
//        // Act and Assert
//        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.getUserById(1));
//        verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
//        verify(userRepo).findById(eq(1));
//    }

    /**
     * Method under test: {@link UserServiceImpl#getAllUsers()}
     */
    @Test
    void GetAllUsers_Test() {
        // Arrange
        when(userRepo.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<UserDto> actualAllUsers = userServiceImpl.getAllUsers();

        // Assert
        verify(userRepo).findAll();
        assertTrue(actualAllUsers.isEmpty());
    }

    /**
     * Method under test: {@link UserServiceImpl#getAllUsers()}
     */
    @Test
    void GetAllUsers_Test2() {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any())).thenReturn(userDto);

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepo.findAll()).thenReturn(userList);

        // Act
        List<UserDto> actualAllUsers = userServiceImpl.getAllUsers();

        // Assert
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(userRepo).findAll();
        assertEquals(1, actualAllUsers.size());
        assertSame(userDto, actualAllUsers.get(0));
    }

    /**
     * Method under test: {@link UserServiceImpl#getAllUsers()}
     */
    @Test
    void GetAllUsers_Test3() {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any())).thenReturn(userDto);

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        User user2 = new User();
        user2.setAbout("42");
        user2.setEmail("john.smith@example.org");
        user2.setId(2);
        user2.setName("42");
        user2.setPassword("Password");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user2);
        userList.add(user);
        when(userRepo.findAll()).thenReturn(userList);

        // Act
        List<UserDto> actualAllUsers = userServiceImpl.getAllUsers();

        // Assert
        verify(modelMapper, atLeast(1)).map(Mockito.<Object>any(), isA(Class.class));
        verify(userRepo).findAll();
        assertEquals(2, actualAllUsers.size());
        assertSame(userDto, actualAllUsers.get(0));
        assertSame(userDto, actualAllUsers.get(1));
    }

    /**
     * Method under test: {@link UserServiceImpl#getAllUsers()}
     */
    @Test
    void GetAllUsers_Test4() {
        // Arrange
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepo.findAll()).thenReturn(userList);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.getAllUsers());
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(userRepo).findAll();
    }

    /**
     * Method under test: {@link UserServiceImpl#deleteUser(Integer)}
     */
    @Test
    void DeleteUser_Test() {
        // Arrange
        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user);

        User user2 = new User();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());
        when(userRepo.save(Mockito.<User>any())).thenReturn(user2);
        doNothing().when(userRepo).delete(Mockito.<User>any());
        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        userServiceImpl.deleteUser(1);

        // Assert
        verify(userRepo).delete(isA(User.class));
        verify(userRepo).findById(eq(1));
        verify(userRepo).save(isA(User.class));
    }

    /**
     * Method under test: {@link UserServiceImpl#deleteUser(Integer)}
     */
    @Test
    void DeleteUser_Test2() {
        // Arrange
        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepo.save(Mockito.<User>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));
        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.deleteUser(1));
        verify(userRepo).findById(eq(1));
        verify(userRepo).save(isA(User.class));
    }

    /**
     * Method under test: {@link UserServiceImpl#deleteUser(Integer)}
     */
    @Test
    void DeleteUser_Test3() {
        // Arrange
        Optional<User> emptyResult = Optional.empty();
        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.deleteUser(1));
        verify(userRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link UserServiceImpl#registerNewUser(UserDto)}
     */
    @Test
    void RegisterNewUser_Test() {
        // Arrange
        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<User>>any())).thenReturn(user);

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Optional<Role> ofResult = Optional.of(role);
        when(roleRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(userRepo.save(Mockito.<User>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.registerNewUser(userDto));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(roleRepo).findById(eq(502));
        verify(userRepo).save(isA(User.class));
        verify(passwordEncoder).encode(isA(CharSequence.class));
    }

    /**
     * Method under test: {@link UserServiceImpl#registerNewUser(UserDto)}
     */
//    @Test
//    void RegisterNewUser_Test2() {
//        // Arrange
//        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
//        User user = mock(User.class);
//        when(user.getPassword()).thenReturn("iloveyou");
//        doNothing().when(user).setAbout(Mockito.<String>any());
//        doNothing().when(user).setEmail(Mockito.<String>any());
//        doNothing().when(user).setId(anyInt());
//        doNothing().when(user).setName(Mockito.<String>any());
//        doNothing().when(user).setPassword(Mockito.<String>any());
//        doNothing().when(user).setPosts(Mockito.<List<Post>>any());
//        doNothing().when(user).setRoles(Mockito.<Set<Role>>any());
//        user.setAbout("About");
//        user.setEmail("jane.doe@example.org");
//        user.setId(1);
//        user.setName("Name");
//        user.setPassword("iloveyou");
//        user.setPosts(new ArrayList<>());
//        user.setRoles(new HashSet<>());
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Map");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<User>>any())).thenReturn(user);
//        Optional<Role> emptyResult = Optional.empty();
//        when(roleRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
//
//        UserDto userDto = new UserDto();
//        userDto.setAbout("About");
//        userDto.setEmail("jane.doe@example.org");
//        userDto.setId(1);
//        userDto.setName("Name");
//        userDto.setPassword("iloveyou");
//        userDto.setRoles(new HashSet<>());
//
//        // Act and Assert
//        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.registerNewUser(userDto));
//        verify(user).getPassword();
//        verify(user).setAbout(eq("About"));
//        verify(user).setEmail(eq("jane.doe@example.org"));
//        verify(user).setId(eq(1));
//        verify(user).setName(eq("Name"));
//        verify(user, atLeast(1)).setPassword(Mockito.<String>any());
//        verify(user).setPosts(isA(List.class));
//        verify(user).setRoles(isA(Set.class));
//        verify(modelMapper, atLeast(1)).map(isA(Object.class), isA(Class.class));
//        verify(roleRepo).findById(eq(502));
//        verify(passwordEncoder).encode(isA(CharSequence.class));
//    }
}
