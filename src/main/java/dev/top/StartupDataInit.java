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
			this.collegue.save(new Collegue(0, "Dev 1",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(-1000, "Dev 2",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(1000, "Dev 3",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(500, "Dev 4",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
			this.collegue.save(new Collegue(-500, "Dev 5 ",
					"https://s3-us-west-2.amazonaws.com/s.cdpn.io/1673994/profile/profile-512.jpg?1515254870"));
		}

	}
}
