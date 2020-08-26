/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import controller.LoginController;

/**
 *
 * @author marcos
 */
@Intercepts
public class LoginInterceptor implements  Interceptor{
    
    private Result result;
    private UserSession userSession;

    public LoginInterceptor(Result result, UserSession userSession) {
        this.result = result;
        this.userSession = userSession;
    }            

    @Override
    public void intercept(InterceptorStack is, ResourceMethod rm, Object o) throws InterceptionException {
        if (userSession.isLogged()){
            is.next(rm, o);
        } else{
            result.redirectTo(LoginController.class).login();
        }
    }

    @Override
    public boolean accepts(ResourceMethod rm) {
        return !(rm.getMethod().isAnnotationPresent(Public.class) ||
                rm.getResource().getType().isAnnotationPresent(Public.class));
    }
    
}
