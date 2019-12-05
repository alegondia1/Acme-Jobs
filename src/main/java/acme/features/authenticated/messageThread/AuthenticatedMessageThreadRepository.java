
package acme.features.authenticated.messageThread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messageThread.Message;
import acme.entities.messageThread.MessageThread;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageThreadRepository extends AbstractRepository {

	@Query("select m from MessageThread m where m.id = ?1")
	MessageThread findOneById(int id);

	@Query("select m from MessageThread m")
	Collection<MessageThread> findManyAll();

	@Query("select u.messageThread from UserInvolved u join u.messageThread where u.user.id = ?1")
	Collection<MessageThread> findManyAllByUser(int id);

	@Query("select m from Message m  where m.id = ?1")
	Message findOneMessageById(int id);

}
