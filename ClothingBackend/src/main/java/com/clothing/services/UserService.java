
package com.clothing.services;

import  com.clothing.Payload.SingIn;
import com.clothing.Payload.UserDto;

public interface UserService {


    UserDto CreateUser(UserDto userDto);

    SingIn SingIn(SingIn singIn);
}
