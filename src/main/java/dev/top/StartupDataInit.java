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
			this.collegue.save(new Collegue(1000, "Djamel",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(-1000, "Gaetan",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(1000, "Flora",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(700, "Jordan",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(900, "Clement",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
		}

	}
}
