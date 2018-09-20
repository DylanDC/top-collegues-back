package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.repos.ColleguesRepo;

@Component
public class StartupDataInit {

	@Autowired
	ColleguesRepo collegue;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {

		if (this.collegue.count() <= 0) {
			this.collegue.save(new Collegue(0, "Aragorn",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(-1000, "Arwen",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(1000, "Daeron",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(500, "Eowyn",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(-500, "Gandalf",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
		}

	}
}
