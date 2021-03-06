/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.pokedex.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.pokedex.model.Pokemon;
import com.liferay.pokedex.model.PokemonModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Pokemon service. Represents a row in the &quot;Pokemon&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PokemonModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PokemonImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PokemonImpl
 * @see Pokemon
 * @see PokemonModel
 * @generated
 */
@ProviderType
public class PokemonModelImpl extends BaseModelImpl<Pokemon>
	implements PokemonModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a pokemon model instance should use the {@link Pokemon} interface instead.
	 */
	public static final String TABLE_NAME = "Pokemon";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "id_", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "originalName", Types.VARCHAR },
			{ "customName", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "type_", Types.VARCHAR },
			{ "order_", Types.BIGINT },
			{ "frontImageURL", Types.VARCHAR },
			{ "frontShinyImageURL", Types.VARCHAR },
			{ "backImageURL", Types.VARCHAR },
			{ "backShinyImageURL", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("originalName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("customName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("order_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("frontImageURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("frontShinyImageURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("backImageURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("backShinyImageURL", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table Pokemon (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,originalName VARCHAR(75) null,customName VARCHAR(75) null,description STRING null,type_ VARCHAR(75) null,order_ LONG,frontImageURL VARCHAR(75) null,frontShinyImageURL VARCHAR(75) null,backImageURL VARCHAR(75) null,backShinyImageURL VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Pokemon";
	public static final String ORDER_BY_JPQL = " ORDER BY pokemon.order ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Pokemon.order_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.pokedex.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.pokedex.model.Pokemon"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.pokedex.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.pokedex.model.Pokemon"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.pokedex.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.pokedex.model.Pokemon"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long ORDER_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.pokedex.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.pokedex.model.Pokemon"));

	public PokemonModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Pokemon.class;
	}

	@Override
	public String getModelClassName() {
		return Pokemon.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("originalName", getOriginalName());
		attributes.put("customName", getCustomName());
		attributes.put("description", getDescription());
		attributes.put("type", getType());
		attributes.put("order", getOrder());
		attributes.put("frontImageURL", getFrontImageURL());
		attributes.put("frontShinyImageURL", getFrontShinyImageURL());
		attributes.put("backImageURL", getBackImageURL());
		attributes.put("backShinyImageURL", getBackShinyImageURL());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String originalName = (String)attributes.get("originalName");

		if (originalName != null) {
			setOriginalName(originalName);
		}

		String customName = (String)attributes.get("customName");

		if (customName != null) {
			setCustomName(customName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long order = (Long)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String frontImageURL = (String)attributes.get("frontImageURL");

		if (frontImageURL != null) {
			setFrontImageURL(frontImageURL);
		}

		String frontShinyImageURL = (String)attributes.get("frontShinyImageURL");

		if (frontShinyImageURL != null) {
			setFrontShinyImageURL(frontShinyImageURL);
		}

		String backImageURL = (String)attributes.get("backImageURL");

		if (backImageURL != null) {
			setBackImageURL(backImageURL);
		}

		String backShinyImageURL = (String)attributes.get("backShinyImageURL");

		if (backShinyImageURL != null) {
			setBackShinyImageURL(backShinyImageURL);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getOriginalName() {
		if (_originalName == null) {
			return StringPool.BLANK;
		}
		else {
			return _originalName;
		}
	}

	@Override
	public void setOriginalName(String originalName) {
		_originalName = originalName;
	}

	@Override
	public String getCustomName() {
		if (_customName == null) {
			return StringPool.BLANK;
		}
		else {
			return _customName;
		}
	}

	@Override
	public void setCustomName(String customName) {
		_customName = customName;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@Override
	public long getOrder() {
		return _order;
	}

	@Override
	public void setOrder(long order) {
		_columnBitmask = -1L;

		_order = order;
	}

	@Override
	public String getFrontImageURL() {
		if (_frontImageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _frontImageURL;
		}
	}

	@Override
	public void setFrontImageURL(String frontImageURL) {
		_frontImageURL = frontImageURL;
	}

	@Override
	public String getFrontShinyImageURL() {
		if (_frontShinyImageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _frontShinyImageURL;
		}
	}

	@Override
	public void setFrontShinyImageURL(String frontShinyImageURL) {
		_frontShinyImageURL = frontShinyImageURL;
	}

	@Override
	public String getBackImageURL() {
		if (_backImageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _backImageURL;
		}
	}

	@Override
	public void setBackImageURL(String backImageURL) {
		_backImageURL = backImageURL;
	}

	@Override
	public String getBackShinyImageURL() {
		if (_backShinyImageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _backShinyImageURL;
		}
	}

	@Override
	public void setBackShinyImageURL(String backShinyImageURL) {
		_backShinyImageURL = backShinyImageURL;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Pokemon.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Pokemon.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Pokemon toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Pokemon)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PokemonImpl pokemonImpl = new PokemonImpl();

		pokemonImpl.setUuid(getUuid());
		pokemonImpl.setId(getId());
		pokemonImpl.setGroupId(getGroupId());
		pokemonImpl.setCompanyId(getCompanyId());
		pokemonImpl.setUserId(getUserId());
		pokemonImpl.setUserName(getUserName());
		pokemonImpl.setCreateDate(getCreateDate());
		pokemonImpl.setModifiedDate(getModifiedDate());
		pokemonImpl.setOriginalName(getOriginalName());
		pokemonImpl.setCustomName(getCustomName());
		pokemonImpl.setDescription(getDescription());
		pokemonImpl.setType(getType());
		pokemonImpl.setOrder(getOrder());
		pokemonImpl.setFrontImageURL(getFrontImageURL());
		pokemonImpl.setFrontShinyImageURL(getFrontShinyImageURL());
		pokemonImpl.setBackImageURL(getBackImageURL());
		pokemonImpl.setBackShinyImageURL(getBackShinyImageURL());

		pokemonImpl.resetOriginalValues();

		return pokemonImpl;
	}

	@Override
	public int compareTo(Pokemon pokemon) {
		int value = 0;

		if (getOrder() < pokemon.getOrder()) {
			value = -1;
		}
		else if (getOrder() > pokemon.getOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Pokemon)) {
			return false;
		}

		Pokemon pokemon = (Pokemon)obj;

		long primaryKey = pokemon.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		PokemonModelImpl pokemonModelImpl = this;

		pokemonModelImpl._originalUuid = pokemonModelImpl._uuid;

		pokemonModelImpl._originalGroupId = pokemonModelImpl._groupId;

		pokemonModelImpl._setOriginalGroupId = false;

		pokemonModelImpl._originalCompanyId = pokemonModelImpl._companyId;

		pokemonModelImpl._setOriginalCompanyId = false;

		pokemonModelImpl._setModifiedDate = false;

		pokemonModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Pokemon> toCacheModel() {
		PokemonCacheModel pokemonCacheModel = new PokemonCacheModel();

		pokemonCacheModel.uuid = getUuid();

		String uuid = pokemonCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			pokemonCacheModel.uuid = null;
		}

		pokemonCacheModel.id = getId();

		pokemonCacheModel.groupId = getGroupId();

		pokemonCacheModel.companyId = getCompanyId();

		pokemonCacheModel.userId = getUserId();

		pokemonCacheModel.userName = getUserName();

		String userName = pokemonCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			pokemonCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			pokemonCacheModel.createDate = createDate.getTime();
		}
		else {
			pokemonCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			pokemonCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			pokemonCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		pokemonCacheModel.originalName = getOriginalName();

		String originalName = pokemonCacheModel.originalName;

		if ((originalName != null) && (originalName.length() == 0)) {
			pokemonCacheModel.originalName = null;
		}

		pokemonCacheModel.customName = getCustomName();

		String customName = pokemonCacheModel.customName;

		if ((customName != null) && (customName.length() == 0)) {
			pokemonCacheModel.customName = null;
		}

		pokemonCacheModel.description = getDescription();

		String description = pokemonCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			pokemonCacheModel.description = null;
		}

		pokemonCacheModel.type = getType();

		String type = pokemonCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			pokemonCacheModel.type = null;
		}

		pokemonCacheModel.order = getOrder();

		pokemonCacheModel.frontImageURL = getFrontImageURL();

		String frontImageURL = pokemonCacheModel.frontImageURL;

		if ((frontImageURL != null) && (frontImageURL.length() == 0)) {
			pokemonCacheModel.frontImageURL = null;
		}

		pokemonCacheModel.frontShinyImageURL = getFrontShinyImageURL();

		String frontShinyImageURL = pokemonCacheModel.frontShinyImageURL;

		if ((frontShinyImageURL != null) && (frontShinyImageURL.length() == 0)) {
			pokemonCacheModel.frontShinyImageURL = null;
		}

		pokemonCacheModel.backImageURL = getBackImageURL();

		String backImageURL = pokemonCacheModel.backImageURL;

		if ((backImageURL != null) && (backImageURL.length() == 0)) {
			pokemonCacheModel.backImageURL = null;
		}

		pokemonCacheModel.backShinyImageURL = getBackShinyImageURL();

		String backShinyImageURL = pokemonCacheModel.backShinyImageURL;

		if ((backShinyImageURL != null) && (backShinyImageURL.length() == 0)) {
			pokemonCacheModel.backShinyImageURL = null;
		}

		return pokemonCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", originalName=");
		sb.append(getOriginalName());
		sb.append(", customName=");
		sb.append(getCustomName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", order=");
		sb.append(getOrder());
		sb.append(", frontImageURL=");
		sb.append(getFrontImageURL());
		sb.append(", frontShinyImageURL=");
		sb.append(getFrontShinyImageURL());
		sb.append(", backImageURL=");
		sb.append(getBackImageURL());
		sb.append(", backShinyImageURL=");
		sb.append(getBackShinyImageURL());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.liferay.pokedex.model.Pokemon");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>originalName</column-name><column-value><![CDATA[");
		sb.append(getOriginalName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customName</column-name><column-value><![CDATA[");
		sb.append(getCustomName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order</column-name><column-value><![CDATA[");
		sb.append(getOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>frontImageURL</column-name><column-value><![CDATA[");
		sb.append(getFrontImageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>frontShinyImageURL</column-name><column-value><![CDATA[");
		sb.append(getFrontShinyImageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backImageURL</column-name><column-value><![CDATA[");
		sb.append(getBackImageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backShinyImageURL</column-name><column-value><![CDATA[");
		sb.append(getBackShinyImageURL());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Pokemon.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Pokemon.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _id;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _originalName;
	private String _customName;
	private String _description;
	private String _type;
	private long _order;
	private String _frontImageURL;
	private String _frontShinyImageURL;
	private String _backImageURL;
	private String _backShinyImageURL;
	private long _columnBitmask;
	private Pokemon _escapedModel;
}