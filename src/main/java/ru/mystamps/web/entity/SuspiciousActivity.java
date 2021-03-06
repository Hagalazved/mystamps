/*
 * Copyright (C) 2009-2016 Slava Semushin <slava.semushin@gmail.com>
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
package ru.mystamps.web.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "suspicious_activities")
@Getter
@Setter
public class SuspiciousActivity {
	
	public static final int PAGE_URL_LENGTH     = 100;
	public static final int METHOD_LENGTH       = 7;
	public static final int IP_LENGTH           = 15;
	public static final int REFERER_PAGE_LENGTH = 255;
	public static final int USER_AGENT_LENGTH   = 255;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private SuspiciousActivityType type;
	
	@Column(name = "occurred_at", nullable = false)
	private Date occurredAt;
	
	@Column(length = PAGE_URL_LENGTH, nullable = false)
	private String page;

	@Column(length = METHOD_LENGTH)
	private String method;
	
	@ManyToOne
	private User user;
	
	@Column(length = IP_LENGTH, nullable = false)
	private String ip;
	
	@Column(name = "referer_page", length = REFERER_PAGE_LENGTH)
	private String refererPage;
	
	@Column(name = "user_agent", length = USER_AGENT_LENGTH)
	private String userAgent;
	
}
