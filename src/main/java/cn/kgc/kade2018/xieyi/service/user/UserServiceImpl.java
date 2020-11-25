package cn.kgc.kade2018.xieyi.service.user;

import cn.kgc.kade2018.xieyi.mapper.UserMapper;
import cn.kgc.kade2018.xieyi.pojo.User;
import cn.kgc.kade2018.xieyi.pojo.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Resource
    UserMapper  userMapper;
    @Override
    public boolean add(User user) {
        if(userMapper.insert(user)>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public User login(String userCode, String userPassword) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsercodeEqualTo(userCode).andUserpasswordEqualTo(userPassword);
        List<User> user=userMapper.selectByExample(userExample);
        if(user!=null&&user.size()>0){
            return user.get(0);
        }
         return null;
    }

    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        return null;
    }

    @Override
    public int getUserCount(String queryUserName, int queryUserRole) {
        return 0;
    }

    @Override
    public User selectUserCodeExist(String userCode) {
        return null;
    }

    @Override
    public boolean deleteUserById(Integer delId) {
        return false;
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public boolean modify(User user) {
        return false;
    }

    @Override
    public boolean updatePwd(Long id, String pwd) {
        User user=new User();
        user.setId(id);
        user.setUserpassword(pwd);

          if(userMapper.updateByPrimaryKeySelective(user)>0){
              return true;
          }else {
              return false;
          }

    }
}
