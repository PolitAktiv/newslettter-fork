create index IX_91543751 on ZN_Category (companyId, groupId);

create index IX_F94942E8 on ZN_Mailing (companyId, groupId);
create index IX_9223A8E on ZN_Mailing (newsletterId);

create index IX_E58BC149 on ZN_MailingLang (mailingId, languageId);

create index IX_A994BA0C on ZN_Newsletter (companyId, groupId);

create index IX_A8E50161 on ZN_Subscriptor (companyId, groupId, email);
create index IX_22C9450B on ZN_Subscriptor (uuid_);
create index IX_8945BA3D on ZN_Subscriptor (uuid_, companyId);
create unique index IX_DC81ABFF on ZN_Subscriptor (uuid_, groupId);

create index IX_A3CAAB94 on ZN_SubscriptorCategory (categoryId);
create index IX_2CF49452 on ZN_SubscriptorCategory (subscriptorId);
create index IX_1BD9103F on ZN_SubscriptorCategory (subscriptorId, categoryId);