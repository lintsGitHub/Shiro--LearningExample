import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DelegatingSubject;

public class inimain {
    public static void main(String[] args) {
        IniRealm iniRealm = new IniRealm("classpath:user.ini");
        //        创建主体
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("user","111");
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = new DelegatingSubject(defaultSecurityManager);
//        我们设置让这个用户登入
        subject.login(usernamePasswordToken);
        System.out.println(subject.isAuthenticated());
        subject.checkRole("hello");
        subject.checkPermission("111:create");
//        然后将这个用户请出去
        subject.logout();
        System.out.println(subject.isAuthenticated());
    }
}
