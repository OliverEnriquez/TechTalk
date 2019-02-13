package util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserNameLdapUtil {

    public String getUserNameLdap() {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String[] userInfo = userDetails.toString().replace("org.springframework.security.ldap.userdetails.LdapUserDetailsImpl@33eb7054: Dn: cn=", "").split(",".trim());
        return userInfo[0];
    }
}
