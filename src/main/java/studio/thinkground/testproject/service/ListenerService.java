package studio.thinkground.testproject.service;

import studio.thinkground.testproject.data.entity.Listener;

public interface ListenerService {

    Listener getEntity(Long id);

    void saveEntity(Listener listener);

    void updateEntity(Listener listener);

    void removeEntity(Listener listener);

}
