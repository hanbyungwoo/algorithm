package woowahan;
//select team_id, team_name, sum(bb) num_points from (
//	
//    
//    select *, ifnull(sum(host_point),0) bb from teams 
//     
//	 left outer join (select *, case when host_goals > guest_goals then 3
//		when host_goals = guest_goals then 1
//		when host_goals < guest_goals then 0 END host_point from matches) A on  team_id = host_team 
//	group by team_id
//	
//    union All
//
//	select *, ifnull(sum(guest_point), 0) bb from teams
//	 left outer join  (
//		(select *, case when host_goals < guest_goals then 3
//		when host_goals = guest_goals then 1
//		when host_goals > guest_goals then 0 END guest_point from matches) 
//		
//	 ) B  on  team_id = guest_team 
//     group by team_id
//) C group by C.team_id order by num_points desc, team_id;