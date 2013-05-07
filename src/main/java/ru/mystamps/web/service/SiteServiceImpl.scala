/*
 * Copyright (C) 2009-2013 Slava Semushin <slava.semushin@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package ru.mystamps.web.service

import javax.inject.Inject

import java.util.Date

import org.apache.commons.lang3.{StringUtils, Validate}

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import ru.mystamps.web.dao.{SuspiciousActivityDao, SuspiciousActivityTypeDao}
import ru.mystamps.web.entity.{User, SuspiciousActivity, SuspiciousActivityType}

@Service
class SiteServiceImpl implements SiteService {
	
	@Inject
	private SuspiciousActivityDao suspiciousActivities

	@Inject
	private SuspiciousActivityTypeDao suspiciousActivityTypes
	
	@SuppressWarnings("PMD.UseObjectForClearerAPI")
	@Transactional
	override def logAboutAbsentPage(
			page: String,
			user: User,
			ip: String,
			referer: String,
			agent: String): Unit = {
		
		logEvent(getAbsentPageType(), page, user, ip, referer, agent)
	}
	
	@SuppressWarnings("PMD.UseObjectForClearerAPI")
	@Transactional
	override def logAboutFailedAuthentication(
			page: String,
			user: User,
			ip: String,
			referer: String,
			agent: String): Unit = {
		
		logEvent(getFailedAuthenticationType(), page, user, ip, referer, agent)
	}
	
	private def logEvent(
			type: SuspiciousActivityType,
			page: String,
			user: User,
			ip: String,
			referer: String,
			agent: String): Unit = {
		
		Validate.isTrue(type != null, "Type of suspicious activity was not set")
		Validate.isTrue(page != null, "Page should be non null")
		
		SuspiciousActivity activity = new SuspiciousActivity()
		activity.setType(type)
		activity.setOccuredAt(new Date())
		activity.setPage(page)
		
		activity.setUser(user)
		
		activity.setIp(StringUtils.defaultString(ip))
		activity.setRefererPage(StringUtils.defaultString(referer))
		activity.setUserAgent(StringUtils.defaultString(agent))
		
		suspiciousActivities.save(activity)
	}
	
	private def getAbsentPageType() : SuspiciousActivity = {
		// see src/main/resources/{dev,test}/init-data.sql
		return suspiciousActivityTypes.findByName("PageNotFound")
	}
	
	private def getFailedAuthenticationType(): SuspiciousActivityType = {
		// see src/main/resources/{dev,test}/init-data.sql
		return suspiciousActivityTypes.findByName("AuthenticationFailed")
	}
	
}
