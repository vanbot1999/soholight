package com.soholighting.sohoTeam8.repository.impl;

import com.soholighting.sohoTeam8.model.Sponsors;
import com.soholighting.sohoTeam8.repository.SponsorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SponsorRepositoryTest {
    @Mock
    private DataSource dataSource;

    private Sponsors sponsor;

    @InjectMocks
    private SponsorRepository sponsorRepository;

    @BeforeEach
    void setUp() {
        sponsor = new Sponsors(1,"SponsorName", "https://sponsor.url", "logo.jpg");
        sponsorRepository = new SponsorRepository(dataSource);
    }

    @Test
    void findAllSponsors() throws SQLException {
        List<Sponsors> expectedSponsors = Arrays.asList(new Sponsors(), new Sponsors());
        when(dataSource.getConnection()).thenReturn(mock(Connection.class));
        when(dataSource.getConnection().createStatement()).thenReturn(mock(Statement.class));
        when(dataSource.getConnection().createStatement().executeQuery(anyString())).thenReturn(mock(ResultSet.class));
        when(dataSource.getConnection().createStatement().executeQuery(anyString()).next()).thenReturn(true, true, false);
        when(dataSource.getConnection().createStatement().executeQuery(anyString()).getInt("Sponsor_id")).thenReturn(1, 2);
        when(dataSource.getConnection().createStatement().executeQuery(anyString()).getString("name")).thenReturn("Sponsor1", "Sponsor2");
        when(dataSource.getConnection().createStatement().executeQuery(anyString()).getString("Url")).thenReturn("https://sponsor1.url", "https://sponsor2.url");
        when(dataSource.getConnection().createStatement().executeQuery(anyString()).getString("Sponsor_logo")).thenReturn("logo1.jpg", "logo2.jpg");

        List<Sponsors> result = sponsorRepository.findAllSponsors();

        assertEquals(expectedSponsors.size(), result.size());
    }
    @Test
    void insertSponsor() throws Exception {
        // Mock DataSource and related objects
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);

        when(dataSource.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);

        // Call the method to be tested
        sponsorRepository.insertSponsor(sponsor);

        // Verify the expected behavior
        verify(preparedStatement, times(1)).executeUpdate();
    }

    @Test
    void removeSponsorById() throws Exception {
        // Mock DataSource and related objects
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);

        when(dataSource.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);

        // Call the method to be tested
        sponsorRepository.removeSponsorById(1);

        // Verify the expected behavior
        verify(preparedStatement, times(1)).executeUpdate();
    }


}
