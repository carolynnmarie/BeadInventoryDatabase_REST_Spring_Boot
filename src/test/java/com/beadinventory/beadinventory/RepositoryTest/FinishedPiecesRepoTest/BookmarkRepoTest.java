package com.beadinventory.beadinventory.RepositoryTest.FinishedPiecesRepoTest;

import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.BookmarkRepo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class BookmarkRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookmarkRepo bookmarkRepo;


}
