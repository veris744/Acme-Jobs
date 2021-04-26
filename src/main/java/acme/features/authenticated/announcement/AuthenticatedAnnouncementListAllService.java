package acme.features.authenticated.announcement;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcements.Announcement;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAnnouncementListAllService implements AbstractListService<Authenticated, Announcement> {
	
	@Autowired
	AuthenticatedAnnouncementRepository repository;
	
	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;
		return true;
	}
	
	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "status", "text", "info");
	}
	
	@Override
	public Collection<Announcement> findMany(final Request<Announcement> request) {
		assert request != null;
		
		Collection<Announcement> result;
		
		result = this.repository.findAllAnnouncements();
		return result;
	}
}