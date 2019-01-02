import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DelegatingSubject;

public class main {
    public static void main(String[] args) {
//        认证规则
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("111","111","lint","hello");
//        创建主体
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("111","111");
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = new DelegatingSubject(defaultSecurityManager);
        subject.login(usernamePasswordToken);
        subject.logout();
        System.out.println(subject.isAuthenticated());
        subject.checkRole("hello");
    }
}
