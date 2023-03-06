package com.cursoandroid.mysubscribers.repository

import com.cursoandroid.mysubscribers.data.dao.SubscriberDAO
import com.cursoandroid.mysubscribers.data.entity.SubscriberEntity

class DatabaseDataSource(private val subscriberDAO: SubscriberDAO): SubscriberRepository {

    override suspend fun insertSubscriber(name: String, email: String): Long {
        val subscriber = SubscriberEntity(
            name = name,
            email = email
        )
        return subscriberDAO.insert(subscriber)
    }

    override suspend fun updateSubscriber(id: Long, name: String, email: String) {
        val subscriber = SubscriberEntity(
            id = id,
            name = name,
            email = email
        )
        return subscriberDAO.update(subscriber)
    }

    override suspend fun deleteSubscriber(id: Long) {
        subscriberDAO.delete(id)
    }

    override suspend fun deleteAllSubscribers() {
        subscriberDAO.deleteAll()
    }

    override suspend fun getAllSubscribers(): List<SubscriberEntity> {
        return subscriberDAO.getAll()
    }

}