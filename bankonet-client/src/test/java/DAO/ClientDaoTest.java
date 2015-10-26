package DAO;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.bankonet.Client;

public class ClientDaoTest {

	@Test
	public void testRecupereClient() {
		Client client = new Client();
		ClientDao.recupereClient(client.getLogin(), client.getMotDePasse());
	}

}
