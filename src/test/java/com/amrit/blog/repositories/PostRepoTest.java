//package com.amrit.blog.repositories;
//
//import com.amrit.blog.entities.Category;
//import com.amrit.blog.entities.Post;
//import com.amrit.blog.entities.User;
//
//import java.time.LocalDate;
//import java.time.ZoneOffset;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashSet;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ContextConfiguration;
//
//@ContextConfiguration(classes = {PostRepo.class})
//@EnableAutoConfiguration
//@EntityScan(basePackages = {"com.amrit.blog.entities"})
//@DataJpaTest
//class PostRepoTest {
//    @Autowired
//    private PostRepo postRepo;
//
//    /**
//     * Method under test: {@link PostRepo#findByUser(User)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void FindByUser_Test() {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement; SQL [n/a]; constraint [FKIJNWR3BRS8VAOSL80JG9RP7UC]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement
//        //       at jdk.proxy4/jdk.proxy4.$Proxy184.save(Unknown Source)
//        //   org.hibernate.exception.ConstraintViolationException: could not execute statement
//        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:59)
//        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:37)
//        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:113)
//        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:99)
//        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:200)
//        //       at org.hibernate.dialect.identity.GetGeneratedKeysDelegate.executeAndExtract(GetGeneratedKeysDelegate.java:58)
//        //       at org.hibernate.id.insert.AbstractReturningDelegate.performInsert(AbstractReturningDelegate.java:43)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3279)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3885)
//        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:84)
//        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:645)
//        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:282)
//        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:263)
//        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:317)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:330)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:287)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:193)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:123)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:185)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:128)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:55)
//        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)
//        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:756)
//        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:742)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy180.persist(Unknown Source)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy184.save(Unknown Source)
//        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKIJNWR3BRS8VAOSL80JG9RP7UC: PUBLIC.POSTS FOREIGN KEY(CATEGORY_ID) REFERENCES PUBLIC.CATEGORIES(CATEGORY_ID) (1)"; SQL statement:
//        //   insert into posts (post_id, added_date, category_id, content, post_title, user_id) values (default, ?, ?, ?, ?, ?) [23506-214]
//        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:508)
//        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:477)
//        //       at org.h2.message.DbException.get(DbException.java:223)
//        //       at org.h2.message.DbException.get(DbException.java:199)
//        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
//        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
//        //       at org.h2.table.Table.fireConstraints(Table.java:1172)
//        //       at org.h2.table.Table.fireAfterRow(Table.java:1190)
//        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
//        //       at org.h2.command.dml.Insert.update(Insert.java:135)
//        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
//        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
//        //       at org.h2.command.Command.executeUpdate(Command.java:252)
//        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:209)
//        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:169)
//        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
//        //       at org.hibernate.dialect.identity.GetGeneratedKeysDelegate.executeAndExtract(GetGeneratedKeysDelegate.java:58)
//        //       at org.hibernate.id.insert.AbstractReturningDelegate.performInsert(AbstractReturningDelegate.java:43)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3279)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3885)
//        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:84)
//        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:645)
//        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:282)
//        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:263)
//        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:317)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:330)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:287)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:193)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:123)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:185)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:128)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:55)
//        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)
//        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:756)
//        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:742)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy180.persist(Unknown Source)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy184.save(Unknown Source)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        // Arrange
//        Category category = new Category();
//        category.setCategoryDescription("Category Description");
//        category.setCategoryId(1);
//        category.setCategoryTitle("Dr");
//        category.setPosts(new ArrayList<>());
//
//        User user = new User();
//        user.setAbout("About");
//        user.setEmail("jane.doe@example.org");
//        user.setId(1);
//        user.setName("Name");
//        user.setPassword("iloveyou");
//        user.setPosts(new ArrayList<>());
//        user.setRoles(new HashSet<>());
//
//        Post post = new Post();
//        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        post.setCategory(category);
//        post.setContent("Not all who wander are lost");
//        post.setTitle("Dr");
//        post.setUser(user);
//
//        Category category2 = new Category();
//        category2.setCategoryDescription("42");
//        category2.setCategoryId(2);
//        category2.setCategoryTitle("Mr");
//        category2.setPosts(new ArrayList<>());
//
//        User user2 = new User();
//        user2.setAbout("42");
//        user2.setEmail("john.smith@example.org");
//        user2.setId(2);
//        user2.setName("42");
//        user2.setPassword("Password");
//        user2.setPosts(new ArrayList<>());
//        user2.setRoles(new HashSet<>());
//
//        Post post2 = new Post();
//        post2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        post2.setCategory(category2);
//        post2.setContent("Content");
//        post2.setTitle("Mr");
//        post2.setUser(user2);
//        postRepo.save(post);
//        postRepo.save(post2);
//
//        User user3 = new User();
//        user3.setAbout("About");
//        user3.setEmail("jane.doe@example.org");
//        user3.setName("Name");
//        user3.setPassword("iloveyou");
//        user3.setPosts(new ArrayList<>());
//        user3.setRoles(new HashSet<>());
//
//        // Act
//        postRepo.findByUser(user3);
//    }
//
//    /**
//     * Method under test: {@link PostRepo#findByCategory(Category)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void FindByCategory_Test() {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement; SQL [n/a]; constraint [FKIJNWR3BRS8VAOSL80JG9RP7UC]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement
//        //       at jdk.proxy4/jdk.proxy4.$Proxy184.save(Unknown Source)
//        //   org.hibernate.exception.ConstraintViolationException: could not execute statement
//        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:59)
//        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:37)
//        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:113)
//        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:99)
//        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:200)
//        //       at org.hibernate.dialect.identity.GetGeneratedKeysDelegate.executeAndExtract(GetGeneratedKeysDelegate.java:58)
//        //       at org.hibernate.id.insert.AbstractReturningDelegate.performInsert(AbstractReturningDelegate.java:43)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3279)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3885)
//        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:84)
//        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:645)
//        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:282)
//        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:263)
//        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:317)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:330)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:287)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:193)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:123)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:185)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:128)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:55)
//        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)
//        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:756)
//        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:742)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy180.persist(Unknown Source)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy184.save(Unknown Source)
//        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKIJNWR3BRS8VAOSL80JG9RP7UC: PUBLIC.POSTS FOREIGN KEY(CATEGORY_ID) REFERENCES PUBLIC.CATEGORIES(CATEGORY_ID) (1)"; SQL statement:
//        //   insert into posts (post_id, added_date, category_id, content, post_title, user_id) values (default, ?, ?, ?, ?, ?) [23506-214]
//        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:508)
//        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:477)
//        //       at org.h2.message.DbException.get(DbException.java:223)
//        //       at org.h2.message.DbException.get(DbException.java:199)
//        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
//        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
//        //       at org.h2.table.Table.fireConstraints(Table.java:1172)
//        //       at org.h2.table.Table.fireAfterRow(Table.java:1190)
//        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
//        //       at org.h2.command.dml.Insert.update(Insert.java:135)
//        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
//        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
//        //       at org.h2.command.Command.executeUpdate(Command.java:252)
//        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:209)
//        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:169)
//        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
//        //       at org.hibernate.dialect.identity.GetGeneratedKeysDelegate.executeAndExtract(GetGeneratedKeysDelegate.java:58)
//        //       at org.hibernate.id.insert.AbstractReturningDelegate.performInsert(AbstractReturningDelegate.java:43)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3279)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3885)
//        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:84)
//        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:645)
//        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:282)
//        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:263)
//        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:317)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:330)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:287)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:193)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:123)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:185)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:128)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:55)
//        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)
//        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:756)
//        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:742)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy180.persist(Unknown Source)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy184.save(Unknown Source)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        // Arrange
//        Category category = new Category();
//        category.setCategoryDescription("Category Description");
//        category.setCategoryId(1);
//        category.setCategoryTitle("Dr");
//        category.setPosts(new ArrayList<>());
//
//        User user = new User();
//        user.setAbout("About");
//        user.setEmail("jane.doe@example.org");
//        user.setId(1);
//        user.setName("Name");
//        user.setPassword("iloveyou");
//        user.setPosts(new ArrayList<>());
//        user.setRoles(new HashSet<>());
//
//        Post post = new Post();
//        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        post.setCategory(category);
//        post.setContent("Not all who wander are lost");
//        post.setTitle("Dr");
//        post.setUser(user);
//
//        Category category2 = new Category();
//        category2.setCategoryDescription("42");
//        category2.setCategoryId(2);
//        category2.setCategoryTitle("Mr");
//        category2.setPosts(new ArrayList<>());
//
//        User user2 = new User();
//        user2.setAbout("42");
//        user2.setEmail("john.smith@example.org");
//        user2.setId(2);
//        user2.setName("42");
//        user2.setPassword("Password");
//        user2.setPosts(new ArrayList<>());
//        user2.setRoles(new HashSet<>());
//
//        Post post2 = new Post();
//        post2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        post2.setCategory(category2);
//        post2.setContent("Content");
//        post2.setTitle("Mr");
//        post2.setUser(user2);
//        postRepo.save(post);
//        postRepo.save(post2);
//
//        Category category3 = new Category();
//        category3.setCategoryDescription("Category Description");
//        category3.setCategoryTitle("Dr");
//        category3.setPosts(new ArrayList<>());
//
//        // Act
//        postRepo.findByCategory(category3);
//    }
//
//    /**
//     * Method under test: {@link PostRepo#searchByTitle(String)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void SearchByTitle_Test() {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement; SQL [n/a]; constraint [FKIJNWR3BRS8VAOSL80JG9RP7UC]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement
//        //       at jdk.proxy4/jdk.proxy4.$Proxy184.save(Unknown Source)
//        //   org.hibernate.exception.ConstraintViolationException: could not execute statement
//        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:59)
//        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:37)
//        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:113)
//        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:99)
//        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:200)
//        //       at org.hibernate.dialect.identity.GetGeneratedKeysDelegate.executeAndExtract(GetGeneratedKeysDelegate.java:58)
//        //       at org.hibernate.id.insert.AbstractReturningDelegate.performInsert(AbstractReturningDelegate.java:43)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3279)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3885)
//        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:84)
//        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:645)
//        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:282)
//        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:263)
//        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:317)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:330)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:287)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:193)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:123)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:185)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:128)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:55)
//        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)
//        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:756)
//        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:742)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy180.persist(Unknown Source)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy184.save(Unknown Source)
//        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKIJNWR3BRS8VAOSL80JG9RP7UC: PUBLIC.POSTS FOREIGN KEY(CATEGORY_ID) REFERENCES PUBLIC.CATEGORIES(CATEGORY_ID) (1)"; SQL statement:
//        //   insert into posts (post_id, added_date, category_id, content, post_title, user_id) values (default, ?, ?, ?, ?, ?) [23506-214]
//        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:508)
//        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:477)
//        //       at org.h2.message.DbException.get(DbException.java:223)
//        //       at org.h2.message.DbException.get(DbException.java:199)
//        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
//        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
//        //       at org.h2.table.Table.fireConstraints(Table.java:1172)
//        //       at org.h2.table.Table.fireAfterRow(Table.java:1190)
//        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
//        //       at org.h2.command.dml.Insert.update(Insert.java:135)
//        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
//        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
//        //       at org.h2.command.Command.executeUpdate(Command.java:252)
//        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:209)
//        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:169)
//        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
//        //       at org.hibernate.dialect.identity.GetGeneratedKeysDelegate.executeAndExtract(GetGeneratedKeysDelegate.java:58)
//        //       at org.hibernate.id.insert.AbstractReturningDelegate.performInsert(AbstractReturningDelegate.java:43)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3279)
//        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3885)
//        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:84)
//        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:645)
//        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:282)
//        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:263)
//        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:317)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:330)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:287)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:193)
//        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:123)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:185)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:128)
//        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:55)
//        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)
//        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:756)
//        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:742)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy180.persist(Unknown Source)
//        //       at jdk.proxy4/jdk.proxy4.$Proxy184.save(Unknown Source)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        // Arrange
//        Category category = new Category();
//        category.setCategoryDescription("Category Description");
//        category.setCategoryId(1);
//        category.setCategoryTitle("Dr");
//        category.setPosts(new ArrayList<>());
//
//        User user = new User();
//        user.setAbout("About");
//        user.setEmail("jane.doe@example.org");
//        user.setId(1);
//        user.setName("Name");
//        user.setPassword("iloveyou");
//        user.setPosts(new ArrayList<>());
//        user.setRoles(new HashSet<>());
//
//        Post post = new Post();
//        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        post.setCategory(category);
//        post.setContent("Not all who wander are lost");
//        post.setTitle("Dr");
//        post.setUser(user);
//
//        Category category2 = new Category();
//        category2.setCategoryDescription("42");
//        category2.setCategoryId(2);
//        category2.setCategoryTitle("Mr");
//        category2.setPosts(new ArrayList<>());
//
//        User user2 = new User();
//        user2.setAbout("42");
//        user2.setEmail("john.smith@example.org");
//        user2.setId(2);
//        user2.setName("42");
//        user2.setPassword("Password");
//        user2.setPosts(new ArrayList<>());
//        user2.setRoles(new HashSet<>());
//
//        Post post2 = new Post();
//        post2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        post2.setCategory(category2);
//        post2.setContent("Content");
//        post2.setTitle("Mr");
//        post2.setUser(user2);
//        postRepo.save(post);
//        postRepo.save(post2);
//
//        // Act
//        postRepo.searchByTitle("Dr");
//    }
//}
