package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenCollectAddresses() {

        List<Address> addresses = List.of(
           new Address("Berlin", "MorgenStrasse", 12, 2),
           new Address("London", "Roadsreat", 34, 7),
           new Address("Milan", "Viagrande", 56, 7)
        );
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(addresses.get(0)));
        profiles.add(new Profile(addresses.get(1)));
        profiles.add(new Profile(addresses.get(2)));
        Function<Profile, Address> profileAddressFunction = profile -> profile.getAddress();
        List<Address> result = new Profiles().collect(profiles);
        assertThat(result, is(addresses));
    }
}