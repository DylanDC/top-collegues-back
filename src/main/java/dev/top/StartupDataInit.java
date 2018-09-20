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
			this.collegue.save(new Collegue(0, "Arwen", "https://randomuser.me/api/portraits/women/60.jpg", "8b2d3ac7",
					"Hahn", "Nellie", "nelliehahn@sultraxin.com", "1978-10-09T05:15:33 -02:00", "female",
					"442 Tillary Street, Bordelonville, 8990"));
			this.collegue.save(new Collegue(0, "Daeron", "https://randomuser.me/api/portraits/men/90.jpg", "75e8048c",
					"Bullock", "Jackson", "jacksonbullock@sultraxin.com", "1971-02-16T08:37:15 -01:00", "male",
					"289 Gardner Avenue, Gilmore, 7992"));
		}

	}
}
