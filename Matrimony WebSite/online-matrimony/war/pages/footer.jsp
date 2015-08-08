<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<table class="footer-table border-top">
<tr>
	<td align="center">
		<table border="0" width="100%" class="footer">
		<tr>
			<td width="5%"><br></td>
			<td width="30%" align="right">
				<bean:message key="footer.copyright"/>&nbsp;
				वधु-वर सूचक मंडळ, डोंबिवली
			</td>
			<td align="center">
				<div class="BottomBar BottomBarText">
					<a class="BottomBarLink" href="/Menu.do?action=view&hm=aboutUs">
						<bean:message key="menu.item.about_us"/>
					</a>
					 | 
					<a class="BottomBarLink" href="/Menu.do?action=view&hm=features">
						<bean:message key="menu.item.features"/>
					</a>
					 | 
					<a class="BottomBarLink" href="/Menu.do?action=view&hm=guidelines">
						<bean:message key="menu.item.guidelines"/>
					</a>
					 | 
					<a class="BottomBarLink" href="/Menu.do?action=view&hm=faqs">
						<bean:message key="menu.item.faqs"/>
					</a>
					 | 
					<a class="BottomBarLink" href="/Menu.do?action=view&hm=privacy">
						<bean:message key="menu.item.privacy"/>
					</a>
					 | 
					<a class="BottomBarLink" href="/Menu.do?action=view&hm=terms">
						<bean:message key="menu.item.terms"/>
					</a>
				</div>
			</td>
			<td align="left">
				<img src="/images/appengine-silver-120x30.gif" border="0">
			</td>
			<td width="5%"><br></td>
		</tr>
		</table>
	</td>
</tr>
</table>