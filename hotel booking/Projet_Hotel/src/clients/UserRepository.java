package clients;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import entity.Hotel;


public class UserRepository {

	private Hotel hotel;

	private static Map<String, Client> allUsers;

	public UserRepository(Hotel hotel) {
		this.setHotel(hotel);
		allUsers = new TreeMap<String, Client>();
		ArrayList<Client> clientList = hotel.getClients();
		for (Client client : clientList) {
			allUsers.put(client.getLastName()+" "+client.getFirstName(), client);
		}

		
	}

	/**
	 * Gets the information on the user with the specified first name.
	 * 
	 * @param firstName
	 *            First name.
	 * @return Matching user info.
	 */
	public static Client getUserInfo(String firstName) {
		return allUsers.get(firstName);
	}

	/**
	 * Gets all users.
	 * 
	 * @return All users.
	 */
	public static Client[] getAllUsers() {
		return allUsers.values().toArray(new Client[] {});
	}

	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
