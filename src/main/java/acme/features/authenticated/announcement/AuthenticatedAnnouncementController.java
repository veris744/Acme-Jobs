package acme.features.authenticated.announcement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.announcements.Announcement;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/announcement/")
public class AuthenticatedAnnouncementController  extends AbstractController<Authenticated, Announcement> {

	// Internal state ---------------------------------------------------------

		@Autowired
		protected AuthenticatedAnnouncementListAllService	listAllService;

		@Autowired
		protected AuthenticatedAnnouncementListRecentService	listRecentService;

		@Autowired
		protected AuthenticatedAnnouncementShowService	showService;

		@Autowired
		protected AuthenticatedAnnouncementCreateService	createService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCustomCommand(CustomCommand.LIST_ALL, BasicCommand.LIST, this.listAllService);
			super.addCustomCommand(CustomCommand.LIST_RECENT, BasicCommand.LIST, this.listRecentService);
			super.addBasicCommand(BasicCommand.SHOW, this.showService);
			super.addBasicCommand(BasicCommand.CREATE, this.createService);
		}
}
