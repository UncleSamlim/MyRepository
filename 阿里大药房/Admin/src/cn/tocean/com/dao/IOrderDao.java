package cn.tocean.com.dao;

import java.util.List;

import cn.tocean.com.dao.entity.Order;
import cn.tocean.com.utils.Page;

/**   
*    
* 项目名称：second_program   
* 类名称：IOrderDao   
* 类描述：   为订单操作提供的接口
* 创建人：Sam  
* 创建时间：2019年12月10日 下午4:16:07   
* @version        
*/
public interface IOrderDao {
	
	/*管理员使用： 增加订单 并返回修改行数 */
	public int addOrders(Order order);
	
	/*管理员&用户使用： 更新订单 并返回修改行数 */
	public int updateOrders(Order order);
	
	/*管理员&用户使用：根据订单id删除订单 并返回修改行数 */
	public int deleteOrders(int orderId);
	
	/*根据id查询订单*/
	public Order getOrderById(int id);
	
	/*管理员使用： 向管理员显示所有订单 并返回订单列表 */
	public List<Order> ListAllOrdersToAdmin();
	
	/*用户使用： 向用户显示用户所有订单 并返回订单列表 */
	public List<Order> ListAllOrdersToUser(int orderId);
	
	/*分页获取信息总数*/
	public int getCount();
	
	/*订单分页*/
	public List<Order> onePageInfo(int currentPage,int pagesize);
	/*使用Page打包一页的信息*/
	public Page<Order> getPage(int currentPage,int pagesize);
	/*发货*/
	public int fahuo(int id);
}
