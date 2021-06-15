package final_project.web;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import final_project.model.DebitCard;

@Path("/debit")
public class DebitService {
	
	@POST
	@Path("check")
    @Produces(MediaType.TEXT_XML)
    public Response paymentAllowed(final DebitCard input) {
		double price = 10;
		if (input != null) {
			int cardIndex = cardExists(input.getId(), input.getDate(), input.getCvc());
			if (cardIndex != -1) {
				DebitCard card = cards.get(cardIndex);
				// if card is ok on balance
				return Response.ok("{\"cardExists\": true, \"transaction\": true}", MediaType.APPLICATION_JSON).build();
			}
		}
		// return 404
		return Response.ok("{\"cardExists\": false, \"transaction\": false}", MediaType.APPLICATION_JSON).build();
    }
	
	private int cardExists(String id, String date, String cvc) {
		DebitCard card;
		for(int i = 0; i < cards.size(); i++) {
			card = cards.get(i);
			if (card.getId().equals(id) &&
				card.getDate().equals(date) && 
				card.getCvc().equals(cvc)) {
				return i;
			}
		}
		return -1;
		
		// Return index of card if it exists
		// Else it returns -1
	}
	
	private static ArrayList<DebitCard> cards = generateCards(); 
	
	public static ArrayList<DebitCard> generateCards() {
		ArrayList<DebitCard> list = new ArrayList<DebitCard>();
		
		DebitCard card1 = new DebitCard("1111222233334444", "111", "112024");
		DebitCard card2 = new DebitCard("1111222233335555", "111", "112024");
		DebitCard card3 = new DebitCard("1111222233336666", "111", "112024");
		DebitCard card4 = new DebitCard("1111222233337777", "111", "112024");
		
		list.add(card1);
		list.add(card2);
		list.add(card3);
		list.add(card4);

		return list;
	}
}
