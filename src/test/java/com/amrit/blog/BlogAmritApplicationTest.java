package com.amrit.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;

import com.amrit.blog.config.AppConstants;
import com.amrit.blog.entities.Role;
import com.amrit.blog.repositories.RoleRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.modelmapper.internal.InheritingConfiguration;
import org.modelmapper.internal.TypeResolvingList;
import org.modelmapper.internal.converter.MergingCollectionConverter;
import org.modelmapper.internal.valueaccess.MapValueReader;
import org.modelmapper.internal.valuemutate.MapValueWriter;
import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.NameTokenizer;
import org.modelmapper.spi.ValueReader;
import org.modelmapper.spi.ValueWriter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class BlogAmritApplicationTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private RoleRepo roleRepo;

    @InjectMocks
    private BlogAmritApplication blogAmritApplication;

    /**
     * Method under test: {@link BlogAmritApplication#modelMapper()}
     */
    @Test
    void ModelMapper_Test() {
        // Arrange and Act
        ModelMapper actualModelMapperResult = (new BlogAmritApplication()).modelMapper();

        // Assert
        Configuration configuration = actualModelMapperResult.getConfiguration();
        assertTrue(configuration instanceof InheritingConfiguration);
        List<ValueReader<?>> valueReaders = configuration.getValueReaders();
        assertEquals(1, valueReaders.size());
        assertTrue(valueReaders instanceof TypeResolvingList);
        List<ValueWriter<?>> valueWriters = configuration.getValueWriters();
        assertEquals(1, valueWriters.size());
        assertTrue(valueWriters instanceof TypeResolvingList);
        List<ConditionalConverter<?, ?>> converters = configuration.getConverters();
        assertEquals(14, converters.size());
        assertTrue(converters.get(1) instanceof MergingCollectionConverter);
        assertTrue(valueReaders.get(0) instanceof MapValueReader);
        ValueWriter<?> getResult = valueWriters.get(0);
        assertTrue(getResult instanceof MapValueWriter);
        assertNull(configuration.getPropertyCondition());
        assertNull(configuration.getProvider());
        assertEquals(Configuration.AccessLevel.PUBLIC, configuration.getFieldAccessLevel());
        assertEquals(Configuration.AccessLevel.PUBLIC, configuration.getMethodAccessLevel());
        assertFalse(configuration.isDeepCopyEnabled());
        assertFalse(getResult.isResolveMembersSupport());
        Collection<TypeMap<?, ?>> typeMaps = actualModelMapperResult.getTypeMaps();
        assertTrue(typeMaps.isEmpty());
        assertTrue(configuration.isCollectionsMergeEnabled());
        assertSame(typeMaps, ((InheritingConfiguration) configuration).typeMapStore.get());
        assertSame(converters, ((InheritingConfiguration) configuration).converterStore.getConverters());
        NameTokenizer expectedSourceNameTokenizer = configuration.getDestinationNameTokenizer();
        assertSame(expectedSourceNameTokenizer, configuration.getSourceNameTokenizer());
        assertSame((TypeResolvingList<ValueReader<?>>) valueReaders,
                ((InheritingConfiguration) configuration).valueAccessStore.getValueReaders());
        assertSame((TypeResolvingList<ValueWriter<?>>) valueWriters,
                ((InheritingConfiguration) configuration).valueMutateStore.getValueWriters());
    }

    public BlogAmritApplicationTest() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Method under test: {@link BlogAmritApplication#run(String[])}
     */
    @Test
    void Run_Test() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     BlogAmritApplication.passwordEncoder
        //     BlogAmritApplication.roleRepo

        // Arrange and Act
        (new BlogAmritApplication()).run("Args");
    }

    @Test
    void testRun() throws Exception {
        // Prepare test data
        Role roleAdmin = new Role();
        roleAdmin.setId(AppConstants.ADMIN_USER);
        roleAdmin.setName("ROLE_ADMIN");

        Role roleNormal = new Role();
        roleNormal.setId(AppConstants.NORMAL_USER);
        roleNormal.setName("ROLE_NORMAL");

        List<Role> roles = List.of(roleAdmin, roleNormal);

        // Mock behavior
        when(roleRepo.saveAll(anyList())).thenReturn(roles);

        // Execute the run method
        blogAmritApplication.run();

        // Verify the interaction with the repository
        verify(roleRepo).saveAll(anyList());

        // Optionally, you can check console output if needed, though it's generally not done in unit tests
        // You might use a logging framework or a custom solution for that purpose.
    }
}
