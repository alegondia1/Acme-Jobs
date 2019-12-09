
package acme.features.authenticated.messageThread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messageThread.Message;
import acme.entities.messageThread.MessageThread;
import acme.entities.messageThread.UserInvolved;
import acme.framework.entities.Authenticated;
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

	@Query("select u.user from UserInvolved u join u.messageThread where u.messageThread.id = ?1")
	Collection<Authenticated> findUserByThreadId(int id);

	@Query("select u from Authenticated u where u.id = ?1")
	Authenticated finUserById(int activeRoleId);

	@Query("select u from UserInvolved u join u.messageThread where u.messageThread.id = ?1")
	Collection<UserInvolved> findUserInvolvedByThreadId(int threadId);

	@Query("select u from Authenticated u where u.userAccount.username = ?1")
	Authenticated findUserByUsername(String username);

	@Query("select u from Authenticated u where u.id = ?1")
	Authenticated findUSerById(int activeRoleId);

	@Query("select u from UserInvolved u where u.id = ?1")
	UserInvolved findUserInvolvedById(int id);

}
