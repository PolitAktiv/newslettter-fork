create table ZN_Category (
	categoryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name STRING null,
	description STRING null
);

create table ZN_Mailing (
	mailingId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	newsletterId LONG,
	newsletterName VARCHAR(255) null,
	emailFromName VARCHAR(75) null,
	emailFromAddress VARCHAR(75) null,
	startDate DATE null,
	fromDate DATE null,
	emailCount INTEGER,
	status INTEGER,
	isScheduled BOOLEAN
);

create table ZN_MailingLang (
	mailingLangId LONG not null primary key,
	mailingId LONG,
	languageId VARCHAR(75) null,
	emailSubjectPre VARCHAR(255) null,
	emailBodyPre TEXT null
);

create table ZN_MailingSubscriptor (
	mailingSubscriptorId LONG not null primary key,
	mailingId LONG,
	email VARCHAR(75) null,
	name VARCHAR(75) null,
	surname VARCHAR(75) null,
	languageId VARCHAR(75) null,
	emailSubject VARCHAR(255) null,
	emailBody TEXT null,
	tokens STRING null
);

create table ZN_Newsletter (
	newsletterId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(255) null,
	description STRING null,
	categoryId LONG,
	subject STRING null,
	articleId VARCHAR(75) null,
	articleGroupId LONG,
	schedulerActive BOOLEAN,
	schedulerType INTEGER,
	schedulerDate DATE null
);

create table ZN_Subscriptor (
	uuid_ VARCHAR(75) null,
	subscriptorId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name VARCHAR(75) null,
	surname VARCHAR(75) null,
	email VARCHAR(75) null,
	languageId VARCHAR(75) null,
	selfSubscribe BOOLEAN
);

create table ZN_SubscriptorCategory (
	subscriptorCategoryId LONG not null primary key,
	subscriptorId LONG,
	categoryId LONG
);